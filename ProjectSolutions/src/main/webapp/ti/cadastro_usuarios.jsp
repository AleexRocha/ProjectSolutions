<%-- 
Document   : cadastro_usuarios
Created on : 08/04/2019, 21:45:57
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuários</title>
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
                            <a class="nav-link" href="listagem_filiais.jsp">Filiais</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../venda/relatorio.jsp">Relatorio</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <h2 class="h2 text-center">Cadastrar Usuário</h2>
        </header>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form>
                        <div class="form-group">
                            <label for="codigoUsuario">Código:</label>
                            <input type="number" class="form-control" id="codigoUsuario" placeholder="Código do usuário" name="codigoUsuario">

                            <label for="nome">Nome:</label>
                            <input type="text" class="form-control" id="nome" placeholder="Nome" name="nome">

                            <label for="email">E-mail:</label>
                            <input type="emaiç" class="form-control" id="email" placeholder="E-mail" name="email">

                            <label for="senha">Senha:</label>
                            <input type="text" class="form-control" id="senha" placeholder="Senha" name="senha">

                            <label for="confirmarSenha">Confirmar senha:</label>
                            <input type="text" class="form-control" id="confirmarSenha" placeholder="Confirmar senha" name="confirmarSenha">

                            <label for="setor" >Setor:</label>
                            <select class="custom-select" id="setor">
                                <option value="venda">Venda</option>
                                <option value="backoffice">Back Office</option>
                                <option value="ti">TI</option>
                                <option value="global">Gerente Global</option>
                                <option value="regional">Gerente Regional</option>
                                <option value="diretora">Diretoria</option>
                            </select>

                            <label for="tipo" >Filial:</label>
                            <select class="custom-select" id="inputGroupSelect01">
                                <option value="1">Filial 1</option>
                                <option value="1">Filial 2</option>
                                <option value="1">Filial 3</option>
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
