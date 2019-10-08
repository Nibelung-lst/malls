package com.lst.malls.mapper;

import com.lst.malls.pojo.ImageUrl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 附图mapper
 */
public interface ImageUrlMapper {

    /**
     * 插入附图
     * @param record
     * @return
     */
    Integer insert(ImageUrl record);

    /**
     * 根据商品名进行查询
     * @param goodsName
     * @return
     */
    List<ImageUrl> selectByGoodsName(@Param("goodsName") String goodsName);


}