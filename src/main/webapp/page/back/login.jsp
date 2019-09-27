<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>后台管理登录</title>
<link href="../../css/login/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<!-- -->
<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="../../js/jquery/jquery.min.js"></script>

	<script>
		<c:if test="${loginError}">
		alert("用户名或密码错误！");
		</c:if>
	</script>
</head>
<body>
<!-- contact-form -->
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>登录</h1>
		 <div class="alert-close"> </div> 			
	</div>
		<form action="/back/adminLogin" method="post">
			<li>
				<input id="name" name="name" type="text" class="text" value="账号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'name';}"><a href="#" class=" icon user"></a>
			</li>
				<div class="clear"> </div>
			<li>
				<input id="password" name="password" type="password" value="密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'password';}"> <a href="#" class="icon lock"></a>
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<input type="submit" onclick="myFunction()" value="登录" >
				<h4><a href="#">忘记密码？</a></h4>
						  <div class="clear">  </div>	
			</div>
				
		</form>
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