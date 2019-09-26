package com.lst.malls.service;

import com.lst.malls.pojo.ImageURL;

import java.util.List;

/**
 * @Author    :Nibelung
 * @Date      ：Created in 14:02 2019/9/24
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface ImageUrlService {

    /**
     * 添加附图
     * @param imageUrl
     */
    void add(ImageURL imageUrl);

    /**
     * 显示附图
     * @param goodsName
     * @return
     */
    List<ImageURL> get(String goodsName);

}
