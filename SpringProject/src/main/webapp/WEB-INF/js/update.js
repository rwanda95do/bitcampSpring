$(function(){

// 수정
	$('#updateBtn').click(function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val()== '')
			 $('#nameDiv').html("이름 입력하세요");
		else if($('#id').val()== '')
			 $('#idDiv').html("아이디 입력하세요");
		else if($('#pwd').val()== '')
			 $('#pwdDiv').html("비밀번호 입력하세요");
		else 
			$.ajax({
				type : 'post',
				url : '/spring/user/update',
				data : $('#userUpdateForm').serialize(),
				success : function(){
					alert('수정 완료!');
					location.href='/spring/user/list?pg=' + $('#pg').val();
				},
				error : function(e){console.log(e)}
				
			});			 
	});
	
// 삭제
	$('#deleteBtn').click(function(){
		if($('#chPwd').val() == $('#pwd').val()){
			$.ajax({
				type: 'post',
				url: '/spring/user/delete',
				data: 'id=' + $('#id').val() ,
				success: function(){
					alert('삭제');
					location.href='/spring/user/list'
				},
				error: function(e){console.log(e);}
			});
		}
	});



});