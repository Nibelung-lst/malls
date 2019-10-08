package com.lst.malls.service.impl;

import com.lst.malls.mapper.ImageUrlMapper;
import com.lst.malls.pojo.ImageUrl;
import com.lst.malls.service.ImageUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    ImageUrlMapper imageUrlMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(ImageUrl imageUrl) {
        imageUrlMapper.insert(imageUrl);
    }

    @Override
    public List<ImageUrl> get(String goodsName) {

        List<ImageUrl> imageUrls = imageUrlMapper.selectByGoodsName(goodsName);
        return imageUrls;
    }
}
