<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/11
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<script src="../../js/jquery/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<head>
    <title>商品添加</title>
</head>
<style>
    .bottom_footer {
        bottom: 0px;
        width: 100%;
        height: 50px;
        font-weight: bold;
        background-color: #f4f5f7
    }
</style>
<script>

</script>
<body>

<ol class="breadcrumb">
    <li><a href="#">首页</a></li>
    <li><a href="#">商品</a></li>
    <li class="active">添加</li>
</ol>

<div   style="margin-top: 50px; margin-left: 100px; margin-right: 50px">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>添加商品图片</h1>
            </div>
        </div>
        <hr>
        <form action="/back/imageAdd" method="post" enctype="multipart/form-data">
            <table class="addTable" >
                <div class="form-group" style="height:51px;width:449px">
                    <label for="goodsName">商品名</label><span class="label label-danger">必须</span>
                    <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="请输入商品名" required="required">
                </div>
                <div class="form-group" style="height:51px;width:449px">
                    <label for="goodsName">图片</label><span class="label label-danger">必须</span>
                    <input type="file" name="file" >
                </div>

                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-success" >提 交</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
