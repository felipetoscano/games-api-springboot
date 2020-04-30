<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar</title>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/images" var="images" />

<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<link href="${css}/style.css" rel="stylesheet">

</head>
<body>
	<table class="geral">
		<tr>
			<td class="back-button" rowspan="2"><a href="home"> <img
					src="${images}/back-button.png" width="80" alt="Voltar">
			</a></td>
			<td class="header">
				<p>Cadastrar Novo Jogo</p>
			</td>
		</tr>
		<tr>
			<td class="itens"><form:form modelAttribute="gameModel"
					action="${contextPath}/new" method="post">

					<label for="name">Nome: </label>
					<form:input class="in" type="text" path="name" id="name" />
					<br>
					<form:errors class="error" path="name" />

					<br />

					<label for="price">Preço:</label>
					<form:input type="number" id="price" path="price" />
					<br>
					<form:errors class="error" path="price" />
					<br />

					<label for="category">Categoria: </label>
					<form:input type="text" path="category" id="category" />
					<br>
					<form:errors class="error" path="category" />
					<br />

					<label for="description">Descrição: </label>
					<form:input type="text" path="description" id="description" />
					<br>
					<form:errors class="error" path="description" />
					<br />

					<label for="image">Capa do Jogo: </label>
					<form:input type="text" path="image" id="image"
						placeholder="Insira aqui a url da imagem" />
						<br>
					<form:errors class="error" path="image" />
					<br />

					<label for="urlBuy">Url de Compra: </label>
					<form:input type="text" path="urlBuy" id="urlBuy" />
					<br>
					<form:errors class="error" path="urlBuy" />
					<br />

					<div id="div-save">
						<button type="submit" class="save-button">
							<img src="${images}/save-button.png">
						</button>
					</div>

				</form:form></td>
		</tr>
	</table>
</body>
</html>