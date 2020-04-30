<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Principal</title>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/images" var="images"/>

<c:set value="${pageContext.request.contextPath}" var="contextPath"/>

<link href="${css}/style.css" rel="stylesheet">

</head>
<body>
	<table class="geral-home">
		<tr>
			<td class="borda-home"></td>
			<td align="center">
				<div class="estante">
					<c:forEach items="${games}" var="game">
					<!-- Arrumar direcionamento do detalhe -->
						<a href="${contextPath}/page/${game.id}" style="text-decoration: none">
							<img id="objeto" src="${game.image}">
						</a>
					</c:forEach>
				</div>
			</td>
			<td class="borda-home">
				<a href="new"> 
					<img id="add-button" src="${images}/add-button.png" width="80">
				</a>
			</td>
		</tr>
	</table>
</body>
</html>