package com.lst.malls.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;

    private String order_ID;

    private String address;

    private String receiver;

    private String telephone;

    private BigDecimal price;

    private Date creator_time;

    private Date finsh_time;

    private String status;

    private String user_name;

    /**非数据库实体类----------------------*/
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

   /**------------------------------------*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID == null ? null : order_ID.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreator_time() {
        return creator_time;
    }

    public void setCreator_time(Date creator_time) {
        this.creator_time = creator_time;
    }

    public Date getFinsh_time() {
        return finsh_time;
    }

    public void setFinsh_time(Date finsh_time) {
        this.finsh_time = finsh_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }
}