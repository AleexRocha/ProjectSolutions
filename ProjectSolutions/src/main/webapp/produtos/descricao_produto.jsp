<%-- 
    Document   : descricao_produto
    Created on : 19/09/2019, 21:00:41
    Author     : Nicolas Yoshioka/Guilherme Pereira
    Updated on: 16/10/2019 09:40
    Author: Guilherme Pereira
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Descrição do Produto</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css" />
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css"/>
        <link rel="stylesheet" type="text/css" href="../assets/css/themify-icons.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">
                <span class="sr-only">Floricultura TADES</span>
                <img src="../assets/img/logo.png">
            </h1>
            <nav class="navbar navbar-expand-md navbar-light bg-warning">
                <div class="container">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarsExample08">
                        <ul id="itensMenu" class="navbar-nav justify-content-center">
                            <li class="nav-item">
                                <form action="../produtos/listagem_produtos" method="GET">
                                    <button type="submit" class="btn nav-link nav-text">Produtos</button>
                                </form>
                            </li>
                        </ul>
                        <i class="fas fa-user-tie"></i>
                        <span id="nav-saudacao"> Olá, <c:out value="${nomeUsuario}"/> </span>
                        <form action="../venda/logout" method="POST">
                            <button type="submit" class="btn nav-link nav-text">Sair</button>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
        <div class="container">
        <br>
        <h2 class="text-center subtitulo titulo-produto-descricao"><c:out value="${produto.nome}"/></h2>        
			  <!--================Single Product Area =================-->
			  <div class="product_image_area">
			    <div class="container">
			      <div class="row s_product_inner">
			        <div class="col-lg-5">
			          <div class="product_slider_img">
			            <div id="vertical">
			              <div data-thumb="img/product_details/prodect_details_1.png">
							<%--  <img src="${produto.srcImagem}" /> --%>
							<!-- Web Server for Chrome --> 
							<!-- Adicionar extensão ao chrome que simula um servidor na pasta de imagens / caminho está sendo bloqueado -->
			              	<img src="http://127.0.0.1:8887/${produto.srcImagem}" />
			              </div>
			            </div>
			          </div>
			        </div>
			        <div class="col-lg-5 offset-lg-1">
			          <div class="s_product_text">
			            <h3><c:out value="${produto.nome}"/></h3>
			            <h2>R$<c:out value="${produto.valorUnitario}"/></h2>
			            <ul class="list">
			              <li>
		                	Categoria: <a class="active" href="#"> <c:out value="${produto.tipo}"/> </a>
			              </li>
			            </ul>
			            <p>
			                <c:out value="${produto.descricao}"/>
			            </p>
			            <c:if test="${produto.tipo == 'Produto'}">
			              <div class="product_count d-inline-block">
			                <span class="inumber-decrement"> <i class="ti-minus"></i></span>
			                <input readonly class="input-number" type="text" value="1" min="0" max="10">
			                <span class="number-increment"> <i class="ti-plus"></i></span>
			              </div>
			            </c:if>
			            <div class="card_area">
			              <div class="add_to_cart">
			                  <a href="#" class="btn_3">Adicionar ao Carrinho</a>
			              </div>
			            </div>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			  <!--================End Single Product Area =================-->
			  <hr>
			  <!--================Produto Description Area =================-->
			  <section class="product_description_area" align="center">
			    <div class="container">
			      <ul class="nav nav-tabs" id="myTab" role="tablist">
			        <li class="nav-item">
			          <a class="nav-link active" id="review-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review"
			            aria-selected="false">Perguntas Frequentes</a>
			        </li>
			      </ul>
			      <div class="tab-content" id="myTabContent">
			        <div class="tab-pane fade show active" id="review" role="tabpanel" aria-labelledby="review-tab">
			            <div class="row">
			                <div class="col-lg-2"></div>
			                <div class="col-lg-8">
			                    <div class="row total_rate">
			                        <div class="col-6">
			                        </div>
			                        <div class="col-6">
			                        </div>
			                    </div>
			                    <div class="review_list">
			                        <div class="review_item">
			                            <div class="media">
			                                <div class="d-flex">
			                                    <img src="img/product/single-product/review-1.png" alt="" />
			                                </div>
			                                <div class="media-body">
			                                    <p class="perguntaFaq">Gostaria de saber se tem flores a pronta entrega e se podem ser enviadas com um bilhete para surpresa?</p>
			                                </div>
			                            </div>
			                            <p>
			                                Lorem ipsum dolor sit amet, consectetur adipisicing elit,
			                                sed do eiusmod tempor incididunt ut labore et dolore magna
			                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation
			                                ullamco laboris nisi ut aliquip ex ea commodo
			                            </p>
			                        </div>
			                        <div class="review_item">
			                            <div class="media">
			                                <div class="d-flex">
			                                    <img src="img/product/single-product/review-2.png" alt="" />
			                                </div>
			                                <div class="media-body">
			                                    <p class="perguntaFaq">Gostaria de saber se tem flores a pronta entrega e se podem ser enviadas com um bilhete para surpresa?</p>
			                                </div>
			                            </div>
			                           <p class="respostaFaq">R: Olá! Sim, temos flores para entrega imediata, e assinamos as entregas da forma que desejar, basta nos informar a mensagem.</p>
			                        </div>
			                        <div class="review_item">
			                            <div class="media">
			                                <div class="d-flex">
			                                    <img src="img/product/single-product/review-3.png" alt="" />
			                                </div>
			                                <div class="media-body">
			                                    <p class="perguntaFaq">Gostaria de saber se tem flores a pronta entrega e se podem ser enviadas com um bilhete para surpresa?</p>
			                                </div>
			                            </div>
			                            <p class="respostaFaq">R: Olá! Sim, temos flores para entrega imediata, e assinamos as entregas da forma que desejar, basta nos informar a mensagem.</p>
			                        </div>
			                    </div>
			                </div>
			                <div class="col-lg-2"></div>
			            </div>
			        </div>
			      </div>
			    </div>
			  </section>
            <%@include file="../WEB-INF/footer.jsp"%>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
        
          <script src="../assets/js/popper.min.js"></script>
 		  <script src="../assets/js/jquery.magnific-popup.js"></script>
		  <!-- swiper js -->
		  <script src="../assets/js/lightslider.min.js"></script>
		  <!-- swiper js -->
		  <script src="../assets/js/mixitup.min.js"></script>
		  <script src="../assets/js/lightslider.min.js"></script>
		  <!-- particles js -->
		  <script src="../assets/js/owl.carousel.min.js"></script>
		  <script src="../assets/js/jquery.nice-select.min.js"></script>
		  <!-- slick js -->
		  <script src="../assets/js/slick.min.js"></script>
		  <script src="../assets/js/jquery.counterup.min.js"></script>
		  <script src="../assets/js/waypoints.min.js"></script>
		  <script src="../assets/js/contact.js"></script>
		  <script src="../assets/js/jquery.ajaxchimp.min.js"></script>
		  <script src="../assets/js/jquery.form.js"></script>
		  <script src="../assets/js/jquery.validate.min.js"></script>
		  <script src="../assets/js/mail-script.js"></script>
		  <!-- custom js -->
		  <script src="js/custom.js"></script>
</body>
</html>