package com.lst.malls.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 订单表Entity
 */
public class Order {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 地址
     */
    private String address;
    /**
     * 收货人
     */
    private String receiver;
    /**
     * 电话
     */
    @Size(min = 11,max = 11)
    private String telephone;
    /**
     * 总价
     */
    @DecimalMin("0")
    private BigDecimal price;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private Date creatorTime;
    /**
     * 完成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finshTime;
    /**
     * 订单状态
     */
    @NotBlank
    private String status;
    /**
     * 用户名
     */
    @NotBlank
    private String userName;

    /**非数据库实体类----------------------*/
    /**
     * 订单详情
     */
    private List<OrderDetail> orderDetails;

    /**
     * 得到订单详情
     * @return
     */
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    /**
     * 保存订单详情
     * @param orderDetails
     */
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    /**------------------------------------*/

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
        this.address = address;
    }

    /**
     * 得到收货人
     * @return
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 保存收货人
     * @param receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 得到电话
     * @return
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 保存电话
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 得到订单金额
     * @return
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 保存订单金额
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 得到创建时间
     * @return
     */
    public Date getCreatorTime() {
        return creatorTime;
    }

    /**
     * 保存创建时间
     * @param creatorTime
     */
    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

    /**
     * 得到完成时间
     * @return
     */
    public Date getFinshTime() {
        return finshTime;
    }

    /**
     * 保存完成时间
     * @param finshTime
     */
    public void setFinshTime(Date finshTime) {
        this.finshTime = finshTime;
    }

    /**
     * 得到状态
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * 保存状态
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 得到用户名
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 保存用户名
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}