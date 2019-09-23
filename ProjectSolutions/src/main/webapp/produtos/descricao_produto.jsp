<%-- 
    Document   : descricao_produto
    Created on : 19/09/2019, 21:00:41
    Author     : Nicolas Yoshioka/Guilherme Pereira
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet" type="text/css"
	href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../assets/css/main.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
</head>
<body>
	<header>
		<h1 style="text-align: center;">
			<span class="sr-only">Floricultura TADES</span>
			<img src="../assets/img/logo.png">
		</h1>
		<nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
			<ul id="itensMenu" class="nav justify-content-center">
				<li class="nav-item">
					<form action="#">
						<button type="submit" class="btn nav-link nav-text">Vendas</button>
					</form>
				</li>
				<li class="nav-item">
					<form action="#" method="GET">
						<button type="submit" class="btn nav-link nav-text">Filiais</button>
					</form>
				</li>
				<li class="nav-item">
					<form action="#" method="GET">
						<button type="submit" class="btn nav-link nav-text">Usuarios</button>
					</form>
				</li>
				<li class="nav-item">
					<form action="#" method="GET">
						<button type="submit" class="btn nav-link nav-text">Relatorio</button>
					</form>
				</li>
			</ul>
			<i class="fas fa-user-tie" style="margin-left: -189px;"></i>
			&nbsp;&nbsp; Olá, <c:out value="${nomeUsuario}"/> 
			<form action="../venda/logout" method="POST">
				<button type="submit" class="btn nav-link nav-text">Sair</button>
			</form>
		</nav>
	</header>

	<h2 class="h2 text-center subtitulo"><c:out value="${produto.nome}"/></h2>

	<div class="container" id="contentDescricao">
		<div class="row">
			<div class="col-md-7 details-product">
				<div class="text-center" id="imgProduto">
					<img id="img-product" src="../assets/img/flor_teste.jpg" alt="">
				</div>
				<p id="desc-product"> <c:out value="${produto.descricao}"/> </p>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-4">
				<p id="price-product" class="h2 titulo">R$<c:out value="${produto.valorUnitario}"/></p>
				<br>
				<div class="row" id="rowOptionsProduto">
					<div class="col">
						<select class="border btn dropdown-toggle" id="modelos"
							name="tipo">
							<option disabled="" selected="" hidden="">Cores</option>
							<option value="Produto">Vermelho</option>
							<option value="Serviço">Rosa</option>
						</select>
					</div>
					<div class="col">
						<button type="button" class="btn btn-outline-danger">-</button>
						<input type="text" disabled="" value="1" name="qtd" id="text-qtd">
						<button type="button" class="btn btn-outline-success">+</button>
					</div>
				</div>
				<button id="add-to-cart" type="button" class="btn btn-success">Comprar</button>
			</div>
		</div>
	</div>
	<hr>
	<div class="container">
		<h2 class="h2 titulo">
			Perguntas Frequentes
			</p>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-3">
					<h4>Guilherme Pereira</h4>
				</div>
				<div class="col-md-6">
					<h4>Gostaria de saber se tem flores a pronta entrega e se
						podem ser enviadas com um bilhete para surpresa.</h4>
				</div>
				<div class="col-md-1"></div>
			</div>
	</div>
</body>
</html>
