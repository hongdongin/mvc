<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${userInfo.uiNum}</td>
		</tr>
		<th>이름</th>
		<td>${userInfo.uiName}</td>
		</tr>
		<th>아이디</th>
		<td>${userInfo.uiId}</td>
		</tr>
		<th>비밀번호</th>
		<td>${userInfo.uiPwd}</td>
		</tr>

	</table>
</body>
</html>