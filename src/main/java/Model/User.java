/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author DUY
 */
public class User {
    private int userID;
    private String account;
    private String password; 
    private  Date dob;
    private String phone;
    private String email;
    private int gender;
    private String address;

    public User() {
    }

    public User(int userID, String account, String password, Date dob, String phone, String email, int gender, String address) {
        this.userID = userID;
        this.account = account;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", account=" + account + ", password=" + password + ", dob=" + dob + ", phone=" + phone + ", email=" + email + ", gender=" + gender + ", address=" + address + '}';
    }
    
    
    
    
}
