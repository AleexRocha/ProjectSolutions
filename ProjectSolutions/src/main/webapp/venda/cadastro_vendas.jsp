<%-- 
Document   : cadastro_vendas
Created on : 08/04/2019, 21:47:39
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Vendas</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>
        <h2 class="h2 text-center subtitulo">Cadastrar Venda</h2>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="create_venda" method="post">

                        <c:if test="${varMsgS == true}">
                            <div class="alert alert-success" role="alert">
                                <c:out value="${msg}"/>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>
                        <c:if test="${varMsgE == true}">
                            <div class="alert alert-danger" role="alert">
                                <c:out value="${msg}"/>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:if>

                        <div class="form-group">
                            <span id="divProduto">
                                <label for="codigoProduto">Produto:</label>
<!--                                <a href="javascript:void(0)" id="addInput" style="float: right; text-decoration: none;">
                                    <span><i class="fas fa-plus"></i> Adicionar novo produto </span>
                                </a>-->
                                <c:choose>
                                    <c:when test="${empty codProdutoErro}">
                                        <select class="custom-select inputForm" id="codigoProduto" name="codigoProduto" onchange="setValor()">
                                            <option selected ="" disabled="" hidden="">Produto</option>
                                            <c:forEach var="produto" items="${listaProdutos}" varStatus="id">
                                                <option value="${produto.codigoProduto}">
                                                    <c:out value="${produto.nomeProduto}"/> - R$<c:out value="${produto.valorUnidade}"/>
                                                </option>
                                            </c:forEach>

                                        </select>
                                    </c:when>
                                    <c:otherwise>
                                        <select class="custom-select inputForm error" id="codigoProduto" name="codigoProduto">
                                            <option disabled="" selected="" hidden="">${codProdutoErro}</option>
                                            <c:forEach var="produto" items="${listaProdutos}">
                                                <option value="<c:out value="${produto.codigoProduto}"></c:out>">
                                                    <c:out value="${produto.nomeProduto}"/> - R$<c:out value="${produto.valorUnidade}"/>
                                                    </option>
                                            </c:forEach>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                                <div class="form-row">
                                    <div class="col-12">
                                        <label for="quantidade">Quantidade:</label>
                                        <c:choose>
                                            <c:when test="${empty quantidadeErro}">
                                                <input type="number" class="form-control inputForm" id="quantidade"
                                                       placeholder="Quantidade" name="quantidade" min="1" onchange="setValor2()">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="number" class="form-control inputForm error" id="quantidade"
                                                       placeholder="${quantidadeErro}" name="quantidade" min="0">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
<!--                                    <div class="col-6">
                                        <label for="valor">Valor:</label>
                                        <c:choose>
                                            <c:when test="${empty quantidadeErro}">
                                                <input type="text" class="form-control inputForm" id="valor"
                                                       placeholder="Valor do Produto" name="valor" min="0">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="valor"
                                                       placeholder="${valorErro}" name="valor" min="0">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>-->
                                </div>
                            </span>

                            <label for="idFuncionario">Funcionário:</label>
                            <c:choose>
                                <c:when test="${empty idFuncErro}">
                                    <select class="custom-select inputForm" id="codigoProduto" name="idFuncionario">
                                        <option hidden="" value="${cdFuncionario}"><c:out value="${nomeUsuario}"/></option>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="custom-select inputForm error" id="codigoProduto" name="idFuncionario">
                                        <option hidden="" value="${cdFuncionario}"><c:out value="${nomeUsuario}"/></option>
                                    </select>
                                </c:otherwise>
                            </c:choose>

                            <label for="cpfCliente">CPF do cliente:</label>
                            <input type="text" class="form-control inputForm" id="cpfCliente"
                                   placeholder="CPF do cliente" name="cpfCliente" min="0" minlength="0" maxlength="11">

                            <label for="valorTotal">Valor Total:</label>
                            <c:choose>
                                <c:when test="${empty quantidadeErro}">
                                    <input type="text" class="form-control inputForm" id="valorTotal"
                                           placeholder="Valor Total" name="valorTotal" min="0">
                                </c:when>               
                            </c:choose>

                        </div>
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="far fa-save"></i>
                            Salvar venda
                        </button>
                        <button type="reset" class="btn btn-light btn-block">
                            <i class="fas fa-ban"></i>
                            Cancelar
                        </button>
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
           <%@include file="../WEB-INF/footer.jsp" %>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/jquery.mask.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
        <script>
            function setValor() {
                document.getElementById("quantidade").value = 1;
                document.getElementById("valor").value = null;
            }
            function setValor2() {
                var valor = document.getElementById("valor").value.toString().replace(",", ".");
                var split = valor.split("$");
                var qtd = document.getElementById("quantidade").value;

                var totalUnitario = document.getElementById("valor").value = qtd * split[1];
                document.getElementById("valorTotal").value = "R$" + totalUnitario;
                document.getElementById("valor").value =  "R$" + totalUnitario;;
            }
        </script>
    </body>
</html>
