<%-- 
Document   : listagem_usuarios
Created on : 08/04/2019, 21:46:50
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
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
                        <a class="nav-link nav-text" href="../produtos/listagem_produtos.jsp">Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="listagem_filiais.jsp">Filiais</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Usuários</h2>
        </header>
        <div class="container">
            <form  action="formulario_usuarios" method="post">
                <button class="btn btn-light" type="submit">
                    <i class="fas fa-user-plus"></i>
                    Cadastrar Usuário
                </button>
            </form>
<!--            <a class="btn btn-light" href="cadastro_usuarios.jsp"></a>-->
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
                        <th scope="col">Email</th>
                        <th scope="col">Senha</th>
                        <th scope="col">Filial</th>
                        <th scope="col">Setor</th>
                        <th scope="col">Acoes</th>
                    </tr>
                </thead>
                <tbody id="teste">  
                    <c:forEach var="usuarios" items="${listaUsuarios}">                
                        <tr>
                            <td><input type="radio"></td>
                            <td name="codigo" ><c:out value="${usuarios.codigo}" /></td>
                            <td name="nome" ><c:out value="${usuarios.nome}" /></td>
                            <td name="email" ><c:out value="${usuarios.email}" /></td>
                            <td name="senha" ><c:out value="${usuarios.senha}" /></td>
                            <td name="setor" ><c:out value="${usuarios.setor}" /></td>
                            <td name="filial"><c:out value="${usuarios.codigoFilial}" /></td>

                            <td class="btn-group">
                                <form action="dados_usuario" method="POST">

                                    <button name="editarID" value="${usuarios.codigo}" type="submit" class="btn btn-success">
                                        <i class="fas fa-pen"></i>
                                    </button>

                                </form>
                                <form action="excluir_usuario" method="POST">
                                    <button name ="excluirID" value="${usuarios.codigo}" type="submit" class="btn btn-danger">
                                        <i class="far fa-trash-alt"></i>
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
