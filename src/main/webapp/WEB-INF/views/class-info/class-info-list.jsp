<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>난 강의 리스트</h3>
<%
List<Map<String,String>> list = (List<Map<String, String>>)request.getAttribute("classInfoList");
%>
<%=list %>
<table border="1">
<tr>
<th>번호</th>
<th>강의명</th>
<th>강의내용</th>
</tr>

<tr>


</tr>

</table>
</body>
</html>