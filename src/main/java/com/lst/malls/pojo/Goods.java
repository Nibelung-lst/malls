package com.lst.malls.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * @Author:Nibelung
 */
public class Goods {
    private Integer id;

    private String name;

    private String image;

    private BigDecimal originalPrice;

    private BigDecimal realPrice;

    private String represent;

    private String categoryName;

    private String creater;

    private Date createDate;

    private String finalChanger;

    private Date finalChangeTime;

    private List<ImageUrl> imageUrls;


    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFinalChanger() {
        return finalChanger;
    }

    public void setFinalChanger(String finalChanger) {
        this.finalChanger = finalChanger;
    }

    public Date getFinalChangeTime() {
        return finalChangeTime;
    }

    public void setFinalChangeTime(Date finalChangeTime) {
        this.finalChangeTime = finalChangeTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<ImageUrl> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<ImageUrl> imageUrls) {
        this.imageUrls = imageUrls;
    }




}