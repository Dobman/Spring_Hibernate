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
<%--@elvariable id="person" type="pl.coderslab.Entity.Person"--%>
person form
<form:form	method="post" modelAttribute="person">
    <form:label path="login" id="login">Login</form:label>
    <form:input	path="login" id="login"	/>
    <form:label path="password" id="password">Login</form:label>
    <form:input	path="password" id="password" />
    <form:label path="email" id="email">Login</form:label>
    <form:input	path="email" id="email"/>
    <input	type="submit">
</form:form>
<%--<form method="post">
    <label for="login">Login</label>
    <input type="text" name="login" id="login">
    <label for="password">Login</label>
    <input  type ="password" name="password" id="password">
    <label for="email">Login</label>
    <input type="email" name="email"  id="email">
    <input type="submit" name="submit" value="Wyslij urzytkownika" >
</form>--%>
</body>
</html>
