package com.example.android.entity;

public class sijientity {
    private String userid;
    private String username;
    private String si_title;
    private String si_content;
    private String si_id;
    private String si_img;


    public String getU_userid(){
        return userid;
    }
    public String getU_username(){
        return username;

    }
    public String getsi_title(){
        return si_title;
    }
    public String getsi_content(){
        return si_content;
    }
    public String getsi_id(){
        return si_id;
    }
    public String getsi_img(){
        return si_img;
    }

    public void setU_id(String userid){
        this.userid=userid;
    }

    public void setU_name(String username){
        this.username=username;
    }
    public void setsi_title(String si_title){
        this.si_title=si_title;
    }
    public void setsi_content(String si_content){
        this.si_content=si_content;
    }
    public void setsi_id(String si_id){
        this.si_id=si_id;
    }

    public sijientity(){

    }
    public sijientity(String userid,String username,String si_title,String si_content,String si_id,String si_img){
        this.userid=userid;
        this.si_title=si_title;
        this.username=username;
        this.si_id=si_id;
        this.si_content=si_content;
        this.si_img=si_img;
    }
}
