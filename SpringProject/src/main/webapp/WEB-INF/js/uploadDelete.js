$(function () {
// 전체 선택
  $("#all").click(function () {
    if ($(this).prop("checked")) {
      $(".check").prop("checked", true);
    } else {
      $(".check").prop("checked", false);
    }
  });
 // 항목이 하나라도 선택도면 #all 해제
  $(".check").click(function () {
    console.log("체크박스 개수" + $(".check").length);
    console.log("체크박스 개수" + $(".check:checked").length);

    $("#all").prop("checked", $(".check").length == $(".check:checked").length);
  });
 // #uploadDeleteBtn 클릭했을 때
  $("#uploadDeleteBtn").click(function () {
  	$.ajax({
  		type: 'post',
  		url: '/spring/user/uploadDelete',
  		data: $('#uploadListForm').serialize(), // 체크된 항목만 서버로 간다 : 체크박스 특징-false의 데이터는 가져가지 않음
  		success: function(){
  			alert('이미지 삭제 완료');
  			location.href='/spring/user/uploadList';
  		},
  		error: function(e){
  			console.log(e);
  		}
  	});
  });

});
