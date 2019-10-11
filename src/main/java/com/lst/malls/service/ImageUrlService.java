package com.lst.malls.service;

import com.lst.malls.pojo.ImageUrl;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 14:02 2019/9/24
 * @Description :附图Service
 */
public interface ImageUrlService {

    /**
     * 添加附图
     * @param imageUrl 附图对象
     */
    void add(ImageUrl imageUrl);

    /**
     * 显示附图
     * @param goodsName 商品名
     * @return 附图对象数组
     */
    List<ImageUrl> get(String goodsName);

}
