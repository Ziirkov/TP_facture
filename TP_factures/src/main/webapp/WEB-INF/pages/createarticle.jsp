<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="commons/links.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="commons/header.jsp" %>
	
	<form method="post" action="articles">
		<input type="text" placeholder="Nom" name="nom">
		<input type="number" placeholder="Prix" name="prix">
		<button type="submit"> Envoyer</button>
	</form>
</body>
</html>