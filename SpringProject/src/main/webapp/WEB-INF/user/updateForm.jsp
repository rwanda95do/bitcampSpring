<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/user.css"> 
</head>
<body>
	<div id="wrap">
		<a href="/spring"><img alt="gif였네" src="../image/img1.gif" width="50" height="50"></a>	
	    <div id="Formwrap">
	        <form id="userUpdateForm" method="post">
	        	<input type="hidden" id="pg" value="${pg}">
	        	<input type="hidden" id="chPwd" value="${userDTO.pwd}">
	            <div id="inputwrap">
	                <div id="namewrap">
	                    <div>이름 : </div>
	                    <input type="text" id="name" name="name" value="${userDTO.name}"/>
	                    <div id="nameDiv"></div>
	                </div>
	                <div id="idwrap">
	                    <div>아이디 : </div>
	                    <input type="text" id="id" name="id" value="${userDTO.id}" readonly="readonly"/>
	                    <div id="idDiv"></div>
	                </div>
	                <div id="pwdwrap">
	                    <div>비밀번호 : </div>
	                    <input type="text" id="pwd" name="pwd"/>
	                    <div id="pwdDiv"></div>
	                </div>
	                <div id="btnwrap">
	                    <input id="updateBtn" type="button" value="수정"/>
	                    <input id="deleteBtn" type="button" value="삭제" onclick="location.href='/spring/user/deleteForm?id=${userDTO.id}&pg=${pg }'"/>
	                    <input type="button" value="목록" onclick="location.href='/spring/user/list?pg=${pg}'"/>
	                </div>
	                <div id="resetwrap">
	                    <input type="reset" value="취소"/>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/update.js"></script>
<script type="text/javascript" src="../js/delete.js"></script>
</body>
</html>