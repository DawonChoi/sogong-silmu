<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*" %>
<%@page import="kr.gsm.model.*" %>
<%	
	List<MemberVO> list=(List<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function memform() {
		location.href="/auto/insertForm.do"
	}
	function memdel(num) {
		location.href="/auto/delete?num="+num;
	}
</script>
</head>
<body>
<h1>3218_�ִٿ� ȸ������Ʈ ���(View)</h1>
<table border="1" width="600px">
  <tr>
    <td>�Ϸù�ȣ</td>
    <td>�й�</td>
    <td>�̸�</td>
    <td>��ȭ��ȣ</td>
    <td>�̸���</td>
    <td>�ּ�</td>
  </tr>
  
 <% for(MemberVO vo : list){  %>
   <tr>
    <td><%=vo.getNum() %></td>
    <td><a href="/auto/content?num=<%=vo.getNum()%>"><%=vo.getBun() %></a></td>
    <td><%=vo.getName() %></td>
    <td><%=vo.getTel() %></td>
    <td><%=vo.getEmail() %></td>
    <td><%=vo.getAddr() %></td>
    <td><input type="button" value="����" onclick="memdel(<%=vo.getNum() %>)"/></td>
  </tr>	 
 <% } %>
  <tr>
    <td colspan="6" align="right">
      <input type="button" value="ȸ������" onclick="memform()"/>
    </td>
  </tr>
</table>
</body>
</html>