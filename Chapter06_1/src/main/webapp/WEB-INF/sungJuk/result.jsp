<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<!-- EL/JSTL : getName()은 name으로 사용할 수 있다  -->
			<td colspan="2">${sungJukDTO.name } 성적표</td>
		</tr>
		<tr>
			<td>총점</td>
			<td>${sungJukDTO.tot }</td>
		</tr>
		<tr>
			<td>평균</td>
			<td> <fmt:formatNumber pattern="#.##"> ${sungJukDTO.avg }</fmt:formatNumber></td>
		</tr>
	</table>
</body>
</html>