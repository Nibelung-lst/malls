package com.lst.malls.mapper;

import com.lst.malls.pojo.ImageURL;
import com.lst.malls.pojo.ImageURLExample;
import java.util.List;

/**
 * @Author:Nibelung
 */
public interface ImageURLMapper {

    /**
     * 插入附图
     * @param record
     * @return
     */
    int insert(ImageURL record);


    /**
     * 根据条件查询附图
     * @param example
     * @return
     */
    List<ImageURL> selectByExample(ImageURLExample example);

}