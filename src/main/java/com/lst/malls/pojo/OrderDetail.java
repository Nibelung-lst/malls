package com.lst.malls.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 订单详情表Entity
 */
public class OrderDetail {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单编号
     */
    @NotBlank
    private Long orderId;
    /**
     * 商品编号
     */
    @NotBlank
    private Integer goodsId;
    /**
     * 商品数量
     */
    @Min(0)
    private Integer number;

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
     * 得到订单编号
     * @return
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 保存订单编号
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
    public Integer getNumber() {
        return number;
    }

    /**
     * 保存商品数量
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}