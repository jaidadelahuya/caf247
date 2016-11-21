<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>

<head>
<meta charset="ISO-8859-1">
<title>People</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="/style/materialize.min.css">
<link rel="stylesheet" href="/style/materialize-tags.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="/style/jquery.webui-popover.css">
<link rel="stylesheet" href="/style/main.css">
<link rel="stylesheet" href="/style/media-queries.css">
<style type="text/css">
.follow,.friend-request,.message {
	cursor: pointer;
}
</style>
</head>
<body style="background-color: #f1f3f7">
	<%@ include file="/WEB-INF/main-nav.html"%>
	<%@ include file="/WEB-INF/people/home.html"%>

	<!-- message modal -->
	<div id="message-modal" class="modal">
		<div class="row valign-wrapper" style="margin: 2%">
			<img class="circle" id="recipient-image"
				style="width: 45px; height: 45px; margin: 0px 10px"> <span
				id="recipient-name"></span>
		</div>
		<form action="<c:url value="/azure/notifications/friend/message/send" />">
			<div style="max-height: 400px; overflow-y: auto">
				<div class="card-content"
					style="padding-top: 10px; padding-bottom: 0px">

					<div class="row">
						<input type="hidden" id="recipient-key" name="web-key">
						<div class="input-field col s12" style="margin-top: 0px;">
							
							<textarea id="message-area" class="materialize-textarea" name="message"
								style="padding-top: 1px; padding-bottom: 1px; margin-bottom: 2px; white-space: pre-wrap;"></textarea>
							<label for="message-area">Write a message</label>

						</div>
						<div class="col s12"  id="send-msg-error" style="color: red; font-family: calibri"></div>
					</div>
					
				</div>
			</div>
			<div class="modal-footer">
				<a href="#!" id="send-message"
					class="waves-effect waves-green btn-flat">Send
					Message</a>
			</div>
		</form>
	</div>

	<script src="/js/jquery-1.11.2.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/jquery.webui-popover.js"></script>
	<script type="text/javascript" src="/js/main.js"></script>
	<script type="text/javascript" src="/js/people.js"></script>

</body>
</html>