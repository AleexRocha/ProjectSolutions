<%-- 
    Document   : carrinho
    Created on : 21/10/2019, 20:52:56
    Author     : guilherme.rsvieira
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carrinho</title>
        <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css" />
        <link rel="stylesheet" href="../assets/css/style.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>
        <h2 class="h2 text-center subtitulo">Check-out</h2>
        <br>
        <div class="container">
            <div class="alert alert-success sr-only" role="alert">
                <span id="msg-alert-success">TESTE</span>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="alert alert-danger sr-only" role="alert">
                <span id="msg-alert-danger">TESTE</span>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="row">
                <div class="col-6" style="border-bottom: 2px solid #aeaeae">
                    <h4 class="h4 text-center subtitulo">Resumo da compra</h4>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Produto</th>
                                <th scope="col">Valor Unitário</th>
                                <th scope="col">Quantidade</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="produto" items="${produtosCarrinho}">
                                <tr class="carrinho">
                                    <td class="produto">
                                        <div class="media">
                                            <div class="media-body">
                                                <p class="sr-only idProduto">${produto.codigo}</p>
                                                <p class="nomeProduto"><c:out value="${produto.nome}"/></p>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="precoUnitario">
                                        <h5 class="unitario">R$ <c:out value="${produto.valorUnitario}"/></h5>
                                    </td>
                                    <td class="quantidade">
                                        <div class="product_count">
                                            <input type="number" readonly="" class="input-quantidade" data-posicao="${produto.codigo}" value="${produto.quantidadeEstoque}" min="1" max="5">
                                        </div>
                                    </td>
                                    <td class="precoTotal">
                                        <h5 class="total">R$ <c:out value="${produto.valorTotal}"/></h5>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>
                                    <h5>Subtotal</h5>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="subtotal">R$ <c:out value="${subtotal}"></c:out> </h5>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-3 text-center" style="border-bottom: 2px solid #aeaeae">
                        <h4 class="h4 text-center subtitulo">Forma de pagamento</h4>
                        <select class="custom-select form-control inputForm" id="pagamento" name="pagamento">
                            <option selected ="" disabled="" hidden="">Selecione um pagamento</option>
                            <option value="99">Boleto</option>
                        <c:forEach var="pagamento" items="${metodosPagamento}">  
                            <option value="<c:out value="${pagamento.id}"></c:out>">
                                Titular: <c:out value="${pagamento.nomeTitular}"/>
                            </option>  
                        </c:forEach>
                    </select>
                    <span class="msgPagamento sr-only">Selecione uma forma de pagamento</span>
                    <br>
                    <div class="row">
                        <c:forEach var="pagamento" items="${metodosPagamento}">  
                            <div class="col-12 cardPagamento cardCheckout" id="pagamento<c:out value="${pagamento.id}"/>">
                                <div class="card" style="background-color: #f3f3f3 !important;">
                                    <div class="card-body">
                                        <span class="card-title">
                                            <b> Método Pagamento:</b>
                                            <p><c:out value="${pagamento.tipoPagamento}"/></p>
                                        </span>
                                        <div class="row">
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> Número de Identificação: </b>
                                                    <p>****.*****.****.<c:out value="${pagamento.numeroPagamento}"/></p>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> Nome do Titular: </b>
                                                    <p><c:out value="${pagamento.nomeTitular}"/></p>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> Vencimento: </b>
                                                    <p><c:out value="${pagamento.dataVencimento}"/></p>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <form action="../ti/pagamento_listagem" method="POST" style="margin: 10px auto;">
                            <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn btn-danger">
                                Cadastrar forma de pagamento
                            </button>
                        </form>
                    </div>
                </div>
                <div class="col-3 text-center" style="border-bottom: 2px solid #aeaeae">
                    <h4 class="h4 text-center subtitulo">Endereço de entrega</h4>
                    <select class="custom-select form-control inputForm" id="endereco" name="endereco">
                        <option selected ="" disabled="" hidden="">Selecione um endereço</option>                               
                        <c:forEach var="enderecos" items="${enderecosEntrega}">  
                            <option value="<c:out value="${enderecos.codigoEndereco}"></c:out>">
                                Logradouro: <c:out value="${enderecos.logradouro}"/> 
                            </option>  
                        </c:forEach>       
                    </select>
                    <span class="msgEndereco sr-only">Selecione um endereco de entrega</span>
                    <div class="row">
                        <c:forEach var="enderecos" items="#{enderecosEntrega}">
                            <div class="col-12 cardEndereco cardCheckout" id="endereco<c:out value="${enderecos.codigoEndereco}"/>">
                                <div class="card" style="background-color: #f3f3f3 !important;">
                                    <div class="card-body">
                                        <span class="card-title">
                                            <b> Logradouro / Número:</b>
                                            <p><c:out value="${enderecos.logradouro}"/>, <c:out value="${enderecos.numero}"/></p>
                                        </span>
                                        <div class="row">
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> Complemento </b>
                                                    <p><c:out value="${enderecos.complemento}"/></p>
                                                </span>
                                            </div>
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> CEP: </b>
                                                    <p><c:out value="${enderecos.cep}"/></p>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> Bairro: </b>
                                                    <p><c:out value="${enderecos.bairro}"/></p>
                                                </span>
                                            </div>
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> Cidade: </b>
                                                    <p><c:out value="${enderecos.cidade}"/></p>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <span class="card-title">
                                                    <b> Estado: </b>
                                                    <p><c:out value="${enderecos.estado}"/></p>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="col-12">
                            <div id="valores" class="text-center"></div>
                        </div>
                        <form action="../ti/cadastro_endereco.jsp" method="POST" style="margin: 7px auto;">
                            <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn btn-danger">
                                Cadastrar novo endereço
                            </button>
                        </form>
                    </div>
                </div>
                <div class="col-6"></div>
                <div class="col-6">
                    <button type="button" class="btn btn-success btn-block" onclick="salvarProdutos()" style="margin-top: 10px; float: right;">
                        <i class="fas fa-shopping-cart"></i>
                        Finalizar compra
                    </button>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="vendaRealizada" tabindex="-1" role="dialog" aria-labelledby="vendaRealizada" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">PARABÉNS!! Seu pedido foi realizado com sucesso.</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>O codigo da sua venda é: <span id="codigoVenda"></span></p>
                            <p>Você pode acompanhar o andamento do seu pedido no seu perfil, clicando em "Meus Pedidos".</p>
                        </div>
                        <div class="modal-footer">
                            <form action="../produtos/listagem_produtos" method="POST" name ="deletarUsuario">
                                <button name="index" type="submit" class="btn btn-light">
                                    <i class="fas fa-th-list"></i> Ir a tela principal!
                                </button>
                            </form>
                            <form action="../ti/perfil" method="POST">
                                <button name="perfil" value="${sessionScope.cdFuncionario}" type="submit" class="btn btn-light">
                                    <i class="fas fa-user-tie"></i> Visitar a tela de perfil!
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp"%>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/checkout.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>