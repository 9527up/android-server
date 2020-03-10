package com.example.android.entity;

public class liujientity {
    private String userid;
    private String username;
    private String liu_title;
    private String liu_content;
    private String liu_id;
    private String liu_img;


    public String getU_userid(){
        return userid;
    }
    public String getU_username(){
        return username;

    }
    public String getliu_title(){
        return liu_title;
    }
    public String getliu_content(){
        return liu_content;
    }
    public String getliu_id(){
        return liu_id;
    }
    public String getliu_img(){
        return liu_img;
    }

    public void setU_id(String userid){
        this.userid=userid;
    }

    public void setU_name(String username){
        this.username=username;
    }
    public void setliu_title(String liu_title){
        this.liu_title=liu_title;
    }
    public void setliu_content(String liu_content){
        this.liu_content=liu_content;
    }
    public void setliu_id(String liu_id){
        this.liu_id=liu_id;
    }

    public liujientity(){

    }
    public liujientity(String userid,String username,String liu_title,String liu_content,String liu_id,String liu_img){
        this.userid=userid;
        this.liu_title=liu_title;
        this.username=username;
        this.liu_id=liu_id;
        this.liu_content=liu_content;
        this.liu_img=liu_img;
    }
}
