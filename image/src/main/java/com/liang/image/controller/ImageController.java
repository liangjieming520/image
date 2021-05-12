package com.liang.image.controller;

import com.liang.image.model.Image;
import com.liang.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    //上传图片接口
    @PostMapping("/upload")
    public String saveImage(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        try {
            InputStream is = file.getInputStream();
            Image image = new Image();
            byte[] photo = new byte[(int)file.getSize()];
            is.read(photo);
            image.setImage(photo);
            imageService.addImage(image);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    //获取图片接口
    @GetMapping("/getPhoto/{id}")
    public void getPhotoById(HttpServletResponse response, @PathVariable int id) throws IOException {
        Image images = imageService.getImage(id);
        if(images.getImage()!=null){
            byte[] data = images.getImage();
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputStream = response.getOutputStream();
            InputStream in = new ByteArrayInputStream(data);
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf, 0, 1024)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
        }
    }

}
