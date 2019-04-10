<%-- 
Document   : listagem_filiais
Created on : 08/04/2019, 21:42:40
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="../venda/cadastro_vendas.jsp">Vendas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../produtos/listagem_produtos.jsp">Produtos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="listagem_usuarios.jsp">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../venda/relatorio.jsp">Relatorio</a>
                        </li>
                    </ul>
                </div>
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
                <tbody>
                    <tr>
                        <td><input type="radio"></td>
                        <td>0001</td>
                        <td>Rua Felipe Stevaux</td>
                        <td>8000</td>
                        <td>01000-999</td>
                        <td>Jd. Angela</td>
                        <td>São Paulo</td>
                        <td>SP</td>
                        <td>(11)0419-4015</td>
                        <td class="btn-group">
                            <button type="button" class="btn btn-success">
                                <i class="fas fa-pen"></i>
                            </button>
                            <button type="button" class="btn btn-danger">
                                <i class="far fa-trash-alt"></i>
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
