package com.example.android.controller;

import com.example.android.entity.ResponseEntity;
import com.example.android.entity.mesentity;
import com.example.android.entity.sijientity;
import com.example.android.entity.userentity;
import com.example.android.mapper.sijimapper;
import com.example.android.mapper.usermapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@RestController
public class message {
    @Resource
    private com.example.android.mapper.mesmapper mesmapper;

    @RequestMapping(value="/addmes")
    public ResponseEntity addsiji(String mes_title, String mes_content,HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"失败","");
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("userid");
        String userid=String.valueOf(obj);
        userentity user= mesmapper.getUserByid(userid);
        String username=user.getUsername();

        Random rand = new Random();
        int a=rand.nextInt(10000);
        String mes_id=userid;
        String b=Integer.toString(a);
        mes_id=mes_id.concat(b);
        mesentity mes=new mesentity(userid,username,mes_id,mes_title,mes_content);
        try {
            mesmapper.mesadd(mes);
            responseEntity.setStatus(1);
            responseEntity.setMsg("发布成功");
        }catch(Exception e){
            return responseEntity;
        }
        return responseEntity;
    }
    @RequestMapping(value="/meslist")
    public ResponseEntity sijilist(){
        ResponseEntity responseEntity=new ResponseEntity(0,"失败","");
        try{
            List<mesentity> meslist=mesmapper.meslist();
            responseEntity.setMsg("成功");
            responseEntity.setStatus(1);
            responseEntity.setData(meslist);
            return responseEntity;
        }catch(Exception e){
            return responseEntity;
        }

    }




}
