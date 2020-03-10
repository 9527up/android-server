package com.example.android.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class userentity implements Serializable {

    private String userid;
    private String userpass;
    private String username;
    private String school;
    private String acadamy;
    private String number;
    private String user_img;

    public String getU_pass(){
        return userpass;
    }
    public String getU_id(){
        return userid;

    }
    public String getU_name(){
        return username;
    }
    public String getU_school(){
        return school;
    }
    public String getU_acadamy(){
        return acadamy;
    }
    public String getU_namber(){
        return number;
    }
    public String getU_img(){
        return user_img;
    }

    public void setU_id(String userid){
        this.userid=userid;
    }
    public void setU_pass(String userpass){
        this.userpass=userpass;
    }
    public void setU_name(String username){
        this.username=username;
    }
    public void setU_school(String school){
        this.school=school;
    }
    public void setU_acadamy(String acadamy){
        this.acadamy=acadamy;
    }
    public void setU_number(String number){
        this.number=number;
    }
    public void SetU_img(String user_img){
        this.user_img=user_img;
    }

    public userentity(){
    }
    public userentity(String userid,String userpass,String username,String school,String acadamy,String number,String user_img){
        this.userid=userid;
        this.userpass=userpass;
        this.username=username;
        this.school=school;
        this.acadamy=acadamy;
        this.number=number;
        this.user_img=user_img;


    }


}
