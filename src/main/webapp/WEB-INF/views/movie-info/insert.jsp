<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>영화등록</h3>
	<form action="/movie-info/insert" method="POST">
		<input type="text" name="miTitle" placaholder="영화제목"><br>
		<input type="text" name="miDesc" placaholder="영화설명"><br>
		<input type="text" name="miGenre" placaholder="영화장르"><br>
		<input type="date" name="miCredat" placaholder="개봉일"><br>
		<input type="number" name="miCnt" placaholder="관객수"><br>
		<button>등록</button>
		</form>
</body>
</html>