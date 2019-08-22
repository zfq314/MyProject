<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ZHAOFUQIANG
  Date: 2019/8/11
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<body>
<center >

    <h1>欢迎<span style="color: blue">${sessionScope.user.username}</span>登陆  <span style="color: blue"><a href="${pageContext.request.contextPath}/LogOutServlet">注销</a></span></h1>
    <c:if test="${empty requestScope.emp}">
        <caption>现在还没有员工</caption>
    </c:if>
    <c:if test="${!empty requestScope.emp}">
        <div class="col-sm-7 col-sm-offset-2">
        <caption>员工列表</caption>
        <table class="table">
            <thead>
            <tr class="danger">
                <th>ID编号</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>薪水</th>
                <th>部门</th>
                <th colspan="2">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.emp}" var="all">
                <tr class="success">
                    <td>${all.id}</td>
                    <td>${all.lastName}</td>
                    <td>${all.email}</td>
                    <td>${allsalary}</td>
                    <td>${all.dept}</td>
                    <td><a href="${pageContext.request.contextPath}/EditEmployeeServlet?id=${all.id}">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/DeleteEmployeeServlet?id=${all.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
        </div>
</center>
</body>
</html>
