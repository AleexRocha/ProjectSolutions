<%-- 
    Document   : cadastro_vendas
    Created on : 08/04/2019, 21:47:39
    Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
    </head>
    <body>
        <img src="assets/img/logo.png">
        <hr>
        <h2>Floricultura</h2>
        <a href="./produtos/listagem_produtos.jsp">Produtos</a>
        <a href="./ti/listagem_filiais.jsp">Filiais</a>
        <a href="relatorio.jsp">Relatorio</a>
        <a href="./ti/listagem_usuarios.jsp">Usuarios</a>
        <hr>
        <br>
        <br>
        <form>
            <fieldset>
                Codigo venda:<br> 
                <input type="text" 
                       name="Codigo venda">
                <br>
                Nome do produto:<br>
                <input type="text" 
                       name="Nome do produto">
                <br>
                Codigo do produto:<br>
                <input type="text" 
                       name="Codigo do produto">
                <br>
                Quantidade vendida:<br>
                <input type="text" 
                       name="Quantidade vendida">
                <br>
                ID funcionario:<br>
                <input type="text" 
                       name="ID funcionario">
                <br>
                Codigo da filial:<br>
                <input type="text" 
                       name="Codigo da filial">
                <br>
                <br>
            </fieldset>
            <br>
            <input type="submit" value="Salvar">
            <button type="button">Cancelar</button>
        </form>

    </body>
</html>
