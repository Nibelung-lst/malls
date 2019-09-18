package com.lst.malls.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    private Integer id;

    private String name;

    private String image;

    private BigDecimal original_price;

    private BigDecimal real_price;

    private String represent;

    private String category_name;

    private String creater;

    private Date create_date;

    private String final_changer;

    private Date final_change_time;

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
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public BigDecimal getoriginal_price() {
        return original_price;
    }

    public void setoriginal_price(BigDecimal original_price) {
        this.original_price = original_price;
    }

    public BigDecimal getReal_price() {
        return real_price;
    }

    public void setReal_price(BigDecimal real_price) {
        this.real_price = real_price;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent == null ? null : represent.trim();
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name == null ? null : category_name.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getFinal_changer() {
        return final_changer;
    }

    public void setFinal_changer(String final_changer) {
        this.final_changer = final_changer == null ? null : final_changer.trim();
    }

    public Date getFinal_change_time() {
        return final_change_time;
    }

    public void setFinal_change_time(Date final_change_time) {
        this.final_change_time = final_change_time;
    }
}