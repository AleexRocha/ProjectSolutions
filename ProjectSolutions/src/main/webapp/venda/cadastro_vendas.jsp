<%-- 
Document   : cadastro_vendas
Created on : 08/04/2019, 21:47:39
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
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
                            <a class="nav-link" href="../produtos/listagem_produtos.jsp">Produtos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../ti/listagem_filiais.jsp">Filiais</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../ti/listagem_usuarios.jsp">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="relatorio.jsp">Relatorio</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <h2 class="h2 text-center subtitulo">Cadastrar uma venda</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form>
                        <div class="form-group">
                            <label for="codigoProduto">Codigo do produto:</label>
                            <input type="number" class="form-control inputForm" id="codigoProduto" placeholder="Código do produto" name="codigoProduto">

                            <label for="nomeProduto">Nome do produto:</label>
                            <input type="text" class="form-control inputForm" id="nomeProduto" placeholder="Nome do produto" name="nomeProduto">

                            <label for="idFuncionario">ID do Funcionario:</label>
                            <input type="number" class="form-control inputForm" id="idFuncionario" placeholder="ID do funcionario" name="idFuncionario">

                            <label for="cpfCliente">CPF do Cliente:</label>
                            <input type="number" class="form-control inputForm" id="cpfCliente" placeholder="CPF do cliente" name="cpfCliente">

                            <label for="codigoFilial">Codigo da filial:</label>
                            <input type="number" class="form-control inputForm" id="codigoFilial" placeholder="Código da filial" name="codigoFilial">

                            <label for="quantidade">Quantidade vendida:</label>
                            <input type="number" class="form-control inputForm" id="quantidade" placeholder="Quantidade" name="quantidade">
                        </div>
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="far fa-save"></i>
                            Salvar venda
                        </button>
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="fas fa-ban"></i>
                            Cancelar
                        </button>                    
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div> <!-- /container -->
    </body>
</html>
