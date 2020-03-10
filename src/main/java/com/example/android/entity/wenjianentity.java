package com.example.android.entity;

public class wenjianentity {
    private String file_id;
    private String file_name;
    private String file_url;

    public String getFile_id(){
        return file_id;
    }
    public String getFile_name(){
        return file_name;
    }
    public String getFile_url(){
        return file_url;
    }
    public void setFile_id(String file_id){
        this.file_id=file_id;
    }
    public void setFile_name(String file_name){
        this.file_name=file_name;
    }
    public void setFile_url(String file_url){
        this.file_url=file_url;
    }
    public wenjianentity(){

    }
    public wenjianentity(String file_id,String file_name,String file_url){
        this.file_id=file_id;
        this.file_name=file_name;
        this.file_url=file_url;
    }
}
