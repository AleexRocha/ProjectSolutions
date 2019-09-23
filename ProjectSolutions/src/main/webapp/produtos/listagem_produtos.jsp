<%-- 
   Document   : listagem_produtos
   Created on : 08/04/2019, 21:45:31
   Author     : nicolas.hgyoshioka
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Produtos</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
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
                        <form action="../ti/listagem_filiais" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Filiais</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../ti/listagem_usuarios" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Usuarios</button>
                        </form>
                    </li>
                    <li class="nav-item">
                        <form action="../venda/carrega_relatorio" method="GET">
                            <button type="submit" class="btn nav-link nav-text" >Relatorio</button>
                        </form>
                    </li>
                </ul>
                <i class="fas fa-user-tie" style="margin-left: -189px;"></i> &nbsp;&nbsp; Olá, <c:out value="${nomeUsuario}"/> 
                <form action="../venda/logout" method="POST">
                    <button type="submit" class="btn nav-link nav-text" >Sair</button>
                </form>
            </nav>
            <h2 class="h2 text-center subtitulo">Produtos</h2>
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

            <form id="btn_cadastro" action="select_cadastro" method="GET">
                <Button type="submit" class="btn btn-light">
                    <i class="fas fa-box"></i>
                    Cadastrar Produto
                </Button>
            </form>
            <button type="submit" class="btn btn-danger">
                <i class="far fa-trash-alt"></i>
                Excluir Selecionado(s)
            </button>
            <br>
            <br>    

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th class="coluna" ><input type="checkbox"></th>
                        <th class="coluna" scope="col">Codigo</th>
                        <th class="coluna" scope="col">Nome</th>
                        <th class="coluna" scope="col">Descricao</th>
                        <th class="coluna" scope="col">Tipo</th>
                        <th class="coluna" scope="col">Filial</th>
                        <th class="coluna" scope="col">Estoque</th>
                        <th class="coluna" scope="col">Valor unidade</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach var = "produtos"  items="${listaProdutos}">
                            <td class="coluna" >
                                <input name="selected" value="${produtos.codigo}" type="checkbox"> 
                            </td>
                            <td class="coluna" name="codigo"><c:out value ="${produtos.codigo}"/></td>
                            <td class="coluna" name="nome"><c:out value ="${produtos.nome}"/></td>
                            <td class="coluna" name="descricao"><c:out value ="${produtos.descricao}"/></td>
                            <td class="coluna" name="tipo"><c:out value ="${produtos.tipo}"/></td>
                            <td class="coluna" name="codigoFilialint"><c:out value ="${produtos.nomeFilial}"/></td>
                            <td class="coluna" name="quantidadeEstoque"><c:out value ="${produtos.quantidadeEstoque}"/></td>
                            <td class="coluna" name="valorUnitario"><c:out value ="${produtos.valorUnitario}"/></td>
                            <td class="btn-group">
                                <form action="descricao" method="GET">
                                    <button name="consultarID" value="${produtos.codigo}" type="submit" class="btn btn-success">
                                        <i class="far fa-eye"></i>
                                    </button>
                                </form>
                                <form action="dados_produto" method="POST">
                                    <button name="editarID" value="${produtos.codigo}" type="submit" class="btn btn-success">
                                        <i class="fas fa-pen"></i>
                                    </button>
                                </form>
                                <!-- Button que chama a modal -->
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteProduto">
                                    <i class="far fa-trash-alt"></i>
                                    <c:set var="codigoProduto" value="${produtos.codigo}"/>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!-- Modal -->
            <div class="modal fade" id="deleteProduto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">ATENÇÃO!!</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>Tem certeza que deseja excluir o produto?</p>
                        </div>
                        <div class="modal-footer">
                            <form action="excluir_produto" method="POST" name ="deletarProduto">
                                <button name="excluirID" value="${codigoProduto}" type="submit" class="btn btn-danger">
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