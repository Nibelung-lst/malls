package com.lst.malls.mapper;

import com.lst.malls.pojo.Category;
import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.GoodsExample;
import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectByExampleWithCategory(String category_name);

    Goods selectByName(String name);
}