<%@ page import="com.exam.service.UserService" %>
<%@ page import="com.exam.service.serviceImpl.UserServiceImpl" %>
<%@ page import="com.exam.model.User" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/11/29
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    UserService userService = new UserServiceImpl();
    User user = userService.findById(id);
%>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
    <form action="/UpdateUserServlet" method="post" target="_top">
        <div>
            <label>序号：<input type="text" name="id" readonly value="<%= user.getId() %>">(不可修改)</label>
        </div>
        <div>
            <label>用户名:<input type="text" name="username" value="<%= user.getUsername() %>"></label>
        </div>
        <div>
            <label>密码:<input type="text" name="password" value="<%= user.getPassword() %>"></label>
        </div>
        <div>
            <button type="submit">修改</button>
        </div>
    </form>
</body>
</html>

