
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" >
</head>
<body>
	<h2>URL: ${requestScope.resultado.url }</h2>
	<h2>Temática: ${requestScope.resultado.tematica }</h2>
	<h2>Descripción: ${requestScope.resultado.descripcion }</h2>
	<a href="toInicio">Volver a home</a>
</body>
</html> 

