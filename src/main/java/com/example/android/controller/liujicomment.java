package com.example.android.controller;

import com.example.android.entity.ResponseEntity;
import com.example.android.entity.liucommententity;
import com.example.android.entity.sicommententity;
import com.example.android.entity.userentity;
import com.example.android.mapper.liucommentmapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class liujicomment {
    @Resource
    private liucommentmapper lcmapper;

    @RequestMapping("/liucomment")
    public ResponseEntity liucomment(HttpServletRequest request,String liu_id){
        ResponseEntity responseEntity=new ResponseEntity(0,"获取失败","");
        try{
            List<liucommententity>liucomment=lcmapper.liucomment(liu_id);
            responseEntity.setStatus(1);
            responseEntity.setMsg("获取成功");
            responseEntity.setData(liucomment);
            return responseEntity;
        }catch(Exception e){
            return responseEntity;
        }

    }
    @RequestMapping("/addliujicomment")
    public ResponseEntity addliujicomment(String liu_id,String liu_comment,HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"获取失败","");
        HttpSession session=request.getSession();
        Object obj=session.getAttribute("userid");
        String userid=String.valueOf(obj);
        userentity user=lcmapper.getUserByid(userid);
        String username=user.getUsername();
        liucommententity ljcomment=new liucommententity(userid,username,liu_comment,liu_id);
        try{
            lcmapper.liucommentadd(ljcomment);
            responseEntity.setStatus(1);
            responseEntity.setMsg("发布成功");
            return responseEntity;
        }catch(Exception e){
            return responseEntity;
        }

    }
}
