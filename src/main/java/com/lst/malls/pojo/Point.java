package com.lst.malls.pojo;

import java.util.Date;
/**
 * @Author:Nibelung
 * @Date ：Created in 14:52 2019/10/8
 * @Description: 积分表Entity
 */
public class Point {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 得到的积分
     */
    private Integer point;
    /**
     * 总积分
     */
    private Integer totalPoint;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**非数据库实体类----------------------------------------*/
    /**
     * 用户信息
     */
    private User user;

    /**
     * 得到用户信息
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * 保存用户信息
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * 订单信息
     */
    private Order order;

    /**
     * 得到订单信息
     * @return
     */
    public Order getOrder() {
        return order;
    }

    /**
     * 保存订单信息
     * @param order
     */
    public void setOrder(Order order) {
        this.order = order;
    }
    /**---------------分割线-----------------------------------*/

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
     * 得到用户ID
     * @return
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 保存用户ID
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 得到得到的积分
     * @return
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * 保存得到的积分
     * @param point
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * 得到总积分
     * @return
     */
    public Integer getTotalPoint() {
        return totalPoint;
    }

    /**
     * 保存总积分
     * @param totalPoint
     */
    public void setTotalPoint(Integer totalPoint) {
        this.totalPoint = totalPoint;
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
}