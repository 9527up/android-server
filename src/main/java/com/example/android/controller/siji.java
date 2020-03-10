package com.example.android.controller;

import com.example.android.entity.ResponseEntity;
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
public class siji {
    @Resource
    private com.example.android.mapper.sijimapper sijimapper;

    @RequestMapping(value="/addsiji")
    public ResponseEntity addsiji(String si_title, String si_content, String si_img,HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"失败","");
        HttpSession session =request.getSession();
        Object obj=session.getAttribute("userid");
        String userid=String.valueOf(obj);
        userentity user= sijimapper.getUserByid(userid);
        String username=user.getUsername();
        Random rand = new Random();
        int a=rand.nextInt(10000);
        String si_id=userid;
        String b=Integer.toString(a);
        si_id=si_id.concat(b);
        sijientity siji=new sijientity(userid,username,si_title,si_content,si_id,null);
        try {
            sijimapper.sijiadd(siji);
            responseEntity.setStatus(1);
            responseEntity.setMsg("发布成功");
        }catch(Exception e){
            return responseEntity;
        }
        return responseEntity;
    }
    @RequestMapping(value="/sijilist")
    public ResponseEntity sijilist(){
        ResponseEntity responseEntity=new ResponseEntity(0,"失败","");
      try{
        List<sijientity> sijilist=sijimapper.sijilist();
        responseEntity.setMsg("成功");
        responseEntity.setStatus(1);
        responseEntity.setData(sijilist);
        return responseEntity;

    }catch(Exception e){
          return responseEntity;
      }
      //return responseEntity;
    }

    @RequestMapping("/test")
    public ResponseEntity test(String userid){
        ResponseEntity responseEntity=new ResponseEntity(1,"获取成功","");
        userentity user=  sijimapper.getUserByid(userid);
        responseEntity.setData(user);
        return responseEntity;
    }


}
