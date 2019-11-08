<%-- 
    Document   : cadastro_endereco
    Created on : 20/10/2019, 19:20:21
    Author     : Alexsander Rocha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Cadastrar Endereço</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>

        <c:if test="${acao == 'editar'}">
            <h2 class="h2 text-center subtitulo">Editar Endereço</h2>
        </c:if>
        <c:if test="${empty acao}">
            <h2 class="h2 text-center subtitulo">Cadastrar Endereço</h2>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <c:choose>
                        <c:when test="${acao == 'editar'}">
                            <form action="update_endereco" method="post">
                            </c:when>
                            <c:otherwise>
                                <form action="create_endereco" method="post">
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
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <label class="sr-only">Info usuarios:</label>
                                        <input type="number" class="form-control inputForm sr-only" id="codigoUsuario"
                                               value="${codigoUsuario}" name="codigoUsuario">
                                        <input type="text" class="form-control inputForm sr-only" id="valorSetor"
                                               value="${valorSetor}" name="valorSetor">
                                    </c:when>
                                    <c:otherwise>
                                        <label class="sr-only">Info usuarios:</label>
                                        <input type="number" class="form-control inputForm sr-only" id="codigoUsuario"
                                               value="${codigoUsuario}" name="codigoUsuario">
                                        <input type="text" class="form-control inputForm sr-only" id="valorSetor"
                                               value="${valorSetor}" name="valorSetor">
                                    </c:otherwise>

                                </c:choose>

                                <label for="codigoEndereco" class="sr-only">Código do endereco:</label>
                                <input type="number" class="form-control inputForm sr-only" id="codigoEndereco"
                                       value="${codigoEndereco}" name="codigoEndereco">

                                <label for="cep">CEP:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty cepErro}">
                                                <input type="number" class="form-control inputForm" id="cep"
                                                       value="${cep}" name="cep" minlength="0" maxlength="8" onchange="buscaCep();">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="number" class="form-control inputForm error" id="cep"
                                                       placeholder="${cepErro}" name="cep" minlength="0" maxlength="8" onchange="buscaCep();">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty cepErro}">
                                                <input type="number" class="form-control inputForm" id="cep"
                                                       placeholder="CEP" name="cep" minlength="0" maxlength="8" onchange="buscaCep();">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="number" class="form-control inputForm error" id="cep"
                                                       placeholder="${cepErro}" name="cep" minlength="0" maxlength="8" onchange="buscaCep();">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="logradouro">Logradouro:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty logradouroErro}">
                                                <input type="text" class="form-control inputForm" id="logradouro"
                                                       value="${logradouro}" name="logradouro" minlength="0" maxlength="250">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="logradouro"
                                                       placeholder="${logradouroErro}" name="logradouro" minlength="0" maxlength="250">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty logradouroErro}">
                                                <input type="text" class="form-control inputForm" id="logradouro"
                                                       placeholder="Logradouro" name="logradouro" minlength="0" maxlength="250">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="logradouro"
                                                       placeholder="${logradouroErro}" name="logradouro" minlength="0" maxlength="250">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="numero">Numero:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty numeroErro}">
                                                <input type="number" class="form-control inputForm" id="numero"
                                                       value="${numero}" name="numero" minlength="0" maxlength="11">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="number" class="form-control inputForm error" id="numero"
                                                       placeholder="${numeroErro}" name="numero" minlength="0" maxlength="11">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty numeroErro}">
                                                <input type="number" class="form-control inputForm" id="numero"
                                                       placeholder="Numero" name="numero" minlength="0" maxlength="11">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="number" class="form-control inputForm error" id="numero"
                                                       placeholder="${numeroErro}" name="numero" minlength="0" maxlength="11">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="logradouro">Complemento:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <input type="text" class="form-control inputForm" id="complemento"
                                               value="${complemento}" name="complemento" minlength="0" maxlength="250">
                                    </c:when>
                                    <c:otherwise>
                                            <input type="text" class="form-control inputForm" id="complemento"
                                                   placeholder="Complemento" name="complemento" minlength="0" maxlength="250">
                                    </c:otherwise>
                                </c:choose>

                                <label for="bairro">Bairro:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty bairroErro}">
                                                <input type="text" class="form-control inputForm" id="bairro"
                                                       value="${bairro}" name="bairro" minlength="0" maxlength="50">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="bairro"
                                                       placeholder="${bairroErro}" name="bairro" minlength="0" maxlength="50">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty bairroErro}">
                                                <input type="text" class="form-control inputForm" id="bairro"
                                                       placeholder="Bairro" name="bairro" minlength="0" maxlength="50">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="bairro"
                                                       placeholder="${bairroErro}" name="bairro" minlength="0" maxlength="50">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="cidade">Cidade:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty cidadeErro}">
                                                <input type="text" class="form-control inputForm" id="cidade"
                                                       value="${cidade}" name="cidade" minlength="0" maxlength="50">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="cidade"
                                                       placeholder="${cidadeErro}" name="cidade" minlength="0" maxlength="50">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty cidadeErro}">
                                                <input type="text" class="form-control inputForm" id="cidade"
                                                       placeholder="Cidade" name="cidade" minlength="0" maxlength="50">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="cidade"
                                                       placeholder="${cidadeErro}" name="cidade" minlength="0" maxlength="50">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="estado">Estado:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty estadoErro}">
                                                <input type="text" class="form-control inputForm" id="estado"
                                                       value="${estado}" name="estado" minlength="0" maxlength="5">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="estado"
                                                       placeholder="${estadoErro}" name="estado" minlength="0" maxlength="5">
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty estadoErro}">
                                                <input type="text" class="form-control inputForm" id="estado"
                                                       placeholder="Estado" name="estado" minlength="0" maxlength="5">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" class="form-control inputForm error" id="estado"
                                                       placeholder="${estadoErro}" name="estado" minlength="0" maxlength="5">
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>

                                <label for="tipoEndereco" >Tipo de Endereço:</label>
                                <c:choose>
                                    <c:when test="${acao == 'editar'}">
                                        <c:choose>
                                            <c:when test="${empty tipoErro}">
                                                <select class="custom-select inputForm" id="tipoEndereco" name="tipoEndereco">
                                                    <option selected = "" hidden="" value="${tipoEndereco}">${tipoEndereco}</option>
                                                    <option value="Cobranca">Endereço de Cobrança</option>
                                                    <option value="Entrega">Endereço de Entrega</option>
                                                </select>
                                            </c:when>
                                            <c:otherwise>
                                                <select class="custom-select inputForm" id="tipoEndereco" name="tipoEndereco">
                                                    <option selected = "" hidden="" value="${tipoEndereco}">${tipoErro}</option>
                                                    <option value="Cobranca">Endereço de Cobrança</option>
                                                    <option value="Entrega">Endereço de Entrega</option>
                                                </select>
                                            </c:otherwise>
                                        </c:choose>                                      
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty tipoErro}">
                                                <select class="custom-select inputForm" id="tipoEndereco" name="tipoEndereco">
                                                    <option selected = "" hidden="">Tipo de Endereço</option>
                                                    <option value="Cobranca">Endereço de Cobrança</option>
                                                    <option value="Entrega">Endereço de Entrega</option>
                                                </select>
                                            </c:when>
                                            <c:otherwise>
                                                <select class="custom-select inputForm error" id="tipoEndereco" name="tipoEndereco">
                                                    <option selected = "" hidden="">${tipoErro}</option>
                                                    <option value="Cobranca">Endereço de Cobrança</option>
                                                    <option value="Entrega">Endereço de Entrega</option>
                                                </select>
                                            </c:otherwise>
                                        </c:choose>                                    
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <button type="submit" class="btn btn-light btn-block">
                                <i class="far fa-save"></i>
                                Salvar
                            </button>
                        </form>
                        <form action="listagem_usuarios" method="GET" style="padding-top: 8px; ">
                            <button type="submit" class="btn btn-light btn-block">
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