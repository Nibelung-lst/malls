<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/20
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<link rel="stylesheet" href="../../css/forehome/style.css" />

<script>

</script>

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

<div >
    <a href="#">
        <img id="simpleLogo" class="simpleLogo" src="../../image/luckin.jpg">
    </a>
</div>


<form action="/fore/searchBox" method="post" >
    <div class="searchDiv">
        <input name="keyWord" type="text">
        <button  type="submit" class="searchButton">搜索</button>
        <div class="searchBelow">
            <c:forEach items="${categories}" var="c" varStatus="st">
                <c:if test="${st.count>=2 and st.count<=5}">
                            <span>
                                <a href="forecategory?cid=${c.id}">
                                        ${c.name}
                                </a>
                            </span>
                </c:if>
            </c:forEach>
        </div>
    </div>
</form>

