<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="commons/links.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="commons/header.jsp" %>
	<table class="table">
          
           <thead>
	           	<tr>
					<th scope="col">Nom Article</th>
					<th scope="col">Prix</th>
	            </tr>
           </thead>
            <tbody>
            <c:forEach items="${articles}" var="article">
            	<tr>
                	<td><c:out value="${article.getNom()}"/></td>
                	<td><c:out value="${article.getPrix()}"/></td>
            	</tr>
            </c:forEach>
            </tbody>
            
          
   </table>
   
   <li><a href="articles?action=creer">Ajouter Article</a></li>
</body>
</html>