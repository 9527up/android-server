package com.example.android.controller;

import com.example.android.entity.ResponseEntity;
import com.example.android.entity.userentity;
import com.example.android.mapper.usermapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class user {
    private userentity userEntity;
    @Resource
    private com.example.android.mapper.usermapper usermapper;

    @RequestMapping(value = "/register")
    public ResponseEntity  register(String userid,String userpass){
        ResponseEntity responseEntity=new ResponseEntity(200,"注册失败","");
        try{
        userEntity=new userentity(userid,userpass,null,null,null,null,null) ;
        usermapper.userregister(userEntity);
            responseEntity.setStatus(1);
            responseEntity.setMsg("注册成功");
            return responseEntity;
    }catch (Exception e){
            return  responseEntity;
        }
    }
    @RequestMapping(value ="/login")
    public ResponseEntity login(String userid, String userpass, HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity();
        userentity user=usermapper.getUserByid(userid);
       // userentity use=user.get(user.size()-1);
        String pss=user.getU_pass();
        if(pss.equals(userpass)){
            HttpSession session =  request.getSession(true);
            session.setAttribute("userid",userid);
            session.setAttribute("userpass",userpass);
            responseEntity.setStatus(1);
            responseEntity.setMsg("登录成功");
            responseEntity.setData(user);
        }
        else
        {responseEntity.setStatus(0);
            responseEntity.setMsg("登录失败");}
        return responseEntity;
    }
    @RequestMapping(value="/update")
    public ResponseEntity update(String number,String school,String acadamy,String username,HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"注册失败","");
        HttpSession session=request.getSession(true);
        Object obj=session.getAttribute("userid");
        Object obj1=session.getAttribute("userpass");
        String userid=String.valueOf(obj);
        String userpass=String.valueOf(obj1);
        userEntity=new userentity(userid,userpass,username,school,acadamy,number,null);
        try{usermapper.updateUser(userEntity);
        userentity user=usermapper.getUserByid(userid);
       // userentity use=user.get(user.size()-1);
        responseEntity.setStatus(1);
        responseEntity.setMsg("设置成功");
        responseEntity.setData(user);
        return responseEntity;}
        catch(Exception e){
            return responseEntity;
        }
    }

}
