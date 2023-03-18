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
public class Donor extends Account {
    private int donorId;
    private String email;
    private String city;
    private String province;
    private String address;
    private String name;
    private String avatar;
    private String phoneNumber;
    private String dob;
    private String bank_account;

    public Donor(int accountId, String username, String password, int role, String salt) {
        super(accountId, username, password, role, salt);
    }

    public Donor() {
        
    }
    
    public Donor(int accountId, String email, String bank_account) {
        super(accountId);
        this.email = email;
        this.bank_account = bank_account;
    }
    public Donor(int accountId, String username, String name, String phoneNumber, String dob, String city, String province, String address, String avatar) {
        super(accountId, username);
        this.phoneNumber = phoneNumber;
        this.dob=dob;
        this.city = city;
        this.province = province;
        this.address = address;
        this.name = name;
        this.avatar = avatar;
    }

    
public Donor(int accountId, String username, String password, int role, String salt, String email, String city, String province, String address, String name, String avatar, String phoneNumber, String dob, String bank_account) {
        super(accountId, username, password, role, salt);
        this.email = email;
        this.city = city;
        this.province = province;
        this.address = address;
        this.name = name;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.bank_account = bank_account;
    }
    
    
    public Donor(int accountId, String username, String password, int role, String salt, int donorId, String email, String city, String province, String address, String name, String avatar, String phoneNumber, String dob, String bank_account) {
        super(accountId, username, password, role, salt);
        this.donorId = donorId;
        this.email = email;
        this.city = city;
        this.province = province;
        this.address = address;
        this.name = name;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.bank_account = bank_account;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    @Override
    public String toString() {
        return "Donor{" + "donorId=" + donorId + ", email=" + email + ", city=" + city + ", province=" + province + ", address=" + address + ", name=" + name + ", avatar=" + avatar + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", bank_account=" + bank_account + '}';
    }
    
    
}
