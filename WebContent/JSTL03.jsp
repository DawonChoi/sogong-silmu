<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kr.gsm.model.*"%>
<%
	MemberVO vo=new MemberVO();
	vo.setBun(1003);
	vo.setName("나길동");
	vo.setTel("010-1111-1111");
	vo.setEmail("hong123@gmail.com");
	request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL PRACTICE 3</title>
</head>
<body>
<h1>c:forEach getAttribute(VO)</h1>
${vo.bun}, ${vo.name}, ${vo.tel}, ${vo.email}

<hr>



</body>