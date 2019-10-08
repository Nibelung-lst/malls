package com.lst.malls.pojo;

/**
 * @Author: Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 管理员表Entity
 */
public class Admin {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 管理员名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

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
     * 得到用户名
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 保存用户名
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 得到密码
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 保存密码
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}