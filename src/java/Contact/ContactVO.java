/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contact;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author toten
 */
@Getter
@Setter
public class ContactVO extends Contact {
    private String sendAt;
    private String email;
    private String username;

    public ContactVO(int contactId, String title, String messageContent, int accountId) {
        super(contactId, title, messageContent, accountId);
    }
    
    public ContactVO(int contactId, String title, String messageContent, int accountId, String sendAt, String email, String username) {
        super(contactId, title, messageContent, accountId);
        this.sendAt = sendAt;
        this.email = email;
        this.username = username;
    }
    
}
