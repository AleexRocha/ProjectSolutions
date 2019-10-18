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
        <%@include file="../WEB-INF/header.jsp"%>
        <h2 class="h2 text-center subtitulo">Produtos</h2>
        <div class="container" id="contentDescricao">
            <h2 class="text-center subtitulo titulo-produto-descricao">Produto: <c:out value="${produto.nome}"/></h2>
            <div class="row" id="details-product">
                <div class="col-md-7">
                    <div class="text-center" id="imgProduto">
                        <img id="img-product" src="${produto.srcImagem}" alt="">
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
                        <div class="opcoes-produto">
                            <span id="dropdown-cor">Cor:</span>
                            <select class="border btn dropdown-toggle" name="cor">
                                <option disabled="" selected="" hidden="">Cores</option>
                                <option value="Produto">Vermelho</option>
                                <option value="Serviço">Rosa</option>
                            </select>
                        </div>
                        <div class="opcoes-produto">
                            <span>Quantidade:</span>
                            <select class="border btn dropdown-toggle" name="quantidade">
                                <option disabled="" selected="" hidden="">Quantidade</option>
                                <option value="1">1 produto</option>
                                <option value="2">2 produtos</option>
                                <option value="3">3 produtos</option>
                                <option value="4">4 produtos</option>
                                <option value="5">5 produtos</option>
                                <option disabled="">Para quantidades maiores, entre em contato com o FAQ</option>
                            </select>
                        </div>
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
