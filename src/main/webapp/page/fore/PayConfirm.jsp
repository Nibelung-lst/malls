<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/26
  Time: 9:00
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
            <li>收货地址：${order1.address} ${order1.receiver} ${order1.telephone}</li>
            <li>实付款：<span class="payedInfoPrice">
			￥<fmt:formatNumber type="number" value="${order1.price}" minFractionDigits="2"/>
            </li>
            <li>预计12月1日送达	</li>
        </ul>

        <div class="paedCheckLinkDiv">
            您可以
            <a class="payedCheckLink" href="/fore/orderInformation">查看交易详情 </a>
        </div>

    </div>

    <div class="payedSeperateLine">
    </div>


</div>
