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

<hr>
<div id="category">
    <div class="categoryPageDiv">


        <div class="categoryProducts" >
            <c:forEach items="${CategoryGood}" var="goods" >
                    <div style="width: 240px;height: 300px;float: left;box-sizing: border-box;display: inline-block">
                            <a href="#">
                                <img width="180px" height="180px" class="goodsImage" src="/images/${goods.image }">
                            </a>
                        <div>
                            <del>¥<fmt:formatNumber type="number" value="${goods.original_price}" minFractionDigits="2"/></del>
                        </div>
                        <div>
                            <span style="color: red;font-size: 20px">¥<fmt:formatNumber type="number" value="${goods.real_price}" minFractionDigits="2"/></span>
                        </div>
                        <div>
                            <a  href="#">
                                    ${fn:substring(goods.name, 0, 50)}
                            </a>
                        </div>
                    </div>
            </c:forEach>
            <div style="clear:both"></div>
        </div>

    </div>
</div>
