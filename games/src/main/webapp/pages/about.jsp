<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhes</title>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/images" var="images" />

<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<link href="${css}/style.css" rel="stylesheet">

</head>
<body>
	<table class="geral">
		<tr>
			<td class="back-button" rowspan="3">
				<a href="home"> <img
					src="${images}/back-button.png" width="80" alt="Voltar">
				</a>
			</td>
			<td class="header" colspan="4">
				<p>Detalhes</p>
			</td>
			<td rowspan="3" style="width: 550px;">
				<div id="case">
					<img src="${gameModel.image}" alt="Capa do Jogo"/>
				</div>
			</td>
		</tr>
		<tr>
			<td class="details" colspan="3">
				<label for="nome">Nome:</label>
				<label id="info">${gameModel.name}</label>
				<br><br>
				<label for="category">Categoria:</label>
				<label id="info">${gameModel.category}</label>
				<br><br>
				<label for="price">Preço:</label>
				<label id="info">${gameModel.price}</label>
				<br><br>
				<label for="description">Descrição:</label>
				<label id="info">${gameModel.description}</label>
				<br><br>
				<label for="urlBuy">Url de Compra:</label>
				<label id="info">
					<a href="${gameModel.urlBuy}">${gameModel.urlBuy}</a>
				</label>
			</td>
		</tr>
		<tr style="height: 80px;">
			<form:form action="${contextPath}/delete/${gameModel.id}" method="delete">
				<td class="buttons" align="right">
					<a href="${contextPath}/edit?id=${gameModel.id}"> 
						<img src="${images}/edit-button.png" width="80" alt="Editar">
					</a>
				</td>
				<td></td>
				<td class="buttons" align="left">
					<button type="submit" class="delete-button">
						<img src="${images}/delete-button.png" width="80" alt="Deletar">
					</button>
				</td>
			</form:form>
		</tr>
	</table>
</body>
</html>