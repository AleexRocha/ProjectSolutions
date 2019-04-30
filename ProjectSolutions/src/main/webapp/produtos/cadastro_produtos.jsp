<%-- 
Document   : cadastro_produtos
Created on : 08/04/2019, 21:44:27
Author     : nicolas.hgyoshioka
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
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
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <ul class="nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/cadastro_vendas.jsp">Vendas</a>
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_filiais" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Filiais</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_usuarios" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Usuarios</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>
        </header>

        <c:if test="${acao == 'editar'}"> 
            <h2 class="h2 text-center subtitulo">Editar Produto</h2>
        </c:if>

        <c:if test="${empty acao}"> 
            <h2 class="h2 text-center subtitulo">Cadastrar Produto</h2>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">

                    <c:if test="${acao == 'editar'}">
                        <form action="editar_produto" method="POST">
                        </c:if>
                        <c:if test="${empty acao}">
                            <form action="cadastro_produto" method="POST">
                            </c:if>

                            <div class="form-group">

                                <label for="codigoProduto" class="sr-only">Código:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="number" class="form-control inputForm sr-only" id="codigoProduto"
                                           value="${codigo}" name="codigoProduto">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="number" class="form-control inputForm sr-only" id="codigoProduto"
                                           placeholder="Codigo do produto" name="codigoProduto">
                                </c:if>

                                <label for="nomeProduto">Nome:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="text" class="form-control inputForm" id="nome"
                                           value="${nome}" name="nome">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="text" class="form-control inputForm" id="nome"
                                           placeholder="Nome do produto" name="nome">
                                </c:if>

                                <label for="descricaoProduto">Descrição:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="text" class="form-control inputForm" id="descricao"
                                           value="${descricao}" name="descricao">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="text" class="form-control inputForm" id="descricao"
                                           placeholder="Descrição do produto" name="descricao">
                                </c:if>

                                <label for="quantidadeEstoque">Quantidade em estoque:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="number" class="form-control inputForm" id="quantidadeEstoque"
                                           value="${qtd_estoque}" name="quantidadeEstoque">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="number" class="form-control inputForm" id="quantidadeEstoque"
                                           placeholder="Quantidade em estoque" name="quantidadeEstoque">
                                </c:if>

                                <label for="valorProduto">Valor Unitário:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="number" class="form-control inputForm" id="valorUnitario"
                                           value="${valor_unidade}" name="valorUnitario">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="number" class="form-control inputForm" id="valorUnitario"
                                           placeholder="Valor Unitário" name="valorUnitario">
                                </c:if>

                                <label for="tipo" >Tipo:</label>
                                <c:if test="${acao == 'editar'}">
                                    <select class="custom-select inputForm" id="tipo" name="tipo">
                                        <option value="Produto">${tipoCadastrado}</option>
                                        <option value="Produto">Produto</option>
                                        <option value="Serviço">Serviço</option>
                                    </select>
                                </c:if>
                                <c:if test="${empty acao}">
                                    <select class="custom-select inputForm" id="tipo" name="tipo">
                                        <option value="Produto">Produto</option>
                                        <option value="Serviço">Serviço</option>
                                    </select>
                                </c:if>                            

                                <label for="filial" >Filial:</label>
                                <c:if test="${acao == 'editar'}">
                                    <select class="custom-select inputForm" id="filial" name="codigoFilial">
                                        <option value="${cdFilialCadastrada}">${nomeFilialCadastrada}</option>
                                        <c:forEach var="filiais" items="${listaFiliais}">
                                            <option value="<c:out value="${filiais.codigo}"/>">
                                                <c:out value="${filiais.nomeFilial}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </c:if>
                                <c:if test="${empty acao}">
                                    <select class="custom-select inputForm" id="filial" name="codigoFilial">
                                        <option disabled="" selected=""> Filial </option>
                                        <c:forEach var="filiais" items="${listaFiliais}">
                                            <option value="<c:out value="${filiais.codigo}"/>">
                                                <c:out value="${filiais.nomeFilial}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </c:if>

                            </div>
                            <button type="submit" class="btn btn-light btn-block">
                                <i class="far fa-save"></i>
                                Salvar
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

    </body>
</html>
