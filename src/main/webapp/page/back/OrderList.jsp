<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/11
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<html>
<script src="../../js/jquery/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<head>
    <title>分类展示</title>
</head>
<script>
    $(function(){
        $(".buttonclick").click(function(){
            var order_id = $(this).attr("order_id");
            $("tr.orderDetail[order_id="+order_id+"]").fadeToggle("slow");
        });
    });
</script>

<body>
<ol class="breadcrumb">
    <li><a href="#">首页</a></li>
    <li><a href="#">订单</a></li>
    <li class="active">订单详情</li>
</ol>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>订单列表</h1>
        </div>
    </div>
        <!--显示表格数据-->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr class="success">
                        <th>订单编号</th>
                        <th>地址</th>
                        <th>接收人</th>
                        <th>电话</th>
                        <th>总额</th>
                        <th>创建时间</th>
                        <th>完成时间</th>
                        <th>状态</th>
                        <th>会员名</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${OrderPageInfo.list}" var="order">

                        <tr>
                            <th>${order.orderId}</th>
                            <th>${order.address}</th>
                            <th>${order.receiver}</th>
                            <th>${order.telephone}</th>
                            <th>${order.price}</th>
                            <th><fmt:formatDate type="date" value="${order.creatorTime}" /></th>
                            <th><fmt:formatDate type="date" value="${order.finshTime}" /></th>
                            <th>${order.status}</th>
                            <th>${order.userName}</th>

                            <th> <button order_id=${order.id} class="buttonclick" >查看详情</button></th>

                        </tr>


                        <tr class="orderDetail" order_id=${order.id}  style="display:none">
                            <td colspan="10" align="center">
                                <div >
                                    <table width="1000px" align="center">
                                        <c:forEach items="${order.orderDetails}" var="orderDetail">
                                            <thead>
                                            <tr class="success">
                                                <th>商品图片</th>
                                                <th>商品名</th>
                                                <th>商品描述</th>
                                                <th>商品分类</th>
                                                <th>商品数量</th>
                                                <th>商品价格</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td><img width="35px" height="35px" src="/images/${orderDetail.goods.image}"></td>
                                                <td>${orderDetail.goods.name}</td>
                                                <td>${orderDetail.goods.represent}</td>
                                                <td>${orderDetail.goods.categoryName}</td>
                                                <td>${orderDetail.number}个</td>
                                                <td>${orderDetail.goods.realPrice}元</span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                            </tbody>


                                    </table>
                                </div>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>







    <!--显示分页信息-->
    <div class="row">
        <!--显示文字信息-->
        <div class="col-md-6">
            当前数据数：${OrderPageInfo.pageNum}页,总${OrderPageInfo.pages}页，总${OrderPageInfo.total}条数据
        </div>
        <!--分页条信息-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="/back/orderList?pageNumber=1">首页</a> </li>

                    <c:if test="${OrderPageInfo.hasPreviousPage}">
                        <li>
                            <a href="/back/orderList?pageNumber=${OrderPageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                    </c:if>
                    <c:forEach items="${OrderPageInfo.navigatepageNums}" var="pageNums">
                        <c:if test="${pageNums == OrderPageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNums}</a></li>
                        </c:if>
                        <c:if test="${pageNums != OrderPageInfo.pageNum}">
                            <li ><a href="/back/orderList?pageNumber=${pageNums}" target="right">${pageNums}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${OrderPageInfo.hasNextPage}">
                        <li>
                            <a href="/back/orderList?pageNumber=${OrderPageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>


                    <li><a href="/back/orderList?pageNumber=${OrderPageInfo.pages}">末页</a> </li>

                </ul>
            </nav>
        </div>

    </div>
</div>

<%@include file="../static_page/page.jsp" %>
</body>
</html>
