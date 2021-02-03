<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
	<%@include file="commons/links.jsp" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="commons/header.jsp" %>
	
	<table class="table">
          
           <thead>
	           	<tr>
					<th scope="col">Nom Client</th>
					<th scope="col">Adresse</th>
	            </tr>
           </thead>
            <tbody>
            <c:forEach items="${clients}" var="client">
            	<tr>
                	<td><c:out value="${client.getNom()}"/></td>
                	<td><c:out value="${client.getAdresse()}"/></td>
            	</tr>
            </c:forEach>
            </tbody>
            
          
   </table>
   
   <li><a href="clients?action=creer">Ajouter Client</a></li>
</body>
</html>