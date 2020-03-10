package com.example.android.controller;

import com.example.android.entity.ResponseEntity;
import com.example.android.entity.sicommententity;
import com.example.android.entity.userentity;
import com.example.android.mapper.sicommentmapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class sijicomment {
    @Resource
    private sicommentmapper scmapper;

    @RequestMapping("/sicomment")
    public ResponseEntity sicomment(String si_id, HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"获取失败","");
        try{
            List<sicommententity>sicomment=scmapper.sicomment(si_id);
            responseEntity.setStatus(1);
            responseEntity.setMsg("获取成功");
            responseEntity.setData(sicomment);
        }catch(Exception e){
            return responseEntity;
        }
        return responseEntity;
    }
    @RequestMapping("/addsijicomment")
    public ResponseEntity addsijicomment(String si_id,String si_comment,HttpServletRequest request){
        ResponseEntity responseEntity=new ResponseEntity(0,"获取失败","");
        HttpSession session=request.getSession();
        Object obj=session.getAttribute("userid");
        String userid=String.valueOf(obj);
        userentity user=scmapper.getUserByid(userid);
        String username=user.getUsername();
        sicommententity sjcomment=new sicommententity(userid,username,si_id,si_comment);
        try{
            scmapper.sicommentadd(sjcomment);
            responseEntity.setStatus(1);
            responseEntity.setMsg("发布成功");
            return responseEntity;
        }catch(Exception e){
            return responseEntity;
        }

    }
}
