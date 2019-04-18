<%-- 
Document   : listagem_filiais
Created on : 08/04/2019, 21:42:40
Author     : nicolas.hgyoshioka
--%>
<%@page import="Model.Filial"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Filiais</title>
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
                        <a class="nav-link nav-text" href="listagem_usuarios.jsp">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../venda/relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Filiais</h2>
        </header>
        <div class="container">
            <a class="btn btn-light" href="cadastro_filiais.jsp">
                <i class="far fa-building"></i>
                Cadastrar filial
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
                        <th scope="col">Logradouro</th>
                        <th scope="col">Numero</th>
                        <th scope="col">Cep</th>
                        <th scope="col">Bairro</th>
                        <th scope="col">Cidade</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Telefone</th>
                        <th scope="col">Acoes</th>
                    </tr>
                </thead>    
                <script>
                    window.onload = carregaFiliais();
                    function carregaFiliais() {
                        var xhttp = new XMLHttpRequest();
                        xhttp.open("GET", "listagem_filiais", false);
                        xhttp.send();
                        if (xhttp.status === 200) {
                            var response = xhttp.responseText;
                            document.write(result);

                        } else {
                            alert('errow');
                        }
                    }


                </script>
                <c:forEach var="filiais" items="${lista}">
                    <tbody id="teste">                  

                        <tr>
                            <td><input type="radio"></td>
                            <td><c:out value="${filiais.codigo}" /></td>
                            <td><c:out value="${filiais.logradouro}" /></td>
                            <td><c:out value="${filiais.numero}" /></td>
                            <td><c:out value="${filiais.cep}" /></td>
                            <td><c:out value="${filiais.bairro}" /></td>
                            <td><c:out value="${filiais.estado}" /></td>
                            <td><c:out value="${filiais.cidade}" /></td>
                            <td><c:out value="${filiais.telefone}" /></td>        
                            <td class="btn-group">
                                <button type="button" class="btn btn-success">
                                    <a href="cadastro_filiais.jsp">
                                        <i class="fas fa-pen"></i>
                                    </a>
                                </button>
                                <button type="button" class="btn btn-danger">
                                    <i class="far fa-trash-alt"></i>
                                </button>
                            </td>
                        </tr>

                    </tbody>    
                </c:forEach>
            </table>
        </div>

    </body>
</html>
