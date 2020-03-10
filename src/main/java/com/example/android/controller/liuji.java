package com.example.android.controller;

import com.example.android.entity.ResponseEntity;
import com.example.android.entity.liujientity;
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
public class liuji {
    @Resource
    private com.example.android.mapper.liujimapper liujimapper;

    @RequestMapping(value="/addliuji")
    public ResponseEntity addliuji(String liu_title, String liu_content, String liu_img,HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"失败","");
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("userid");
        String userid=String.valueOf(obj);
        userentity user= liujimapper.getUserByid(userid);
        String username=user.getUsername();
        Random rand = new Random();
        int a=rand.nextInt(10000);
        String liu_id=userid;
        String b=Integer.toString(a);
        liu_id=liu_id.concat(b);
        liujientity liuji=new liujientity(userid,username,liu_title,liu_content,liu_id,liu_img);
        try {
            liujimapper.liujiadd(liuji);
            responseEntity.setStatus(1);
            responseEntity.setMsg("发布成功");
        }catch(Exception e){
            return responseEntity;
        }
        return responseEntity;
    }
    @RequestMapping(value="/liujilist")
    public ResponseEntity liujilist(){
        ResponseEntity responseEntity=new ResponseEntity(0,"失败","");
        try{
            List<liujientity> liujilist=liujimapper.liujilist();
            responseEntity.setMsg("成功");
            responseEntity.setStatus(1);
            responseEntity.setData(liujilist);
            return responseEntity;

        }catch(Exception e){
            return responseEntity;
        }

    }

    @RequestMapping("/test2")
    public ResponseEntity test2(String userid){
        ResponseEntity responseEntity=new ResponseEntity(0,"失败","");

        return responseEntity;
    }


}
