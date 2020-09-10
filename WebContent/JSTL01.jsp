<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="sum" value="10"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL PRACTICE 1</title>
</head>
<body>
<h1>sum=${sum}</h1>
<c:if test="${sum%2==0}">
<h3>${sum} is Even Number.</h3>
</c:if>
<c:if test="${sum%2!=0}">
<h3>${sum} is Odd Number.</h3>
</c:if>

<hr><h1>c:foreach</h1>
<c:forEach var="i" begin="1" end="5" step="1">
	<font color="red" size="${i*1.5}">야호~</font><br/>
</c:forEach>

<hr><h1>c:choose (switch-case)</h1>
<c:choose>
	<c:when test="${sum%2==0}">
		<h3>${sum} is Even Number.</h3>
	</c:when>
	<c:when test="${sum%2!=0}">
		<h3>${sum} is Odd Number.</h3>
	</c:when>
	<c:otherwise>
		default
	</c:otherwise>
</c:choose>

</body>
</html>