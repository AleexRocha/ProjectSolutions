<%-- 
Document   : relatorio
Created on : 08/04/2019, 21:48:45
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Relatório</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="gerar_relatorio" method="get">
                        <div class="form-row">
                            <div class="col-md-3">
                            </div>
                            <div class="form-row col-md-5">
                                <div class="col-md-6">
                                    <label for="dataDe">De:</label>
                                    <input type="date" class="form-control inputForm" id="dataDe" name="dataDe">
                                </div>
                                <div class="col-md-6">
                                    <label for="dataAte">Ate:</label>
                                    <input type="date" class="form-control inputForm" id="dataAte" name="dataAte">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <!--<button class="btn btn-light" style="margin: 32px 176px 0 0; float: right">-->
                                <button class="btn btn-light" style="margin: 32px 217px 0 0; float: right">
                                    <i class="far fa-file-alt"></i>
                                    Gerar relatorio
                                </button>
                            </div>
                        </div>
                    </form>
                    <!--                    <div class="col-md-12">
                                            <form action="gerar_excel" method="get" style="float: right; margin:-39px -15px 0 0;">
                                                <button class="btn btn-success">
                                                    <i class="far fa-file-excel"></i>
                                                    Exportar Para Excel
                                                </button>
                                            </form>
                                        </div>-->
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <hr>
                    <table class="table table-striped">
                        <thead class="coluna" >
                            <tr>
                                <th scope="col" style="width: 1px">Código da venda</th>
                                <th scope="col">Nome do produto</th>
                                <th scope="col" style="width: 1px">Código do produto</th>
                                <th scope="col" style="width: 1px">Quantidade vendida</th>
                                <th scope="col" style="width: 1px">Valor total</th>
                                <th scope="col">CPF do cliente</th>
                                <th scope="col" style="width: 1px">ID do funcionário</th>
                                <th scope="col">Data da venda</th>
                                <th scope="col" style="width: 1px">Status</th>
                            </tr>
                        </thead>
                        <tbody class="coluna" >
                            <c:forEach var="relatorio" items="${listaRelatorios}">
                                <tr>
                                    <td name="codigoVenda" ><c:out value="${relatorio.codigoVenda}" /></td>
                                    <td name="nomeProduto" ><c:out value="${relatorio.nomeProduto}" /></td>
                                    <td name="codigoProduto" ><c:out value="${relatorio.codigoProduto}" /></td>
                                    <td name="quantidadeProduto" ><c:out value="${relatorio.quantidadeProduto}" /></td>
                                    <td name="valorTotal" ><c:out value="${relatorio.valorTotal}" /></td>
                                    <td name="cpfCliente" ><c:out value="${relatorio.cpfCliente}" /></td>
                                    <td name="idUsuario" ><c:out value="${relatorio.idUsuario}" /></td>   
                                    <td name="dataVenda" ><c:out value="${relatorio.dataVenda}" /></td>   
                                    <c:choose>
                                        <c:when test="${relatorio.status == 0}">
                                            <td name="dataVenda" >Ativa</td>  
                                        </c:when>
                                        <c:otherwise>
                                            <td name="dataVenda" >Estornada</td>  
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>
    </body>
</html>