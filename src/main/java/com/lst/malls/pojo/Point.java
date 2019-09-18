package com.lst.malls.pojo;

import java.util.Date;

public class Point {
    private Integer id;

    private Integer user_id;

    private Integer point;

    private Integer total_point;

    private Integer order_id;

    private Date create_time;

    /**非数据库实体类----------------------------------------*/
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    /**---------------分割线-----------------------------------*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getTotal_point() {
        return total_point;
    }

    public void setTotal_point(Integer total_point) {
        this.total_point = total_point;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}