package com.lst.malls.mapper;

import com.lst.malls.pojo.ImageURL;
import com.lst.malls.pojo.ImageURLExample;
import java.util.List;

public interface ImageURLMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImageURL record);

    int insertSelective(ImageURL record);

    List<ImageURL> selectByExample(ImageURLExample example);

    ImageURL selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImageURL record);

    int updateByPrimaryKey(ImageURL record);
}