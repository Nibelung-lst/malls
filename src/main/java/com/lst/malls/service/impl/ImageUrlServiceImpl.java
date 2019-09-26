package com.lst.malls.service.impl;

import com.lst.malls.mapper.ImageURLMapper;
import com.lst.malls.pojo.ImageURL;
import com.lst.malls.pojo.ImageURLExample;
import com.lst.malls.service.ImageUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 14:02 2019/9/24
 * @Description :
 * @Modified By :
 * @Version : $
 */
@Service
public class ImageUrlServiceImpl implements ImageUrlService {
    @Autowired
    ImageURLMapper imageUrlMapper;

    @Override
    public void add(ImageURL imageUrl) {
        imageUrlMapper.insert(imageUrl);
    }

    @Override
    public List<ImageURL> get(String goodsName) {
        ImageURLExample example = new ImageURLExample();
        example.createCriteria().andGoods_nameEqualTo(goodsName);
        List<ImageURL> imageUrls = imageUrlMapper.selectByExample(example);
        return imageUrls;
    }
}
