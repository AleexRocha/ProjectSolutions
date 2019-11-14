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
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/encanto_de_rosas_vermelhas.jpg" alt="Encanto de Rosas Vermelhas" />
                                        </div>
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
                                        <span class="altera input-number-decrement" data-posicao="1" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                        <input type="number" readonly="" class="input-quantidade" value="1" min="1" max="5">
                                        <span class="altera input-number-increment" data-posicao="1" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$  77.00</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_nobile.jpg" alt="Buque Nobile" />
                                        </div>
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
                                        <span class="altera input-number-decrement" data-posicao="2" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                        <input type="number" readonly="" class="input-quantidade" value="1" min="1" max="5">
                                        <span class="altera input-number-increment" data-posicao="2" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 178.37</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_flores_charme_rosas.jpg" alt="Buque de Flores Charme em Rosas" />
                                        </div>
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
                                        <span class="altera input-number-decrement" data-posicao="3" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                        <input type="number" readonly="" class="input-quantidade" value="1" min="1" max="5">
                                        <span class="altera input-number-increment" data-posicao="3" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 138.90</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/arranjo_flores_luz_amor.jpg" alt="Arranjo de Flores Luz e Amor" />
                                        </div>
                                        <div class="media-body">
                                            <p class="sr-only idProduto">4</p>
                                            <p>Arranjo de Flores Luz e Amor</p>
                                        </div>
                                    </div>
                                </td>
                                <td class="precoUnitario">
                                    <h5 class="unitario">R$ 89.00</h5>
                                </td>
                                <td class="quantidade">
                                    <div class="product_count">
                                        <span class="altera input-number-decrement" data-posicao="4" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                        <input type="number" readonly="" class="input-quantidade" value="1" min="1" max="5">
                                        <span class="altera input-number-increment" data-posicao="4" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 89.00</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_garden_flores_campo.jpg" alt="Buque Garden Flores do Campo" />
                                        </div>
                                        <div class="media-body">
                                            <p class="sr-only idProduto">5</p>
                                            <p>Buque Garden Flores do Campo</p>
                                        </div>
                                    </div>
                                </td>
                                <td class="precoUnitario">
                                    <h5 class="unitario">R$ 95.00</h5>
                                </td>
                                <td class="quantidade">
                                    <div class="product_count">
                                        <span class="altera input-number-decrement" data-posicao="5" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                        <input type="number" readonly="" class="input-quantidade" value="1" min="1" max="5">
                                        <span class="altera input-number-increment" data-posicao="5" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 95.00</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_flores_tradition_com_18_rosas.jpg" alt="Buque de Flores Tradition com 18 Rosas" />
                                        </div>
                                        <div class="media-body">
                                            <p class="sr-only idProduto">6</p>
                                            <p>Buque de Flores Tradition com 18 Rosas</p>
                                        </div>
                                    </div>
                                </td>
                                <td class="precoUnitario">
                                    <h5 class="unitario">R$ 192.90</h5>
                                </td>
                                <td class="quantidade">
                                    <div class="product_count">
                                        <span class="altera input-number-decrement" data-posicao="6" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                        <input type="number" readonly="" class="input-quantidade" value="1" min="1" max="5">
                                        <span class="altera input-number-increment" data-posicao="6" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 192.90</h5>
                                </td>
                            </tr>
                            <tr class="carrinho">
                                <td class="produto">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/cesta_café_com_flores_bom_dia_para_você!.jpg" alt="Cesta de Café com Flores Bom Dia para Você!" />
                                        </div>
                                        <div class="media-body">
                                            <p class="sr-only idProduto">7</p>
                                            <p>Cesta de Café com Flores Bom Dia para Você!</p>
                                        </div>
                                    </div>
                                </td>
                                <td class="precoUnitario">
                                    <h5 class="unitario">R$ 213.57</h5>
                                </td>
                                <td class="quantidade">
                                    <div class="product_count">
                                        <span class="altera input-number-decrement" data-posicao="7" onclick="atualizarCarrinho(this)"><i class="fas fa-minus"></i></span>
                                        <input type="number" readonly="" class="input-quantidade" value="1" min="1" max="5">
                                        <span class="altera input-number-increment" data-posicao="7" onclick="atualizarCarrinho(this)"><i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td class="precoTotal">
                                    <h5 class="total">R$ 213.57</h5>
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
                            <tr>
                                <td></td>
                                <td></td>
                                <td>
                                    <h5>Frete</h5>
                                </td>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <div class="shipping_box">
                                        <p> Endereços de entrega: </p>
                                        <select class="custom-select inputForm">
                                            <option value="1">Interlagos</option>
                                            <option value="2">Taboão da Serra</option>
                                            <option value="4">Vila das Belezas</option>
                                        </select>
                                    </div>
                                </td>
                                <td>
                                    <div class="shipping_box">
                                        <ul class="list">
                                            <li>
                                                <input type="radio" id="gratis" name="frete" value="">
                                                <label for="gratis">Frete Grátis</label>
                                            </li>
                                            <li>
                                                <input type="radio" id="instantaneo" name="frete" value="">
                                                <label for="instantaneo">Instantanea R$ 20.00</label>
                                            </li>
                                            <li>
                                                <input type="radio" id="agendado" name="frete" value="">
                                                <label for="agendado">Agendada: R$ 15.00</label>
                                            </li>
                                        </ul>
                                    </div>
                                </td>
                                <td>
                                    <a class="btn btn-light btn-block" href="#">
                                        <i class="fas fa-sync-alt"></i>
                                        Atualizar Detalhes
                                    </a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="checkout_btn_inner float-right">
                        <button  type="submit" class="btn btn-success btn-block" onclick="salvarProdutos();">
                            <i class="fas fa-shopping-cart"></i>
                            Finalizar compra
                        </button>
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