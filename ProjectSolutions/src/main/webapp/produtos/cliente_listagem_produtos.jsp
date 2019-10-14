<%-- 
    Document   : cliente_listagem_produto
    Created on : 19/09/2019, 19:54:46
    Author     : Guilherme Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Produtos</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">
                <span class="sr-only">Floricultura TADES</span> <img
                    src="../assets/img/logo.png">
            </h1>
            <nav class="navbar navbar-expand-md navbar-light bg-warning">
                <div class="container">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarsExample08">
                        <ul id="itensMenu" class="navbar-nav justify-content-center">
<!--                            <li class="nav-item">
                                <form action="../produtos/listagem_produtos" method="GET">
                                    <button type="submit" class="btn nav-link nav-text">Produtos</button>
                                </form>
                            </li>-->
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

        <h2 class="h2 text-center subtitulo">Produtos</h2>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div id="carouselExampleIndicators" class="carousel slide my-4"
                         data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0"
                                class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid"
                                     src="../assets/img/girassol-slide.jpg" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid"
                                     src="../assets/img/flores-rosas-slide.jpg" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid"
                                     src="../assets/img/flores-rosas-vermelhas-slide.jpg"
                                     alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators"
                           role="button" data-slide="prev"> <span
                                class="carousel-control-prev-icon" aria-hidden="true"></span> <span
                                class="sr-only">Previous</span>
                        </a> <a class="carousel-control-next" href="#carouselExampleIndicators"
                                role="button" data-slide="next"> <span
                                class="carousel-control-next-icon" aria-hidden="true"></span> <span
                                class="sr-only">Next</span>
                        </a>
                    </div>
                </div>

                <c:forEach var="produtos" items="#{listaProdutos}">
                    <div class="col-lg-4 col-md-6 col-sm-3">
                        <div class="card h-100">
                            <a href="#">
                                <img class="card-img-top" src="${produtos.srcImagem}" alt="Arranjo de Girassol">
                            </a>
                            <div class="card-body">
                                <p class="card-title">
                                    <span class="tituloProdutoCliente h4"> <c:out value="${produtos.nome}"/> </span>
                                    <span class="precoProdutoCliente h5"> R$<c:out value="${produtos.valorUnitario}"/> </span>
                                </p>
                                <p class="card-text descricaoProdutoCliente"> <c:out value="${produtos.descricao}"/>  </p>
                                <div class="row">
                                    <div class="col-lg-6"> 
                                        <button type="button" class="btn btn-outline-success btn-block">Comprar</button> 
                                    </div>
                                    <div class="col-lg-6"> 
                                        <form action="../produtos/visualizar_descricao" method="GET">
                                            <button name="visualizarPorId" type="submit" value ="${produtos.codigo}" class="btn btn-outline-success btn-block">Saiba mais</button>
                                        </form> 
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <%@include file="../WEB-INF/footer.jsp"%>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>
