/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donate;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class DonateService {
    DonateDAO dao = new DonateDAO();

    int getWalletAmount(int accountId) {
        return dao.getWalletAmount(accountId);
    }

    void donate(Donate donate) {
        try {
            try {
                dao.donate(donate);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DonateService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonateService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
