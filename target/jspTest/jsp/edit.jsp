<%--
  Created by IntelliJ IDEA.
  User: ZHAOFUQIANG
  Date: 2019/8/11
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#lastName").change(function () {
            var lastName = $(this).val();
                //alert(lastName);
            var url = "${pageContext.request.contextPath}/EmployeeCheckName";
                $.ajax({
                    url:url,
                    type:"POST",
                    data:"lastName="+lastName,
                    success:function (data) {
                         $("#mySpan").html(data);
                    }
                },"text");
        });
    });
</script>
<body>
<center>
    <h1>修改员工ID为:<span style="color: blue">${requestScope.emp.id}</span>的信息为:</h1>
    <form action="${pageContext.request.contextPath}/SaveEmployeeServlet?id=${requestScope.emp.id}" method="post">
        用户名字:<input type="text"  name="lastName" value="${requestScope.emp.lastName}" id="lastName"><span style="color: red" id="mySpan"></span><br>
        用户邮箱:<input type="text" name="email" value="${requestScope.emp.email}"><br>
        用户薪水:<input type="text" name="salary" value="${requestScope.emp.salary}"><br>
        用户部门:<input type="text" name="dept" value="${requestScope.emp.dept}"><br>
        <input type="submit" value="修改" id="modify">

    </form>
</center>

</body>
</html>
