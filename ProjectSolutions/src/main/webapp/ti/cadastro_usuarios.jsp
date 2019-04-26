<%-- 
Document   : cadastro_usuarios
Created on : 08/04/2019, 21:45:57
Author     : nicolas.hgyoshioka
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuários</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" type="text/css" href="../assets/css/navbar-top.css">
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
                        <a class="nav-link nav-text" href="../produtos/listagem_produtos.jsp">Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="listagem_filiais.jsp">Filiais</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Cadastrar Usuário</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="cadastro_usuario" method="post">
                        <div class="form-group">
                            <label for="codigoUsuario" class="sr-only">Código:</label>
                            <input type="number" class="form-control inputForm sr-only" id="codigoUsuario" placeholder="Código do usuário" name="codigoUsuario">

                            <label for="nome">Nome:</label>
                            <input type="text" class="form-control inputForm" id="nome" placeholder="Nome" name="nome">

                            <label for="email">E-mail:</label>
                            <input type="email" class="form-control inputForm" id="email" placeholder="E-mail" name="email">

                            <label for="senha">Senha:</label>
                            <input type="text" class="form-control inputForm" id="senha" placeholder="Senha" name="senha">

                            <label for="confirmarSenha">Confirmar senha:</label>
                            <input type="text" class="form-control inputForm" id="confirmarSenha" placeholder="Confirmar senha" name="confirmarSenha">

                            <label for="setor" >Setor:</label>
                             <select class="custom-select inputForm" id="codigoSetor" name="codigoSetor">
                                <option disabled="" selected="" hidden="">Código do Setor</option>
                                <c:forEach var="listaSetores" items="${setores}">  
                                    <option value="<c:out value="${listaSetores.id}"></c:out>"> <c:out value="${listaSetores.id}"/> </option>  
                                </c:forEach>  
                            </select>
                            <label for="tipo" >Filial:</label>
                            <select class="custom-select inputForm" id="codigoFilial" name="filial">
                                <option disabled="" selected="" hidden="">Código da Filial</option>
                                <c:forEach var="listaFiliais" items="${filiais}">  
                                    <option value="<c:out value="${listaFiliais.id}"></c:out>"> <c:out value="${listaFiliais.id}"/> </option>  
                                </c:forEach>  
                            </select>
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
