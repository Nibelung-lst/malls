<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/10
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
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
    <title>管理员列表</title>
</head>
<script>
    <c:if test="${check}">
    alert("添加成功");
    </c:if>
    <c:if test="${exist}">
    alert("用户名重复");
    </c:if>
</script>
<body>
<div   style="margin-top: 100px; margin-left: 100px; margin-right: 50px">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>添加管理员</h1>
            </div>
        </div>
        <hr>
    <form action="/back/adminAdd" method="post">
        <table class="addTable">
            <div class="input-group input-group-lg">
                <span class="input-group-addon">用户名</span>
                <input type="text" id="name" name="name" class="form-control" placeholder="Username" aria-describedby="sizing-addon3" required="required"
                       style="height:51px;width:449px">
            </div>
            <div>
                <br>
            </div>

            <div class="input-group input-group-lg">
                <span class="input-group-addon" style="width:87.5px">密码</span>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password" aria-describedby="sizing-addon1" required="required"
                       style="height:51px;width:449px">
            </div>
            <br>

            <tr class="submitTR">
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-success">提 交</button>
                    <button type="reset" class="btn btn-primary">重置</button>
                </td>
            </tr>
        </table>
    </form>
    </div>
</div>
<footer>
<%@include file="../static_page/page.jsp" %>
</footer>
</body>
</html>