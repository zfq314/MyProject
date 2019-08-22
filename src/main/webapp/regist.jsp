<%--
  Created by IntelliJ IDEA.
  User: ZHAOFUQIANG
  Date: 2019/8/8
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#username").focus(function () {
               $("#MySpan").text("");
            });
            $("#reg").click(function () {
                var username = $("#username").val();
                var usernameReg = /^[a-zA-Z0-9_-]{3,16}$/;
                if(!usernameReg.test(username)){
                    alert("名字格式不正确，输入的名字只能有字母数字和下划线减号等");
                    return false;
                }
                var passwrod = $("#password").val();
                var passwordReg =/^[a-zA-Z0-9_-]{6,18}$/;
                if(!passwordReg.test(passwrod)){
                    alert("密码格式不正确，输入的密码只能有字母数字和下划线减号等");
                    return false;
                }
                var rePwd = $("#rePwd").val();
                if (rePwd != passwrod){
                    $("#rePwd").val("");
                    alert("两次输入的密码不一致，请重新输入");
                    return false;
                }
                var email = $("#email").val();
                var emailReg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if(!emailReg.test(email)){
                    alert("输入的邮箱格式不正确");
                    return false;
                }

            });
        });

    </script>
    <script type="text/javascript">
        $(function () {
            $("#username").blur(function () {
                var username = $("#username").val();
               // alert(username);
                $.ajax({
                    url:"checkUsername",
                    type:"POST",
                    data:"username="+username,
                    success:function (data) {
                        $("#MySpan").html(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<h1>欢迎注册</h1>
<form action="${pageContext.request.contextPath}/RegistServlet" method="post">
    用户名字:<input type="text" name="username" id="username"><span style="color: red" id="MySpan">${requestScope.message}</span><br>
    用户密码:<input type="password" name="password" id="password"><br>
    确认密码:<input type="password" name="rePwd" id="rePwd"><br>
    用户邮箱:<input type="email" name="email" id="email"><br>
    <input type="submit" value="注册" id="reg">
</form>
</body>
</html>
