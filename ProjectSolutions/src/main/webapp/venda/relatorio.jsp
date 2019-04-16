<%-- 
Document   : relatorio
Created on : 08/04/2019, 21:48:45
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório</title>
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
                        <a class="nav-link nav-text" href="cadastro_vendas.jsp">Vendas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../produtos/listagem_produtos.jsp">Produtos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../ti/listagem_filiais.jsp">Filiais</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-text" href="../ti/listagem_usuarios.jsp">Usuarios</a>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Relatório</h2>
        </header>
        <div class="container">
            <div class="row">
                <form action="relatorio">
                    <div class="col-md-3">
                        <label for="filial" >Filial:</label>
                        <select class="custom-select inputForm" id="filial" name="filial">
                            <option value="1">Filial 1</option>
                            <option value="1">Filial 2</option>
                            <option value="1">Filial 3</option>
                        </select>
                    </div>
                    <div class="col-md-5">
                        <div class="form-row">
                            <div class="col">
                                <label for="dataDe">De:</label>
                                <input type="date" class="form-control inputForm" id="dataDe" name="dataDe">
                            </div>
                            <div class="col">
                                <label for="dataAte">Ate:</label>
                                <input type="date" class="form-control inputForm" id="dataAte" name="dataAte">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 btn-relatorio">
                        <button class="btn btn-light">
                            <i class="far fa-file-alt"></i>
                            Gerar relatorio
                        </button>
                        <button class="btn btn-success">
                            <i class="far fa-file-excel"></i>
                            Exportar
                        </button>
                    </div>
                </form>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Código da venda</th>
                                <th scope="col">Nome do produto</th>
                                <th scope="col">Código do produto</th>
                                <th scope="col">Quantidade vendida</th>
                                <th scope="col">Valor total</th>
                                <th scope="col">Nome da filial</th>
                                <th scope="col">ID do funcionario</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>0001</td>
                                <td>Rosa Vermelha do Acre</td>
                                <td>0010</td>
                                <td>100</td>
                                <td>R$ 1000,00</td>
                                <td>São Paulo - SP</td>
                                <td>1234</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div> <!-- row -->
        </div> <!-- container -->
    </div>
</body>
</html>