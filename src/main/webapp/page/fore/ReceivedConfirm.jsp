<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/30
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/fore/top.jsp"%>

<div class="payedDiv">
    <div class="payedTextDiv">
        <img src=../../image/fore/paySuccess.jpg>
        <span>您已成功付款</span>

    </div>
    <div class="payedAddressInfo">
        <ul>
            <li>订单编号：${order2.order_ID}</li>
            <li>获得积分：<span class="payedInfoPrice">
			<fmt:formatNumber type="number" value="${order2.price}"/>
            </li>
            <li>卖家将收到您的货款</li>
        </ul>

        <div class="paedCheckLinkDiv">
            您可以
            <a class="payedCheckLink" href="/fore/orderReceived?status=已完成">查看交易详情 </a>
        </div>

    </div>

    <div class="payedSeperateLine">
    </div>


</div>