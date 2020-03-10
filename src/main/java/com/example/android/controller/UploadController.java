package com.example.android.controller;
import com.example.android.entity.ResponseEntity;
import com.example.android.entity.userentity;
import com.example.android.mapper.usermapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Controller
public class UploadController {
    @Resource
    private com.example.android.mapper.usermapper usermapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    @Value("${server.port}")
    //获取主机端口
    private String POST;
    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }
    @PostMapping("/uploadimg")
    @ResponseBody
    public ResponseEntity uploadimg (@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        ResponseEntity responseEntity=new ResponseEntity(0,"上传失败","");
        userentity userEntity=new userentity();
        HttpSession session =request.getSession();
        Object obj= session.getAttribute("userid");
        Object obj1=session.getAttribute("userpass");
        String userpass=String.valueOf(obj1);
        String userid=String.valueOf(obj);
        userentity user=usermapper.getUserByid(userid);
        String username=user.getUsername();
        String school=user.getSchool();
        String acadamy=user.getU_acadamy();
        String number=user.getNumber();
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {

        }
        if (file.isEmpty()) {
            responseEntity.setMsg("上传失败，请选择文件");
            return responseEntity;
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/userhead/";
        File dest = new File(new File(filePath).getAbsolutePath()+ "/" + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            String url=host+":"+POST+filePath+fileName;
            String user_img=url;
            userentity user1=new userentity(userid,userpass,username,school,acadamy,number,user_img);
            usermapper.updateUser(user1);
            responseEntity.setData(user1);
            responseEntity.setMsg("上传成功");
            return responseEntity;
        } catch (IOException e) {
            responseEntity.setMsg("上传失败，请选择文件");
            return responseEntity;
        }

    }


}
