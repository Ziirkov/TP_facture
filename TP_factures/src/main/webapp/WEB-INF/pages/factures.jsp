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
					<th scope="col">Numéro Facture</th>
					<th scope="col">Date</th>
					<th scope="col">Prix</th>
					<th scope="col">Id Client</th>
	            </tr>
           </thead>
            <tbody>
            <c:forEach items="${factures}" var="facture">
            	<tr>
                	<td><c:out value="${facture.getNumero()}"/></td>
                	<td><c:out value="${facture.getDate()}"/></td>
                	<td><c:out value="${facture.getPrix()}"/></td>
                	<td><c:out value="${facture.getClient().getNom()}"/></td>
            	</tr>
            </c:forEach>
            </tbody>
            
          
   </table>
</body>
</html>