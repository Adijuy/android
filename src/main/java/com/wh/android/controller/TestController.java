package com.wh.android.controller;



import com.wh.android.entity.Result;
import com.wh.android.utils.Images;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Base64.Encoder;

@RequestMapping("/test")
@Controller
public class TestController {

    @Resource
    Images images;
    @Value("${server.port}")
    String port;
    @GetMapping("/image")
    public ResponseEntity<byte[]> testImage(HttpServletRequest request , HttpServletResponse response) throws Exception {
        byte[] image = images.getImage();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image,headers, HttpStatus.OK);

    }
    @GetMapping("/msg")
    @ResponseBody
    public Object getImage(HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");

        byte[] image = images.getImage();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        Encoder encoder = Base64.getEncoder();
        return new Result("200","lailalaodi",encoder.encodeToString(image));

    }
}
