package com.lst.malls.service.impl;

import com.lst.malls.mapper.GoodsMapper;
import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.ImageUrl;
import com.lst.malls.service.GoodsService;
import com.lst.malls.service.ImageUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author :Nibelung
 * @Date ：Created in 17:19 2019/9/12
 * @Description :商品管理与显示service
 */

@Service
public class GoodsServiceImpl implements GoodsService {
    /**
     * 商品表的sql方法
     */
    @Autowired
    GoodsMapper goodsMapper;
    /**
     * 附图表的sql方法
     */
    @Autowired
    ImageUrlService imageUrlService;

    /**
     * 展示
     * @return 商品对象数组
     */
    @Override
    public List<Goods> list(){

        List<Goods> goods = goodsMapper.select();

        return goods;
    }

    /**
     * 展示相应分类下的商品
     * @param categoryName 分类名
     * @return 商品对象数组
     */
    @Override
    public List<Goods> listCategory(String categoryName) {

        List<Goods> goods =goodsMapper.selectByCategory(categoryName);

        return goods;
    }

    /**
     * 添加商品
     * @param goods 商品对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

    /**
     * 根据主键进行删除
     * @param id 商品主键
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        goodsMapper.delete(id);
    }

    /**
     * 商品名字查重
     * @param name 商品名
     * @return boolean
     */
    @Override
    public boolean exist(String name) {

        Goods goods = goodsMapper.selectByName(name);

        if (goods == null){

            return true;
        }
        return false;
    }

    /**
     * 更新商品
     * @param goods 商品对象
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);

    }


    /**
     * 通过主键进行查询
     * @param id 商品主键
     * @return 商品对象
     */
    @Override
    public Goods get(Integer id) {
        Goods goods =goodsMapper.selectById(id);
        return goods;
    }

    /**
     * 通过商品名查询商品
     * @param goodName 商品名
     * @return 商品对象
     */
    @Override
    public Goods getByName(String goodName) {
        List<ImageUrl> imageUrls = imageUrlService.get(goodName);
        Goods goods = goodsMapper.selectByName(goodName);
        goods.setImageUrls(imageUrls);
        return goods;
    }


}
