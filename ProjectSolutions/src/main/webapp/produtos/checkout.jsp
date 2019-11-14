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
            <div class="row">
                <div class="col-6">
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
                                        <h5 class="total">R$  <c:out value="${produto.valorTotal}"/></h5>
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
                                    <h5>R$ 984.74</h5>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-3">
                    <h4 class="h4 text-center subtitulo">Forma de pagamento</h4>
                    <select class="custom-select form-control inputForm" id="pagamento" name="pagamento">
                        <option selected ="" disabled="" hidden="">Selecione um pagamento</option>                               
                        <c:forEach var="pagamento" items="${metodosPagamento}">  
                            <option value="<c:out value="${pagamento.id}"></c:out>">
                                Titular: <c:out value="${pagamento.nomeTitular}"/>
                            </option>  
                        </c:forEach>       
                    </select>
                    <br>
                    <div class="row">
                        <div class="col-12">
                            <div class="card" style="background-color: #f3f3f3 !important;">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <span class="card-title">
                                                <b> Número de Identificação: </b>
                                                <p>****.*****.****.1234</p>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <span class="card-title">
                                                <b> Nome do Titular: </b>
                                                <p>Cliente Sobrenome</p>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <span class="card-title">
                                                <b> Vencimento: </b>
                                                <p>12/2021</p>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <h4 class="h4 text-center subtitulo">Endereço de entrega</h4>
                    <select class="custom-select form-control inputForm" id="endereco" name="endereco">
                        <option selected ="" disabled="" hidden="">Selecione um endereço</option>                               
                        <c:forEach var="enderecos" items="${enderecosEntrega}">  
                            <option value="<c:out value="${enderecos.codigoEndereco}"></c:out>">
                                Logradouro: <c:out value="${enderecos.logradouro}"/> 
                            </option>  
                        </c:forEach>       
                    </select>
                    <div class="row">
                        <div class="col-12">
                            <div class="card" style="background-color: #f3f3f3 !important;">
                                <div class="card-body">
                                    <span class="card-title">
                                        <b> Logradouro / Número:</b>
                                        <p>Rua Felipe Mendes Rodrigues, 79</p>
                                    </span>
                                    <div class="row">
                                        <div class="col">
                                            <span class="card-title">
                                                <b> Complemento </b>
                                                <p>I14</p>
                                            </span>
                                        </div>
                                        <div class="col">
                                            <span class="card-title">
                                                <b> CEP: </b>
                                                <p>06867370</p>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <span class="card-title">
                                                <b> Bairro: </b>
                                                <p>Jardim das Oliveiras</p>
                                            </span>
                                        </div>
                                        <div class="col">
                                            <span class="card-title">
                                                <b> Cidade: </b>
                                                <p>Itapecerica da Serra</p>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <span class="card-title">
                                                <b> Estado: </b>
                                                <p>SP</p>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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