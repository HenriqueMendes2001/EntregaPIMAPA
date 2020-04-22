<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Cliente" %>

<!doctype html>
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">

	<title>Bonvinos</title>
	</head>	
	<body>
		<!-- Barra superior com os menus de navegação -->
		<c:import url="menu.jsp"/>
		
		<div id="main" class="container">
			<h3 class="page-header">Login - Clientes</h3>
			<form action="LoginCliente.do" method="post">
				<div class="row">
					<div class="form-group col-md-12">
						<label for="email">Email</label>
						<input type="email" class="form-control" name="email" id="email" required maxlength="100" placeholder="O mesmo digitado na tela de cadastro"/>
					</div>				
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label for="senha">Senha</label>
						<input type="password" class="form-control" name="senha" id="senha" required maxlength="100" placeholder="**********"/>
					</div>				
				</div>
				<hr/>
				<div id="actions" class="row">
					<div class="md-col-12">
						<button type="submit" class="btn btn-primary" name="acao" value="Login">Login</button>
						<a href="loginFormulario.jsp" class="btn btn-default">Limpar</a>
					</div>
				</div>
			</form>
		</div>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>