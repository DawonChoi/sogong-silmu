<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String[] f={"apple", "banana", "orange"};
	request.setAttribute("f", f);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL PRACTICE 2</title>
</head>
<body>
<h1>c:forEach getAttribute(list)</h1>
<c:forEach var="v" items="${f}">
	<font size="5" color="green">${v}</font><br>
</c:forEach>

</body>