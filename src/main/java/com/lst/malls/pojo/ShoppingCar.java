package com.lst.malls.pojo;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 购物车表Entity
 */
public class ShoppingCar {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer numbers;

    /**非数据库实体类--------------------------------*/
    /**
     * 商品信息
     */
    private Goods goods;

    /**
     * 得到商品信息
     * @return
     */
    public Goods getGoods() {
        return goods;
    }

    /**
     * 保存商品信息
     * @param goods
     */
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    /**--------------------------------------------*/

    /**
     * 得到主键
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 保存主键
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 得到用户ID
     * @return
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 保存用户ID
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 得到商品ID
     * @return
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 保存商品ID
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 得到商品数量
     * @return
     */
    public Integer getNumbers() {
        return numbers;
    }

    /**
     * 保存商品数量
     * @param numbers
     */
    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}