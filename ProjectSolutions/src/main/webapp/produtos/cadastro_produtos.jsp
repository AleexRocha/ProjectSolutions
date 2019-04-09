<%-- 
    Document   : cadastro_produtos
    Created on : 08/04/2019, 21:44:27
    Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
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
                Codigo:<br> 
                <input type="text" 
                       name="Codigo Produto">
                <br>
                Nome produto:<br>
                <input type="text" 
                       name="Nome produto">
                <br>
                Descricao:<br>
                <input type="text" 
                       name="Descricao">
                <br>
                Estoque:<br>
                <input type="number" 
                       name="Estoque">
                <br>
                Valor unitario:<br>
                <input type="number" 
                       name="Valor unitario">
                <br>
                <br>
                <label for = "Tipo:" > Tipo: </label>
                <select name = "Tipo">
                    <option value = "selecionar">Selecionar</option>
                </select> 
                <label for = "Filial:" > Filial: </label>
                <select name = "Filial">
                    <option value = "selecionar">Selecionar</option>
                </select> 
            </fieldset>
            <br>
            <input type="submit" value="Salvar">
            <button type="button">Cancelar!</button>
        </form>

    </body>
</html>
