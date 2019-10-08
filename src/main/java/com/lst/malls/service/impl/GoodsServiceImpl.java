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
 * @Description :
 * @Modified By :
 * @Version : $
 */

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ImageUrlService imageUrlService;

    /**
     * 查询Admin表里的账户数据
     *
     * @return admin
     */
    @Override
    public List<Goods> list(){

        List<Goods> goods = goodsMapper.select();

        return goods;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Goods> listCategory(String categoryName) {

        List<Goods> goods =goodsMapper.selectByCategory(categoryName);

        return goods;
    }

    /**
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

    /**
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        goodsMapper.delete(id);
    }

    /**
     * 查重
     * @param name
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
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);

    }


    /**
     *
     * @return
     */
    @Override
    public Goods get(Integer id) {
        Goods goods =goodsMapper.selectById(id);
        return goods;
    }

    /**
     * 通过商品名查询商品
     * @param goodName
     * @return
     */
    @Override
    public Goods getByName(String goodName) {
        List<ImageUrl> imageUrls = imageUrlService.get(goodName);
        Goods goods = goodsMapper.selectByName(goodName);
        goods.setImageUrls(imageUrls);
        return goods;
    }


}
