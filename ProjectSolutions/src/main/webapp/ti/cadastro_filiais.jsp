<%-- 
Document   : cadastro_filiais
Created on : 08/04/2019, 21:40:32
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Filiais</title>
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
            <h2 class="h2 text-center">Cadastrar Filial</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form>
                        <div class="form-group">
                            <label for="codigoFilial">Código:</label>
                            <input type="number" class="form-control" id="codigoFilial" placeholder="Código da filial" name="codigoFilial">

                            <label for="logradouro">Logradouro:</label>
                            <input type="text" class="form-control" id="logradouro" placeholder="Logradouro" name="logradouro">

                            <label for="numero">Número:</label>
                            <input type="number" class="form-control" id="numero" placeholder="Número" name="numero">

                            <label for="cep">CEP:</label>
                            <input type="number" class="form-control" id="cep" placeholder="CEP" name="cep">

                            <label for="bairro">Bairro:</label>
                            <input type="text" class="form-control" id="bairro" placeholder="Bairro" name="bairro">

                            <label for="cidade">Cidade:</label>
                            <input type="texte" class="form-control" id="cidade" placeholder="Cidade" name="cidade">

                            <label for="estado">Estado:</label>
                            <input type="text" class="form-control" id="estado" placeholder="Estado" name="estado">

                            <label for="telefone">Telefone:</label>
                            <input type="number" class="form-control" id="telefone" placeholder="Telefone" name="telefone">
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
