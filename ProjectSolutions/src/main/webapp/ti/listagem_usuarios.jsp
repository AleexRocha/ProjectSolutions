<%-- 
Document   : listagem_usuarios
Created on : 08/04/2019, 21:46:50
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuários</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/navbar-top.css">
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
                    </li><li class="nav-item">
                        <a class="nav-link" href="../produtos/listagem_produtos.jsp">Produtos</a>
                    </li><li class="nav-item">
                        <a class="nav-link" href="listagem_filiais.jsp">Filiais</a>
                    </li><li class="nav-item">
                        <a class="nav-link" href="relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <div class="container">
        <a class="btn btn-light" href="cadastro_usuarios.jsp">Cadastrar Usuário</a>
        <a class="btn btn-light" href="">Excluir Selecionado(s)</a>
        <br>
        <br>
        <table class="table">
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
            <tbody>
                <tr>
                    <td><input type="radio"></td>
                    <td>0000</td>
                    <td>SENAC Santo Amaro</td>
                    <td>teste_teste@email.com</td>
                    <td>1234</td>
                    <td>São Paulo - SP</td>
                    <td>TI</td>
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
    </table>
</body>
</html>
