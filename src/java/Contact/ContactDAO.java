/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class ContactDAO {
    public void createMessage(Contact contact) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "insert into contact values (?, ?, ?);";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, contact.getTitle());
            ps.setString(2, contact.getMessageContent());
            ps.setInt(3, contact.getAccountId());
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
