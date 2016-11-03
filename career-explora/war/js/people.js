$(document).ready(function() {
	$(".people-tab").click(function() {
		var ref = "/azure/people/get?category="+$(this).prop("id");
		$.ajax({
			url : ref,
			dataType : "json",
			success : function(data) {
				console.log(data);
			}
		});
	});
	
	$(".follow").click(function(e){
		e.preventDefault();
		var me = $(this);
		var x = me.prop("href");
		$.ajax({
			url:x,
			success:function(data) {
				me.fadeOut();
			}
		});
	});
});