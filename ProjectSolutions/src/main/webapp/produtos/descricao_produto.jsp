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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Descrição do Produto</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">
                <span class="sr-only">Floricultura TADES</span>
                <img src="../assets/img/logo.png">
            </h1>
            <nav class="navbar navbar-expand-md navbar-light bg-warning">
                <div class="container">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarsExample08">
                        <ul id="itensMenu" class="navbar-nav justify-content-center">
                            <li class="nav-item">
                                <form action="../produtos/listagem_produtos" method="GET">
                                    <button type="submit" class="btn nav-link nav-text">Produtos</button>
                                </form>
                            </li>
                        </ul>
                        <i class="fas fa-user-tie"></i>
                        <span id="nav-saudacao"> Olá, <c:out value="${nomeUsuario}" /></span>
                        <form action="../venda/logout" method="POST">
                            <button type="submit" class="btn nav-link nav-text">Sair</button>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
        <div class="container" id="contentDescricao">
            <h2 class="text-center subtitulo titulo-produto-descricao">Produto: <c:out value="${produto.nome}"/></h2>
            <div class="row">
                <div class="col-md-7 details-product">
                    <div class="text-center" id="imgProduto">
                        <img id="img-product" src="../assets/img/flor_teste.jpg" alt="">
                    </div>
                    <span id="title-desc-produto">Descrição do Produto:</span>
                    <p id="desc-product">
                        <c:out value="${produto.descricao}"/>
                    </p>
                </div>
                <div class="col-md-4">
                    <div class="col text-center">
                        <p id="price-product">
                            Valor unitario: R$<c:out value="${produto.valorUnitario}"/>
                        </p>
                        <select class="border btn" id="modelos" name="tipo">
                            <option disabled="" selected="" hidden="">Cores</option>
                            <option value="Produto">Vermelho</option>
                            <option value="Serviço">Rosa</option>
                        </select>
                        <span>
                            <button type="button" class="btn btn-outline-danger">-</button>
                            <input type="text" disabled="" value="1" name="qtd" id="text-qtd">
                            <button type="button" class="btn btn-outline-success">+</button>
                        </span>
                    </div>
                    <div class="col">
                        <button id="add-to-cart" type="button" class="btn btn-success btn-block">Comprar</button>
                    </div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-12">
                    <p class="h2">
                        Perguntas Frequentes
                    </p>
                </div>
                <div class="col-md-4">
                    <p class="nomeFaq">Guilherme Pereira</p>
                </div>
                <div class="col-md-8">
                    <p class="perguntaFaq">Gostaria de saber se tem flores a pronta entrega e se podem ser enviadas com um bilhete para surpresa?</p>
                    <p class="respostaFaq">R: Olá! Sim, temos flores para entrega imediata, e assinamos as entregas da forma que desejar, basta nos informar a mensagem.</p>
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp"%>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>
