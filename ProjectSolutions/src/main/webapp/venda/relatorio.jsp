<%-- 
Document   : relatorio
Created on : 08/04/2019, 21:48:45
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Relatório</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
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
                        <form action="../ti/listagem_usuarios" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Usuarios</button>
                        </form>
                    </li>
                </ul>
                <i class="fas fa-user-tie" style="margin-left: -189px;"></i> &nbsp;&nbsp; Olá, <c:out value="${nomeUsuario}"/> 
                <form action="../venda/logout" method="POST">
                    <button type="submit" class="btn nav-link nav-text" >Sair</button>
                </form>
            </nav>
            <h2 class="h2 text-center subtitulo">Relatório</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="gerar_relatorio" method="get">
                        <div class="form-row">
                            <div class="col-md-3">
                                <label for="filial" >Filial:</label>
                                <select class="custom-select inputForm" id="filial" name="filial">
                                    <option disabled="" selected="" hidden="">Filial</option>
                                    <c:forEach var="filiais" items="${listaFiliais}">
                                        <option value="<c:out value="${filiais.codigo}"></c:out>">
                                            <c:out value="${filiais.nomeFilial}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-row col-md-5">
                                <div class="col-md-6">
                                    <label for="dataDe">De:</label>
                                    <input type="date" class="form-control inputForm" id="dataDe" name="dataDe">
                                </div>
                                <div class="col-md-6">
                                    <label for="dataAte">Ate:</label>
                                    <input type="date" class="form-control inputForm" id="dataAte" name="dataAte">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <!--<button class="btn btn-light" style="margin: 32px 176px 0 0; float: right">-->
                                <button class="btn btn-light" style="margin: 32px 217px 0 0; float: right">
                                    <i class="far fa-file-alt"></i>
                                    Gerar relatorio
                                </button>
                            </div>
                        </div>
                    </form>
                    <!--                    <div class="col-md-12">
                                            <form action="gerar_excel" method="get" style="float: right; margin:-39px -15px 0 0;">
                                                <button class="btn btn-success">
                                                    <i class="far fa-file-excel"></i>
                                                    Exportar Para Excel
                                                </button>
                                            </form>
                                        </div>-->
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr>
                    <table class="table table-striped">
                        <thead class="coluna" >
                            <tr>
                                <th scope="col" style="width: 1px">Código da venda</th>
                                <th scope="col">Nome do produto</th>
                                <th scope="col" style="width: 1px">Código do produto</th>
                                <th scope="col" style="width: 1px">Quantidade vendida</th>
                                <th scope="col" style="width: 1px">Valor total</th>
                                <th scope="col">CPF do cliente</th>
                                <th scope="col" style="width: 1px">Código da filial</th>
                                <th scope="col">Nome da filial</th>
                                <th scope="col" style="width: 1px">ID do funcionário</th>
                                <th scope="col">Data da venda</th>
                                <th scope="col" style="width: 1px">Status</th>
                            </tr>
                        </thead>
                        <tbody class="coluna" >
                            <c:forEach var="relatorio" items="${listaRelatorios}">
                                <tr>
                                    <td name="codigoVenda" ><c:out value="${relatorio.codigoVenda}" /></td>
                                    <td name="nomeProduto" ><c:out value="${relatorio.nomeProduto}" /></td>
                                    <td name="codigoProduto" ><c:out value="${relatorio.codigoProduto}" /></td>
                                    <td name="quantidadeProduto" ><c:out value="${relatorio.quantidadeProduto}" /></td>
                                    <td name="valorTotal" ><c:out value="${relatorio.valorTotal}" /></td>
                                    <td name="cpfCliente" ><c:out value="${relatorio.cpfCliente}" /></td>
                                    <td name="idFilial" ><c:out value="${relatorio.idFilial}" /></td>
                                    <td name="nomeFilial" ><c:out value="${relatorio.nomeFilial}" /></td>   
                                    <td name="idUsuario" ><c:out value="${relatorio.idUsuario}" /></td>   
                                    <td name="dataVenda" ><c:out value="${relatorio.dataVenda}" /></td>   
                                    <c:choose>
                                        <c:when test="${relatorio.status == 0}">
                                            <td name="dataVenda" >Ativa</td>  
                                        </c:when>
                                        <c:otherwise>
                                            <td name="dataVenda" >Estornada</td>  
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <footer class="pt-4 my-md-5 pt-md-5 footer-border-top">
                <div class="row text-center">
                    <div class="col-12 col-md">
                        <img class="mb-2" src="../assets/img/logo.png" alt="">
                        <small class="d-block mb-3 text-muted">&copy; Project Solutions - 2019</small>
                    </div>
                    <div class="col-12 col-md">
                        <h5 class="title-footer">Project Solutions</h5>
                        <ul class="list-unstyled text-small">
                            <li class="text-muted">Alexsander Medeiros</li>
                            <li class="text-muted">Daniel Morais</li>
                            <li class="text-muted">Guilherme Ricardo</li>
                            <li class="text-muted">Guilherme Pereira</li>
                            <li class="text-muted">Nicolas Yoshioka</li>
                        </ul>
                    </div>
                </div>
            </footer>
        </div>
    </body>
</html>