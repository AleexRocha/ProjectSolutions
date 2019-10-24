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
        <h2 class="h2 text-center subtitulo">Olá, ${sessionScope.nomeUsuario}</h2>
        <c:if test="${perfil == 'pessoal'}">
            <h4 class="h4 text-center subtitulo">Esse são seus dados:</h4>
        </c:if>
        <c:if test="${perfil == 'endereco'}">
            <h4 class="h4 text-center subtitulo">Esse são seus endereços:</h4>
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-md-3 text-center">
                    <nav class="nav nav-pills nav-fill flex-column">
                        <c:if test="${perfil == 'pessoal'}">
                            <form action="get_endereco" method="POST">
                                <button type="submit" name="idUsuario" value="${codigoUsuario}" class="btn nav-link subtitulo">
                                    Ver endereços cadastrados
                                </button>
                            </form>
                        </c:if>
                        <a class="nav-link subtitulo" href="#">Pedidos em andamento</a>
                        <a class="nav-link subtitulo" href="#">Pedidos finalizados</a>
                    </nav>
                </div>
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

                    <c:choose>
                        <c:when test="${perfil == 'pessoal'}">
                            <label for="codigoUsuario">Seu código de usuário:</label>
                            <input type="number" class="form-control inputFormPerfil" id="codigoUsuario"
                                   placeholder="Código do usuário" value="${codigoUsuario}" name="codigoUsuario" disabled="">

                            <label for="nome">Seu nome:</label>
                            <input type="text" class="form-control inputFormPerfil" id="nome"
                                   placeholder="Seu Nome" value="${nome}" name="nome" disabled="">

                            <label for="cpf">Seu CPF:</label>
                            <input type="text" class="form-control inputFormPerfil" id="cpf"
                                   placeholder="Seu CPF" value="${cpf}" name="cpf" disabled="">

                            <label for="email">Seu E-mail:</label>        
                            <input type="email" class="form-control inputFormPerfil" id="email"
                                   placeholder="Seu E-mail" value="${email}" name="email" disabled="">

                            <label for="setor" >Você é um:</label>
                            <input type="text" class="form-control inputFormPerfil" id="setor"
                                   placeholder="Setor" value="${nomeSetor}" name="senha" disabled="">

                            <form action="dados_usuario" method="POST">
                                <button type="submit" name="idUsuario" value="${codigoUsuario}" class="btn btn-success btn-block col-12" style="margin-top: 10px;">
                                    <i class="fas fa-pen"></i>
                                    Edite suas informações
                                </button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <label for="codigoEndereco">Código do endereço:</label>
                            <input type="number" class="form-control inputFormPerfil" id="codigoEndereco"
                                   placeholder="Código do endereço" value="${codigoEndereco}" name="codigoEndereco" disabled="">

                            <label for="cep" >Seu CEP:</label>
                            <input type="text" class="form-control inputFormPerfil" id="cep"
                                   placeholder="Seu CEP" value="${cep}" name="cep" disabled="">

                            <label for="numero">Seu Número:</label>
                            <input type="number" class="form-control inputFormPerfil" id="numero"
                                   placeholder="Seu Número" value="${numero}" name="numero" disabled="">

                            <label for="logradouro">Seu Logradouro:</label>
                            <input type="text" class="form-control inputFormPerfil" id="logradouro"
                                   placeholder="Seu Logradouro" value="${logradouro}" name="logradouro" disabled="">

                            <label for="email">Seu Bairro:</label>        
                            <input type="bairro" class="form-control inputFormPerfil" id="bairro"
                                   placeholder="Seu Bairro" value="${bairro}" name="bairro" disabled="">

                            <label for="cidade" >Sua Cidade:</label>
                            <input type="text" class="form-control inputFormPerfil" id="cidade"
                                   placeholder="Sua Cidade" value="${cidade}" name="cidade" disabled="">

                            <label for="estado" >Seu Estado:</label>
                            <input type="text" class="form-control inputFormPerfil" id="estado"
                                   placeholder="Seu Estado" value="${estado}" name="estado" disabled="">

                            <label for="tipoEndereco" >Este endereço é de</label>
                            <input type="text" class="form-control inputFormPerfil" id="tipoEndereco"
                                   placeholder="Este endereço é de" value="${tipoEndereco}" name="tipoEndereco" disabled="">

                            <form action="select_endereco" method="POST">
                                <button type="submit" name="idUsuario" value="${codigoUsuario}" class="btn btn-success btn-block col-12" style="margin-top: 10px;">
                                    <i class="fas fa-pen"></i>
                                    Edite suas informações
                                </button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="col-md-3"></div>
            </div>
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>
