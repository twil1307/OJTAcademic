/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investor;

import Operator.Operator;
import Operator.OperatorImage;
import Schedule.ScheduleController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import shared.FileUploader;

@WebServlet(name = "InvestorController", urlPatterns = {"/investor"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class InvestorController extends HttpServlet {

    private final InvestorService service = new InvestorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "register":
                regisInvestor(req, resp);
                break;
            case "update":
                int programId = Integer.parseInt(req.getParameter("programId"));
                List<Investor> listInvestor = service.getListInvestorsByProgramId(programId);
                req.setAttribute("listInvestor", listInvestor);
                req.getRequestDispatcher("investorUpdate.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "register":
                regisInvestor(req, resp);
                break;
            case "update":
                updateInvestor(req, resp);
                break;
        }

    }

    protected void regisInvestor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int investorNumber = Integer.parseInt(req.getParameter("investor-number"));
        int programId = Integer.parseInt(req.getParameter("programId"));
        List<Investor> listInvestor = new ArrayList<Investor>();
        String realPath = req.getServletContext().getRealPath("/img");

        for (int i = 0; i < investorNumber; i++) {
            String investorName = req.getParameter("investorName-" + (i + 1));
            String legalRepresent = req.getParameter("legalRepresent-" + (i + 1));
            String detailDes = req.getParameter("investorDes-" + (i + 1));
            String contact = req.getParameter("contact-" + (i + 1));
            Part investAvatar = req.getPart("investAvatar-" + (i + 1));
            Part qualifyImg = req.getPart("qualifyImg-" + (i + 1));
            String investAvatarFileName = null;
            String qualifyImgFileName = null;

            if (investAvatar != null) {
                investAvatarFileName = "img" + File.separator + Paths.get(investAvatar.getSubmittedFileName()).getFileName().toString();
                investAvatar.write(realPath + File.separator + Paths.get(investAvatar.getSubmittedFileName()).getFileName().toString());
            }

            if (qualifyImg != null) {
                qualifyImgFileName = "img" + File.separator + Paths.get(qualifyImg.getSubmittedFileName()).getFileName().toString();
                qualifyImg.write(realPath + File.separator + Paths.get(qualifyImg.getSubmittedFileName()).getFileName().toString());

            }

            listInvestor.add(new Investor(0, programId, investorName, investAvatarFileName, detailDes, contact, qualifyImgFileName, legalRepresent));
        }

        service.saveInvestors(listInvestor);

        req.getRequestDispatcher("successPage.jsp").forward(req, resp);
    }

    protected void updateInvestor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] unChangeInvestorId = req.getParameterValues("investorId-unchanged");
        String[] investorIdDels = req.getParameterValues("investorIdDel");
        String[] deletedIndex = req.getParameterValues("investorIdDelIndex");

        int investorNumber = Integer.parseInt(req.getParameter("investor-number"));
        int programId = Integer.parseInt(req.getParameter("programId"));

        List<Investor> listInvestor = new ArrayList<>();
        String imageUploadPath = req.getServletContext().getRealPath("/img");

        for (int i = 0; i < investorNumber; i++) {

            if (deletedIndex != null && Arrays.asList(deletedIndex).contains(String.valueOf(i + 1))) {
                continue;
            }

            String investorName = req.getParameter("investorName-" + (i + 1));
            String legalRepresent = req.getParameter("legalRepresent-" + (i + 1));
            String investorDes = req.getParameter("investorDes-" + (i + 1));
            String investorId = req.getParameter("investorId-" + (i + 1));
            String contact = req.getParameter("contact-" + (i + 1));

            String investorImg = null;
            String qualifyImg = null;

            try {
                for (Part part : req.getParts()) {
                    if (part.getName().equals("qualifyImg-" + (i + 1)) && !part.getSubmittedFileName().isEmpty()) {
                        String imgPath = "img" + File.separator + investorName + part.getSubmittedFileName();
                        part.write(imageUploadPath + File.separator + investorName + part.getSubmittedFileName());
                        qualifyImg = imgPath;
                    }

                    if (part.getName().equals("investAvatar-" + (i + 1)) && !part.getSubmittedFileName().isEmpty()) {
                        String imgPath = "img" + File.separator + investorName + part.getSubmittedFileName();
                        part.write(imageUploadPath + File.separator + investorName + part.getSubmittedFileName());
                        investorImg = imgPath;
                    }
                }
            } catch (IOException | ServletException ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (investorImg == null && investorId != null) {
                investorImg = service.getInvestorImg(Integer.parseInt(investorId));
            }

            if (qualifyImg == null && investorId != null) {
                qualifyImg = service.getQualifyImg(investorNumber);
            }

            listInvestor.add(new Investor((investorId != null ? Integer.parseInt(investorId) : 0), programId, investorName, investorImg, investorDes, contact, qualifyImg, legalRepresent));

//            listOperator.add(new Operator((operatorId != null ? Integer.parseInt(operatorId) : 0), programId, operatorDate, operatorDetailDes, actualExpense, activitiesImage, bilImage));
        }

        List<Investor> listInvestorClone = deepClone(listInvestor);

        for (Investor investor : listInvestorClone) {
            if (unChangeInvestorId != null) {
                for (String id : unChangeInvestorId) {
                    if (investor.getInvestorId() == Integer.parseInt(id)) {
                        listInvestor.remove(investor);
                    }
                }
            }
        }

        if (investorIdDels != null) {
            service.deleteMultipleInvestor(investorIdDels);
        }

        service.saveInvestors(listInvestor);

        req.getRequestDispatcher("successPage.jsp").forward(req, resp);
    }

    public List<Investor> deepClone(List<Investor> listInvestor) {
        List<Investor> listOperatorClone = new ArrayList<>();

        for (Investor investor : listInvestor) {
            listOperatorClone.add(investor);
        }

        return listOperatorClone;
    }

}
