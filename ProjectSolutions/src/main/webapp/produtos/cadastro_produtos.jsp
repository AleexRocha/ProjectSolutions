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
                            <a class="nav-link" href="../ti/listagem_filiais.jsp">Filiais</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../ti/listagem_usuarios.jsp">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../venda/relatorio.jsp">Relatorio</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <h2 class="h2 text-center">Cadastrar Produto</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form>
                        <div class="form-group">
                            <label for="codigoProduto">Código:</label>
                            <input type="number" class="form-control" id="codigoProduto" placeholder="Codigo do produto" name="codigoProduto">

                            <label for="nomeProduto">Nome:</label>
                            <input type="text" class="form-control" id="nomeProduto" placeholder="Nome do produto" name="nomeProduto">

                            <label for="descricaoProduto">Descrição:</label>
                            <input type="text" class="form-control" id="descricaoProduto" placeholder="Descrição do produto" name="descricaoProduto">

                            <label for="quantidadeEstoque">Quantidade em estoque:</label>
                            <input type="number" class="form-control" id="quantidadeEstoque" placeholder="Quantidade em estoque" name="quantidadeEstoque">

                            <label for="valorProduto">Valor Unitário:</label>
                            <input type="number" class="form-control" id="valorProduto" placeholder="Valor Unitário" name="valorProduto">

                            <label for="tipo" >Tipo:</label>
                            <select class="custom-select" id="tipo">
                                <option value="produto">Produto</option>
                                <option value="servico">Serviço</option>
                            </select>

                            <label for="filial" >Filial:</label>
                            <select class="custom-select" id="filial">
                                <option value="filial 1">Filial 1</option>
                                <option value="filial 2">Filial 2</option>
                                <option value="filial 3">Filial 3</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-light btn-block">Salvar</button>
                        <button type="submit" class="btn btn-light btn-block">Cancelar</button> 
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </body>
</html>
