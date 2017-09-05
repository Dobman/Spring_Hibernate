<%--
  Created by IntelliJ IDEA.
  User: mariusz
  Date: 05.09.17
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"	%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id=" person" type="pl.coderslab.Entity.Person"--%>
<%--<form:form	method="post"
              modelAttribute=" person">
    <form:input	path="login"	/>
    <form:input	path="password"	/>
    <form:input	path="email"	/>
    <input	type="submit"	value="Save">
</form:form>--%>
<form method="post">
    <label for="login">Login</label>
    <input type="text" name="login" id="login">
    <label for="password">Login</label>
    <input  type ="password" name="password" id="password">
    <label for="email">Login</label>
    <input type="email" name="email"  id="email">
    <input type="submit" name="submit" value="Wyslij urzytkownika" >
</form>
</body>
</html>
