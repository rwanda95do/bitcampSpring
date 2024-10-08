<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
	방법1. jsp가 직접 데이터를 받는다. param을 사용
	<h3> ${param.x} + ${param.y} = ${param.x + param.y} </h3>
 -->
<!-- 방법2. SumController.java 에서 데이터를 받아서 넘ㄱㅕ준다. -->
	<h3> ${x} + ${y} = ${x + y} </h3>
</body>
</html>