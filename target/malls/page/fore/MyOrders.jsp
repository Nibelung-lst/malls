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
        <div class="selectedOrderType"><a orderStatus="all" href="#nowhere">所有订单</a></div>
        <div><a  orderStatus="waitPay" href="#nowhere">待付款</a></div>
        <div><a  orderStatus="waitDelivery" href="#nowhere">待发货</a></div>
        <div><a  orderStatus="waitConfirm" href="#nowhere">待收货</a></div>
        <div><a  orderStatus="finish" href="#nowhere">已完成</a></div>
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
            <table class="orderListItemTable" orderStatus="${o.status}" oid="${o.id}">
                <tr class="orderListItemFirstTR">
                    <td colspan="2">
                        <b>创建时间: <fmt:formatDate value="${o.creator_time}" pattern="yyyy-MM-dd HH:mm:ss"/></b>
                        <span>订单号: ${o.order_ID}
					</span>
                    </td>
                    <td  colspan="3"></td>
                    </td>
                    <td class="orderItemDeleteTD">
                        <a class="deleteOrderLink" orderId="${o.id}" href="#nowhere">
                            <span  class="orderListItemDelete glyphicon glyphicon-trash"></span>
                        </a>
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
                        <div class="orderListItemProductPrice">￥<fmt:formatNumber type="number" value="${oi.goods.real_price}" minFractionDigits="2"/></div>
                        </td>
                        <td>${oi.number}</td>
                        <td  class="orderItemProductInfoPartTD" width="100px">
                            <div class="orderListItemProductOriginalPrice">￥<fmt:formatNumber type="number" value="${o.price}" minFractionDigits="2"/></div>
                        </td>

                    </tr>
                </c:forEach>

            </table>
        </c:forEach>
    </div>

    <div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
        <div class="modal-dialog deleteConfirmModalDiv">
            <div class="modal-content">
                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">确认删除？</h4>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">确认</button>
                </div>
            </div>
        </div>
    </div>

</div>
