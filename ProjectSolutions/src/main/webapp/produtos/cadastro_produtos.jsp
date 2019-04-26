<%-- 
Document   : cadastro_produtos
Created on : 08/04/2019, 21:44:27
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
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
            <h2 class="h2 text-center subtitulo">Cadastrar Produto</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="cadastro_produto" method="POST">
                        <div class="form-group">
                            <label for="codigoProduto" class="sr-only">Código:</label>
                            <input type="number" class="form-control inputForm sr-only" id="codigoProduto" placeholder="Codigo do produto" name="codigoProduto">

                            <label for="nomeProduto">Nome:</label>
                            <input type="text" class="form-control inputForm" id="nome" placeholder="Nome do produto" name="nome">

                            <label for="descricaoProduto">Descrição:</label>
                            <input type="text" class="form-control inputForm" id="descricao" placeholder="Descrição do produto" name="descricao">

                            <label for="tipo">Tipo:</label>
                            <input type="text" class="form-control inputForm" id="tipo" placeholder="Tipo do produto" name="tipo">
                            
                            <label for="quantidadeEstoque">Quantidade em estoque:</label>
                            <input type="number" class="form-control inputForm" id="quantidadeEstoque" placeholder="Quantidade em estoque" name="quantidadeEstoque">

                            <label for="valorProduto">Valor Unitário:</label>
                            <input type="number" class="form-control inputForm" id="valorUnitario" placeholder="Valor Unitário" name="valorUnitario">

                            <label for="tipo" >Tipo:</label>
                            <select class="custom-select inputForm" id="tipo">
                                <option value="produto">Produto</option>
                                <option value="servico">Serviço</option>
                            </select>

                            <label for="filial" >Filial:</label>
                            <select class="custom-select inputForm" id="filial">
                                <option value="filial 1">Filial 1</option>
                                <option value="filial 2">Filial 2</option>
                                <option value="filial 3">Filial 3</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="far fa-save"></i>
                            Salvar
                        </button>
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="fas fa-ban"></i>
                            Cancelar
                        </button> 
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </body>
</html>
