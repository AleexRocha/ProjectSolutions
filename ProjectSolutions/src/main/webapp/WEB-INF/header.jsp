<%-- 
    Document   : header
    Created on : 17/10/2019, 20:14:23
    Author     : daniel.mbarbosa1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1 style="text-align: center;">
        <span class="sr-only">Floricultura TADES</span> <img
            src="../assets/img/logo.png">
    </h1>
    <c:choose>
        <c:when test="${sessionScope.nomeSetor == 'Diretor'}">
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul id="itensMenu" class="nav">
                        <li class="nav-item">
                            <form action="../venda/cadastro_vendas">
                                <button type="submit" class="btn nav-link nav-text">Vendas</button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="../produtos/listagem_produtos" method="GET">
                                <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="../ti/listagem_usuarios" method="GET">
                                <button type="submit" class="btn nav-link nav-text">Usuarios</button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="../venda/carrega_relatorio" method="GET">
                                <button type="submit" class="btn nav-link nav-text">Relatorio</button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="../produtos/carrinho.jsp" method="POST">
                                <button type="submit" class="btn nav-link nav-text">Carrinho</button>
                            </form>
                        </li>
                    </ul>
                    <form action="../ti/perfil" method="POST">
                        <button name="perfil" value="${sessionScope.cdFuncionario}" type="submit" class="btn">
                            <i class="fas fa-user-tie"></i>
                            &nbsp;&nbsp; Olá,
                            <c:out value="${nomeUsuario}" />
                        </button>
                    </form>
                    <button type="submit" data-toggle="modal" data-target="#logout" class="btn"> <i class="fas fa-sign-out-alt"></i> Sair</button>
                </div>
            </nav>
        </c:when>
        <c:when test="${sessionScope.nomeSetor == 'Estoquista'}">
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul id="itensMenu" class="nav">
                        <li class="nav-item">
                            <form action="../produtos/listagem_produtos" method="GET">
                                <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                            </form>
                        </li>
                    </ul>
                    <form action="../ti/perfil" method="POST">
                        <button name="perfil" value="${sessionScope.cdFuncionario}" type="submit" class="btn">
                            <i class="fas fa-user-tie"></i>
                            &nbsp;&nbsp; Olá,
                            <c:out value="${nomeUsuario}" />
                        </button>
                    </form>
                    <button type="submit" data-toggle="modal" data-target="#logout" class="btn"> <i class="fas fa-sign-out-alt"></i> Sair</button>
                </div>
            </nav>
        </c:when>
        <c:when test="${sessionScope.nomeSetor == null}">
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul id="itensMenu" class="nav">
                        <li class="nav-item">
                            <form action="../produtos/carrinho.jsp" method="POST">
                                <button type="submit" class="btn nav-link nav-text">Carrinho</button>
                            </form>
                        </li>
                    </ul>
                    <form action="../login/login.jsp">
                        <button type="submit" class="btn">
                            <i class="fas fa-user-tie"></i>
                            Entrar 
                        </button>
                    </form>
                </div>
            </nav>
        </c:when>
        <c:when test="${sessionScope.nomeSetor == ''}">
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul id="itensMenu" class="nav">
                        <li class="nav-item">
                            <form action="../produtos/carrinho.jsp" method="POST">
                                <button type="submit" class="btn nav-link nav-text">Carrinho</button>
                            </form>
                        </li>
                    </ul>
                    <form action="../login/login.jsp">
                        <button type="submit" class="btn">
                            <i class="fas fa-user-tie"></i>
                            Entrar 
                        </button>
                    </form>
                </div>
            </nav>
        </c:when>
        <c:otherwise>
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul id="itensMenu" class="nav">
                        <li class="nav-item">
                            <form action="../produtos/listagem_produtos" method="GET">
                                <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                            </form>
                        </li>
                        <li class="nav-item">
                            <form action="../venda/carrinho" method="POST">
                                <button type="submit" class="btn nav-link nav-text">Carrinho</button>
                            </form>
                        </li>
                    </ul>
                    <form action="../ti/perfil" method="POST">
                        <button name="perfil" value="${sessionScope.cdFuncionario}" type="submit" class="btn">
                            <i class="fas fa-user-tie"></i>
                            &nbsp;&nbsp; Olá,
                            <c:out value="${nomeUsuario}" />
                        </button>
                    </form>
                    <button type="submit" data-toggle="modal" data-target="#logout" class="btn"> <i class="fas fa-sign-out-alt"></i> Sair</button>
                </div>
            </nav>
        </c:otherwise>
    </c:choose>

    <div class="modal fade" id="logout" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">ATENÇÃO!!</h5>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Tem certeza que deseja fazer Logout?</p>
                </div>
                <div class="modal-footer">
                    <form action="../venda/logout" method="POST">
                        <button name="logout" type="submit" class="btn btn-success"> <i class="fas fa-sign-out-alt"></i> Sim </button>
                    </form>
                    <button type="button" class="btn btn-danger" data-dismiss="modal"> <i class="fas fa-ban"></i> Não </button>
                </div>
            </div>
        </div>
    </div>
</header>
