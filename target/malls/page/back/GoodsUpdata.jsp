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
</script>
<body>

<ol class="breadcrumb">
    <li><a href="#">首页</a></li>
    <li><a href="#">商品分类</a></li>
    <li class="active">修改</li>
</ol>

<div   style="margin-top: 50px; margin-left: 100px; margin-right: 50px">


    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>修改商品</h1>
            </div>
        </div>
        <hr>
        <form action="/back/goodsUpdate" method="post" enctype="multipart/form-data">
            <table class="addTable">

                <div class="form-group">
                    <input type="text" class="form-control" style="display:none" id="id" name="id" value="${goods.id}" required="required" readonly unselectable="on">
                </div>

                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">商品名</label>
                    <input type="text" class="form-control" id="name" name="name" value="${goods.name}" required="required">
                </div>

                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">图片</label>
                    <input type="file" name="file" >
                </div>

                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">原价</label>
                    <input type="text" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" class="form-control" id="originalPrice" name="originalPrice" value="${goods.originalPrice}" required="required">
                </div>

                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">现价</label>
                    <input type="text" onkeyup="if(isNaN(value))execCommand('undo')" onafterpaste="if(isNaN(value))execCommand('undo')" class="form-control" id="realPrice" name="realPrice" value="${goods.realPrice}" required="required">
                </div>

                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">描述</label>
                    <input type="text" class="form-control" id="represent" name="represent" value="${goods.represent}" required="required">
                </div>
                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">所属分类</label>
                    <select   required="required" class="form-control input-medium" id="categoryName" name="categoryName">
                        <option value="">${goods.categoryName}</option>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.name}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group" style="height:51px;width:449px">
                    <label for="name">修改人</label>
                    <p class="form-control-static"><%= session.getAttribute("admin")%></p>
                    <input type="text" class="form-control" style="display:none" id="finalChanger" name="finalChanger" value="<%= session.getAttribute("admin")%>"  required="required" readonly unselectable="on">
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
</body>
</html>
