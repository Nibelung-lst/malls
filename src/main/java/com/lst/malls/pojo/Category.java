package com.lst.malls.pojo;


import java.util.Date;


public class Category {
    private Integer id;

    private String name;

    private String create_name;

    private Date create_time;

    private Date final_modification_time;

    private String final_change_man;

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

    public String getCreate_name() {
        return create_name;
    }

    public void setCreate_name(String create_name) {
        this.create_name = create_name == null ? null : create_name.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getFinal_modification_time() {
        return final_modification_time;
    }

    public void setFinal_modification_time(Date final_modification_time) {
        this.final_modification_time = final_modification_time;
    }

    public String getFinal_change_man() {
        return final_change_man;
    }


    public void setFinal_change_man(String final_change_man) {
        this.final_change_man = final_change_man == null ? null : final_change_man.trim();
    }
}