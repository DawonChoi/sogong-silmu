<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- �޼��带 ����(JSP�ּ�) --%>
<%!
  public int twoHap(){
	int a=100;
	int b=300;
	return a+b;
  }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!-- HTML �ּ� -->
<%
  int v=twoHap();
%>
<table border="1">
  <tr>
    <td>���</td>
    <td><%=v %></td>
  </tr>
</table>
</body>
</html>