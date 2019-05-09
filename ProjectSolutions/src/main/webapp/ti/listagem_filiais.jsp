<%-- 
Document   : listagem_filiais
Created on : 08/04/2019, 21:42:40
Author     : nicolas.hgyoshioka
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filiais</title>
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
                        <form action="../ti/listagem_usuarios" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Usuarios</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="carrega_relatorio" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Relatorio</button>
                        </form>
                    </li>
                </ul>
            </nav>
            <h2 class="h2 text-center subtitulo">Filiais</h2>
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

            <form action="excluir_filiais" method="POST">
                <a id="btn_cadastro" class="btn btn-light" href="cadastro_filiais.jsp">
                    <i class="far fa-building"></i>
                    Cadastrar filial
                </a>
                <button type="subimt" class="btn btn-danger">                 
                    <i class="far fa-trash-alt"></i>
                    Excluir Selecionado(s)
                </button> 
                
                <br>
                <br>
                
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th><input type="checkbox" id="selectAll" onClick="selectAll()"></th>
                            <th scope="col">Codigo</th>
                            <th scope="col">Logradouro</th>
                            <th scope="col">Numero</th>
                            <th scope="col">Cep</th>
                            <th scope="col">Bairro</th>
                            <th scope="col">Cidade</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Telefone</th>
                            <th scope="col">Acoes</th>
                        </tr>
                    </thead>    
                    <tbody id="teste">  
                        <c:forEach var="filiais" items="${lista}">                
                            <tr>
                                <td>
                                    <input name="selected" value="${filiais.codigo}" 
                                           id="chkFilial" type="checkbox"> 
                                </td>
                                <td name="codigo" ><c:out value="${filiais.codigo}" /></td>
                                <td name="logradouro" ><c:out value="${filiais.logradouro}" /></td>
                                <td name="numero" ><c:out value="${filiais.numero}" /></td>
                                <td name="cep" ><c:out value="${filiais.cep}" /></td>
                                <td name="bairro" ><c:out value="${filiais.bairro}" /></td>
                                <td name="cidade" ><c:out value="${filiais.cidade}" /></td>
                                <td name="estado" ><c:out value="${filiais.estado}" /></td>
                                <td name="telefone" ><c:out value="${filiais.telefone}" /></td>        
                                <td class="btn-group">
                                    <form action="dados_filial" method="POST">
                                        <button name="editarID" value="${filiais.codigo}" type="submit" class="btn btn-success">
                                            <i class="fas fa-pen"></i>
                                        </button>
                                    </form>
                                    <!-- Button que chama a modal -->
                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteFilial">
                                        <i class="far fa-trash-alt"></i>
                                        <c:set var="codigoItem" value="${filiais.codigo}"/>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
            <!-- Modal -->
            <div class="modal fade" id="deleteFilial" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">ATENÇÃO!!</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>Tem certeza que deseja excluir a filial?</p>
                        </div>
                        <div class="modal-footer"> 
                            <form action="excluir_filial" name ="deletarFilial" method="POST">
                                <button name="excluirID" value="${codigoItem}" type="submit" class="btn btn-danger">
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
        <script>
                                function selectAll() {
                                    var checkAll = document.getElementById('selectAll');
                                    var otherChecked = document.getElementById('chkFilial');

                                    if (checkAll.checked == true) {
                                        otherChecked.checked = true
                                    } else {
                                        otherChecked.checked = false;
                                    }
                                }
        </script>
    </body>
</html>