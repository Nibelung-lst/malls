<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/22
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/fore/top.jsp"%>

<script>

</script>
<style>
    .categoryGoods:hover{
        border:2px solid #FE2E2E;
    }
    .eachCategory:hover{
        background-color: #d0d0d0;
    }
</style>
<div style="background-color: red" >&nbsp;</div>

<div id="category">
    <div style="width: 230px;height:400px;float: left;box-sizing: border-box;">
        <div class="categoryMenu" style="background-color: white">
            <c:forEach items="${ForeCategory}" var="category">
                <div  class="eachCategory" style="margin-top: 10px" >
                    <a style="font-size: 20px;color: #6C6C6C" href="/fore/CategoryGoods?categoryName=${category.name}">${category.name}</a>
                </div>
            </c:forEach>
        </div>

    </div>
    <div class="categoryPageDiv" style="background-color: white">

        <div class="categoryProducts" >
            <c:forEach items="${CategoryGood}" var="goods" >
                    <div   class="categoryGoods" style="width: 230px;height: 300px;float: left;box-sizing: border-box;margin-left: 10px;margin-top: 10px">

                            <a href="/fore/Goods?name=${goods.name}">
                                <img width="228px" height="235px" class="goodsImage" src="/images/${goods.image }">
                            </a>

                        <div style="background-color: #F0F0F0;">
                            <div>
                                <del>¥<fmt:formatNumber type="number" value="${goods.original_price}" minFractionDigits="2"/></del>
                            </div>
                            <div>
                                <span style="color: red;font-size: 20px">¥<fmt:formatNumber type="number" value="${goods.real_price}" minFractionDigits="2"/></span>
                            </div>

                        <div>
                            <a  href="/fore/Goods?name=${goods.name}">
                                    ${fn:substring(goods.name, 0, 50)}
                            </a>
                        </div>
                        </div>

                    </div>
            </c:forEach>
            <div style="clear:both"></div>
        </div>

    </div>
</div>
