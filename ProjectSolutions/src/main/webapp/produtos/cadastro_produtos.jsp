<%-- 
Document   : cadastro_produtos
Created on : 08/04/2019, 21:44:27
Author     : nicolas.hgyoshioka
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Cadastro de Produtos</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>

        <c:if test="${acao == 'editar'}"> 
            <h2 class="h2 text-center subtitulo">Editar Produto</h2>
        </c:if>
        <c:if test="${empty acao}"> 
            <h2 class="h2 text-center subtitulo">Cadastrar Produto</h2>
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
                    <c:if test="${varMsgError == true}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${msg}"/>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                </div>
                <div class="col-md-6">
                    <form action="upload" method="POST" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-md-8">
                                <label for="inputImagemProduto">Imagem do produto:</label>
                                <input <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> disabled=""</c:if> type="file" class="form-control-file inputForm" id="inputImagemProduto" name="imagemProduto" onchange="preview();"/>
                                </div>
                                <div class="col-md-4 btn-upload">
                                    <button <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> disabled=""</c:if> type="submit" class="btn btn-block btn-success" id="upload-button" onclick="salvarImagem();">
                                        <i class="far fa-save"></i>
                                        Salvar Imagem
                                    </button>
                                </div>
                            </div>
                            <p class="text-center subtitulo">
                                <span class="h4">Preview da Imagem</span>
                            <p class="text-center">
                                <img src="" id="preview-image" class="sr-only" alt="Imagem do Produto" width="380">                        
                            </p>
                            </p>
                        </form>
                    </div>
                    <div class="col-md-6">
                    <c:choose>
                        <c:when test="${acao == 'editar'}">
                            <form action="editar_produto" method="POST">
                            </c:when>
                            <c:otherwise>
                                <form action="cadastro_produto" method="POST">
                                </c:otherwise>
                            </c:choose>
                            <div class="form-group">
                                <label for="codigoProduto" class="sr-only">Código:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <input type="number" class="form-control inputForm sr-only" id="codigoProduto"
                                               value="${codigo}" name="codigoProduto">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="number" class="form-control inputForm sr-only" id="codigoProduto"
                                               placeholder="Codigo do produto" name="codigoProduto">
                                    </c:otherwise>
                                </c:choose>

                                <c:if test="${not empty listaImagens}">
                                    <label for="codigoImagem" class="sr-only">Código da imagem:</label>
                                    <input type="number" class="form-control inputForm sr-only" id="codigoImagem" 
                                           value="${id}" name="codigoImagem">
                                </c:if>

                                <label for="nomeProduto">Nome:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:if test="${empty nomeErro}">
                                            <input type="text" class="form-control inputForm" id="nome"
                                                   value="${nome}" name="nome" minlength="0" maxlength="50"
                                                   <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> readonly </c:if>>
                                        </c:if>
                                        <c:if test="${not empty nomeErro}">         
                                            <input type="text" class="form-control inputForm error" id="nome"
                                                   placeholder="${nomeErro}" name="nome" minlength="0" maxlength="50">                                  
                                        </c:if>    
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${empty nomeErro}">
                                            <input type="text" class="form-control inputForm" id="nome" value="${nome}"
                                                   placeholder="Nome do produto" name="nome" minlength="0" maxlength="50">
                                        </c:if>
                                        <c:if test="${not empty nomeErro}">         
                                            <input type="text" class="form-control inputForm error" id="nome"
                                                   placeholder="${nomeErro}" name="nome" minlength="0" maxlength="50">                                  
                                        </c:if>    
                                    </c:otherwise> 
                                </c:choose>

                                <label for="descricaoProduto">Descrição:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:if test="${empty descricaoErro}">
                                            <input type="text" class="form-control inputForm" id="descricao"
                                                   value="${descricao}" name="descricao" minlength="0" maxlength="500"
                                                   <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> readonly</c:if>    
                                            </c:if>
                                            <c:if test="${not empty descricaoErro}">
                                                <input type="text" class="form-control inputForm error" id="descricao"
                                                name="descricao" minlength="0" maxlength="500" placeholder="${descricaoErro}"
                                                <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> readonly</c:if>    
                                            </c:if>
                                        </c:when>
                                        <c:otherwise>
                                            <c:if test="${empty descricaoErro}"> 
                                                <input type="text" class="form-control inputForm" id="descricao" value="${descricao}" 
                                                placeholder="Descrição do produto" name="descricao" minlength="0" maxlength="500">
                                        </c:if>
                                        <c:if test="${not empty descricaoErro}">
                                            <input type="text" class="form-control inputForm error" id="descricao"
                                                   placeholder="${descricaoErro}" name="descricao" minlength="0" maxlength="500">
                                        </c:if>
                                    </c:otherwise>
                                </c:choose>

                                <label for="quantidadeEstoque">Quantidade em estoque:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:if test="${empty quantidadeEstoqueErro}">
                                            <input type="number" class="form-control inputForm" id="quantidadeEstoque"
                                                   value="${qtd_estoque}" name="quantidadeEstoque" min="0" minlength="0" maxlength="11">
                                        </c:if>
                                        <c:if test="${not empty quantidadeEstoqueErro}">
                                            <input type="number" class="form-control inputForm error" id="quantidadeEstoque"
                                                   placeholder="${quantidadeEstoqueErro}" name="quantidadeEstoque" min="0" minlength="0" maxlength="11">
                                        </c:if>
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${empty quantidadeEstoqueErro}">
                                            <input type="number" class="form-control inputForm" id="quantidadeEstoque" value="${qtd_estoque}"
                                                   placeholder="Quantidade em estoque" name="quantidadeEstoque" min="0" minlength="0" maxlength="11">
                                        </c:if>
                                        <c:if test="${not empty quantidadeEstoqueErro}">        
                                            <input type="number" class="form-control inputForm error" id="quantidadeEstoque"
                                                   placeholder="${quantidadeEstoqueErro}" name="quantidadeEstoque" min="0" minlength="0" maxlength="11">
                                        </c:if> 
                                    </c:otherwise>
                                </c:choose>

                                <label for="valor">Valor Unitário:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:if test="${empty valorUnitarioErro}">
                                            <input type="text" class="form-control money inputForm" id="valor"
                                                   value="${valor_unidade}" name="valorUnitario" minlength="0" maxlength="9"
                                                   <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> readonly </c:if>>
                                        </c:if>
                                        <c:if test="${not empty valorUnitarioErro}">         
                                            <input type="text" class="form-control money inputForm error" id="valor"
                                                   placeholder="${valorUnitarioErro}" name="valorUnitario" minlength="0" maxlength="9">
                                        </c:if> 
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${empty valorUnitarioErro}">
                                            <input type="text" class="form-control money inputForm" id="valor" value="${valor_unidade}"
                                                   placeholder="Valor Unitário" name="valorUnitario" minlength="0" maxlength="9">
                                        </c:if>
                                        <c:if test="${not empty valorUnitarioErro}">         
                                            <input type="text" class="form-control money inputForm error" id="valor"
                                                   placeholder="${valorUnitarioErro}" name="valorUnitario" minlength="0" maxlength="9">
                                        </c:if> 
                                    </c:otherwise>
                                </c:choose>                               

                                <label <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> hidden="" </c:if> for="tipo" >Tipo:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <select <c:if test="${sessionScope.nomeSetor == 'Estoquista'}"> hidden="" </c:if> class="custom-select inputForm" id="tipo" name="tipo">
                                            <option hidden="" value="${tipoCadastrado}">${tipoCadastrado}</option>
                                            <option value="Produto">Produto</option>
                                            <option value="Serviço">Serviço</option>
                                        </select>
                                    </c:when>
                                    <c:otherwise>
                                        <select class="custom-select inputForm" id="tipo" name="tipo">
                                            <option disabled="" selected="" hidden="">Tipo do produto</option>
                                            <option value="Produto">Produto</option>
                                            <option value="Serviço">Serviço</option>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <button type="submit" class="btn btn-light btn-block">
                                <i class="far fa-save"></i>
                                Salvar
                            </button>
                        </form>
                        <form action="listagem_produtos" method="GET" style="padding-top: 8px; ">
                            <button type="submit" class="btn btn-light btn-block">
                                <i class="fas fa-ban"></i>
                                Cancelar
                            </button>
                        </form>
                </div>
                <%@include file="../WEB-INF/footer.jsp" %>
            </div>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>    
    </body>
</html>
