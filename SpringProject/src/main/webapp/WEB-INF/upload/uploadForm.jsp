<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}
tr, td, th{
	padding: 5px;
}
</style>
</head>
<body>
	<form action="/spring/user/upload" method="post" enctype="multipart/form-data"> <!-- 파일 업로드는 무조건 POST -->
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="imageName" size="35"> 
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea rows="10" cols="50" name="imageContent"></textarea>
				</td>
			</tr>
		<%-- 
			<!-- 다중 업로드할때에는 name속성의 이름이 같아야한다. 왜냐? 서버가 배열로 받기 때문이다 -->
			<tr>
				<td colspan="2">
					<input type="file" name="img">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="file" name="img">
				</td>
			</tr>
		--%>
			<!-- 한번에 한개 또는 여러개(드래그)를 선택해서 업로드. 서버에서 List로 받는다 -->
			<tr>
				<td colspan="2">
					<input type="file" name="img[]" multiple="multiple">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="이미지 업로드">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>