<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메인화면</h2>
<h3>
	<p><a href="/spring/user/writeForm">입력</a></p> <!--/spring"/"user/writeForm 중에 ""안에 /만 보면 Servlet이동함  -->
	<p><a href="/spring/user/list">출력</a></p> <!-- pg=1일때는 생략 가능 /spring/user/list?pg=1 -->

	<br>
	
	<p><a href="/spring/user/uploadForm">파일 업로드</a></p>
	<p><a href="/spring/user/uploadAjaxForm">파일 업로드(AJAX)</a></p>
	<p><a href="/spring/user/uploadList">이미지 출력</a></p>
	
</h3>
</body>
</html>

<!--
기획서 : 파일구성 
* springframework (Maven) + mybatis (@Mapper) + jsp (JQuery) + NCP *


 -->