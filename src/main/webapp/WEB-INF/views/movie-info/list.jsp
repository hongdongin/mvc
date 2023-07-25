<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>무비 리스트</h3>

	<table border="1">

		<tr>
			<th>번호</th>
			<th>영화제목</th>
			<th>영화설명</th>
			<th>영화장르</th>
			<th>개봉일</th>
			<th>관객수</th>
		</tr>
		<c:forEach items="${movieInfoList}" var="movieInfo">

			<tr>
				<td>${movieInfo.miNum}</td>
				<td><a href="/movie-info/view?uiNum=${movieInfo.miNum}">${movieInfo.miTitle}</a></td>
				<td>${movieInfo.miDesc}</td>
				<td>${movieInfo.miGenre}</td>
				<td>${movieInfo.miCredat}</td>
				<td>${movieInfo.miCnt}</td>


			</tr>
		</c:forEach>
		<tr>
			<td align="right" colspan="4">
			<button onclick="location.href='/movie-info/insert'">Submit</button></td>
		</tr>
	</table>
</body>
</html>