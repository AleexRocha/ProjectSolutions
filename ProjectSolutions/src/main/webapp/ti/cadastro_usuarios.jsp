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
                <ul id="itensMenu" class="nav justify-content-center">
                    <li class="nav-item">
                        <form action="../venda/cadastro_vendas">
                            <button type="submit" class="btn nav-link nav-text">Vendas</button>
                        </form>                     
                    </li>
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
                        <a class="nav-link nav-text" href="../venda/relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>

            <c:if test="${acao == 'editar'}">
                <h2 class="h2 text-center subtitulo">Editar Usuário</h2>
            </c:if>

            <c:if test="${empty acao}">
                <h2 class="h2 text-center subtitulo">Cadastrar Usuário</h2>
            </c:if>

        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <c:if test="${acao == 'editar'}">
                        <form action="editar_usuario" method="post">
                        </c:if>

                        <c:if test="${empty acao}">
                            <form action="cadastro_usuario" method="post">
                            </c:if>

                            <div class="form-group">
                                <label for="codigoUsuario" class="sr-only">Código:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="number" class="form-control inputForm sr-only" id="codigoUsuario"
                                           value="${codigo}" name="codigoUsuario">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="number" class="form-control inputForm sr-only" id="codigoUsuario"
                                           placeholder="Código do usuário" name="codigoUsuario">
                                </c:if>


                                <label for="nome">Nome:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="text" class="form-control inputForm" id="nome"
                                           value="${nome}" name="nome">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="text" class="form-control inputForm" id="nome"
                                           placeholder="Nome" name="nome">
                                </c:if>


                                <label for="email">E-mail:</label>                         
                                <c:if test="${acao == 'editar'}">
                                    <input type="email" class="form-control inputForm" id="email"
                                           value="${email}" name="email">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="email" class="form-control inputForm" id="email"
                                           placeholder="E-mail" name="email">
                                </c:if>

                                <label for="senha">Senha:</label>
                                <c:if test="${acao == 'editar'}">
                                    <input type="password" class="form-control inputForm" id="senha"
                                           value="${senha}" name="senha">
                                </c:if>
                                <c:if test="${empty acao}">
                                    <input type="password" class="form-control inputForm" id="senha"
                                           placeholder="Senha" name="senha">
                                </c:if>

                                <c:if test="${empty acao}">
                                    <label for="confirmarSenha">Confirmar senha:</label>
                                    <input type="password" class="form-control inputForm" id="confirmarSenha" 
                                           placeholder="Confirmar senha" name="confirmarSenha">
                                </c:if>

                                <label for="setor" >Setor:</label>
                                <c:if test="${acao == 'editar'}">
                                    <select class="custom-select inputForm" id="codigoSetor" name="codigoSetor">
                                        <option value="${setor}">
                                            <c:out value="${nomeSetorCadastrado}"/>
                                        </option>                               
                                        <c:forEach var="listaSetores" items="${listaSetores}">  
                                            <option value="<c:out value="${listaSetores.setor}"></c:out>">
                                                <c:out value="${listaSetores.nomeSetor}"/> 
                                            </option>  
                                        </c:forEach>    
                                    </select>
                                </c:if>
                                <c:if test="${empty acao}">
                                    <select class="custom-select inputForm" id="codigoSetor" name="codigoSetor">
                                        <option disabled="" selected="" hidden="">Setor</option>                               
                                        <c:forEach var="listaSetores" items="${listaSetores}">  
                                            <option value="<c:out value="${listaSetores.setor}"></c:out>">
                                                <c:out value="${listaSetores.nomeSetor}"/> 
                                            </option>  
                                        </c:forEach>       
                                    </select>
                                </c:if>

                                <label for="tipo" >Filial:</label>
                                <c:if test="${acao == 'editar'}">
                                    <select class="custom-select inputForm" id="codigoFilial" name="filial">
                                        <option value="${filial}">
                                            <c:out value="${nomeFilialCadastrado}"/>
                                        </option>
                                        <c:forEach var="listaFiliais" items="${listaFiliais}">  
                                            <option value="<c:out value="${listaFiliais.codigoFilial}"></c:out>"> 
                                                <c:out value="${listaFiliais.nomeFilial}"/> 
                                            </option>  
                                        </c:forEach>  
                                    </select>
                                </c:if>
                                <c:if test="${empty acao}">
                                    <select class="custom-select inputForm" id="codigoFilial" name="filial">
                                        <option disabled="" selected="" hidden="">Filial</option>
                                        <c:forEach var="listaFiliais" items="${listaFiliais}">  
                                            <option value="<c:out value="${listaFiliais.codigoFilial}"></c:out>"> 
                                                <c:out value="${listaFiliais.nomeFilial}"/> 
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
