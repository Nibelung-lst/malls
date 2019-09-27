<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/9
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
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

<script type="text/javascript">


</script>

<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>管理员列表</h1>
        </div>
    </div>
<form method="post">
    <input type="hidden" name="stu_id">
    <input type="hidden" name="stu_name">
    <input type="hidden" name="stu_password">

    <!--显示表格数据-->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>#</th>
                    <th>序列号</th>
                    <th>管理员名</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="admins">

                    <tr>
                        <th>#</th>
                        <th>${admins.id}</th>
                        <th>${admins.name}</th>
                        <td><a href="/back/adminDelete?id=${admins.id}"><span class="glyphicon glyphicon-trash"></span></a>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</form>
    <!--显示分页信息-->
    <div class="row">
        <!--显示文字信息-->
        <div class="col-md-6">
            当前记录数：${pageInfo.pageNum}页,总${pageInfo.pages}页，总${pageInfo.total}条记录
        </div>
        <!--分页条信息-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="/back/adminList?pageNumber=1">首页</a> </li>

                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="/back/adminList?pageNumber=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                    </c:if>
                    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNums">
                        <c:if test="${pageNums == pageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNums}</a></li>
                        </c:if>
                        <c:if test="${pageNums != pageInfo.pageNum}">
                            <li ><a href="/back/adminList?pageNumber=${pageNums}" target="right">${pageNums}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="/back/adminList?pageNumber=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>


                    <li><a href="/back/adminList?pageNumber=${pageInfo.pages}">末页</a> </li>

                </ul>
            </nav>
        </div>

    </div>
</div>

<%@include file="../static_page/page.jsp" %>
</body>
</html>
