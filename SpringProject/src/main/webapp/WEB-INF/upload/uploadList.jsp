<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
th, td {
	padding: 5px;
	width: 200px;
}
</style>
</head>
<body>
<form id="uploadListForm">
	<table border="1" frame="hsides" rules="rows">
		<tr>
			<th>
				<input type="checkbox" id="all">
			</th>
			<th>번호</th>
			<th>이미지</th>
			<th>상품명</th>
		</tr>
		
		<c:forEach var="userUploadDTO" items="${list }">
		<tr>
			<td>
				<input type="checkbox" class="check" value="${userUploadDTO.seq}" name="check">
			</td>
			<td>${userUploadDTO.seq}</td>
		<!-- Local Storage -->	
			<%-- <td><img src="http://localhost:8080/spring/storage/${userUploadDTO.imageOriginalFileName}" alt="${userUploadDTO.imageName}"></td>  --%>
		<!-- NAVER Object Storage -->
			<td>
				<a href="/spring/user/uploadView?seq=${userUploadDTO.seq}">
					<img src="https://kr.object.ncloudstorage.com/bitcamp-9th-bucket-115/storage/${userUploadDTO.imageFileName}" alt="${userUploadDTO.imageName}"></td>
				</a>
			<td>${userUploadDTO.imageName}</td>
		</tr>
		</c:forEach>
	</table>
</form>
	<div style="margin-top: 10px;">
		<input type="button" value="선택삭제" id="uploadDeleteBtn">
	</div>
	
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/uploadDelete.js"></script> 

</body>
</html>