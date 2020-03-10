package com.example.android.entity;

public class liucommententity {
    private String userid;
    private String username;
    private String liu_id;
    private String liu_comment;



    public String getUserid(){
        return userid;
    }
    public String getUsername(){
        return username;
    }
    public String getLiu_id(){
        return liu_id;
    }
    public String getLiu_comment(){
        return liu_comment;
    }
    public void setUserid(String userid){
        this.userid=userid;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setLiu_id(String liu_id){
        this.liu_id=liu_id;
    }
    public void setLiu_comment(String liu_comment){
        this.liu_comment=liu_comment;
    }
    public liucommententity(){

    }
    public liucommententity(String userid,String username,String liu_comment,String liu_id){
        this.userid=userid;
        this.username=username;
        this.liu_id=liu_id;
        this.liu_comment=liu_comment;
    }
}
