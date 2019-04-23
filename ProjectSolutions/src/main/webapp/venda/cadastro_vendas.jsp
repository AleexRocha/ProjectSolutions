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
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">
                <span class="sr-only">Floricultura TADES</span>
                <img src="../assets/img/logo.png">
            </h1>
            <nav class="navbar navbar-expand-md navbar-light bg-warning">
                <ul class="nav justify-content-center">
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../produtos/listagem_produtos.jsp">Produtos</a>
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_filiais" method="GET">
                            <button type="submit" class="nav-link nav-text" >Filiais</button>
                            <!--<a type="submit" class="nav-link nav-text" >Filiais</a>-->
                        </form>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../ti/listagem_usuarios.jsp">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="relatorio.jsp">Relatorio</a>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Cadastrar uma venda</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form>
                        <div class="form-group">
                                <span id="divProduto">
                                    <label for="codigoProduto">Código do produto:</label>
                                    <a href="javascript:void(0)" id="addInput" style="float: right; text-decoration: none;">
                                        <span><i class="fas fa-plus"></i> Adicionar novo produto </span>
                                    </a>
                                    <input type="number" class="form-control inputForm" id="codigoProduto" placeholder="Código do produto" name="codigoProduto">
                                </span>

                            <label for="idFuncionario">ID do Funcionário:</label>
                            <input type="number" class="form-control inputForm" id="idFuncionario" placeholder="ID do funcionario" name="idFuncionario">

                            <label for="cpfCliente">CPF do cliente:</label>
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
        </div>
        <script>
            $(function () {
                var container = $('#divProduto');

                $(document).on('click', '#addInput', function () {
                    $('<p>' +
                            '<label for="codigoProduto">Código do produto:</label>' +
                            '<a href="javascript:void(0)" id="removerInput" style="float: right;">' +
                            '<span><i class="far fa-trash-alt"></i> Remover produto </span>' +
                            '</a>' +
                            '<input type="number" class="form-control inputForm" id="codigoProduto" placeholder="Código do produto" name="codigoProduto">' +
                            '</p>').appendTo(container);
                    return false;
                });

                $(document).on('click', '#removerInput', function () {
                    $(this).parents('p').remove();
                    return false;
                });
            });
        </script>
    </body>
</html>
