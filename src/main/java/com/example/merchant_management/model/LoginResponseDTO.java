package com.example.merchant_management.model;
public class LoginResponseDTO {
    private Admin username;
    private String jwt;


    public LoginResponseDTO(){
        super();
    }


    public LoginResponseDTO(Admin user, String jwt){
        this.username = username;
        this.jwt = jwt;
    }


    public Admin getUser(){
        return this.username;
    }


    public void setUser(Admin username){
        this.username = username;
    }


    public String getJwt(){
        return this.jwt;
    }


    public void setJwt(String jwt){
        this.jwt = jwt;
    }


}