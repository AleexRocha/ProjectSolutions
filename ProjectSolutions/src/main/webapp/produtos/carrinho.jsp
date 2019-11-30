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
        <h2 class="h2 text-center subtitulo">Carrinho</h2>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <c:if test="${varMsg == true}">
                        <div class="alert alert-success" role="alert">
                            <c:out value="${msg}"/>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    <c:if test="${varMsgError == true}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${msg}"/>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="cart_inner">
                <div class="table-responsive">
                    <table class="table">
                        <c:choose>
                            <c:when test="${varMsgTabela == true}">
                                <thead>
                                    <tr>
                                        <th>
                                            <div class="alert" role="alert">
                                                <c:out value="${msg}"/>
                                            </div>
                                        </th>
                                    </tr>
                                </thead>
                            </c:when>
                            <c:otherwise>
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
                                                    <div class="d-flex">
                                                        <img class="card-img-top imgCardView" src="../assets/uploads/images/<c:out value="${produto.nomeImagem}"/>"
                                                             alt="<c:out value="${produto.nome}"/>" style="width: 150px; height: 150px">
                                                    </div>
                                                    <div class="media-body">
                                                        <p class="sr-only idProduto">${produto.codigo}</p>
                                                        <p class="nomeProduto"><c:out value="${produto.nome}"/></p>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="precoUnitario">
                                                <h5 class="unitario money">R$ <c:out value="${produto.valorCarrinho}"/></h5>
                                            </td>
                                            <td class="quantidade">
                                                <div class="product_count">
                                                    <span class="altera input-number-decrement" data-posicao="${produto.idCarrinho}" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                                    <input type="number" readonly="" class="input-quantidade" data-posicao="${produto.codigo}" value="${produto.quantidadeEstoque}" min="1" max="5">
                                                    <span class="altera input-number-increment" data-posicao="${produto.idCarrinho}" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                                    <form action="../produtos/carrinho_produtos" method="POST">
                                                        <button class="btn btn-remover-carrinho" name="idRemover" value="${produto.codigo}"><i class="fas fa-times"></i> Remover do carrinho</button>
                                                    </form>
                                                </div>
                                            </td>
                                            <td class="precoTotal">
                                                <h5 class="total money">R$  <c:out value="${produto.valorTotal}"/></h5>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${varMsgEndereco == true}">
                                            <tr>
                                                <th></th>
                                                <th>
                                                    <div class="alert" role="alert">
                                                        <c:out value="${msg}"/>
                                                    </div>
                                                </th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td>
                                                    <label>Frete:</label>
                                                    <select class="custom-select form-control inputForm" id="endereco" name="endereco">
                                                        <option selected ="" disabled="" hidden="">Selecione um endereço</option>                               
                                                        <c:forEach var="enderecos" items="${enderecosEntrega}">  
                                                            <option value="<c:out value="${enderecos.codigoEndereco}"></c:out>">
                                                                CEP:  <c:out value="${enderecos.cep}"/> / Logradouro: <c:out value="${enderecos.logradouro}"/>, <c:out value="${enderecos.numero}"/>
                                                            </option>  
                                                        </c:forEach>       
                                                    </select></td>
                                                <td class="precoTotal"></td>
                                                <td id="valores"></td>
                                                <td></td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td>Sub Total:</td>
                                        <td class="precoTotal">
                                            <h5 class="subtotal money"> <c:out value="${subtotal}"></c:out> </h5>
                                            </td>
                                        </tr>
                                    </tbody>
                            </c:otherwise>
                        </c:choose>
                    </table>
                    <div class="checkout_btn_inner float-right">
                        <form action="../produtos/listagem_produtos">
                            <button type="submit" class="btn btn-light btn-block">
                                <i class="fas fa-shopping-cart"></i>
                                Continuar comprando
                            </button>
                        </form>
                        <br>
                        <c:if test="${varMsgTabela == false}">
                            <form action="../venda/carrinho">
                                <button type="submit" class="btn btn-success btn-block" value="checkout" name="checkout">
                                    <i class="fas fa-shopping-cart"></i>
                                    Finalizar compra
                                </button>
                            </form>
                            <br>
                        </c:if>
                    </div>
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp"%>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/footable.min.js"></script>
        <script src="../assets/js/carrinho.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>
