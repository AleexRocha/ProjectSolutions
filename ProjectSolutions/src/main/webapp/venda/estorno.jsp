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
        <title>Estorno</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="select_estorno" method="post">
                        <c:if test="${varMsg == true}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${msg}"/>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>
                        <div class="form-row">
                            <div class="col-md-3">
                            </div>
                            <div class="col-md-3">
                                <label for="produto" >Produto:</label>
                                <select class="custom-select inputForm" id="codigoProduto" name="codigoProduto">
                                    <option disabled="" selected="" hidden="">Produto</option>
                                    <c:forEach var="produto" items="${listaProdutos}">
                                        <option value="<c:out value="${produto.codigoProduto}"></c:out>">
                                            <c:out value="${produto.nomeProduto}"></c:out>
                                            </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="cpfCliente">CPF do cliente:</label>
                                <input type="text" class="form-control inputForm" id="cpfCliente"
                                       placeholder="CPF do cliente" name="cpfCliente" min="0" minlength="0" maxlength="11">
                            </div>
                            <div class="col-md-3">
                                <button class="btn btn-light" style="margin: 32px 0 0 0;">
                                    <i class="far fa-file-alt"></i>
                                    Buscar compra
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
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
                                <th scope="col">Quantidade vendida</th>
                                <th scope="col">Data da venda</th>
                                <th scope="col">Ação</th>
                            </tr>
                        </thead>
                        <tbody class="coluna" >
                            <c:forEach var="relatorio" items="${listaEstornos}">
                                <tr>
                                    <td name="codigoVenda" ><c:out value="${relatorio.codigoVenda}" /></td>
                                    <td name="codigoProduto" ><c:out value="${relatorio.codigoProduto}" /></td>
                                    <td name="idUsuario" ><c:out value="${relatorio.idUsuario}" /></td>
                                    <td name="cpfCliente" ><c:out value="${relatorio.cpfCliente}" /></td>
                                    <td name="quantidadeProduto" ><c:out value="${relatorio.quantidadeProduto}" /></td>
                                    <td name="dataVenda" ><c:out value="${relatorio.dataVenda}" /></td>
                                    <td name="acao" >
                                        <!-- Button que chama a modal -->
                                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteProduto">
                                            <i class="far fa-trash-alt"></i>
                                            <c:set var="codigoVenda" value="${relatorio.codigoVenda}"/>
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
                                    <form action="delete_venda" method="POST" name ="deletarVenda">
                                        <button name="excluirID" value="${codigoVenda}" type="submit" class="btn btn-danger">
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
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>