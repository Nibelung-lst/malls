<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/30
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/fore/top.jsp"%>
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
                <li class="disabled">
                    <a href="#">修改</a>
                </li>
                <li class="active">
                    <a href="#">积分详情</a>
                </li>
                <li class="disabled">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
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
                                    <th>${point.order_id}</th>
                                    <th>${point.point}</th>
                                    <th>${point.total_point}</th>
                                    <th><fmt:formatDate type="date" value="${point.create_time}" /></th>
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