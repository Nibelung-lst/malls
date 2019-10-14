package com.lst.malls.controller;

import com.lst.malls.pojo.ImageUrl;
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
 * @Description :附图controller
 */
@Controller
@RequestMapping("back")
public class ImageUrlController {
    /**
     * 附图service
     */
    @Autowired
    ImageUrlService imageUrlService;

    /**
     * 添加附图
     * @param imageUrl 前台传递回来的附图实体类
     * @param file 前台传递回来的文件
     * @return 跳转到相应页面
     * @throws IOException 图片上传文件异常
     */
    @RequestMapping("imageAdd")
    public String imageAdd(ImageUrl imageUrl, MultipartFile file) throws IOException {
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
        imageUrl.setImgUrl(newFileName);
        imageUrlService.add(imageUrl);
        return "back/ImageAdd";
    }
}
