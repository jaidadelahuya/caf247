$(document).ready(function () {
	$(".launchCBT").click(function(e) {
		e.preventDefault();
		var form = $(this).closest("form");
		var x = form.attr("action");
		$.ajax({
			url : x,
			dataType : "json",
			data : form.serialize(),
			success : function (data) {
				console.log(data);
				sessionStorage.setItem("cbt", data);
				var wind = window.open("/pages/cbt.html", data.title,
				"toolbar=yes, scrollbars=yes, fullscreen=1");
			}, 
			error : function(xhr) {
				alert(xhr.statusText);
			}
		});
	});
});