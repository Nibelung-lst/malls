<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>菜单</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="../../css/back/nav.css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/back/nav.js"></script>
</head>

<style>

</style>
<body>
<div class="nav">
    <div style="text-align:center; ">
        <img src="../../image/luckin.jpg" style="height: 80px;margin-top: 5px ">
    </div>
    <div style="text-align:center; ">
        <p><font style="font-family:微软雅黑;color: black;font-size: 16px;"><%= session.getAttribute("admin")%></font></p>
    </div>
    <ul>
        <li class="nav-item">
            <a href="homeshow.jsp" target="right"><strong>网站首页</strong></a>
        </li>
        <li class="nav-item">
            <a href="javascript:;">账户管理</a>
            <ul>
                <li><a href="/back/adminList" target="right"><span>账户列表</span></a></li>
                <li><a href="../back/AdminAdd.jsp" target="right"><span>添加账户</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;">商品管理</a>
            <ul>
                <li><a href="/back/goodsList" target="right"><span>商品列表</span></a></li>
                <li><a href="/back/goodsAddList" target="right"><span>添加商品</span></a></li>
                <li><a href="../back/ImageAdd.jsp" target="right"><span>上传附图</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;">商品分类</a>
            <ul>
                <li><a href="/back/categoryList" target="right"><span>商品分类</span></a></li>
                <li><a href="../back/CategoryAdd.jsp" target="right"><span>添加分类</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;">会员管理</a>
            <ul>
                <li><a href="/back/userList" target="right"><span>会员列表</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;">订单管理</a>
            <ul>
                <li><a href="/back/orderList" target="right"><span>订单列表</span></a></li>
            </ul>
        </li>
        <li class="nav-item">
            <a href="javascript:;">积分管理</a>
            <ul>
                <li><a href="/back/pointList" target="right"><span>积分列表</span></a></li>
            </ul>
        </li>

    </ul>
</div>


</body>
</html>