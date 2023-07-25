<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>무비 업데이트</h3>
	<form action="/movie-info/update" method="POST">
		<input type="hidden" name="miNum" value="${movieInfo.miNum }">
		<input type="text" name="miTitle" placeholder="영화제목"value="${movieInfo.uiId}"><br> 
		<input type="text"name="miDesc" placeholder="영화설명"><br>
        <input type="text" name="miGenre" placeholder="영화장르" value="${movieInfo.uiName}"><br> 
        <input type="date" name="miCredat" placeholder="개봉일" value="${movieInfo.uiName}"><br>
		<input type="number" name="miCnt" placeholder="관객수" value="${movieInfo.uiName}"><br>
		<button>수정</button>
	</form>
</body>
</html>