package com.lst.malls.controller;

import com.lst.malls.pojo.ImageURL;
import com.lst.malls.service.ImageUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author :Nibelung
 * @Date ：Created in 14:01 2019/9/24
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Controller
@RequestMapping("back")
public class ImageUrlController {
    @Autowired
    ImageUrlService imageUrlService;

    @RequestMapping("image_add")
    public String imageAdd(ImageURL imageUrl,MultipartFile file) throws IOException {
        if(imageUrl == null){
            return "static_page/Error";
        }

        String filePath = "C:\\images";
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字 //uuid通用唯一识别码
        String newFileName = UUID.randomUUID()+originalFilename;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
        imageUrl.setImgURL(newFileName);
        imageUrlService.add(imageUrl);
        return "back/ImageAdd";
    }
}