<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Imagem do Produto</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
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
                <ul id="itensMenu" class="nav justify-content-center">
                    <li class="nav-item">
                        <form action="../venda/cadastro_vendas" method="GET">
                            <button type="submit" class="btn nav-link nav-text">Vendas</button>
                        </form>                     
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_usuarios" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Usuarios</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../venda/carrega_relatorio" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Relatorio</button>
                        </form>
                    </li>
                </ul>
                <i class="fas fa-user-tie" style="margin-left: -189px;"></i> &nbsp;&nbsp; Olá, <c:out value="${nomeUsuario}"/> 
                <form action="../venda/logout" method="POST">
                    <button type="submit" class="btn nav-link nav-text" >Sair</button>
                </form>
            </nav>
        </header>

        <c:if test="${acao == 'editar'}"> 
            <h2 class="h2 text-center subtitulo">Editar Imagem do Produto</h2>
        </c:if>
        <c:if test="${empty acao}"> 
            <h2 class="h2 text-center subtitulo">Cadastrar Imagem do Produto</h2>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <c:if test="${varMsg == true}">
                        <div class="alert alert-success" role="alert">
                            <c:out value="${msg}"/>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <form id="upload-form" class="upload-box" action="upload" method="POST" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-8">
                                <label for="imagemProduto">Imagem do produto:</label>
                                <input type="file" class="form-control-file inputForm" id="file" name="file1" onchange="preview();"/>
                            </div>
                            <div class="col-md-4">
                                <button type="submit" class="btn btn-success" id="upload-button" style="margin-top: 24px;" onclick="salvarImagem();">
                                    <i class="far fa-save"></i>
                                    Salvar Imagem
                                </button>
                            </div>
                        </div>
                    </form>
                    <p class="text-center subtitulo">
                        <span class="h4">Preview da Imagem</span>
                        <p class="text-center">
                            <img src="" id="preview-image" class="sr-only" alt="Imagem do Produto" width="380">                        
                        </p>
                    </p>
                </div>
                <div class="col-md-6">
                    <label for="codigoProduto">Código:</label>
                    <input type="number" class="form-control inputForm" id="codigoProduto"
                           value="${listaProdutos.codigo}" name="codigoProduto" readonly="readonly">

                    <label for="nomeProduto">Nome:</label>
                    <input type="text" class="form-control inputForm" id="nome"
                           value="${listaProdutos.nome}" name="nome" readonly="readonly">                                            


                    <label for="descricaoProduto">Descrição:</label>
                    <input type="text" class="form-control inputForm" id="descricao"
                           value="${listaProdutos.descricao}" name="descricao" readonly="readonly">

                    <label for="quantidadeEstoque">Quantidade em estoque:</label>
                    <input type="number" class="form-control inputForm" id="quantidadeEstoque"
                           value="${listaProdutos.quantidadeEstoque}" name="quantidadeEstoque" readonly="readonly">

                    <label for="valor">Valor Unitário:</label>
                    <input type="text" class="form-control inputForm" id="valor"
                           value="${listaProdutos.valorUnitario}" name="valorUnitario" readonly="readonly">

                    <label for="tipo" >Tipo:</label>
                    <input type="text" class="form-control inputForm" id="valor"
                           value="${listaProdutos.tipo}" name="valorUnitario" readonly="readonly">
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>

</body>
</html>
