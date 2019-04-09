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
        <img src="logo.jpg">
        <hr>
        <h2>Floricultura</h2>
        <a href="link1.html">link1</a>
        <a href="link2.html">link2</a>
        <a href="link3.html">link3</a>
        <a href="link4.html">link4</a>
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
