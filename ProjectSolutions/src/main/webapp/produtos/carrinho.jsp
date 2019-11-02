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
                                <th scope="col">Preço</th>
                                <th scope="col">Quantidade</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/encanto_de_rosas_vermelhas.jpg" alt="Encanto de Rosas Vermelhas" />
                                        </div>
                                        <div class="media-body">
                                            <p>Encanto de Rosas Vermelhas</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$77.00</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <span class="input-number-decrement"><i class="fas fa-minus"></i></span>
                                        <input type="number" class="input-carrinho" value="1" min="0" max="10">
                                        <span class="input-number-increment"> <i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$77.00</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_nobile.jpg" alt="Buque Nobile" />
                                        </div>
                                        <div class="media-body">
                                            <p>Buque Nobile</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$178.37</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <span class="input-number-decrement"><i class="fas fa-minus"></i></span>
                                        <input type="number" class="input-carrinho" value="1" min="0" max="10">
                                        <span class="input-number-increment"> <i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$178.37</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_flores_charme_rosas.jpg" alt="Buque de Flores Charme em Rosas" />
                                        </div>
                                        <div class="media-body">
                                            <p>Buque de Flores Charme em Rosas</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$138.90</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <span class="input-number-decrement"><i class="fas fa-minus"></i></span>
                                        <input type="number" class="input-carrinho" value="1" min="0" max="10">
                                        <span class="input-number-increment"> <i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$138.90</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/arranjo_flores_luz_amor.jpg" alt="Arranjo de Flores Luz e Amor" />
                                        </div>
                                        <div class="media-body">
                                            <p>Arranjo de Flores Luz e Amor</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$89.00</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <span class="input-number-decrement"><i class="fas fa-minus"></i></span>
                                        <input type="number" class="input-carrinho" value="1" min="0" max="10">
                                        <span class="input-number-increment"> <i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$89.00</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_garden_flores_campo.jpg" alt="Buque Garden Flores do Campo" />
                                        </div>
                                        <div class="media-body">
                                            <p>Buque Garden Flores do Campo</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$95.00</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <span class="input-number-decrement"><i class="fas fa-minus"></i></span>
                                        <input type="number" class="input-carrinho" value="1" min="0" max="10">
                                        <span class="input-number-increment"> <i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$95.00</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/buquê_flores_tradition_com_18_rosas.jpg" alt="Buque de Flores Tradition com 18 Rosas" />
                                        </div>
                                        <div class="media-body">
                                            <p>Buque de Flores Tradition com 18 Rosas</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$192.90</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <span class="input-number-decrement"><i class="fas fa-minus"></i></span>
                                        <input type="number" class="input-carrinho" value="1" min="0" max="10">
                                        <span class="input-number-increment"> <i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$192.90</h5>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="../assets/img/produtos_teste/cesta_café_com_flores_bom_dia_para_você!.jpg" alt="Cesta de Café com Flores Bom Dia para Você!" />
                                        </div>
                                        <div class="media-body">
                                            <p>Cesta de Café com Flores Bom Dia para Você!</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$213.57</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <span class="input-number-decrement"><i class="fas fa-minus"></i></span>
                                        <input type="number" class="input-carrinho" value="1" min="0" max="10">
                                        <span class="input-number-increment"> <i class="fas fa-plus"></i></span>
                                    </div>
                                </td>
                                <td>
                                    <h5>R$213.57</h5>
                                </td>
                            </tr>

                            <tr>
                                <td></td>
                                <td></td>
                                <td>
                                    <h5>Subtotal</h5>
                                </td>
                                <td>
                                    <h5>R$984.74</h5>
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
                                                <label for="instantaneo">Instantanea R$20.00</label>
                                            </li>
                                            <li>
                                                <input type="radio" id="agendado" name="frete" value="">
                                                <label for="agendado">Agendada: R$15.00</label>
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
                        <button  type="submit" class="btn btn-success btn-block">
                            <i class="fas fa-shopping-cart"></i>
                            Finalizar compra
                        </button>
                    </div>
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp"%>
        </div>  
    </body>
</html>