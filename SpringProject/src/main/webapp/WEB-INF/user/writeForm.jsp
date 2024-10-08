<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- http://localhost:8080/spring/css/user.css  :: Servlet으로 가버려서 NO MAPPING :: Servlet가서 <resources> 추가 -->
<link rel="stylesheet" href="../css/user.css"> 
</head>
<body>
	<div id="wrap">
		<a href="/spring"><img alt="gif였네" src="../image/img1.gif" width="50" height="50"></a>	
	    <div id="Formwrap">
	        <form action="user/write" method="post">
	            <div id="inputwrap">
	                <div id="namewrap">
	                    <div>이름 : </div>
	                    <input type="text" id="name" name="name"/>
	                </div>
	                <div id="idwrap">
	                    <div>아이디 : </div>
	                    <input type="text" id="id" name="id"/>
	                    <div id="idDiv"></div>
	                </div>
	                <div id="pwdwrap">
	                    <div>비밀번호 : </div>
	                    <input type="text" id="pwd" name="pwd"/>
	                </div>
	                <div id="btnwrap">
	                    <input type="submit" value="보내기"/>
	                </div>
	                <div id="resetwrap">
	                    <input type="reset" value="취소"/>
	                </div>
	            </div>
	        </form>
	    </div>
	</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/write.js"></script>
	
</body>
</html>