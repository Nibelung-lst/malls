
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/10/10
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<link rel="stylesheet" href="../../css/forehome/style.css" />
<nav class="top ">
    <a href="../../index.jsp">
        <span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
        商城首页
    </a>

    <c:if test="${!empty user}">
        <a href="/fore/myInformation">${user.name}</a>
        <a href="/fore/foreLoginOut">退出</a>
    </c:if>

    <c:if test="${empty user}">
        <a href="../../page/fore/ForeRegister.jsp">登录/注册</a>
    </c:if>

    <span class="pull-right">
                <a href="/fore/orderInformation">我的订单</a>
                <a href="/fore/shoppingCarShow?userId=${user.id}">
                <span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-shopping-cart redColor"></span>
                购物车<strong>
                    <c:if test="${!empty shoppingCarNumbers}">
                        ${shoppingCarNumbers}
                    </c:if>
                    <c:if test="${empty shoppingCarNumbers}">
                        0
                    </c:if></strong>件</a>
        </span>
</nav>

<div style="margin-bottom: 200px">
    <a href="#">
        <img id="simpleLogo" class="simpleLogo" src="../../image/luckin.jpg">
    </a>
</div>
<html>
<head>
    <title>商品支付</title>
</head>
<script src="../../js/jquery/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<body>
<div class="payedDiv">
    <div class="payedTextDiv">
        <span>请付款</span>
    </div>
    <div class="payedAddressInfo">
        <ul>
            <li>收货地址：${order1.address} ${order1.receiver} ${order1.telephone}</li>
            <li>实付款：<span class="payedInfoPrice">
			￥<fmt:formatNumber type="number" value="${order1.price}" minFractionDigits="2"/>
            </li>
            <li>预计12月1日送达	</li>
            <li>
                <a class="label label-success" href="/fore/paySucceed?orderId=${order1.orderId}">付款成功</a>
            </li>
        </ul>
    </div>
    <div class="payedSeperateLine">
    </div>
</div>
        <img style=" margin-left: 600px;margin-top: 0px;width: 350px;height: 500px" src="../../image/fore/fore/payOff.jpg">
</body>
</html>
