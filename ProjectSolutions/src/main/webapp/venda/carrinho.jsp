<%-- 
    Document   : carrinho
    Created on : 06/10/2019, 11:30:23
    Author     : Alexsander Rocha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carrinho de compra</title>
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
                                    <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                                </form>
                            </li>
                            <li class="nav-item">
                                <form action="/cadastro_vendas">
                                    <button type="submit" class="btn nav-link nav-text">Vendas</button>
                                </form>                     
                            </li>
                            <li class="nav-item">
                                <form action="../ti/listagem_usuarios" method="GET">
                                    <button type="submit" class="btn nav-link nav-text" >Usuarios</button>
                                </form>
                            </li>
                            <li class="nav-item">
                                <form action="../venda/carrega_relatorio" method="GET">
                                    <button type="submit" class="btn nav-link nav-text" >Relatorio</button>
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
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h2 class="h2 text-center subtitulo" style="padding: 20px;">Carrinho</h2>
                </div>
                <div class="col-md-1 col-xl-1"></div>
                <div class="col-md-10 col-sm-10 col-xl-10">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th class="coluna" scope="col">Código</th>
                                        <th class="coluna" scope="col">Produto</th>
                                        <th class="coluna" scope="col">Preço</th>
                                        <th class="coluna" scope="col">Quantidade</th>
                                        <th>Total</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="coluna" name="codigo">0001</td>
                                        <td class="coluna" name="produto">Girasol amarelo</td>
                                        <td class="coluna" name="preco">R$ 50,00</td>
                                        <td class="coluna" name="quantidade">2</td>
                                        <td class="coluna" name="valorTotal">R$ 100,00</td>
                                        <td class="btn-group">
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteProduto">
                                                <i class="far fa-trash-alt"></i>
                                                <c:set var="codigoProduto" value="${produtos.codigo}"/>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="coluna" name="codigo">0002</td>
                                        <td class="coluna" name="produto">Rosas vermelhas</td>
                                        <td class="coluna" name="preco">R$ 25,00</td>
                                        <td class="coluna" name="quantidade">5</td>
                                        <td class="coluna" name="valorTotal">R$ 125,00</td>
                                        <td class="btn-group">
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteProduto">
                                                <i class="far fa-trash-alt"></i>
                                                <c:set var="codigoProduto" value="${produtos.codigo}"/>
                                            </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="coluna" name="codigo">0003</td>
                                        <td class="coluna" name="produto">Ypê Roxo</td>
                                        <td class="coluna" name="preco">R$ 75,00</td>
                                        <td class="coluna" name="quantidade">6</td>
                                        <td class="coluna" name="valorTotal">R$ 450.00</td>
                                        <td class="btn-group">
                                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteProduto">
                                                <i class="far fa-trash-alt"></i>
                                                <c:set var="codigoProduto" value="${produtos.codigo}"/>
                                            </button>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-6"></div>
                        <div class="col-md-6">
                            <h2 class="h2 text-center subtitulo" style="padding: 20px;">Resumo da Compra</h2>
                            <table class="table table-striped">
                                <tbody>
                                    <tr>
                                        <th class="coluna" scope="col">Subtotal</th>
                                        <td class="coluna" name="subtotal">RS 625,00</td>
                                    </tr>
                                    <tr>
                                        <th class="coluna" scope="col">Frete</th>
                                        <td class="coluna" name="frete">
                                            <p>Digite o CEP:</p>
                                            <input type="text" class="form-control inputForm" id="cep"
                                                   placeholder="CEP" name="cep" min="0">
                                            <a href="#">
                                                Calcular frete
                                                <i class="fas fa-shopping-cart"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th class="coluna" scope="col">Total</th>
                                        <td class="coluna" name="total">R$ 650,00</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-xl-1"></div>
            </div>
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>
