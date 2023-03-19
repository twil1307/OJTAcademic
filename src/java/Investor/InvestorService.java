/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investor;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class InvestorService {
    private final InvestorDAO dao = new InvestorDAO();
    
    public void saveInvestors(List<Investor> investor) {
        try {
            dao.saveInvestors(investor);
        } catch (SQLException ex) {
            Logger.getLogger(InvestorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Investor> getListInvestorsByProgramId(int programId) {
         return dao.getListInvestorsByProgramId(programId);
     }
     
     public String getInvestorImg(int investorId) {
         return dao.getInvestorImg(investorId);
     }
     
     public String getQualifyImg(int investorId) {
         return dao.getQualifyImg(investorId);
     }

    void deleteMultipleInvestor(String[] investorIdDels) {
        dao.deleteMultipleInvestor(investorIdDels);
    }
}
