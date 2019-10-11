<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<script src="../../js/jquery/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<head>
    <meta charset="UTF-8">
    <title>分类修改</title>
</head>
<script>
    <c:if test="${CategoryUpdataSucceed}">
    alert("修改成功");
    </c:if>
    <c:if test="${CategoryUpdataExist}">
    alert("分类名重复");
    </c:if>
</script>
<body>

<ol class="breadcrumb">
    <li><a href="#">首页</a></li>
    <li><a href="#">商品</a></li>
    <li class="active">修改</li>
</ol>

<div   style="margin-top: 50px; margin-left: 100px; margin-right: 50px">


    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>修改分类</h1>
            </div>
        </div>
        <hr>
        <form action="/back/categoryUpdate" method="post">
            <table class="addTable">



                <div class="form-group">
                    <input type="text" class="form-control" style="display:none" id="id" name="id" value="${category.id}" required="required" readonly unselectable="on">
                </div>

                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">分类名</label><span class="label label-danger">必须</span>
                    <input type="text" class="form-control" id="name" name="name" value="${category.name}" required="required">
                </div>


                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">修改人</label>
                    <p class="form-control-static"><%= session.getAttribute("admin")%></p>
                    <input type="text" class="form-control" style="display:none" id="finalChangeMan" name="finalChangeMan" value="<%= session.getAttribute("admin")%>"  required="required" readonly unselectable="on">
                </div>

                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">修改时间</label>
                    <p class="form-control-static"><%=new java.sql.Timestamp(System.currentTimeMillis()).toString().substring(0,10) %></p>

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
<%@include file="../static_page/page.jsp" %>
</body>
</html>
