<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*" %>
<%@page import="kr.gsm.model.*" %>
<%
	MemberVO vo = (MemberVO)request.getAttribute("vo");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>user details</title>
</head>
<body>
<h1> - 상세보기 - </h1>
<form action="/auto/update" method="post">
<input type="hidden" name="num" value="<%=vo.getNum() %>"/>
<table border="1">
  <tr>
    <td>번호</td>
    <td><%=vo.getNum() %></td>
  </tr>
  <tr>
    <td>학번</td>
    <td><%=vo.getBun() %></td>
  </tr>
  <tr>
    <td>이름</td>
    <td><%=vo.getName() %></td>
  </tr>
  <tr>
    <td>전화번호</td>
    <td><input type="text" name="tel" value="<%=vo.getTel() %>"/></td>
  </tr>
  <tr>
    <td>이메일</td>
    <td><input type="text" name="email" value="<%=vo.getEmail() %>"/></td>
  </tr>
  <tr>
    <td>주소</td>
    <td><input type="text" name="addr" value="<%=vo.getAddr() %>"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    	<input type="submit" value="수정"/>
    	<input type="button" value="리스트"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>