package com.example.android.entity;

public class mescommententity {
    private String userid;
    private String username;
    private String mes_id;
    private String mes_comment;



    public String getU_userid(){
        return userid;
    }
    public String getU_username(){
        return username;

    }

    public String getMes_id(){
        return mes_id;
    }
    public String getMes_comment(){
        return mes_comment;
    }

    public void setU_id(String userid){
        this.userid=userid;
    }

    public void setU_name(String username){
        this.username=username;
    }

    public void setMes_id(String mes_id){
        this.mes_id=mes_id;
    }
    public void setMes_comment(String mes_comment){
        this.mes_comment=mes_comment;
    }

    public mescommententity(){

    }
    public mescommententity(String userid,String username,String mes_comment,String mes_id){
        this.userid=userid;

        this.username=username;
        this.mes_id=mes_id;
        this.mes_comment=mes_comment;

    }
}
