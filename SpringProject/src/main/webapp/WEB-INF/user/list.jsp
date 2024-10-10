<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/spring"><img alt="gif였네" src="../image/img1.gif" width="50" height="50"></a>	
	<table border="1" >
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="userDTO" items="${map2.list }">
				<tr>
					<td>${userDTO.name }</td>
					<td><a href="/spring/user/updateForm?id=${userDTO.id}&pg=${map2.pg}">${userDTO.id }</a></td>
					<td>${userDTO.pwd }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		${map2.userPaging.pagingHTML}
	</div>
	
	
<script type="text/javascript">
	function userPaging(pg) {
		location.href='/spring/user/list?pg=' + pg;
	}
</script>
</body>
</html>