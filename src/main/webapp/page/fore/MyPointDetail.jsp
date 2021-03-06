<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/30
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<script src="../../js/jquery/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li>
                    <a href="/fore/myInformation">首页</a>
                </li>
                <li >
                    <a href="/fore/myInformationChangeList">修改</a>
                </li>
                <li class="active">
                    <a href="#">积分详情</a>
                </li>
                <li class="disabled">
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">操作</a>
                        </li>
                        <li>
                            <a href="#">设置栏目</a>
                        </li>
                        <li>
                            <a href="#">更多设置</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">分割线</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <form method="post">
                <!--显示表格数据-->
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-hover table-bordered">
                            <tr class="success">
                                <th>订单号</th>
                                <th>积分</th>
                                <th>总积分</th>
                                <th>创建时间</th>
                            </tr>
                            <c:forEach items="${points}" var="point">
                                <tr>
                                    <th>${point.orderId}</th>
                                    <th>${point.point}</th>
                                    <th>${point.totalPoint}</th>
                                    <th><fmt:formatDate type="date" value="${point.createTime}" /></th>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>