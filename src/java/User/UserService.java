/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.List;

/**
 *
 * @author toten
 */
public class UserService {
    private final UserDAO userDAO = new UserDAO();
    
    public Account getUserByID(int userID) {
        return userDAO.getUserByID(userID);
    }
    
    public String getEmailByAccountID(int id) {
        return userDAO.getEmailByAccountID(id);
    }
    
    public List<Account> listUser() {
        return userDAO.listUser();
    }
    
    public int getManagerNumber() {
        return userDAO.getManagerNumber();
    }
    
    public void changeRole(int accountId, String roleCase) {
        userDAO.changeRole(accountId, roleCase);
    }
    
    public double getUserDonateTotal(int accountId) {
        return userDAO.getUserDonateTotal(accountId);
    }
    
    public int getUserContributeProgramNum(int accountId) {
        return userDAO.getUserContributeProgramNum(accountId);
    }
    
    public double getContributeThisMonth(int accountId) {
        return userDAO.getContributeThisMonth(accountId);
    }
}
