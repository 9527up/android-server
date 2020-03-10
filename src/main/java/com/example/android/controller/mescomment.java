package com.example.android.controller;

import com.example.android.entity.*;
import com.example.android.mapper.mesmapper;
import com.example.android.mapper.sicommentmapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class mescomment {
    @Resource
    private com.example.android.mapper.mescommentmapper mescommentmapper;

        @RequestMapping("/hello")
        public String hello(Model model) {
            return "user";
        }
    @RequestMapping("/mescomment")
    public ResponseEntity mescomment(String mes_id, HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"获取失败","");
        try{
            List<mescommententity>mescomment=mescommentmapper.mescomment(mes_id);
            responseEntity.setStatus(1);
            responseEntity.setMsg("获取成功");
            responseEntity.setData(mescomment);
        }catch(Exception e){
            return responseEntity;
        }
        return responseEntity;
    }
    @RequestMapping("/addmescomment")
    public ResponseEntity addmescomment(String mes_id,String mes_comment,HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"获取失败","");
        HttpSession session=request.getSession();
        Object obj=session.getAttribute("userid");
        String userid=String.valueOf(obj);
        userentity user=mescommentmapper.getUserByid(userid);
        String username=user.getUsername();
        mescommententity mescomment=new mescommententity(userid,username,mes_comment,mes_id);
        try{
            mescommentmapper.mescommentadd(mescomment);
            responseEntity.setStatus(1);
            responseEntity.setMsg("发布成功");
            return responseEntity;
        }catch(Exception e){
            return responseEntity;
        }

    }
}
