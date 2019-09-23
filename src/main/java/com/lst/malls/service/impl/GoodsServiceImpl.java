package com.lst.malls.service.impl;

import com.lst.malls.mapper.GoodsMapper;
import com.lst.malls.pojo.Goods;
import com.lst.malls.pojo.GoodsExample;
import com.lst.malls.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 查询Admin表里的账户数据
     *
     * @return admin
     */
    @Override
    public List<Goods> list(){
        GoodsExample example = new GoodsExample();
        //使用list接受
        List<Goods> goods = goodsMapper.selectByExample(example);

        return goods;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Goods> listCategory(String category_name) {

        List<Goods> goods =goodsMapper.selectByExampleWithCategory(category_name);

        return goods;
    }

    /**
     *
     * @return
     */
    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

    /**
     *
     * @return
     */
    @Override
    public void delete(Integer id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查重
     * @param name
     */
    @Override
    public boolean exist(String name) {
        GoodsExample example = new GoodsExample();
        //通过 name 调用Example里的方法进行校验
        example.createCriteria().andNameEqualTo(name);
        //如果数据库内有字段相同的name，就给categories赋值
        List<Goods> goods = goodsMapper.selectByExample(example);

        if (goods.isEmpty()){

            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public void update(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);

    }


    /**
     *
     * @return
     */
    @Override
    public Goods get(Integer id) {
        Goods goods =goodsMapper.selectByPrimaryKey(id);
        return goods;
    }


}
