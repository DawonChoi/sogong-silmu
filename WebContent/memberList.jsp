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
<h1>3218_최다원 회원리스트 출력(View)</h1>
<table border="1" width="600px">
  <tr>
    <td>일련번호</td>
    <td>학번</td>
    <td>이름</td>
    <td>전화번호</td>
    <td>이메일</td>
    <td>주소</td>
  </tr>
  
 <% for(MemberVO vo : list){  %>
   <tr>
    <td><%=vo.getNum() %></td>
    <td><a href="/auto/content?num=<%=vo.getNum()%>"><%=vo.getBun() %></a></td>
    <td><%=vo.getName() %></td>
    <td><%=vo.getTel() %></td>
    <td><%=vo.getEmail() %></td>
    <td><%=vo.getAddr() %></td>
    <td><input type="button" value="삭제" onclick="memdel(<%=vo.getNum() %>)"/></td>
  </tr>	 
 <% } %>
  <tr>
    <td colspan="6" align="right">
      <input type="button" value="회원가입" onclick="memform()"/>
    </td>
  </tr>
</table>
</body>
</html>