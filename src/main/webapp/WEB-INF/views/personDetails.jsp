<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
- login
- password
- email
- firstName
- lastName
- gender (radio button)
- country (select z możliwością pojedynczego wyboru)
- notes (textarea)
- mailingList (checkbox)
- programmingSkills (select z możliwością wyboru wielu opcji)
- hobbies (grupa checkboxów)
<form:form	method="post" modelAttribute="details">
    <form:label path="login" id="login">Login</form:label>
    <form:input	path="login" id="login"	/>
    <form:label path="password" id="password">Login</form:label>
    <form:input	path="password" id="password" />
    <form:label path="firstName" id="firstName">First Name</form:label>
    <form:input	path="firstName" id="firstName"/>
    <form:label path="lastName" id="lastName">Last Name</form:label>
    <form:input	path="lastName" id="lastName"/>
    <form:label path="gender" id="gender">Gender</form:label>
    <form:radiobutton	path="gender" id="male" value="male"/>
    <form:radiobutton	path="gender" id="female" value="female"/>
    <form:label path="country" id="country">Country</form:label>
    <form:select	path="country"	items="${countryItems}"	/>
    <form:label path="notes" id="notes">notes</form:label>
    <form:textarea path="notes" rows="1" cols="10"></form:textarea>
    <form:label path="mailingList" id="mailingList">mailingList</form:label>
    <form:checkbox	path="mailingList" />
    <form:select	path="programmingSkills" items="${programmingSkills}" multiple="true" />
    <form:checkboxes path="hobbies"	items="${hobbies}"		/>
    <input	type="submit">
</form:form>
</body>
</html>