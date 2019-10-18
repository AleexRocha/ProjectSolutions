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
                <ul id="itensMenu" class="nav justify-content-center">
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
                </ul>
                <i class="fas fa-user-tie" style="margin-left: -189px;"></i>
                &nbsp;&nbsp; Olá,
                <c:out value="${nomeUsuario}" />
                <form action="../venda/logout" method="POST">
                    <button type="submit" class="btn nav-link nav-text">Sair</button>
                </form>
            </nav>
        </c:when>
            <c:when test="${sessionScope.nomeSetor == 'Estoquista'}">
                <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                    <ul id="itensMenu" class="nav justify-content-center">
                        <li class="nav-item">
                            <form action="../produtos/listagem_produtos" method="GET">
                                <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                            </form>
                        </li>
                    </ul>
                    <i class="fas fa-user-tie" style="margin-left: -189px;"></i>
                    &nbsp;&nbsp; Olá,
                    <c:out value="${nomeUsuario}" />
                    <form action="../venda/logout" method="POST">
                        <button type="submit" class="btn nav-link nav-text">Sair</button>
                    </form>
                </nav>
            </c:when>
            <c:otherwise>
                <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                    <ul id="itensMenu" class="nav justify-content-center">
                        <li class="nav-item">
                            <form action="../produtos/listagem_produtos" method="GET">
                                <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                            </form>
                        </li>
                    </ul>
                    <i class="fas fa-user-tie" style="margin-left: -189px;"></i>
                    &nbsp;&nbsp; Olá,
                    <c:out value="${nomeUsuario}" />
                    <form action="../venda/logout" method="POST">
                        <button type="submit" class="btn nav-link nav-text">Sair</button>
                    </form>
                </nav>
            </c:otherwise>
    </c:choose>
</header>