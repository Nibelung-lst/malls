<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/26
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/fore/top.jsp"%>

<script>

</script>

<div class="boughtDiv">
    <div class="orderType">
        <div class="selectedOrderType"><a orderStatus="all" href="/fore/orderInformation">所有订单</a></div>
        <div><a  orderStatus="waitPay" href="/fore/orderReceived?status=待付款">待付款</a></div>
        <div><a  orderStatus="waitConfirm" href="/fore/orderReceived?status=待收货">待收货</a></div>
        <div><a  orderStatus="finish" href="/fore/orderReceived?status=已完成">已完成</a></div>
        <div class="orderTypeLastOne" style="padding-top: 22px"><a class="noRightborder"> </a></div>
    </div>
    <div style="clear:both"></div>
    <div class="orderListTitle">
        <table class="orderListTitleTable">
            <tr>
                <td>宝贝</td>
                <td width="100px">单价</td>
                <td width="100px">数量</td>
                <td width="120px">实付款</td>
                <td width="100px">交易操作</td>
            </tr>
        </table>
    </div>

    <div class="orderListItem">
        <c:forEach items="${orderInformation}" var="o">
            <table class="orderListItemTable" orderStatus="${o.status}" oiid="${o.orderId}">
                <tr class="orderListItemFirstTR">
                    <td colspan="2">
                        <b>创建时间: <fmt:formatDate value="${o.creatorTime}" pattern="yyyy-MM-dd"/></b>
                        <span>订单号: ${o.orderId}
					</span>
                    </td>
                    <td  colspan="3">
                    </td>
                    <td  class="orderItemProductInfoPartTD" width="100px">
                        <div class="orderListItemProductOriginalPrice">￥<fmt:formatNumber type="number" value="${o.price}" minFractionDigits="2"/></div>
                    </td>
                    <td class="orderItemDeleteTD">
                        <a class="deleteOrderLink" oiid="${o.orderId}" href="/fore/deleteOrder?orderId=${o.orderId}" onclick="return confirm('请确认删除');"><span  class="orderListItemDelete glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
                <c:forEach items="${o.orderDetails}" var="oi" varStatus="st">
                    <tr class="orderItemProductInfoPartTR" >
                        <td class="orderItemProductInfoPartTD"><img width="80" height="80" src="/images/${oi.goods.image}"></td>
                        <td class="orderItemProductInfoPartTD">
                            <div class="orderListItemProductLinkOutDiv">
                                <a href="/fore/Goods?goodsName=${oi.goods.name}">${oi.goods.name}</a>
                            </div>
                        </td>
                        <td>
                        <div class="orderListItemProductPrice">￥<fmt:formatNumber type="number" value="${oi.goods.realPrice}" minFractionDigits="2"/></div>
                        </td>
                        <td>${oi.number}</td>
                        <td>

                        </td>
                        <td  class="orderItemProductInfoPartTD" width="100px">
                            <div class="orderListItemProductOriginalPrice">￥<fmt:formatNumber type="number" value="${oi.goods.realPrice*oi.number}" minFractionDigits="2"/></div>
                        </td>
                        <td></td>

                    </tr>

                </c:forEach>
            </table>
        </c:forEach>
    </div>



</div>
