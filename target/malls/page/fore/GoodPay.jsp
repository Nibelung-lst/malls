<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/24
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/fore/top.jsp"%>

<div class="buyPageDiv">
    <form action="/fore/creatOrder" method="post">

        <div class="buyFlow">
            <div style="clear:both"></div>
        </div>



        <div class="address">
            <div class="addressTip">订单编号</div>
            <div class="addressTip">输入收货地址</div>
            <div>
                <table class="addressTable">
                    <tr>
                        <td class="firstColumn">详细地址<span class="redStar">*</span></td>

                        <td><textarea id="address" name="address" placeholder="请填写详细收货地址"></textarea></td>
                    </tr>

                    <input type="text" id="price" style="display: none" name="price" value="${price}">
                    <input type="text" id="status" style="display: none" name="status" value="代发货">
                    <input type="text" id="user_name" style="display: none" name="user_name" value="${user.name}">

                    <tr>
                        <td>收货人姓名<span class="redStar">*</span></td>
                        <td><input id="receiver" name="receiver" type="text"></td>
                    </tr>
                    <tr>
                        <td>手机号码 <span class="redStar">*</span></td>
                        <td><input id="telephone" name="telephone"  placeholder="请输入11位手机号码" type="text"></td>
                    </tr>
                </table>

            </div>

        </div>
        <div class="productList">
            <div class="productListTip">确认订单信息</div>

            <table class="productListTable">
                <thead>
                <tr>
                    <th colspan="2" class="productListTableFirstColumn"></th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                    <th>配送方式</th>
                </tr>
                <tr class="rowborder">
                    <td  colspan="2" ></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody class="productListTableTbody">
                <c:forEach items="${order}" var="order" varStatus="st" >
                    <tr class="orderItemTR">
                        <td class="orderItemFirstTD"><img class="orderItemImg" src="/images/${order.goods.image }"></td>
                        <td class="orderItemProductInfo">
                            <a  href="foreproduct?pid=${oi.product.id}" class="orderItemProductLink">
                                    ${order.goods.name}
                            </a>
                        </td>
                        <td>
                            <span class="orderItemProductPrice">￥<fmt:formatNumber type="number" value="${order.goods.real_price}" minFractionDigits="2"/></span>
                        </td>
                        <td>
                            <span class="orderItemProductNumber">${order.number}</span>
                        </td>
                        <td><span class="orderItemUnitSum">
						￥<fmt:formatNumber type="number" value="${order.number*order.goods.real_price}" minFractionDigits="2"/>
						</span></td>
                        <c:if test="${st.count==1}">
                            <td rowspan="5"  class="orderItemLastTD">
                                <label class="orderItemDeliveryLabel">
                                    <input type="radio" value="" checked="checked">
                                    普通配送
                                </label>

                                <select class="orderItemDeliverySelect" class="form-control">
                                    <option>快递 免邮费</option>
                                </select>

                            </td>
                        </c:if>

                    </tr>
                </c:forEach>

                </tbody>

            </table>
            <div class="orderItemSumDiv">
                <span class="pull-right">店铺合计(含运费): ￥<fmt:formatNumber type="number" value="${price}" minFractionDigits="2"/></span>
            </div>

        </div>

        <div class="orderItemTotalSumDiv">
            <div class="pull-right">
                <span>实付款：</span>
                <span class="orderItemTotalSumSpan">￥<fmt:formatNumber type="number" value="${price}" minFractionDigits="2"/></span>
            </div>
        </div>

        <div class="submitOrderDiv">
            <button type="submit" class="submitOrderButton">提交订单</button>
        </div>
    </form>
</div>
