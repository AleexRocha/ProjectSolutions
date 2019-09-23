<%-- 
    Document   : cliente_listagem_produto
    Created on : 19/09/2019, 19:54:46
    Author     : Guilherme Ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">
                <span class="sr-only">Floricultura TADES</span>
                <img src="../assets/img/logo.png">
            </h1>
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <ul id="itensMenu" class="nav justify-content-center">
                    <li class="nav-item">
                        <form action="../venda/cadastro_vendas" method="GET">
                            <button type="submit" class="btn nav-link nav-text">Vendas</button>
                        </form>                     
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_filiais" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Filiais</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_usuarios" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Usuarios</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../venda/carrega_relatorio" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Relatorio</button>
                        </form>
                    </li>
                </ul>
                <i class="fas fa-user-tie" style="margin-left: -189px;"></i> &nbsp;&nbsp; Olá, <c:out value="${nomeUsuario}"/> 
                <form action="../venda/logout" method="POST">
                    <button type="submit" class="btn nav-link nav-text" >Sair</button>
                </form>
            </nav>
        </header>
                
        <h2 class="h2 text-center subtitulo">Produtos</h2>        
        
        <div class="container">
           <div class="row">
			  <div class="col-lg-1"></div>
		      <div class="col-lg-10">
		        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
		          <ol class="carousel-indicators">
		            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		          </ol>
		          <div class="carousel-inner" role="listbox">
		            <div class="carousel-item active">
		              <img class="d-block img-fluid" src="../assets/img/girassol-slide.jpg" alt="First slide">
		            </div>
		            <div class="carousel-item">
		              <img class="d-block img-fluid" src="../assets/img/flores-rosas-slide.jpg" alt="Second slide">
		            </div>
		            <div class="carousel-item">
		              <img class="d-block img-fluid" src="../assets/img/flores-rosas-vermelhas-slide.jpg" alt="Third slide">
		            </div>
		          </div>
		          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		            <span class="sr-only">Previous</span>
		          </a>
		          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		            <span class="carousel-control-next-icon" aria-hidden="true"></span>
		            <span class="sr-only">Next</span>
		          </a>
		        </div>
		
		        <div class="row">
		
		          <div class="col-lg-4 col-md-6 mb-4">
		            <div class="card h-100">
		              <a href="#"><img class="card-img-top" src="../assets/img/girassol.jpg" alt="Arranjo de Girassol"></a>
		              <div class="card-body">
		                <h4 class="card-title">
		                  <a class="tituloProdutoCliente" href="#"> Girassol</a>
		                </h4>
		                <h5>R$24.99</h5>
		                <p class="card-text">
		                    <button type="button" class="btn btn-outline-success">Comprar</button>
		                    <button type="button" class="btn btn-outline-success">Saiba mais</button>
		              </div>		         
		            </div>
		          </div>
		
		          <div class="col-lg-4 col-md-6 mb-4">
		            <div class="card h-100">
		              <a href="#"><img class="card-img-top" src="../assets/img/flores.jpg" alt=""></a>
		              <div class="card-body">
		                <h4 class="card-title">
		                  <a class="tituloProdutoCliente" href="#"> Flores </a>
		                </h4>
		                <h5>$24.99</h5>
		                <p class="card-text"></p>
		                <button type="button" class="btn btn-outline-success">Comprar</button>
		                <button type="button" class="btn btn-outline-success">Saiba mais</button>
		              </div>
		            </div>
		          </div>
		
		          <div class="col-lg-4 col-md-6 mb-4">
		            <div class="card h-100">
		              <a href="#"><img class="card-img-top" src="../assets/img/rosas-vermelhas.jpg" alt=""></a>
		              <div class="card-body">
		                <h4 class="card-title">
		                  <a class="tituloProdutoCliente" href="#"> Rosas Vermelhas </a>
		                </h4>
		                <h5>$24.99</h5>
		                <p class="card-text"></p>
		                <button type="button" class="btn btn-outline-success">Comprar</button>
		                <button type="button" class="btn btn-outline-success">Saiba mais</button>
		              </div>
		            </div>
		          </div>
		
		        </div>
		        <!-- /.row -->
		
		      </div>
		      <!-- /.col-lg -->
			
			<div class="col-lg-1"></div>
		    </div>
           
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>               
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>
