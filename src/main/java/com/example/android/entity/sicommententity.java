package com.example.android.entity;

public class sicommententity {
    private String userid;
    private String username;
    private String si_id;
    private String si_comment;



    public String getUserid(){
        return userid;
    }
    public String getUsername(){
        return username;
    }
    public String getSi_id(){
        return si_id;
    }
    public String getSi_comment(){
        return si_comment;
    }
    public void setUserid(String userid){
        this.userid=userid;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setSi_id(String si_id){
       this.si_id=si_id;
    }
    public void setSi_comment(String si_comment){
        this.si_comment=si_comment;
    }
    public sicommententity(){

    }
    public sicommententity(String userid,String username,String si_comment,String si_id){
        this.userid=userid;
        this.username=username;
        this.si_id=si_id;
        this.si_comment=si_comment;
    }
}
