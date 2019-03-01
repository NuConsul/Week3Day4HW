package com.chemwater.week3day4hw;

public class User {
    private String userName ;
    private String userEmail ;
    private String passWord ;

    public User() {
    }

    public User(String userName, String userEmail, String passWord) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}



