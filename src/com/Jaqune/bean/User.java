package com.Jaqune.bean;

public class User {

    private  Integer id;

    private String userName;

    private  String userPassword;

    private  String userEmail;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public User() {
    }

    public User(Integer id, String userName, String userPassword, String userEmail) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }
}
