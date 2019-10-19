<%-- 
    Document   : perfil
    Created on : 19/10/2019, 16:42:30
    Author     : Alexsander Rocha
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
        <h2 class="h2 text-center subtitulo">Olá, ${nome}</h2>
        <h4 class="h4 text-center subtitulo">Esse são seus dados:</h4>

        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6 col-sm-12">

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

                    <label for="codigoUsuario">Seu código de usuário:</label>
                    <input type="number" class="form-control inputFormPerfil" id="codigoUsuario"
                           placeholder="Código do usuário" value="${codigo}" name="codigoUsuario" disabled="">

                    <label for="nome">Seu nome:</label>
                    <input type="text" class="form-control inputFormPerfil" id="nome"
                           placeholder="Seu Nome" value="${nome}" name="nome" minlength="0" maxlength="75" disabled="">

                    <label for="cpf">Seu CPF:</label>
                    <input type="text" class="form-control inputFormPerfil" id="cpf"
                           placeholder="Seu CPF" value="${cpf}" name="cpf" minlength="0" maxlength="11" disabled="">

                    <label for="email">Seu E-mail:</label>        
                    <input type="email" class="form-control inputFormPerfil" id="email"
                           placeholder="Seu E-mail" value="${email}" name="email" minlength="0" maxlength="50" disabled="">

                    <label for="setor" >Você é um:</label>
                    <input type="text" class="form-control inputFormPerfil" id="setor"
                           placeholder="Setor" value="${nomeSetor}" name="senha" minlength="0" maxlength="25" disabled="">

                    <form action="dados_usuario" method="POST">
                        <button type="submit" name="idUsuario" value="${codigo}" class="btn btn-success btn-block col-12" style="margin-top: 10px;">
                            <i class="fas fa-pen"></i>
                            Edite suas informações
                        </button>
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>
    </body>
</html>
