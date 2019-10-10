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
    $(function(){


        $("div.rightMenu span").mouseleave(function(){
            $("img#catear").hide();
        });

        var left = $("div#carousel-of-product").offset().left;
        $("div.categoryMenu").css("left",left-20);
        $("div.categoryWithCarousel div.head").css("margin-left",left);
        $("div.productsAsideCategorys").css("left",left-20);

    });


    $(function () {
        $("#Category1Button").click(function () {
            $(".category1Menu").fadeToggle("");
        })


    })

</script>
<style>

    .head1{
        width: 200px;
        background-color: #610B38;
        height: 36px;
        line-height: 36px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        margin-left: 40px;
        display: inline-block;
    }
    .head2{
        width: 200px;
        background-color: #610B38;
        height: 36px;
        line-height: 36px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        margin-left: 80px;
        display: inline-block;
    }

    .head3{
        width: 200px;
        background-color: #610B38;
        height: 36px;
        line-height: 36px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        margin-left: 120px;
        display: inline-block;
    }

</style>


<div id="category">
    <div class="categoryWithCarousel">

        <div class="headbar show1" >
            <div class="head1 " style="display: inline-block;cursor: pointer">
                <span style="margin-left:50px" id="CategoryButton">商品分类</span>
            </div>

            <div class="head2 " style="display: inline-block;cursor: pointer">
                <span style="margin-left:50px" id="nae">科幻</span>
            </div>
            s
            <div class="head3" style="display: inline-block;cursor: pointer">
                <span style="margin-left:50px" id="ds">网络小说</span>
            </div>

            <div class="head3" style="display: inline-block;cursor: pointer">
                <span style="margin-left:50px" id="ds1">文学</span>
            </div>

        </div>
        <div class="categoryMenu" style="margin-top: 37px;background: black;opacity: 0.5;">
            <c:forEach items="${ForeCategory}" var="category">
                <div  class="eachCategory"  >
                    <a  style="color: white;font-weight:bold" href="/fore/categoryGoods?categoryName=${category.name}">${category.name}</a>
                </div>
            </c:forEach>
        </div>
    </div>




    <div class="categoryPageDiv">

        <div class="categoryProducts" >
            <c:forEach items="${CategoryGood}" var="goods" >
                    <div   class="categoryGoods" style="width: 230px;height: 300px;float: left;box-sizing: border-box;margin-left: 10px;margin-top: 10px">

                            <a href="/fore/Goods?goodsName=${goods.name}">
                                <img width="228px" height="235px" class="goodsImage" src="/images/${goods.image }">
                            </a>

                        <div style="background-color: #F0F0F0;">
                            <div>
                                <del>¥<fmt:formatNumber type="number" value="${goods.originalPrice}" minFractionDigits="2"/></del>
                            </div>
                            <div>
                                <span style="color: red;font-size: 20px">¥<fmt:formatNumber type="number" value="${goods.realPrice}" minFractionDigits="2"/></span>
                            </div>

                        <div>
                            <a  href="/fore/Goods?goodsName=${goods.name}">
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
