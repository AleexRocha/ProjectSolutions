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
                <ul id="itensMenu" class="nav justify-content-center">
                    <li class="nav-item">
                        <form action="../produtos/listagem_produtos" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                        </form>
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
                        <form action="carrega_relatorio" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Relatorio</button>
                        </form>
                    </li>
                </ul>
                <i class="fas fa-user-tie" style="margin-left: -189px;"></i> &nbsp;&nbsp; Olá, <c:out value="${nome}"/> 
                <form action="../venda/logout" method="POST">
                    <button type="submit" class="btn nav-link nav-text" >Sair</button>
                </form>
            </nav>
            <h2 class="h2 text-center subtitulo" style="padding: 24px 0px;">Cadastrar uma venda</h2>
            <form action="estorno" method="GET" class="form-estorno-cadastro">
                <button type="submit" class="btn btn-success" >Estornar compras</button>
            </form>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="create_venda" method="post">

                        <c:if test="${varMsgS == true}">
                            <div class="alert alert-success" role="alert">
                                <c:out value="${msg}"/>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>
                        <c:if test="${varMsgE == true}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${msg}"/>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>

                        <div class="form-group">
                            <label for="codigoProduto">Código do produto:</label>
                            <c:choose>
                                <c:when test="${empty codProdutoErro}">
                                    <select class="custom-select inputForm" id="codigoProduto" name="codigoProduto">
                                        <option disabled="" selected="" hidden="">Código do produto</option>
                                        <c:forEach var="produto" items="${listaProdutos}">
                                            <option value="<c:out value="${produto.codigoProduto}"></c:out>">
                                                <c:out value="${produto.nomeProduto}"></c:out>
                                                </option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="custom-select inputForm error" id="codigoProduto" name="codigoProduto">
                                        <option disabled="" selected="" hidden="">${codProdutoErro}</option>
                                        <c:forEach var="produto" items="${listaProdutos}">
                                            <option value="<c:out value="${produto.codigoProduto}"></c:out>">
                                                <c:out value="${produto.nomeProduto}"></c:out>
                                                </option>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>

                            <label for="idFuncionario">ID do Funcionário:</label>
                            <c:choose>
                                <c:when test="${empty idFuncErro}">
                                    <select class="custom-select inputForm" id="codigoProduto" name="idFuncionario">
                                        <option disabled="" selected="" hidden="">ID do funcionário</option>
                                        <c:forEach var="usuario" items="${listaUsuarios}">  
                                            <option value="<c:out value="${usuario.idFuncionario}"></c:out>">
                                                <c:out value="${usuario.nomeFuncionario}"></c:out>
                                                </option>  
                                        </c:forEach>  
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="custom-select inputForm error" id="codigoProduto" name="idFuncionario">
                                        <option disabled="" selected="" hidden="">${idFuncErro}</option>
                                        <c:forEach var="usuario" items="${listaUsuarios}">
                                            <option value="<c:out value="${usuario.idFuncionario}"></c:out>">
                                                <c:out value="${usuario.nomeFuncionario}"></c:out>
                                                </option>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>

                            <label for="cpfCliente">CPF do cliente:</label>
                            <input type="number" class="form-control inputForm" id="cpfCliente"
                                   placeholder="CPF do cliente" name="cpfCliente">

                            <label for="codigoFilial">Código da filial:</label>
                            <c:choose>
                                <c:when test="${empty codFilialErro}">
                                    <select class="custom-select inputForm" id="codigoProduto" name="codigoFilial">
                                        <option disabled="" selected="" hidden="">Código da filial</option>
                                        <c:forEach var="filial" items="${listaFiliais}">
                                            <option value="<c:out value="${filial.codigoFilial}"></c:out>">
                                                <c:out value="${filial.nomeFilial}"></c:out>
                                                </option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="custom-select inputForm error" id="codigoProduto" name="codigoFilial">
                                        <option disabled="" selected="" hidden="">${codFilialErro}</option>
                                        <c:forEach var="filial" items="${listaFiliais}">  
                                            <option value="<c:out value="${filial.codigoFilial}"></c:out>">
                                                <c:out value="${filial.nomeFilial}"></c:out>
                                                </option>  
                                        </c:forEach>  
                                    </select>
                                </c:otherwise>
                            </c:choose>

                            <label for="quantidade">Quantidade vendida:</label>
                            <c:choose>
                                <c:when test="${empty quantidadeErro}">
                                    <input type="number" class="form-control inputForm" id="quantidade"
                                           placeholder="Quantidade" name="quantidade" min="0">
                                </c:when>
                                <c:otherwise>
                                    <input type="number" class="form-control inputForm error" id="quantidade"
                                           placeholder="${quantidadeErro}" name="quantidade" min="0">
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
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>
