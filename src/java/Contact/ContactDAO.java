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
import java.util.ArrayList;
import java.util.List;
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

            String query = "insert into contact values (?, ?, ?, GETDATE());";

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
    
    public List<ContactVO> getAllMessage() {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select ct.*, dn.email, dn.name from contact ct, donor dn where ct.account_id = dn.account_id order by contact_id desc";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            List<ContactVO> listContact = new ArrayList<>();
            while (rs.next()) {
                ContactVO contactAdd =  new ContactVO(rs.getInt("contact_id"), rs.getString("title"), rs.getString("messageContent"), rs.getInt("account_id"), rs.getString("sendAt"), rs.getString("email"), rs.getString("name"));
                
                listContact.add(contactAdd);
            }

            return listContact;

        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        ContactDAO dao = new ContactDAO();
        
        System.out.println(dao.getAllMessage());
    }
}
