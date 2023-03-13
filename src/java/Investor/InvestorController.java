/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
        int investorNumber = Integer.parseInt(req.getParameter("investor-number"));
        int programId = Integer.parseInt(req.getParameter("programId"));
        String imageUploadPath2 = req.getServletContext().getRealPath("/img");
        System.out.println(imageUploadPath2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

}
