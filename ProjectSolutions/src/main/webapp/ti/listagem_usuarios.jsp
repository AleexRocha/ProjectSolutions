<%-- 
Document   : listagem_usuarios
Created on : 08/04/2019, 21:46:50
Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Usuários</title>
</head>
<body>
    <img src="../assets/img/logo.png">
    <hr>
    <h1>Floricultura</h1>
    <a href="../venda/cadastro_vendas.jsp">Vendas</a>
    <a href="../produtos/listagem_produtos.jsp">Produtos</a>
    <a href="listagem_filiais.jsp">Filiais</a>
    <a href="../venda/relatorio.jsp">Relatorio</a>
    <hr>
    <br>
    <a href="cadastro_usuarios.jsp">Cadastrar Usuario</a>
    <button type="button">Excluir Selecionado(s)</button>
    <br>
    <br>
    <table border="1" cellspacing="0" cellpadding="3">
        <tr>
            <td><input type="radio"></td>
            <td>Codigo</td>
            <td>Nome</td>
            <td>Email</td>
            <td>Senha</td>
            <td>Filial</td>
            <td>Setor</td>
            <td>Acoes</td>
        </tr>
        <tr>
            <td><input type="radio"></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><button type="button"><img src="lapis.jpg">
                <button type="button"><img src="lapis.jpg">
                </button>
            </button></td>
        </tr>
    </table>
</body>
</html>
