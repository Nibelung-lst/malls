package com.lst.malls.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 用户表Entity
 */
public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户名
     */
    @NotBlank
    private String name;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 密码
     */
    @NotBlank
    private String password;
    /**
     * 性别
     */
    private Boolean sex;
    /**
     * 电话
     */
    @Size(min = 11,max = 11)
    private String telephone;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮箱
     */
    @Email
    private String email;
    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 积分
     */
    @NotBlank
    private Integer point;
    /**
     * 状态
     */
    @NotBlank
    private Boolean status;

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
     * 得到真实姓名
     * @return
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 保存真实姓名
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
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

    /**
     * 得到性别
     * @return
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 保存性别
     * @param sex
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 得到电话号码
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 保存电话号码
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 得到地址
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * 保存地址
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 得到电子邮箱
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 保存电子邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 得到生日日期
     * @return
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 保存生日日期
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 得到积分
     * @return
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * 保存积分
     * @param point
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * 得到状态
     * @return
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 保存状态
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}