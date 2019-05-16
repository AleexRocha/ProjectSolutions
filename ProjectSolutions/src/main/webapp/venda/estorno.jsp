<%-- 
    Document   : estorno
    Created on : 08/05/2019, 16:00:20
    Author     : Alexsander Rocha
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
                <ul id="itensMenu" class="nav justify-content-center">
                    <li class="nav-item">
                        <form action="cadastro_vendas">
                            <button type="submit" class="btn nav-link nav-text">Vendas</button>
                        </form>                     
<!--                    </li>
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
                    </li>-->
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Estorno de compras</h2>
            <form action="cadastro_vendas" method="GET" class="form-estorno-relatorio">
                <button type="submit" class="btn btn-success" >Cadastrar Vendas</button>
            </form>
        </header>
        <div class="container">
            <div class="row">
                <form action="select_estorno" method="post">
                    <c:if test="${varMsg == true}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${msg}"/>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    <label for="filial" >Filial:</label>
                    <select class="custom-select inputForm" id="codigoProduto" name="codigoFilial">
                        <option disabled="" selected="" hidden="">Filial</option>
                        <c:forEach var="filial" items="${listaFiliais}">
                            <option value="<c:out value="${filial.codigoFilial}"></c:out>">
                                <c:out value="${filial.nomeFilial}"></c:out>
                                </option>
                        </c:forEach>
                    </select>
                    <label for="produto" >Produto:</label>
                    <select class="custom-select inputForm" id="codigoProduto" name="codigoProduto">
                        <option disabled="" selected="" hidden="">Produto</option>
                        <c:forEach var="produto" items="${listaProdutos}">
                            <option value="<c:out value="${produto.codigoProduto}"></c:out>">
                                <c:out value="${produto.nomeProduto}"></c:out>
                                </option>
                        </c:forEach>
                    </select>
                    <label for="cpfCliente">CPF do cliente:</label>
                    <input type="number" class="form-control inputForm" id="cpfCliente"
                           placeholder="CPF do cliente" name="cpfCliente">
                    <button class="btn btn-light">
                        <i class="far fa-file-alt"></i>
                        Buscar
                    </button>
                </form>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr>
                    <table class="table table-striped">
                        <thead class="coluna" >
                            <tr>
                                <th scope="col">Código da venda</th>
                                <th scope="col">Código do produto</th>
                                <th scope="col">ID do funcionário</th>
                                <th scope="col">CPF do cliente</th>
                                <th scope="col">Código da filial</th>
                                <th scope="col">Quantidade vendida</th>
                                <th scope="col">Data da venda</th>
                                <th scope="col">Ação</th>
                            </tr>
                        </thead>
                        <tbody class="coluna" >
                            <c:forEach var="relatorio" items="${listaEstorno}">
                                <tr>
                                    <td name="codigoVenda" ><c:out value="${relatorio.codigoVenda}" /></td>
                                    <td name="codigoProduto" ><c:out value="${relatorio.codigoProduto}" /></td>
                                    <td name="idUsuario" ><c:out value="${relatorio.idUsuario}" /></td>
                                    <td name="cpfCliente" ><c:out value="${relatorio.cpfCliente}" /></td>
                                    <td name="idFilial" ><c:out value="${relatorio.idFilial}" /></td>
                                    <td name="quantidadeProduto" ><c:out value="${relatorio.quantidadeProduto}" /></td>
                                    <td name="dataVenda" ><c:out value="${relatorio.dataVenda}" /></td>
                                    <td name="acao" >
                                        <!-- Button que chama a modal -->
                                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteProduto">
                                            <i class="far fa-trash-alt"></i>
                                            <c:set var="codigoProduto" value="${produtos.codigo}"/>
                                        </button>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <!-- Modal -->
                    <div class="modal fade" id="deleteProduto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">ATENÇÃO!!</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <p>Tem certeza que deseja estornar está venda?</p>
                                </div>
                                <div class="modal-footer">
                                    <form action="excluir_produto" method="POST" name ="deletarProduto">
                                        <button name="excluirID" value="${codigoProduto}" type="submit" class="btn btn-danger">
                                            <i class="far fa-trash-alt"></i> Sim
                                        </button>
                                    </form>
                                    <button type="button" class="btn btn-success" data-dismiss="modal">
                                        <i class="fas fa-ban"></i> Não
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>