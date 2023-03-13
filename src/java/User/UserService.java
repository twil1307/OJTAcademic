/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

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
}
