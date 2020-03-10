package com.example.android.entity;

public class mesentity {
    private String userid;
    private String username;
    private String mes_title;
    private String mes_id;
    private String mes_content;



    public String getU_userid(){
        return userid;
    }
    public String getU_username(){
        return username;

    }
    public String getMes_title(){
        return mes_title;
    }
    public String getMes_content(){
        return mes_content;
    }
    public String getMes_id(){
        return mes_id;
    }


    public void setU_id(String userid){
        this.userid=userid;
    }

    public void setU_name(String username){
        this.username=username;
    }
    public void setMes_title(String liu_title){
        this.mes_title=liu_title;
    }
    public void setMes_content(String mes_content){
        this.mes_content=mes_content;
    }
    public void setMes_id(String mes_id){
        this.mes_id=mes_id;
    }

    public mesentity(){

    }
    public mesentity(String userid,String username,String mes_id,String mes_title,String mes_content){
        this.userid=userid;
        this.mes_title=mes_title;
        this.username=username;
        this.mes_id=mes_id;
        this.mes_content=mes_content;

    }
}
