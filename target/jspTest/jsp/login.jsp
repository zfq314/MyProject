<%--
  Created by IntelliJ IDEA.
  User: ZHAOFUQIANG
  Date: 2019/8/8
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src = "${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#username").focus(function () {
                $("#Qspan").text("");
            });
            //非空校验
            $("#sub").click(function () {
                var username = $("#username").val();
                if(username == "")
                {
                    alert("名字不能为空");
                    return false;
                }
                var password = $("#password").val();
                if(password == "")
                {
                alert("密码不能为空");
                    return false;
                }
            });
        });
    </script>
</head>
<body>
<h1>欢迎登录</h1>

<form action="${pageContext.request.contextPath}/LoginServlet" method="post">

    用户名字:<input type="text" name="username" id="username"><span style="color: red" id="Qspan">${requestScope.message}</span><br>
    用户密码:<input type="password" name="password" id="password"><br>
    <input type="submit" value="登录" id="sub">
</form>
</body>
</html>
