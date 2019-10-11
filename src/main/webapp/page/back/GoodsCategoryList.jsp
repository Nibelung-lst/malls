<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/12
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<script src="../../js/jquery/jquery.min.js"></script>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<head>
    <title>Title</title>
</head>
<script>

</script>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>商品列表</h1>
        </div>
    </div>
    <form method="post">
        <!--显示表格数据-->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover table-bordered">
                    <tr class="success">
                        <th>序列号</th>
                        <th>商品名</th>
                        <th>图片</th>
                        <th>原价</th>
                        <th>现价</th>
                        <th>描述</th>
                        <th>分类</th>
                        <th>创建人</th>
                        <th>创建时间</th>
                        <th>最后修改人</th>
                        <th>最后修改时间</th>
                        <th>编辑</th>
                        <th>删除</th>
                    </tr>
                    <c:forEach items="${GoodPageInfo.list}" var="category">

                        <tr>
                            <th>${category.id}</th>
                            <th>${category.name}</th>
                            <th><c:if test="${category.image!=null }">
                                <img width="80px" height="80px" id="images" alt="" src="/images/${category.image }"></c:if></th>
                            <th>${category.originalPrice}</th>
                            <th>${category.realPrice}</th>
                            <th>${category.represent}</th>
                            <th>${category.categoryName}</th>
                            <th>${category.creater}</th>
                            <th><fmt:formatDate type="date" value="${category.createDate}" /></th>
                            <th>${category.finalChanger}</th>
                            <th><fmt:formatDate type="date" value="${category.finalChangeTime}" /></th>
                            <td><a href="/back/goodsUpdateList?id=${category.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                            <td><a href="/back/goodsDelete?id=${category.id}&pn=${GoodsPageInfo.pageNum}"  onclick="return confirm('请确认删除');"><span class="glyphicon glyphicon-trash"></span> </a> </td>
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
            当前数据数：${GoodPageInfo.pageNum}页,总${GoodPageInfo.pages}页，总${GoodPageInfo.total}条数据
        </div>
        <!--分页条信息-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="/back/goodsCategoryList?pageNumber=1&categoryName=<%=session.getAttribute("Category")%>">首页</a> </li>

                    <c:if test="${GoodPageInfo.hasPreviousPage}">
                        <li>
                            <a href="/back/goodsCategoryList?pageNumber=${GoodPageInfo.pageNum-1}&categoryName=<%=session.getAttribute("Category")%>" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                    </c:if>
                    <c:forEach items="${GoodPageInfo.navigatepageNums}" var="pageNums">
                        <c:if test="${pageNums == GoodPageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNums}</a></li>
                        </c:if>
                        <c:if test="${pageNums != GoodPageInfo.pageNum}">
                            <li ><a href="/back/goodsCategoryList?pageNumber=${pageNums}&categoryName=<%=session.getAttribute("Category")%>" target="right">${pageNums}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${CategoryPageInfo.hasNextPage}">
                        <li>
                            <a href="/back/goodsCategoryList?pageNumber=${GoodPageInfo.pageNum+1}&categoryName=<%=session.getAttribute("Category")%>" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>


                    <li><a href="/back/goodsCategoryList?pageNumber=${GoodPageInfo.pages}&categoryName=<%=session.getAttribute("Category")%>">末页</a> </li>

                </ul>
            </nav>
        </div>

    </div>
</div>

</body>
</html>
