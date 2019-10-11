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
     * @param record 附图对象
     * @return 插入成功
     */
    Integer insert(ImageUrl record);

    /**
     * 根据商品名进行查询
     * @param goodsName 商品名
     * @return 附图对象数组
     */
    List<ImageUrl> selectByGoodsName(@Param("goodsName") String goodsName);


}