package com.example.android.controller;
import com.example.android.entity.ResponseEntity;
import com.example.android.entity.wenjianentity;
import com.example.android.mapper.wenjianmapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class wenjianupload {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);
    @Value("${server.port}")
    //获取主机端口
    private String POST;
    @Resource
    private com.example.android.mapper.wenjianmapper wenjianmapper;

    @PostMapping("/uploadfile")
    @ResponseBody
    public ResponseEntity uploadfile (@RequestParam("file") MultipartFile file) {
        ResponseEntity responseEntity=new ResponseEntity(0,"上传失败","");

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
        String filePath ="/userhead/";
        File dest = new File(new File(filePath).getAbsolutePath()+ "/" + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            String file_url=host+":"+POST+filePath+fileName;
            String file_name=fileName;
            long id=System.currentTimeMillis();
            String file_id=String.valueOf(id);
            wenjianentity wenjian=new wenjianentity(file_id,file_name,file_url);
            wenjianmapper.wenjian(wenjian);
            responseEntity.setMsg("上传成功");
            responseEntity.setData(1);
            return responseEntity;
        } catch (IOException e) {
            return responseEntity;
        }

    }
    @RequestMapping(value="/showwenjian")
    public ResponseEntity showwenjian(){
        ResponseEntity responseEntity=new ResponseEntity(0,"获取失败","");
        try{
            List<wenjianentity> wenjianlist=wenjianmapper.wenjianlist();
            responseEntity.setData(wenjianlist);
            responseEntity.setMsg("获取成功");
            responseEntity.setStatus(1);
            return responseEntity;
        }catch(Exception e){
            responseEntity.setMsg("获取失败");
            responseEntity.setStatus(0);
        }
        return responseEntity;
    }

}
