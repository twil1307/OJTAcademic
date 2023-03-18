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
public class Account {

    private int accountId;
    private String username;
    private String password;
    private int role;
    private String salt;

    public Account(int accountId, String username, String password, int role, String salt) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.salt = salt;
    }

    public Account(int accountId, String username) {
        this.accountId = accountId;
        this.username = username;
    }

    public Account(int accountId) {
        this.accountId = accountId;

    }

    public Account() {

    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", username=" + username + ", password=" + password + ", role=" + role + ", salt=" + salt + '}';
    }

}
