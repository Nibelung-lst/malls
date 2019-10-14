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
 * @Description :商品附图管理service
 */
@Service
public class ImageUrlServiceImpl implements ImageUrlService {
    /**
     * 附图表的sql方法
     */
    @Autowired
    ImageUrlMapper imageUrlMapper;

    /**
     * 添加附图
     * @param imageUrl 附图对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(ImageUrl imageUrl) {
        imageUrlMapper.insert(imageUrl);
    }

    /**
     * 显示附图
     * @param goodsName 商品名
     * @return 附图对象数组
     */
    @Override
    public List<ImageUrl> get(String goodsName) {
        return imageUrlMapper.selectByGoodsName(goodsName);
    }
}
