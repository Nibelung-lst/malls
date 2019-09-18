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
     * 展示
     * @return
     */
    List<Goods> listCategory(String category_name);

    /**
     * 添加分类
     * */

    void add(Goods goods);


    /**
     * 查重
     */
    boolean exist(String name);

    /**
     *
     * 删除分类By id
     */
    void delete(Integer id);

    /**
     *
     *更新分类
     */
    void update(Goods goods);

    /**
     * 通过主键进行查询
     * @param id
     * @return
     */
    Goods get(Integer id);

}
