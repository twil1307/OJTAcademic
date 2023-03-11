/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact;

/**
 *
 * @author toten
 */
public class ContactService {
    private final ContactDAO  dao = new ContactDAO();
    
    public void createMessage(Contact contact) {
        dao.createMessage(contact);
    }
}
