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
<h1> - �󼼺��� - </h1>
<form action="/auto/update" method="post">
<input type="hidden" name="num" value="<%=vo.getNum() %>"/>
<table border="1">
  <tr>
    <td>��ȣ</td>
    <td><%=vo.getNum() %></td>
  </tr>
  <tr>
    <td>�й�</td>
    <td><%=vo.getBun() %></td>
  </tr>
  <tr>
    <td>�̸�</td>
    <td><%=vo.getName() %></td>
  </tr>
  <tr>
    <td>��ȭ��ȣ</td>
    <td><input type="text" name="tel" value="<%=vo.getTel() %>"/></td>
  </tr>
  <tr>
    <td>�̸���</td>
    <td><input type="text" name="email" value="<%=vo.getEmail() %>"/></td>
  </tr>
  <tr>
    <td>�ּ�</td>
    <td><input type="text" name="addr" value="<%=vo.getAddr() %>"/></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
    	<input type="submit" value="����"/>
    	<input type="button" value="����Ʈ"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>