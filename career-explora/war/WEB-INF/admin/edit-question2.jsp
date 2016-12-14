<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Question</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="/style/materialize.min.css">
<link rel="stylesheet" href="/style/materialize-tags.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body class="blue lighten-5">

	<%@ include file="/pages/partials/admin-nav.html"%>
	<div class="container">
		<div class="row">
			<ul class="collection with-header">
				<li class="collection-header"><h5>${fn:length(editQuestions)} questions found</h5></li>
				
				<c:forEach var="item" items = "${editQuestions}">
					 <li class="collection-item"><div><span style="font-size: 10pt">${item.body}</span><a href="#!" class="secondary-content"><i class="material-icons">delete</i></a><a href="#!" class="secondary-content"><i class="material-icons">mode_edit</i></a></div></li>
				</c:forEach>
			</ul>
		</div>
	</div>







	<script src="/js/jquery-1.11.2.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/admin.js"></script>
</body>
</html>