package com.lst.malls.pojo;


import java.util.Date;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 分类表表Entity
 */
public class Category {
    private Integer id;

    private String name;

    private String createName;

    private Date createTime;

    private Date finalModificationTime;

    private String finalChangeMan;

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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinalModificationTime() {
        return finalModificationTime;
    }

    public void setFinalModificationTime(Date finalModificationTime) {
        this.finalModificationTime = finalModificationTime;
    }

    public String getFinalChangeMan() {
        return finalChangeMan;
    }

    public void setFinalChangeMan(String finalChangeMan) {
        this.finalChangeMan = finalChangeMan;
    }
}