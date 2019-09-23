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
    <title>用户展示</title>
</head>
<script>

</script>

<body>
<ol class="breadcrumb">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户</a></li>
    <li class="active">展示</li>
</ol>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>用户列表</h1>
        </div>
    </div>
    <form method="post">
        <input type="hidden" name="id">
        <input type="hidden" name="name">
        <input type="hidden" name="create_name">
        <!--显示表格数据-->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover table-bordered">
                    <tr class="success">
                        <th>序列号</th>
                        <th>用户名</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>地址</th>
                        <th>邮件</th>
                        <th>生日</th>
                        <th>积分</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${UserPageInfo.list}" var="user">
                        <tr>
                            <th>${user.id}</th>
                            <th>${user.name}</th>
                            <td><c:choose>
                                    <c:when test="${user.sex}">
                                        男
                                    </c:when>
                                    <c:when test="${!user.sex}">
                                    女
                                    </c:when>
                                <c:otherwise>
                                    error
                                </c:otherwise>
                                </c:choose>
                            </td>
                            <th>${user.telephone}</th>
                            <th>${user.address}</th>
                            <th>${user.email}</th>
                            <th><fmt:formatDate type="date" value="${user.birthday}" /></th>
                            <th>${user.point}</th>
                            <th><c:choose>
                                <c:when test="${user.status}">
                                    正常
                                </c:when>
                                <c:otherwise>
                                    冻结
                                </c:otherwise>
                            </c:choose>
                            </th>
                            <th><a class="label label-success" <c:if test="${!user.status}">href="/back/user_status?id=${user.id}&pn=${UserPageInfo.pageNum}&status=1"</c:if>>解冻</a>
                                <a class="label label-danger" <c:if test="${user.status}"> href="/back/user_status?id=${user.id}&pn=${UserPageInfo.pageNum}&status=0"</c:if>>冻结</a>
                            </th>
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
            当前数据数：${UserPageInfo.pageNum}页,总${UserPageInfo.pages}页，总${UserPageInfo.total}条数据
        </div>
        <!--分页条信息-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="/back/user_list?pn=1">首页</a> </li>

                    <c:if test="${UserPageInfo.hasPreviousPage}">
                        <li>
                            <a href="/back/user_list?pn=${UserPageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                    </c:if>
                    <c:forEach items="${UserPageInfo.navigatepageNums}" var="pageNums">
                        <c:if test="${pageNums == UserPageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNums}</a></li>
                        </c:if>
                        <c:if test="${pageNums != UserPageInfo.pageNum}">
                            <li ><a href="/back/user_list?pn=${pageNums}" target="right">${pageNums}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${UserPageInfo.hasNextPage}">
                        <li>
                            <a href="/back/user_list?pn=${UserPageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>


                    <li><a href="/back/user_list?pn=${UserPageInfo.pages}">末页</a> </li>

                </ul>
            </nav>
        </div>

    </div>
</div>


</body>
<%@include file="../static_page/page.jsp" %>
</html>
