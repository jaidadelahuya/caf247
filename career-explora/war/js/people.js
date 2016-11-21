$(document).ready(
		function() {

		/*	$(window).scroll(
					function() {
						if ($(window).scrollTop() + $(window).height() == $(
								document).height()) {
							alert("bottom!");
							// getData();
						}
					});*/

			$("#send-message").click(function(e) {
				e.preventDefault();
				var me = $(this);
				var form = me.closest("form");
				$.ajax({
					url : form.prop("action"),
					data : form.serialize(),
					method : "POST",
					beforeSend : function() {
						me.prop("disabled", true);
						me.css("color", "orange");
						me.text("Sending...");
					},
					success : function() {
						me.text("Message Sent");
						me.css("color", "green");
						setTimeout(function() {
							me.prop("disabled", false);
							$("#message-modal").closeModal();
						}, 3000);

					},
					error : function(xhr) {
						$("#send-msg-error").text(xhr.statusText);
						me.text("Send Message");
						me.css("color", "black");
					}
				});
			});

			$(".message").click(function() {
				var par = $(this).closest(".card");
				var img = par.find(".person-image").prop("src");
				var name = par.find(".person-name").text();
				var webKey = par.find(".person-webkey").val();
				$("#send-message").text("Send Message");
				$("#send-message").css("color", "black")

				$("#message-area").val("");
				$("#message-area").next().removeClass("active");
				$("#recipient-key").val(webKey);
				$("#recipient-image").prop("src", img);
				$("#recipient-name").text(name);
				$("#message-modal").openModal();
			});

			$(".people-tab").click(function() {
				var ref = "/azure/people/get?category=" + $(this).prop("id");
				$.ajax({
					url : ref,
					dataType : "json",
					success : function(data) {
						console.log(data);
					}
				});
			});

			$(".follow").click(
					function(e) {
						e.preventDefault();
						var webKey = $(this).closest(".card-action").find(
								".person-webkey").val();
						var me = $(this);
						$.ajax({
							url : "/azure/people/follow/add",
							data : {
								"web-key" : webKey
							},
							success : function(data) {
								me.fadeOut();
							}
						});
					});

			$(".friend-request").click(
					function(e) {
						e.preventDefault();
						var webKey = $(this).closest(".card-action").find(
								".person-webkey").val();
						var me = $(this);
						$.ajax({
							url : "/azure/notifications/friend/request",
							method : "POST",
							data : {
								"web-key" : webKey
							},
							success : function(data) {
								me.fadeOut();
							}
						});

					});
		});