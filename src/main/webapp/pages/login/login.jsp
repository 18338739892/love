<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/9 0009
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<title>用户登录页面</title>
</head>
<body>
	<form method="post" action=<%=contextPath%>/userLoginAction!userLogin.action>
		id:<input type="text" name="userLoginModel.id"><br> 姓名:<input
			type="text" name="userLoginModel.uname"><br> 密码:<input
			type="password" name="userLoginModel.pwd"><br> <input
			type="submit" value="提交">
	</form>
</body>
</html>
