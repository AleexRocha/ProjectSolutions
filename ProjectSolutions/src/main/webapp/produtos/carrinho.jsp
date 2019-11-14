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
            <div class="cart_inner">
                <div class="table-responsive">
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
                                            <div class="d-flex">
                                                <img src="../assets/img/produtos_teste/encanto_de_rosas_vermelhas.jpg" alt="Encanto de Rosas Vermelhas" />
                                            </div>
                                            <div class="media-body">
                                                <p class="sr-only idProduto">${produto.codigo}</p>
                                                <p class="nomeProduto"><c:out value="${produto.nome}"/></p>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="precoUnitario">
                                        <h5 class="unitario">R$ <c:out value="${produto.valorCarrinho}"/></h5>
                                    </td>
                                    <td class="quantidade">
                                        <div class="product_count">
                                            <span class="altera input-number-decrement" data-posicao="${produto.codigo}" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                            <input type="number" readonly="" class="input-quantidade" data-posicao="${produto.codigo}" value="${produto.quantidadeEstoque}" min="1" max="5">
                                            <span class="altera input-number-increment" data-posicao="${produto.codigo}" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                        </div>
                                    </td>
                                    <td class="precoTotal">
                                        <h5 class="total">R$  <c:out value="${produto.valorTotal}"/></h5>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="checkout_btn_inner float-right">
                        <form action="/produtos/listagem_produtos">
                            <button type="submit" class="btn btn-info btn-block">
                                <i class="fas fa-shopping-cart"></i>
                                Continuar a compra
                            </button>
                        </form>
                        <form action="../venda/carrinho">
                            <button type="submit" class="btn btn-success btn-block" value="1" name="botao" onclick="salvarProdutos();">
                                <i class="fas fa-shopping-cart"></i>
                                Finalizar compra
                            </button>
                        </form>
                        <a href="checkout.jsp">CHECKOUT</a>
                    </div>
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp"%>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/carrinho.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>