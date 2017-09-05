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
<form action="/Spring01hibernate03/book/add" method="post">
<label>Title:</label><input type="text" name="title"/>
<label>Author</label><input type="text" name="author"/>
<label>Rating:</label><input type="text" name="rating"/>
<label>Publisher:</label><input type="text" name="publisher"/>
<label>Description:</label><input type="text" name="description"/>
<input type="submit"/>
</form>
</body>
</html>