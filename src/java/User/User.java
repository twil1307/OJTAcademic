/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author toten
 */
@Builder
@Getter
@Setter
@ToString
public class User {
    private int user_id;
    private String username;
    private String password;
    private String email;
    private String city;
    private String province;
    private String address;
    private String name;
    private String role;
    private String avatar;
    private String phoneNumber;
    private Date dob;
    private String bank_account;
}
