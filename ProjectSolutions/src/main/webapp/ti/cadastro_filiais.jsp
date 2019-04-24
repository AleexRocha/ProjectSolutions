<%-- 
Document   : cadastro_filiais
Created on : 08/04/2019, 21:40:32
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Filiais</title>
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
                        <a class="nav-link nav-text" href="listagem_usuarios.jsp">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>

            <c:if test="${acao == 'editar'}"> 
                <h2 class='h2 text-center subtitulo'>Editar Filial</h2> 

                <div class="container">
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-6">
                            <form action="editar_filial" method="post">

                                <div class="form-group">

                                    <label for="codigoFilial" class="sr-only">Código:</label>
                                    <input type="number" class="form-control inputForm sr-only" id="codigoFilial" 
                                           placeholder="Código da filial" name="codigoFilial" value="${codigo}">       

                                    <label for="logradouro">Logradouro:</label>
                                    <input type="text" class="form-control inputForm" id="logradouro" 
                                           placeholder="Logradouro" name="logradouro" value="${logradouro}">
                                    <label for="numero">Número:</label>   

                                    <input type="number" class="form-control inputForm" id="numero" 
                                           placeholder="Número" name="numero" value="${numero}">

                                    <label for="cep">CEP:</label>
                                    <input type="number" class="form-control inputForm" id="cep" 
                                           placeholder="CEP" name="cep" value="${cep}">
                                    <label for="bairro">Bairro:</label>
                                    <input type="text" class="form-control inputForm" id="bairro" 
                                           placeholder="Bairro" name="bairro" value="${bairro}">

                                    <label for="cidade">Cidade:</label>
                                    <input type="text" class="form-control inputForm" id="cidade" 
                                           placeholder="Cidade" name="cidade" value="${cidade}">

                                    <label for="estado">Estado:</label>
                                    <input type="text" class="form-control inputForm" id="estado" 
                                           placeholder="Estado" name="estado" value="${estado}">

                                    <label for="telefone">Telefone:</label>
                                    <input type="number" class="form-control inputForm" id="telefone" 
                                           placeholder="Telefone" name="telefone" value="${telefone}">
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
            </c:if>

            <c:if test="${empty acao}">
                <h2 class='h2 text-center subtitulo'>Cadastrar Filial</h2>

            </header>
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <form action="cadastro_filial" method="post">

                            <div class="form-group">

                                <label for="codigoFilial" class="sr-only">Código:</label>
                                <input type="number" class="form-control inputForm sr-only" id="codigoFilial" 
                                       placeholder="Código da filial" name="codigoFilial">       

                                <label for="logradouro">Logradouro:</label>
                                <c:if test="${empty logradouroErro}">
                                    <input type="text" class="form-control inputForm" id="logradouro" 
                                           placeholder="Logradouro" name="logradouro">
                                </c:if>
                                <c:if test="${not empty logradouroErro}">                                
                                    <input type="text" class="form-control inputForm error" id="logradouro" 
                                           placeholder="${logradouroErro}" name="logradouro">
                                </c:if>    

                                <label for="numero">Número:</label>
                                <c:if test="${empty numeroErro}">                                
                                    <input type="number" class="form-control inputForm" id="numero" 
                                           placeholder="Número" name="numero">
                                </c:if>
                                <c:if test="${not empty numeroErro}">                                
                                    <input type="number" class="form-control inputForm error" id="numero" 
                                           placeholder="${numeroErro}" name="numero">
                                </c:if>

                                <label for="cep">CEP:</label>
                                <c:if test="${empty cepErro}">
                                    <input type="number" class="form-control inputForm" id="cep" 
                                           placeholder="CEP" name="cep">
                                </c:if>
                                <c:if test="${not empty cepErro}">
                                    <input type="number" class="form-control inputForm error" id="cep" 
                                           placeholder="${cepErro}" name="cep">
                                </c:if>

                                <label for="bairro">Bairro:</label>
                                <c:if test="${empty bairroErro}">
                                    <input type="text" class="form-control inputForm" id="bairro" 
                                           placeholder="Bairro" name="bairro">
                                </c:if>
                                <c:if test="${not empty bairroErro}">
                                    <input type="text" class="form-control inputForm error" id="bairro" 
                                           placeholder="${bairroErro}" name="bairro">
                                </c:if>

                                <label for="cidade">Cidade:</label>
                                <c:if test="${empty cidadeErro}">
                                    <input type="text" class="form-control inputForm" id="cidade" 
                                           placeholder="Cidade" name="cidade">
                                </c:if>
                                <c:if test="${not empty cidadeErro}">
                                    <input type="text" class="form-control inputForm error" id="cidade" 
                                           placeholder="${cidadeErro}" name="cidade">
                                </c:if>

                                <label for="estado">Estado:</label>
                                <c:if test="${empty estadoErro}">
                                    <input type="text" class="form-control inputForm" id="estado" 
                                           placeholder="Estado" name="estado">
                                </c:if>
                                <c:if test="${not empty estadoErro}">
                                    <input type="text" class="form-control inputForm error" id="estado" 
                                           placeholder="${estadoErro}" name="estado">
                                </c:if>

                                <label for="telefone">Telefone:</label>
                                <c:if test="${empty telefoneErro}">
                                    <input type="number" class="form-control inputForm" id="telefone" 
                                           placeholder="Telefone" name="telefone">
                                </c:if>
                                <c:if test="${not empty telefoneErro}">
                                    <input type="number" class="form-control inputForm error" id="telefone" 
                                           placeholder="${telefoneErro}" name="telefone">
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
        </c:if>

    </body>
</html>
