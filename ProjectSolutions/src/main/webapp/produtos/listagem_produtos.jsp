<%-- 
   Document   : listagem_produtos
   Created on : 08/04/2019, 21:45:31
   Author     : nicolas.hgyoshioka
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/navbar-top.css">
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
                <ul class="nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/cadastro_vendas.jsp">Vendas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../ti/listagem_filiais.jsp">Filiais</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../ti/listagem_usuarios.jsp">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Produtos</h2>
        </header>
        <div class="container">
            <a href="cadastro_produtos.jsp" class="btn btn-light">
                <i class="fas fa-box"></i>
                Cadastrar Produto
            </a>
            <a class="btn btn-danger" href="">
                <i class="far fa-trash-alt"></i>
                Excluir Selecionado(s)
            </a>
            <br>
            <br>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th><input type="radio"></th>
                        <th scope="col">Codigo</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descricao</th>
                        <th scope="col">Tipo</th>
                        <th scope="col">Filial</th>
                        <th scope="col">Estoque</th>
                        <th scope="col">Valor unidade</th>
                        <th scope="col">Acoes</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach var = "produtos"  items="${lista}">
                            <td><input type="radio"></td>
                            <td name="codigo"><c:out value ="${produtos.codigo}"/></td>
                            <td name="nome"><c:out value ="${produtos.nome}"/></td>
                            <td name="descricao"><c:out value ="${produtos.descrico}"/></td>
                            <td name="tipo"><c:out value ="${produtos.tipo}"/></td>
                            <td name="codigoFilialint"><c:out value ="${produtos.codigoFilialint}"/></td>
                            <td name="quantidadeEstoque"><c:out value ="${produtos.quantidadeEstoque}"/></td>
                            <td name="valorUnitario"><c:out value ="${produtos.valorUnitario}"/></td>

                            <td class="btn-group">
                                <form action="dados_produto" method="POST">
                                    <button name="editarID" value="${filiais.codigo}" type="submit" class="btn btn-success">
                                        <i class="fas fa-pen"></i>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>