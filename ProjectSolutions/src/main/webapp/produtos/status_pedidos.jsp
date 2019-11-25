<%-- 
   Document   : listagem_produtos
   Created on : 08/04/2019, 21:45:31
   Author     : nicolas.hgyoshioka
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Pedidos</title>
        <link rel="stylesheet" type="text/css"href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css" />
        <link rel="stylesheet"href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>
        <h2 class="h2 text-center subtitulo">Pedidos</h2>

        <div class="container">
            <c:if test="${varMsg == true}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${msg}" />
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <c:if test="${varMsgErro == true}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${msg}" />
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>

            <div class="row">
                <div class="col-12">
                    <div id="accordion">
                        <c:forEach var="pedidos" items="#{listaPedidos}">
                            <div class="card">
                                <div class="card-header" id="heading<c:out value="${pedidos.idVenda}"></c:out>">
                                        <h5 class="mb-0 text-center">
                                            <table class="table table-borderless">
                                                <thead>
                                                    <tr>
                                                        <th>Codigo da Venda</th>
                                                        <th>Data da Venda</th>
                                                        <th>Status do Pedido</th>
                                                        <th>Alterar Status do Pedido</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><c:out value="${pedidos.codigoVenda}"></c:out></td>
                                                    <td><c:out value="${pedidos.dataVenda}"></c:out></td>
                                                    <td><c:out value="${pedidos.nomeStatusVenda}"></c:out></td>
                                                        <td>
                                                            <form action="status_pedidos" method="POST">
                                                                <div class="form-row align-items-center">
                                                                    <div class="col-auto">
                                                                        <select class="custom-select form-control inputForm" id="idStatus" name="idStatus">
                                                                            <option selected ="" disabled="" hidden="">Selecione um novo status</option>
                                                                            <option value="1">Aguardando pagamento</option>
                                                                            <option value="2">Pagamento rejeitado</option>
                                                                            <option value="3">Pagamento aprovado</option>
                                                                            <option value="4">Aguardando retirada</option>
                                                                            <option value="5">Pedido em trânsito</option>
                                                                            <option value="6">Pedido entregue</option>  
                                                                        </select>
                                                                    </div>
                                                                    <div class="col-auto">
                                                                        <button type="submit" class="btn btn-success" id="idPedido" name="idPedido" value="<c:out value="${pedidos.idVenda}"></c:out>">
                                                                            <i class="far fa-save"></i>
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <button class="btn btn-link" data-toggle="collapse" data-target="#<c:out value="collapse${pedidos.idVenda}"></c:out>" aria-expanded="true" aria-controls="collapse<c:out value="${pedidos.idVenda}"></c:out>">
                                                <i class="fas fa-angle-down"></i>
                                                Ver detalhes do produto
                                                <i class="fas fa-angle-down"></i>
                                            </button>
                                        </h5>
                                    </div>
                                        <div id="collapse<c:out value="${pedidos.idVenda}"></c:out>" class="collapse" aria-labelledby="heading<c:out value="${pedidos.idVenda}"></c:out>" data-parent="#accordion">
                                        <div class="card-body">
                                            <table class="table table-borderless">
                                                <thead>
                                                    <tr><th colspan="4">Endereço de entrega</th></tr>
                                                    <tr>
                                                        <th>Logradouro</th>
                                                        <th>CEP</th>
                                                        <th>Número</th>
                                                        <th>Valor do Frete</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                            <td><c:out value="${pedidos.logradouroVenda}"></c:out></td>
                                                    <td><c:out value="${pedidos.cepVenda}"></c:out></td>
                                                    <td><c:out value="${pedidos.numeroEnderecoVenda}"></c:out></td>
                                                    <td>R$ <c:out value="${pedidos.valorFrete}"></c:out></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <table class="table table-borderless">
                                                <thead>
                                                    <tr><th colspan="4">Forma de pagamento</th></tr>
                                                    <tr>
                                                        <th>Pedido pago usando</th>
                                                        <th>Número do <c:out value="${pedidos.nomeFormaPagamentoVenda}"></c:out></th>
                                                        <th>Valor Total do Pedido</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><c:out value="${pedidos.nomeFormaPagamentoVenda}"></c:out></td>
                                                    <td><c:out value="${pedidos.numeroPagamentoVenda}"></c:out></td>
                                                    <td>R$ <c:out value="${pedidos.valorTotalVenda}"></c:out></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <table class="table table-borderless">
                                                <thead>
                                                    <tr><th colspan="4">Detalhes dos produtos</th></tr>
                                                    <tr>
                                                        <th>Quantidade Total de Produtos do Pedido</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><c:out value="${pedidos.quantidadeTotalVenda}"></c:out></td>
                                                    </tr>
                                                </tbody>
                                            </table>

                                            <table class="table table-borderless">
                                                <thead>
                                                <c:forEach var="produtosVenda" items="#{listaProdutos}">
                                                    <c:if test="${pedidos.idVenda == produtosVenda.idVenda}">
                                                        <tr>
                                                            <th>Nome do Produto</th>
                                                            <th>Quantidade adquirida</th>
                                                            <th>Valor Unitario</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td><c:out value="${produtosVenda.nomeProdutoVenda}"></c:out></td>
                                                            <td><c:out value="${produtosVenda.quantidadeUnitariaVenda}"></c:out></td>
                                                            <td>R$ <c:out value="${produtosVenda.valorUnitarioProdutoVenda}"></c:out></td>
                                                            </tr>
                                                    </c:if>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <%@include file="../WEB-INF/footer.jsp"%>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/footable.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>