package com.lst.malls.pojo;


import javax.validation.constraints.NotBlank;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 附图表Entity
 */
public class ImageUrl {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商品名
     */
    @NotBlank
    private String goodsName;
    /**
     * 图片地址
     */
    private String imgUrl;

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
     * 得到商品名
     * @return
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 保存商品名
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * 得到附图地址
     * @return
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 保存附图地址
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}