package com.lst.malls.service;

import com.lst.malls.pojo.Goods;

import java.util.List;
/**
 * @Author    :Nibelung
 * @Date      ：Created in 17:17 2019/9/12
 * @Description :商品Service
 */
public interface GoodsService {

    /**
     * 展示
     * @return 商品对象数组
     */
    List<Goods> list();


    /**
     * 展示相应分类下的商品
     * @param categoryName 分类名
     * @return 商品对象数组
     */
    List<Goods> listCategory(String categoryName);

    /**
     * 添加商品
     * @param goods 商品对象
     */
    void add(Goods goods);


    /**
     * 商品名字查重
     * @param name 商品名
     * @return boolean
     */
    boolean exist(String name);

    /**
     * 根据主键进行删除
     * @param id 商品主键
     */
    void delete(Integer id);

    /**
     * 更新商品
     * @param goods 商品对象
     */
    void update(Goods goods);

    /**
     * 通过主键进行查询
     * @param id 商品主键
     * @return 商品对象
     */
    Goods get(Integer id);

    /**
     * 通过商品名查询商品
     * @param goodName 商品名
     * @return 商品对象
     */
    Goods getByName(String goodName);


}
