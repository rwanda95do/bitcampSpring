$(function(){
	$('#id').focusout(function () {
		$('#idDiv').empty();
		$('#idDiv').css({
		    'color': 'red',       
		    'font-size': '10pt'  
		});
		if($('#id').val()=='') $('#idDiv').html("얍");
		
	});
});
