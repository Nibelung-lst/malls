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
                <li class="active">
                    <a href="#">修改</a>
                </li>
                <li>
                    <a href="/fore/myPointDetail">积分详情</a>
                </li>
                <li class="disabled">
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
            <form action="/fore/myInformationChange" method="post">
            <table class="table">
                <input style="display: none" type="text" id="id" name="id" value="${user.id}">
                <tr>
                    <td>用户名</td>
                    <td>${user.name}</td>
                </tr>
                <tr>
                    <td>真实姓名</td>
                    <td><input style="border: none" type="text" id="realName" name="realName" value="${user.realName}"></td>
                </tr>
                <tr>
                    <td>电话号码</td>
                    <td><input maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"style="border: none" type="text" id="telephone" placeholder="请输入11位手机号码" name="telephone" value="${user.telephone}"></td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td><input style="border: none" type="text" id="address" name="address" value="${user.address}"></td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input style="border: none" type="email" id="email" name="email" value="${user.email}"></td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td><input style="border: none" type="date" id="birthday" name="birthday" ></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <button type="submit" class="btn btn-success" >提 交</button>
                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>