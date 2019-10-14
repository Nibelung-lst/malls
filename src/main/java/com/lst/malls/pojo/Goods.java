package com.lst.malls.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 商品表Entity
 */
public class Goods {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 商品名
     */
    @NotBlank
    private String name;
    /**
     * 商品图片
     */
    private String image;
    /**
     * 原价
     */
    @DecimalMin("0")
    private BigDecimal originalPrice;
    /**
     * 现价
     */
    @DecimalMin("0")
    private BigDecimal realPrice;
    /**
     * 描述
     */
    private String represent;
    /**
     * 分类名
     */
    private String categoryName;
    /**
     * 创建人
     */
    @NotBlank
    private String creater;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    /**
     * 最后修改人
     */
    private String finalChanger;
    /**
     * 最后修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finalChangeTime;
    /**
     * 附图路径
     */
    private List<ImageUrl> imageUrls;
    /**
     * 商品数量
     */
    @Min(0)
    private Integer num;

    /**
     * 取得主键
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
    public String getName() {
        return name;
    }

    /**
     * 保存商品名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 得到图片地址
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     * 保存图片地址
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 得到原价
     * @return
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 保存原价
     * @param originalPrice
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 得到现价
     * @return
     */
    public BigDecimal getRealPrice() {
        return realPrice;
    }

    /**
     * 保存现价
     * @param realPrice
     */
    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    /**
     * 得到描述
     * @return
     */
    public String getRepresent() {
        return represent;
    }

    /**
     * 保存描述
     * @param represent
     */
    public void setRepresent(String represent) {
        this.represent = represent;
    }

    /**
     * 得到分类名
     * @return
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 保存分类名
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 得到创建人
     * @return
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 保存创建人
     * @param creater
     */
    public void setCreater(String creater) {
        this.creater = creater;
    }

    /**
     * 得到创建时间
     * @return
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 保存创建时间
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 得到最后修改人
     * @return
     */
    public String getFinalChanger() {
        return finalChanger;
    }

    /**
     * 保存最后修改人
     * @param finalChanger
     */
    public void setFinalChanger(String finalChanger) {
        this.finalChanger = finalChanger;
    }

    /**
     * 得到最后修改时间
     * @return
     */
    public Date getFinalChangeTime() {
        return finalChangeTime;
    }

    /**
     * 保存最后修改时间
     * @param finalChangeTime
     */
    public void setFinalChangeTime(Date finalChangeTime) {
        this.finalChangeTime = finalChangeTime;
    }

    /**
     * 得到商品数量
     * @return
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 保存商品数量
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 得到附图地址
     * @return
     */
    public List<ImageUrl> getImageUrls() {
        return imageUrls;
    }

    /**
     * 保存附图地址
     * @param imageUrls
     */
    public void setImageUrls(List<ImageUrl> imageUrls) {
        this.imageUrls = imageUrls;
    }




}