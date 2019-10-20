<%-- 
Document   : listagem_usuarios
Created on : 08/04/2019, 21:46:50
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Usuários</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <%@include file="../WEB-INF/header.jsp"%>
        <h2 class="h2 text-center subtitulo">Usuários</h2>
        <div class="container">
            <c:if test="${varMsg == true}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${msg}"/>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <c:if test="${varMsgErro == true}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${msg}"/>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>

            <form id="btn_cadastro" action="formulario_usuarios" method="post">
                <button class="btn btn-light" type="submit">
                    <i class="fas fa-user-plus"></i>
                    Cadastrar Usuário
                </button>
            </form>

            <br>
            <br>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th class="coluna" scope="col">Codigo</th>
                        <th class="coluna" scope="col">Nome</th>
                        <th class="coluna" scope="col">Email</th>
                        <th class="coluna" scope="col">CPF</th>
                        <th class="coluna" scope="col">Setor</th>
                        <th class="coluna" scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody id="teste">  
                    <c:forEach var="usuarios" items="${listaUsuarios}">                
                        <tr>
                            <td class="coluna" name="codigo" ><c:out value="${usuarios.codigo}" /></td>
                            <td class="coluna" name="nome" ><c:out value="${usuarios.nome}" /></td>
                            <td class="coluna" name="email" ><c:out value="${usuarios.email}" /></td>
                            <td class="coluna" name="email" ><c:out value="${usuarios.cpf}" /></td>
                            <td class="coluna" name="setor" ><c:out value="${usuarios.nomeSetor}"/></td>
                            <td class="btn-group">
                                <form action="dados_usuario" method="POST">
                                    <button name="idUsuario" value="${usuarios.codigo}" type="submit" class="btn btn-success">
                                        <i class="fas fa-pen"></i>
                                    </button>
                                </form>
                                <!-- Button que chama a modal -->
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteUsuario"
                                        value="${usuarios.codigo}" onclick="defineCodigo(this.value)">
                                    <i class="far fa-trash-alt"></i>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!-- Modal -->
            <div class="modal fade" id="deleteUsuario" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">ATENÇÃO!!</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>Tem certeza que deseja excluir o usuário?</p>
                        </div>
                        <div class="modal-footer">
                            <form action="excluir_usuario" method="POST" name ="deletarUsuario">
                                <button name="excluirID" id="destino" type="submit" class="btn btn-danger">
                                    <i class="far fa-trash-alt"></i> Sim
                                </button>
                            </form>
                            <button type="button" class="btn btn-success" data-dismiss="modal">
                                <i class="fas fa-ban"></i> Não
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../WEB-INF/footer.jsp" %>
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>