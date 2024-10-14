$(function () {
  $('#uploadUpdateBtn').click(function () {
	let formData = new FormData($('#uploadUpdateForm')[0]);
	
	
    $.ajax({
      type: 'post',
      enctype: 'multipart/form-data',
      processData: false,
      contentType: false,
      url: '/spring/user/uploadUpdate',
      data: formData,
      success: function (data) {
        alert("dddd");
        location.href='/spring/user/uploadList';
      },
      error: function () {
        console.log(e);
      },
    });
  });
});
