package com.lst.malls.service;

import com.lst.malls.pojo.Goods;

import java.util.List;
/**
 * @Author    :Nibelung
 * @Date      ：Created in 17:17 2019/9/12
 * @Description :
 * @Modified By :
 * @Version : $
 */
public interface GoodsService {

    /**
     * 展示
     * @return
     */
    List<Goods> list();


    /**
     * 展示相应分类下的商品
     * @param category_name
     * @return
     */
    List<Goods> listCategory(String category_name);

    /**
     * 添加商品
     * @param goods
     */
    void add(Goods goods);


    /**
     * 商品名字查重
     * @param name
     * @return
     */
    boolean exist(String name);

    /**
     * 根据主键进行删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新商品
     * @param goods
     */
    void update(Goods goods);

    /**
     * 通过主键进行查询
     * @param id
     * @return
     */
    Goods get(Integer id);

}
