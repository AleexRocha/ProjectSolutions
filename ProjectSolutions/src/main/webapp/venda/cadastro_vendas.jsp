<%-- 
Document   : cadastro_vendas
Created on : 08/04/2019, 21:47:39
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/navbar-top.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">
                <span class="sr-only">Floricultura TADES</span>
                <img src="../assets/img/logo.png">
            </h1>
            <nav class="navbar navbar-expand-md navbar-light bg-warning">
                <ul class="nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../produtos/listagem_produtos.jsp">Produtos</a>
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_filiais" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Filiais</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../ti/listagem_usuarios.jsp">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Cadastrar uma venda</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="cadastro_vendas" method="post">
                        <div class="form-group">
                            <span id="divProduto">
                                <label for="codigoProduto">Código do produto:</label>
                                <!--
                                <a href="javascript:void(0)" id="addInput" class="ctrl-produto">
                                    <span><i class="fas fa-plus"></i> Adicionar novo produto </span>
                                </a>
                                -->
                                <c:choose>
                                    <c:when test="${empty codProdutoErro}">
                                        <select class="custom-select inputForm" id="codigoProduto" name="codigoProduto">  
                                            <c:forEach var="elemento" items="${lista}">  
                                                <option value="${lista.id_produto}">${lista.id_produto}</option>  
                                            </c:forEach>  
                                        </select>
                                        <input type="number" class="form-control inputForm" id="codigoProduto"
                                               placeholder="Código do produto" name="codigoProduto">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="number" class="form-control inputForm error" id="codigoProduto"
                                               placeholder="${codProdutoErro}" name="codigoProduto">
                                    </c:otherwise>
                                </c:choose>
                            </span>

                            <label for="idFuncionario">ID do Funcionário:</label>
                            <c:choose>
                                <c:when test="${empty idFuncErro}">
                                    <input type="number" class="form-control inputForm" id="idFuncionario"
                                           placeholder="ID do funcionario" name="idFuncionario">
                                </c:when>
                                <c:otherwise>
                                    <input type="number" class="form-control inputForm error" id="idFuncionario"
                                           placeholder="${idFuncErro}" name="idFuncionario">
                                </c:otherwise>
                            </c:choose>

                            <label for="cpfCliente">CPF do cliente:</label>
                            <input type="number" class="form-control inputForm" id="cpfCliente"
                                   placeholder="CPF do cliente" name="cpfCliente">

                            <label for="codigoFilial">Codigo da filial:</label>
                            <c:choose>
                                <c:when test="${empty codFilialErro}">
                                    <input type="number" class="form-control inputForm" id="codigoFilial"
                                           placeholder="Código da filial" name="codigoFilial">
                                </c:when>
                                <c:otherwise>
                                    <input type="number" class="form-control inputForm error" id="codigoFilial"
                                           placeholder="${codFilialErro}" name="codigoFilial">
                                </c:otherwise>
                            </c:choose>

                            <label for="quantidade">Quantidade vendida:</label>
                            <c:choose>
                                <c:when test="${empty quantidadeErro}">
                                    <input type="number" class="form-control inputForm" id="quantidade"
                                           placeholder="Quantidade" name="quantidade">
                                </c:when>
                                <c:otherwise>
                                    <input type="number" class="form-control inputForm error" id="quantidade"
                                           placeholder="${quantidadeErro}" name="quantidade">
                                </c:otherwise>
                            </c:choose>

                        </div>
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="far fa-save"></i>
                            Salvar venda
                        </button>
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="fas fa-ban"></i>
                            Cancelar
                        </button>                    
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <script src="../assets/js/jquery-1.12.4.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/venda.js"></script>
    </body>
</html>
