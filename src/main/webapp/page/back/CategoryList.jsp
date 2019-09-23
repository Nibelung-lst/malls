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
    <title>分类展示</title>
</head>
<script>
function undate(id,name,create_name){

document.forms[0].elements[0].value = id;
document.forms[0].elements[1].value = name;
document.forms[0].elements[2].value = create_name;
document.forms[0].action = '<c:url value="CategoryUpdata.jsp"/>';
document.forms[0].submit();
}

</script>

<body>
<ol class="breadcrumb">
    <li><a href="#">首页</a></li>
    <li><a href="#">商品分类</a></li>
    <li class="active">分类</li>
</ol>


<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1>分类列表</h1>
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
                        <th>分类名</th>
                        <th>对应商品</th>
                        <th>创建人</th>
                        <th>创建时间</th>
                        <th>最后修改人</th>
                        <th>最后修改时间</th>
                        <th>编辑</th>
                        <th>删除</th>
                    </tr>
                    <c:forEach items="${CategoryPageInfo.list}" var="category">

                        <tr>
                            <th>${category.id}</th>
                            <th>${category.name}</th>
                            <td><a href="/back/Goods_Category_list?categoryName=${category.name}">该分类下的商品</a></td>
                            <th>${category.create_name}</th>
                            <th><fmt:formatDate type="date" value="${category.create_time}" /></th>
                            <th>${category.final_change_man}</th>
                            <th><fmt:formatDate type="date" value="${category.final_modification_time}" /></th>
                            <td><a href="javascript:void(0)" onclick="undate('${category.id}','${category.name}','${category.create_name}');"><span class="glyphicon glyphicon-pencil"></span></a></td>
                            <td><a href="/back/category_delet?id=${category.id}&pn=${CategoryPageInfo.pageNum}"  onclick="return confirm('请确认删除');"><span class="glyphicon glyphicon-trash"></span> </a> </td>
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
            当前数据数：${CategoryPageInfo.pageNum}页,总${CategoryPageInfo.pages}页，总${CategoryPageInfo.total}条数据
        </div>
        <!--分页条信息-->
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li><a href="/back/category_list?pn=1">首页</a> </li>

                    <c:if test="${CategoryPageInfo.hasPreviousPage}">
                        <li>
                            <a href="/back/category_list?pn=${CategoryPageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>

                    </c:if>
                    <c:forEach items="${CategoryPageInfo.navigatepageNums}" var="pageNums">
                        <c:if test="${pageNums == CategoryPageInfo.pageNum}">
                            <li class="active"><a href="#">${pageNums}</a></li>
                        </c:if>
                        <c:if test="${pageNums != CategoryPageInfo.pageNum}">
                            <li ><a href="/back/category_list?pn=${pageNums}" target="right">${pageNums}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${CategoryPageInfo.hasNextPage}">
                        <li>
                            <a href="/back/category_list?pn=${CategoryPageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>


                    <li><a href="/back/category_list?pn=${CategoryPageInfo.pages}">末页</a> </li>

                </ul>
            </nav>
        </div>

    </div>
</div>

<%@include file="../static_page/page.jsp" %>
</body>
</html>
