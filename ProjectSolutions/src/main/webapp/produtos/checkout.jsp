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
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="media-body">
                                            <p class="sr-only idProduto">1</p>
                                            <p class="nomeProduto">Encanto de Rosas Vermelhas</p>
                                        </div>
                                    </div>
                                </td>
                                <td class="precoUnitario">
                                    <h5 class="unitario">R$ 77.00</h5>
                                </td>
                                <td class="quantidade">
                                    <div class="product_count">
                                        <input type="number" readonly="readonly" class="input-quantidade" value="1" min="1" max="5">
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$  77.00</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="media-body">
                                            <p class="sr-only idProduto">2</p>
                                            <p>Buque Nobile</p>
                                        </div>
                                    </div>
                                </td>
                                <td class="precoUnitario">
                                    <h5 class="unitario">R$ 178.37</h5>
                                </td>
                                <td class="quantidade">
                                    <div id="product_count">
                                        <input type="number" readonly="readonly" class="input-quantidade" value="1" min="1" max="5">
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 178.37</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="media-body">
                                            <p class="sr-only idProduto">3</p>
                                            <p>Buque de Flores Charme em Rosas</p>
                                        </div>
                                    </div>
                                </td>
                                <td class="precoUnitario">
                                    <h5 class="unitario">R$ 138.90</h5>
                                </td>
                                <td class="quantidade">
                                    <div class="product_count">
                                        <input type="number" readonly="readonly" class="input-quantidade" value="1" min="1" max="5">
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 138.90</h5>
                                </td>
                            </tr>

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
                    <select class="custom-select form-control inputForm">
                        <option selected ="" disabled="" hidden="">Selecione...</option>                               
                        <option value="1"> Cartão de crédito </option>  
                        <option value="2"> Cartão de débito </option>  
                        <option value="2"> Boleto </option>  
                    </select>
                    <!--                    <select class="custom-select form-control inputForm error" id="codigoSetor" name="codigoSetor">
                                            <option selected ="" disabled="" hidden=""><c:out value="${setorErro}"/></option>                               
                    <c:forEach var="setores" items="${listaSetores}">  
                        <option value="<c:out value="${setores.setor}"></c:out>">
                        <c:out value="${setores.nomeSetor}"/> 
                    </option>  
                    </c:forEach>       
                </select>-->
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
                    <select class="custom-select form-control inputForm">
                        <option selected ="" disabled="" hidden="">Selecione...</option>                               
                        <option value="1"> Cartão de crédito </option>  
                        <option value="2"> Cartão de débito </option>  
                        <option value="2"> Boleto </option>  
                    </select>
                    <!--                    <select class="custom-select form-control inputForm error" id="codigoSetor" name="codigoSetor">
                                            <option selected ="" disabled="" hidden=""><c:out value="${setorErro}"/></option>                               
                    <c:forEach var="setores" items="${listaSetores}">  
                        <option value="<c:out value="${setores.setor}"></c:out>">
                        <c:out value="${setores.nomeSetor}"/> 
                    </option>  
                    </c:forEach>       
                </select>-->
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