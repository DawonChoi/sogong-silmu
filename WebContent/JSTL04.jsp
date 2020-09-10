<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kr.gsm.model.*"%>
<%@page import="java.util.*"%>
<%
	ArrayList<MemberVO> list = new ArrayList<MemberVO>();

	for(int i=1; i<=3; i++){
		MemberVO vo=new MemberVO();
		vo.setBun(1000+i);
		vo.setName("최다원");
		vo.setTel("010-1111-1111");
		vo.setEmail("hong123@gmail.com");
		list.add(vo);
	}
	
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL PRACTICE 4</title>
</head>
<body>
<h1>c:forEach getAttribute(VO)</h1>

<table border="1">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>전화번호</td>
		<td>이메일</td>
	</tr>
	<c:forEach var="v" items="${list}">
		<tr>
			<td>${v.bun}</td>
			<td>${v.name}</td>
			<td>${v.tel}</td>
			<td>${v.email}</td>
		</tr>
	</c:forEach>
</table>



<hr>



</body>