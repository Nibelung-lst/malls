package com.lst.malls.pojo;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 分类表表Entity
 */
public class Category {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 分类名
     */
    @NotBlank
    private String name;
    /**
     * 创建人名
     */
    @NotBlank
    private String createName;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private Date createTime;
    /**
     * 最后修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finalModificationTime;
    /**
     * 最后修改人
     */
    private String finalChangeMan;

    /**
     * 得到主键
     */
    public Integer getId() {
        return id;
    }
    /**
     * 保存主键
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 得到分类名
     */
    public String getName() {
        return name;
    }
    /**
     * 保存分类名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    /**
     * 得到创建人名
     * @return
     */
    public String getCreateName() {
        return createName;
    }
    /**
     * 保存创建人名
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * 得到创建时间
     * @return
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 保存创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 得到最终修改时间
     * @return
     */
    public Date getFinalModificationTime() {
        return finalModificationTime;
    }

    /**
     * 保存最终修改时间
     * @param finalModificationTime
     */
    public void setFinalModificationTime(Date finalModificationTime) {
        this.finalModificationTime = finalModificationTime;
    }

    /**
     * 得到最终修改人
     * @return
     */
    public String getFinalChangeMan() {
        return finalChangeMan;
    }

    /**
     * 保存最终修改人
     * @param finalChangeMan
     */
    public void setFinalChangeMan(String finalChangeMan) {
        this.finalChangeMan = finalChangeMan;
    }
}