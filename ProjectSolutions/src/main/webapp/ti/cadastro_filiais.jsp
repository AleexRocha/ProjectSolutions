<%-- 
    Document   : cadastro_filial
    Created on : 08/04/2019, 21:40:32
    Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Filiais</title>
    </head>
    <body>
        <img src="logo.jpg">
        <hr>
        <h2>Floricultra</h2>
        <a href="link1.html">link1</a>
        <a href="link2.html">link2</a>
        <a href="link3.html">link3</a>
        <a href="link4.html">link4</a>
        <hr>
        <br>
        <br>
        <form>
            <fieldset>
                Codigo Filial:<br> 
                <input type="number" 
                       name="Codigo Filial">
                <br>
                Logradouro:<br>
                <input type="text" 
                       name="Logradouro">
                <br>
                Numero:<br>
                <input type="number" 
                       name="Numero">
                <br>
                CEP:<br>
                <input type="number" 
                       name="CEP">
                <br>
                Bairro:<br>
                <input type="text" 
                       name="Bairro">
                <br>
                Telefone:<br>
                <input type="tel" 
                       name="Telefone">
                <br>
                <br>
                <label for = "Estado:" > Estado: </label>
                <select name = "Estado">
                    <option value = "selecionar">Selecionar</option>
                </select> 
                <label for = "Cidade:" > Cidade: </label>
                <select name = "Cidade">
                    <option value = "selecionar">Selecionar</option>
                </select> 
            </fieldset>
            <br>
            <input type="submit" value="Salvar">
            <button type="button">Cancelar!</button>
        </form>

    </body>
</html>
