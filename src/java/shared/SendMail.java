package shared;

/**
 *
 * @author sonsi
 */
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class SendMail {

    static Session loginGetSession() {
        final String username = "lanhtuan200@gmail.com";
        final String password = "xpdtqogzdwvfopez";

        Properties props = new Properties();
        props.put("mail.smtp.user", "username");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.EnableSSL.enable", "true");

        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    public static void sendSuccessEmail(String email) {
        Session session = loginGetSession();
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Fantastic5"));
            
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("DONATED SUCCESSFULLY");
            String content = ""
                    + "<body marginheight=\"0\" topmargin=\"0\" marginwidth=\"0\" style=\"margin: 0px; background-color: #f2f3f8;\" leftmargin=\"0\">"
                    + "    <!--100% body table-->"
                    + "    <table cellspacing=\"0\" border=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#f2f3f8\""
                    + "        style=\"@import url(https://fonts.googleapis.com/css?family=Rubik:300,400,500,700|Open+Sans:300,400,600,700); font-family: 'Open Sans', sans-serif;\">"
                    + "        <tr>"
                    + "            <td>"
                    + "                <table style=\"background-color: #f2f3f8; max-width:670px;  margin:0 auto;\" width=\"100%\" border=\"0\""
                    + "                    align=\"center\" cellpadding=\"0\" cellspacing=\"0\">"
                    + "                    <tr>"
                    + "                        <td style=\"height:40px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"text-align:center;\">"
                    + "                            <a href=\"/\" title=\"logo\" target=\"_blank\">"
                    + "                                <img width=\"100\" src=\"https://w7.pngwing.com/pngs/38/204/png-transparent-computer-icons-check-mark-true-or-false-miscellaneous-company-logo.png\" title=\"logo\" alt=\"logo\">"
                    + "                            </a>"
                    + "                        </td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"height:20px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td>"
                    + "                            <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\""
                    + "                                style=\"max-width:670px;background:#fff; border-radius:3px; text-align:center;-webkit-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);-moz-box-shadow:0 6px 18px 0 rgba(0,0,0,.06);box-shadow:0 6px 18px 0 rgba(0,0,0,.06);\">"
                    + "                                <tr>"
                    + "                                    <td style=\"height:40px;\">&nbsp;</td>"
                    + "                                </tr>"
                    + "                                <tr>"
                    + "                                    <td style=\"padding:0 35px;\">"
                    + "                                        <h1"
                    + "                                            style=\"color:#1e1e2d; font-weight:500; margin:0;font-size:32px;font-family:'Rubik',sans-serif;\">"
                    + "                                            You have"
                    + "                                            donated successfully</h1>"
                    + "                                        <span"
                    + "                                            style=\"display:inline-block; vertical-align:middle; margin:29px 0 26px; border-bottom:1px solid #cecece; width:100px;\"></span>"
                    + "                                        <p style=\"color:#455056; font-size:15px;line-height:24px; margin:0;\">"
                    + "                                            We received your donate to Fantastic 5 "
                    + "                                            You are wonderfull. Thank for being part of us."
                    + "                                        </p>"
                    + "                                    </td>"
                    + "                                </tr>"
                    + "                                <tr>"
                    + "                                    <td style=\"height:40px;\">&nbsp;</td>"
                    + "                                </tr>"
                    + "                            </table>"
                    + "                        </td>"
                    + "                    <tr>"
                    + "                        <td style=\"height:20px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                    </tr>"
                    + "                    <tr>"
                    + "                        <td style=\"height:80px;\">&nbsp;</td>"
                    + "                    </tr>"
                    + "                </table>"
                    + "            </td>"
                    + "        </tr>"
                    + "    </table>"
                    + "    <!--/100% body table-->"
                    + "</body>";
            message.setContent(content, "text/html");

//            for (int i = 0; i < 100; i++) {
            Transport.send(message);

//            }
            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SendMail.sendSuccessEmail("duclqde160552@fpt.edu.vn");
    }

}