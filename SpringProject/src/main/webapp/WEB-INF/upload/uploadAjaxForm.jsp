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
	<form id="uploadAjaxForm" > <!-- 파일 업로드는 무조건 POST -->
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
			<tr>
				<td colspan="2">
					<span id="showImageList"></span>
					<img id="camera" alt="카메라" src="../image/camera.png" width="50px" height="50px">이미지 미리보기
					<input id="img" type="file" name="img[]" multiple="multiple" style="visibility: hidden;">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="이미지 업로드" id="uploadAjaxBtn">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>		
	</form> 
	
	
	
<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/uploadAjax.js"></script>
<script type="text/javascript">
$('#camera').click(function() {
	$('#img').trigger('click'); // 강제 이벤트 발생
});

// 이미지 미리보기
$('#img').change(function() {
	$('#showImageList').empty();
	
	for(var i=0; i<this.files.length; i++) {
		readURL(this.files[i]);
	}
});
function readURL(file) {
	var reader = new FileReader();
	
	var show;
	reader.onload = function(e) {
		var img=document.createElement('img');
		img.src = e.target.result;
		img.width = 70;
		img.height = 70;
		$('#showImageList').append(img);
	}
	
	reader.readAsDataURL(file);
}



</script>

</body>
</html>



<!-- 
FileReader 란?
FileReader는 type이 file인 input 태그 또는 API 요청과 같은 인터페이스를 통해 
File 또는 Blob 객체를 편리하게 처리할수있는 방법을 제공하는 객체이며
abort, load, error와 같은 이벤트에서 발생한 프로세스를 처리하는데 주로 사용되며,
File 또는 Blob 객체를 읽어서 result 속성에 저장한다.

FileReader도 비동기로 동작한다.

FileReader.onload()
load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료되었을 때마다 발생한다.
 -->

