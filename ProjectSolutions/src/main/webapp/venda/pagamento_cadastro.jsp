<%-- 
    Document   : pagamento_cadastro
    Created on : 12/11/2019, 16:57:46
    Author     : guilherme.pereira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Perfil do Usuário</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h2 class="h2 text-center subtitulo">Cadastrar Pagamento</h2>
        
                    <form action="pagamento_cadastro" method="POST">
                        <label for="codigoUsuario" class="sr-only">Código Usuário:</label>
                        <input type="number" class="form-control inputForm sr-only" id="codigoUsuario"
                            placeholder="${codigoUsuario}" name="codigoUsuario">

                        <label>Método de Pagamento</label>
                        <select class="custom-select inputForm" id="codigoSetor" name="codigoPagamento">
                            <option selected = "" disabled="" hidden="">Selecionar</option>                             
                            <c:forEach var="pagamentos" items="${pagamentosList}">  
                                <option value="<c:out value="${pagamentos.id}"/>">
                                    <c:out value="${pagamentos.tipoPagamento}"/> 
                                </option>  
                            </c:forEach>       
                        </select>

                        <label for="numeroCartao">Número do Cartão</label>
                        <input type="text" class="form-control inputForm" id="nome"
                            placeholder="Número" name="numeroCartao" minlength="0" maxlength="75">

                        <label for="numeroCartao">Nome Do Titular</label>
                        <input type="text" class="form-control inputForm" id="nome"
                            placeholder="Nome do Titular" name="nomeTitular" minlength="0" maxlength="75">
                        
                        <label for="numeroCartao">Data de Vencimento</label>
                        <input type="text" class="form-control inputForm" id="nome"
                            placeholder="Vencimento" name="dataVencimento" minlength="0" maxlength="75">
                        
                        <label for="numeroCartao">Código de Segurança</label>
                        <input type="text" class="form-control inputForm" id="nome"
                            placeholder="CCV" name="codigoSeguranca" minlength="0" maxlength="75">
                        
                        <button type="submit" class="btn btn-light btn-block">
                            <i class="far fa-save"></i>
                            Salvar
                        </button>
                    </form>
                    <form action="#" method="GET">
                        <button name="perfil" type="submit" class="btn btn-light btn-block" value="${sessionScope.cdFuncionario}">
                            <i class="fas fa-ban"></i>
                            Cancelar
                        </button>
                    </form> 
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <%@include file="../WEB-INF/footer.jsp" %>
    </body>
</html>
