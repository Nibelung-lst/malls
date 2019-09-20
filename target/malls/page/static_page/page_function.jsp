<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/10
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../js/jquery/jquery.min.js"></script>
</head>
<script>
    <!--检查是否为空-->
    function checkEmpty(id, name) {
        var value = $("#" + id).val();
        if (value.length == 0) {
            alert(name + "不能为空");
            return false;
        }
        return true;
    }
    <!--检查是否为数字-->
    function checkNumber(id,name) {
        var value = $("#" + id).val();
        if (value.length == 0) {
            alert(name + "不能为空");
            return false;
        }
        if (isNaN(value)){
            alert(name+"必须是数字");
            return false;
        }
        return true
    }
</script>
</html>
