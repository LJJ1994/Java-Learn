package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: LJJ
 * @Program: springmvc-day1
 * @Description:
 * @Create: 2020-05-10 04:38:38
 * @Modified By:
 */
@RequestMapping("/upload")
@Controller
public class FileUploadController {
    @GetMapping("/index")
    public String index(){
        return "fileupload";
    }

    @PostMapping()
    public String upload(String picname, MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        String filename = "";
        String uploadFilename = uploadFile.getOriginalFilename();
        assert uploadFilename != null;
        String extendName = uploadFilename.substring(uploadFilename.lastIndexOf(".")+1, uploadFilename.length());
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        if (!StringUtils.isEmpty(picname)){
            filename = uuid + "_" + picname + "." + extendName;
        }else {
            filename = uuid + "_" + uploadFilename;
        }
        //获取文件路径
        ServletContext context = request.getSession().getServletContext();
        String realPath = context.getRealPath("/uploads");
        String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(realPath + "/" + datePath);
        if (!file.exists()){
            file.mkdirs();
        }
        uploadFile.transferTo(new File(file, filename));
        return "success";
    }
}
