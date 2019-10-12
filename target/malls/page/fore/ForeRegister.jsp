<%@ page import="com.mysql.cj.Session" %><%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2019/9/21
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录</title>
    <link href="../../css/login/style.css" rel="stylesheet" type="text/css" media="all" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- -->
    <script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
    <script src="../../js/jquery/jquery.min.js"></script>

    <script>
        <c:if test="${ForeLoginError}">
        alert("用户名或密码错误！");
        </c:if>
        <c:if test="${RegisterSucceed}">
        alert("注册成功！");
        </c:if>
        <c:if test="${UserExist}">
        alert("用户名存在！");
        </c:if>
        <c:if test="${Status}">
        alert("账号已被冻结！");
        </c:if>


        $(function(){
            $(".ReButton").click(function(){
                $(".Register").fadeToggle("slow");
                $(".radio").fadeToggle("slow");
                $('.check0').fadeToggle("slow");

                if($(".RegisterButton").is(':hidden')){
                    $(".RegisterButton").show();
                    $(".LoginButton").hide();
                    $(".footer").hide();
                    $(".text1").text("已有账号？点击这里登录");
                }
                else {
                    $(".RegisterButton").hide();
                    $(".LoginButton").show();
                    $(".check1").hide();
                    $(".check2").hide();
                    $(".footer").fadeIn(3000);
                    $(".text1").text("没有账号？点击这里注册");
                }
            });
        });
        $(function(){
            $(".LoginButton").click(function(){
                var newUrl = '/fore/foreLogin';    //设置新提交地址
                $(".TestAction").attr('action',newUrl);    //通过jquery为action属性赋值
                $(".TestAction").submit();    //提交ID为TestAction的表单
            })
        })
        $(function(){
            $(".RegisterButton").click(function(){
                var newUrl = '/fore/foreRegister';    //设置新提交地址
                $(".TestAction").attr('action',newUrl);    //通过jquery为action属性赋值
                $(".TestAction").submit();    //提交ID为TestAction的表单
            })
        })

        function KeyUp() {
            var a = $('#password').val();
            //alert(a);
            var b = $('#password1').val();
            //alert(b);
            if (a == b&&a!=null) {
                $(".check1").show();
                $(".check2").hide();
            }
            else {
                $(".check1").hide();
                $(".check2").show();
            }
        }
    </script>
</head>
<body>
<!-- contact-form -->
<div class="message warning">
    <div class="inset">
        <div class="login-head">
            <h1>商城</h1>
            <div class="alert-close"> </div>
        </div>
        <form class="TestAction" method="post" action="">
            <li>
                <span style="font-size:20px;color: #BBBBBB">账号</span> <input id="name" name="name" type="text" class="text" placeholder="账号" required="required" >
            </li>
            <div class="clear"> </div>
            <li>
                <span style="font-size:20px;color: #BBBBBB">密码</span><input id="password" name="password" type="password" placeholder="密码" required="required" >
            </li>
            <li class="check0" style="display: none">
                <span style="font-size:20px;color: #BBBBBB">密码</span><input id="password1" name="password1" type="password" placeholder="重复密码" required="required" onkeyup="KeyUp()">
            </li>
            <li class="check1" style="display: none">
            <span style="font-size:20px;color: #BBBBBB">两次输入的密码一样</span>
            </li>
            <li class="check2" style="display: none">
                <span style="font-size:20px;color: #BBBBBB">两次输入的密码不一样</span>
            </li>
            <li  class="Register" style="display: none;">
                <span style="font-size:20px;color: #BBBBBB">电话</span><input maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" id="telephone" name="telephone" type="text" >
            </li>
            <div class="radio" style=" display: none;background-color: #f0eef0;">
                <label style="font-size:20px;color: #BBBBBB;float:left;margin-left: 30px" for="name">性别</label>

                <select  name="sexCheck" style="border:none;float: left;width:250px;height: 25px;background-color: #f0eef0;margin-left: 5px" required="required" class="form-control input-medium" id="categoryName" name="categoryName">
                    <option  name="sexCheck" value=""></option>
                        <option value="1" name="sexCheck" id="sex">男</option>
                        <option value="0" name="sexCheck" id="sex1">女</option>
                </select>
            </div>
            <input id="status" name="status" type="hidden" value="1" >
            <div class="clear"> </div>
            <div class="submit">
                <input type="submit" class="LoginButton"  value="登录" >
                <input type="submit" class="RegisterButton" style="display: none" value="注册" >

                <div class="clear">
                </div>
            </div>

        </form>
        <div class="ReButton" style="display: inline-block;cursor: pointer"><span class="text1" style="color: #BBBBBB">没有账号？点击这里注册</span></div>
    </div>
</div>
</div>
<div class="clear"> </div>
<!--- footer --->
<div class="footer">
    <p>Nibelung &copy; 2019.</p>
</div>
</body>
</html>
