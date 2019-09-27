<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/24
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/22
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/fore/top.jsp"%>

<script src="../../js/jquery/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<title>简易商城 </title>
<script>
    $(function () {

    $(".productNumberSetting").keyup(function(){
        var num= $(".productNumberSetting").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        $(".productNumberSetting").val(num);
    });

    $(".increaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        num++;
        $(".productNumberSetting").val(num);
    });
    $(".decreaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        --num;
        if(num<=0)
            num=1;
        $(".productNumberSetting").val(num);
    });


    })
$(function () {
    $(".buyButton").click(function () {
        var num = $(".productNumberSetting").val();
        location.href= $(".buyLink").attr('href','/fore/puyNow?id=${commodity.id}&goodsNumbers='+num)
    });
});
    $(function () {
        $(".addCartButton").click(function () {
            var num = $(".productNumberSetting").val();
            location.href= $(".addCartLink").attr('href','/fore/shoppingCarAdd?goodsId=${commodity.id}&goodsNumbers='+num)
        });
    });


</script>
<div style="background-color: red" >&nbsp;</div>

<div class="productPageDiv" style="background-color: white">


    <div class="imgAndInfo" >

        <div class="imgInimgAndInfo" >
            <img src="/images/${commodity.image }" class="bigImg">

        </div>


        <div class="infoInimgAndInfo">

            <div class="productTitle">
                ${commodity.name}

            </div>
            <div class="productTitle" style="color: #A4A4A4">
                ${commodity.represent}
            </div>

            <div class="productPrice">

                <div class="productPrice">
                    <div class="juhuasuan">
                        <span class="juhuasuanBig" >超级加倍</span>
                        <span>此商品价格超级加倍当中，<span class="juhuasuanTime">0天0小时</span>后开始，</span>
                    </div>
                </div>



                <div class="productPriceDiv" style="background-color: #D8D8D8">

                    <div class="originalDiv">
                        <span class="originalPriceDesc">价格</span>
                        <span class="originalPriceYuan">¥</span>
                        <span class="originalPrice">
						<fmt:formatNumber type="number" value="${commodity.original_price}" minFractionDigits="2"/>
					</span>
                    </div>
                    <div class="promotionDiv">
                        <span class="promotionPriceDesc">促销价 </span>
                        <span class="promotionPriceYuan">¥</span>
                        <span class="promotionPrice">
						<fmt:formatNumber type="number" value="${commodity.real_price}" minFractionDigits="2"/>
					</span>
                    </div>
                </div>
            </div>



            <div class="productNumber">
                <br>
                <span style="font-size: 30px">数量</span>
                <span style="height: 30px">
                <input class="productNumberSetting" style="height: 30px;width: 50px;font-size: 30px;border: solid 1px" type="text" value="1">
                <span class="arrow">
                    <a href="#nowhere" class="increaseNumber">
                    <span class="glyphicon glyphicon-triangle-top">
                    </span>
                    </a>
                    <span class="updownMiddle"> </span>
                    <a href="#nowhere"  class="decreaseNumber">
                    <span class="glyphicon glyphicon-triangle-bottom">
                    </span>
                    </a>

                </span>
                    <span style="font-size: 30px">件</span>
                </span>
            </div>

            <div class="serviceCommitment">
                <span class="serviceCommitmentDesc">服务承诺</span>
                <span class="serviceCommitmentLink">
                <a href="#nowhere">正品保证</a>
                <a href="#nowhere">极速退款</a>
                <a href="#nowhere">赠运费险</a>
                <a href="#nowhere">七天无理由退换</a>
            </span>
            </div>

            <div class="serviceCommitment">
                <span class="serviceCommitmentDesc">合作快递</span>
                <span class="serviceCommitmentLink">
                <a href="#nowhere">顺丰</a>
                <a href="#nowhere">中通</a>
                <a href="#nowhere">圆通</a>
                <a href="#nowhere">申通</a>
            </span>
            </div>
            <hr>

            <div class="buyDiv" >
                <a class="buyLink" href=""> <button class="buyButton" data-toggle="modal" data-target="#myModal">立即购买</button></a>
                <a href="" class="addCartLink"><button class="addCartButton" id="addCartButton"><span class="glyphicon glyphicon-shopping-cart"></span>加入购物车</button></a>
            </div>

        </div>

        <div style="clear:both"></div>

    </div>

    <div class="productDetailDiv" >
        <div class="productDetailTopPart">
            <a href="#nowhere" class="productDetailTopPartSelectedLink selected">商品详情</a>
        </div>
        <div class="productParamterPart">
            <div class="productParamter">产品描述：</div>
            <c:forEach items="${commodity.imageUrls}" var="imageUrls">
                <div   style="margin-top: 10px" >
                    <img src="/images/${imageUrls.imgURL}" class="bigImg">
                </div>
            </c:forEach>
            <div style="clear:both"></div>
        </div>
    </div>


    <div class="modal " id="loginModal" tabindex="-1" role="dialog" >
        <div class="modal-dialog loginDivInProductPageModalDiv">
            <div class="modal-content">
                <div class="loginDivInProductPage">
                    <div class="loginErrorMessageDiv">
                        <div class="alert alert-danger" >
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                            <span class="errorMessage"></span>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

</div>
    </div>

