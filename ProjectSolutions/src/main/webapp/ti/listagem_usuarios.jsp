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
        <title>Usuários</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/navbar-top.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
        <header>
            <h1 style="text-align: center;">
                <span class="sr-only">Floricultura TADES</span>
                <img src="../assets/img/logo.png">
            </h1>
            <nav class="navbar navbar-expand-md navbar-light bg-warning mb-4">
                <ul id="itensMenu" class="nav justify-content-center">
                    <li class="nav-item">
                        <form action="../venda/cadastro_vendas">
                            <button type="submit" class="btn nav-link nav-text">Vendas</button>
                        </form>                     
                    </li>
                    <li class="nav-item">
                        <form action="../produtos/listagem_produtos" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Produtos</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_filiais" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Filiais</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="carrega_relatorio" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Relatorio</button>
                        </form>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Usuários</h2>
        </header>
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

            <form action="excluir_usuarios" method="POST">
                <button type="submit" class="btn btn-danger">
                    <i class="far fa-trash-alt"></i>
                    Excluir Selecionado(s)
                </button>

                <br>
                <br>

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th><input type="checkbox"></th>
                            <th scope="col">Codigo</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Email</th>
                            <th scope="col">Filial</th>
                            <th scope="col">Setor</th>
                            <th scope="col">Acoes</th>
                        </tr>
                    </thead>
                    <tbody id="teste">  
                        <c:forEach var="usuarios" items="${listaUsuarios}">                
                            <tr>
                                <td>
                                    <input name="selected" value="${usuarios.codigo}" type="checkbox"> 
                                </td>
                                <td name="codigo" ><c:out value="${usuarios.codigo}" /></td>
                                <td name="nome" ><c:out value="${usuarios.nome}" /></td>
                                <td name="email" ><c:out value="${usuarios.email}" /></td>
                                <td name="filial"><c:out value="${usuarios.nomeFilial}"/></td>
                                <td name="setor" ><c:out value="${usuarios.nomeSetor}"/></td>
                                <td class="btn-group">
                                    <form action="dados_usuario" method="POST">
                                        <button name="editarID" value="${usuarios.codigo}" type="submit" class="btn btn-success">
                                            <i class="fas fa-pen"></i>
                                        </button>
                                    </form>
                                    <!-- Button que chama a modal -->
                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteUsuario">
                                        <i class="far fa-trash-alt"></i>
                                        <c:set var="codigoUsuario" value="${usuarios.codigo}"/>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>

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
                                <button name="excluirID" value="${codigoUsuario}" type="submit" class="btn btn-danger">
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
        </div>
        <script src="../assets/js/jquery-2.1.3.min.js"></script>
        <script src="../assets/js/bootstrap.min.js"></script>
        <script src="../assets/js/main.js"></script>
    </body>
</html>