<%--
  Created by IntelliJ IDEA.
  User: peikunkun
  Date: 2017/11/19 0019
  Time: 下午 7:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常信息</title>
    <jsp:include page="../pages/support/easyui_support.jsp"></jsp:include>

</head>
<body>
</body>

<script type="text/javascript">


    $(document).ready(function () {
        $.messager.confirm("返回主页", "页面出现错误", function (r) {
            if (r) {
                document.location.href = '<%=request.getContextPath()%>main.jsp';
            }
        });
    });


</script>
</html>
