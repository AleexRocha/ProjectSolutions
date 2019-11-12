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
        <c:if test="${perfil == 'pagamento'}">
            <h4 class="h4 text-center subtitulo">Esse são seus métodos de pagamento registrados:</h4>
        </c:if>
            
        <div class="container">
            <div class="row">
                <div class="col-md-3 text-center">
                    <nav class="nav nav-pills nav-fill flex-column">
                        <c:if test="${empty perfil}">
                            <form action="get_endereco" method="POST">
                                <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn nav-link subtitulo">
                                    Ver endereços cadastrados
                                </button>
                            </form>
                            <form action="pagamento_listagem" method="POST">
                                <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn nav-link subtitulo">
                                    Métodos de Pagamento
                                </button>
                            </form>
                        </c:if>
                        <c:if test="${perfil == 'endereco'}">
                            <form action="cadastro_endereco.jsp" method="POST">
                                <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn nav-link subtitulo">
                                    Cadastrar novo endereço
                                </button>
                            </form>
                            <form action="pagamento_listagem" method="POST">
                                <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn nav-link subtitulo">
                                    Métodos de Pagamento
                                </button>
                            </form>
                        </c:if>
                        <c:if test="${perfil == 'pagamento'}">
                            <form action="get_endereco" method="POST">
                                <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn nav-link subtitulo">
                                    Ver endereços cadastrados
                                </button>
                            </form>
                            <c:choose>
                                <c:when test="${metodo == 'listagem'}">
                                    <form action="pagamento_formulario" method="POST">
                                        <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn nav-link subtitulo">
                                            Cadastrar pagamento
                                        </button>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="pagamento_listagem" method="POST">
                                        <button type="submit" name="idUsuario" value="${sessionScope.cdFuncionario}" class="btn nav-link subtitulo">
                                            Métodos de Pagamento
                                        </button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                        
                        <a class="nav-link subtitulo" href="#">Pedidos em andamento</a>
                        <a class="nav-link subtitulo" href="#">Pedidos finalizados</a>
                    </nav>
                </div>
                <div class="col-md-9 col-sm-12">
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

                    <c:if test="${empty perfil}">
                        <div class="row">
                            <div class="col-12">
                                <label for="nome">Seu nome completo:</label>
                                <input type="text" class="form-control inputFormPerfil" id="nome"
                                       placeholder="Seu Nome" value="${nome}" name="nome" disabled="">
                            </div>
                            <div class="col-6">
                                <label for="codigoUsuario">Seu código de usuário:</label>
                                <input type="number" class="form-control inputFormPerfil" id="codigoUsuario"
                                       placeholder="Código do usuário" value="${codigoUsuario}" name="codigoUsuario" disabled="">
                            </div>
                            <div class="col-6">
                                <label for="cpf">Seu CPF:</label>
                                <input type="text" class="form-control inputFormPerfil" id="cpf"
                                       placeholder="Seu CPF" value="${cpf}" name="cpf" disabled="">
                            </div>
                            <div class="col-6">
                                <label for="email">Seu E-mail:</label>        
                                <input type="email" class="form-control inputFormPerfil" id="email"
                                       placeholder="Seu E-mail" value="${email}" name="email" disabled="">
                            </div>
                            <div class="col-6">
                                <label for="setor" >Você é um:</label>
                                <input type="text" class="form-control inputFormPerfil" id="setor"
                                       placeholder="Setor" value="${nomeSetor}" name="senha" disabled="">
                            </div>
                        </div>
                        <form action="dados_usuario" method="POST">
                            <button type="submit" name="idUsuario" value="${codigoUsuario}" class="btn btn-success btn-block col-12" style="margin-top: 10px;">
                                <i class="fas fa-pen"></i>
                                Edite suas informações
                            </button>
                        </form>
                    </c:if>
                    <c:if test="${perfil == 'endereco'}">
                        <div class="row">
                            <c:forEach var="enderecos" items="#{listaEnderecos}">
                                <div class="col-md-6 col-sm-12">
                                    <div class="card" style="background-color: #f3f3f3 !important;">
                                        <div class="card-body">
                                            <span class="card-title">
                                                <b> Logradouro / Número:</b>
                                                <p><c:out value="${enderecos.logradouro}"/>, <c:out value="${enderecos.numero}"/></p>
                                            </span>
                                            <div class="row">
                                                <div class="col">
                                                    <span class="card-title">
                                                        <b> Complemento </b>
                                                        <p><c:out value="${enderecos.complemento}"/></p>
                                                    </span>
                                                </div>
                                                <div class="col">
                                                    <span class="card-title">
                                                        <b> CEP: </b>
                                                        <p><c:out value="${enderecos.cep}"/></p>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <span class="card-title">
                                                        <b> Bairro: </b>
                                                        <p><c:out value="${enderecos.bairro}"/></p>
                                                    </span>
                                                </div>
                                                <div class="col">
                                                    <span class="card-title">
                                                        <b> Cidade: </b>
                                                        <p><c:out value="${enderecos.cidade}"/></p>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <span class="card-title">
                                                        <b> Estado: </b>
                                                        <p><c:out value="${enderecos.estado}"/></p>
                                                    </span>
                                                </div>
                                                <div class="col">
                                                    <span class="card-title">
                                                        <b> Endereço de: </b>
                                                        <p><c:out value="${enderecos.tipoEndereco}"/></p>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <form action="select_endereco" method="POST">
                                            <button type="submit" name="idUsuario" value="${enderecos.codigoEndereco}" class="btn btn-success btn-block col-12" style="margin-top: 10px;">
                                                <i class="fas fa-pen"></i>
                                                Edite suas informações
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:if>
                    <c:if test="${perfil == 'pagamento'}">
                        <h2>Teste Listagem Pagamentos</h2>
                    </c:if>
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
