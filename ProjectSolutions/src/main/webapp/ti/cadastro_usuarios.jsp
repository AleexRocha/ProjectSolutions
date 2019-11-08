<%-- 
Document   : cadastro_usuarios
Created on : 08/04/2019, 21:45:57
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Cadastro de Usuários</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>

        <c:if test="${acao == 'editar'}">
            <h2 class="h2 text-center subtitulo">Editar Usuário</h2>
        </c:if>
        <c:if test="${empty acao}">
            <h2 class="h2 text-center subtitulo">Cadastrar Usuário</h2>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <c:choose>
                        <c:when test="${acao == 'editar'}">
                            <form action="editar_usuario" method="post">
                            </c:when>
                            <c:otherwise>
                                <form action="create_usuario" method="post">
                                </c:otherwise>
                            </c:choose>

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

                            <div class="form-group">
                                <label for="codigoUsuario" class="sr-only">Código:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <input type="number" class="form-control inputForm sr-only" id="codigoUsuario"
                                               value="${codigo}" name="codigoUsuario">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="number" class="form-control inputForm sr-only" id="codigoUsuario"
                                               placeholder="Código do usuário" name="codigoUsuario">
                                    </c:otherwise>
                                </c:choose>

                                <label for="nome">Nome:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty nomeErro}">
                                                <input type="text" class="form-control inputForm" id="nome"
                                                       value="${nome}" name="nome" minlength="0" maxlength="75">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="nome"
                                                       placeholder="${nomeErro}" name="nome" minlength="0" maxlength="75">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty nomeErro}">
                                                <input type="text" class="form-control inputForm" id="nome" value="${nome}"
                                                       placeholder="Nome" name="nome" minlength="0" maxlength="75">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="nome"
                                                       placeholder="${nomeErro}" name="nome" minlength="0" maxlength="75">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="cpf">CPF:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty cpfErro}">
                                                <input <c:if test="${sessionScope.nomeSetor != 'Diretor'}"> readonly</c:if> type="text" class="form-control inputForm" id="cpf"
                                                                                                           value="${cpf}" name="cpf" minlength="0" maxlength="11">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="cpf"
                                                       placeholder="${cpfErro}" name="nome" minlength="0" maxlength="11">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty cpfErro}">
                                                <input type="text" class="form-control inputForm" id="cpf" value="${cpf}"
                                                       placeholder="CPF" name="cpf" minlength="0" maxlength="11">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="cpf"
                                                       placeholder="${cpfErro}" name="cpf" minlength="0" maxlength="11">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="email">E-mail:</label>        
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty emailErro}">
                                                <input <c:if test="${sessionScope.nomeSetor != 'Diretor'}">readonly </c:if> type="email" class="form-control inputForm" id="email"
                                                                                                           value="${email}" name="email" minlength="0" maxlength="50">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="email" class="form-control inputForm error" id="email"
                                                       placeholder="${emailErro}" name="email" minlength="0" maxlength="50">
                                            </c:otherwise>
                                        </c:choose>   
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty emailErro}">
                                                <input type="email" class="form-control inputForm" id="email" value="${email}"
                                                       placeholder="E-mail" name="email" minlength="0" maxlength="50">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="email" class="form-control inputForm error" id="email"
                                                       placeholder="${emailErro}" name="email" minlength="0" maxlength="50">
                                            </c:otherwise>
                                        </c:choose>   
                                    </c:otherwise>
                                </c:choose>

                                <label for="senha">Senha:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty senhaErro}">
                                                <input type="password" class="form-control inputForm" id="senha"
                                                       placeholder="Senha" name="senha" minlength="0" maxlength="25">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="password" class="form-control inputForm error" id="senha"
                                                       placeholder="${senhaErro}" name="senha" minlength="0" maxlength="25">
                                            </c:otherwise>
                                        </c:choose>                                        
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty senhaErro}">
                                                <input type="password" class="form-control inputForm" id="senha"
                                                       placeholder="Senha" name="senha" minlength="0" maxlength="25">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="password" class="form-control inputForm error" id="senha"
                                                       placeholder="${senhaErro}" name="senha" minlength="0" maxlength="25">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:otherwise>
                                </c:choose>

                                <label for="confirmarSenha">Confirmar senha:</label>
                                <c:choose>
                                    <c:when test="${empty cSenhaError}">
                                        <input type="password" class="form-control inputForm" id="confirmarSenha" 
                                               placeholder="Confirmar senha" name="confirmarSenha" minlength="0" maxlength="25">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="password" class="form-control inputForm error" id="confirmarSenha" 
                                               placeholder="${cSenhaError}" name="confirmarSenha" minlength="0" maxlength="25">
                                    </c:otherwise>
                                </c:choose>

                                <c:if test="${cliente == false}">
                                    <label for="setor" >Setor:</label>
                                    <c:choose>
                                        <c:when test="${acao == 'editar'}">
                                            <select class="custom-select inputForm" id="codigoSetor" name="codigoSetor">
                                                <option hidden="" value="${setor}">${nomeSetor}</option>
                                                <c:forEach var="setores" items="${listaSetores}">
                                                    <option value="<c:out value="${setores.setor}"></c:out>">
                                                        <c:out value="${setores.nomeSetor}"/>
                                                    </option>
                                                </c:forEach>
                                            </select>    
                                        </c:when>
                                        <c:otherwise>
                                            <c:if test="${empty setorErro}">
                                                <select class="custom-select inputForm" id="codigoSetor" name="codigoSetor">
                                                    <option selected = "" disabled="" hidden="">Setor</option>
                                                    <c:forEach var="setores" items="${listaSetores}">  
                                                        <option value="<c:out value="${setores.setor}"></c:out>">
                                                            <c:out value="${setores.nomeSetor}"/> 
                                                        </option>  
                                                    </c:forEach>       
                                                </select>
                                            </c:if>
                                            <c:if test="${not empty setorErro}">         
                                                <select class="custom-select form-control inputForm error" id="codigoSetor" name="codigoSetor">
                                                    <option selected ="" disabled="" hidden=""><c:out value="${setorErro}"/></option>                               
                                                    <c:forEach var="setores" items="${listaSetores}">  
                                                        <option value="<c:out value="${setores.setor}"></c:out>">
                                                            <c:out value="${setores.nomeSetor}"/> 
                                                        </option>  
                                                    </c:forEach>       
                                                </select>
                                            </c:if>  
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                                <c:if test="${cliente == true}">
                                    <label for="setor" class="sr-only">Setor:</label>
                                    <input type="hidden" class="form-control inputForm"
                                           placeholder="Este campo serve para informar o setor do cliente sem cadastro" name="codigoSetor" value="4">

                                    <input type="hidden" class="form-control inputForm"
                                           placeholder="Este campo serve para confirmar que o usuario é um cliente ao  salvar" name="cliente" value="cliente">
                                </c:if>
                            </div>
                            <button type="submit" class="btn btn-light btn-block">
                                <i class="far fa-save"></i>
                                Salvar
                            </button>
                        </form>
                        <form <c:if test="${sessionScope.nomeSetor == null}"> action="../login/login.jsp" </c:if> <c:if test="${sessionScope.nomeSetor != 'Diretor'}"> action="perfil" method="POST" </c:if> action="listagem_usuarios" method="GET" style="padding-top: 8px; ">
                            <button name="perfil" type="submit" class="btn btn-light btn-block" value="${sessionScope.cdFuncionario}">
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
    </body>
</html>
