<%-- 
    Document   : relatorio
    Created on : 08/04/2019, 21:48:45
    Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório</title>
    </head>
    <body>
        <img src="assets/img/logo.png">
        <hr>
        <h1>Floricultura</h1>
        <a href="./produtos/listagem_produtos.jsp">Produtos</a>
        <a href="./ti/listagem_filiais.jsp">Filiais</a>
        <a href="./ti/listagem_usuarios.jsp">Usuarios</a>
        <a href="cadastro_vendas.jsp">Vendas</a>
        <hr>
        <br>
        <label>
            <label for = "Filial:" > Selecione a filial na qual deseja <br> obter os relatorios de vendas: </label>
            &nbsp
            <select name = "Filial">
                <option value = "selecionar">Selecionar</option>
            </select> 
        </label>
        <br>
        <p></p>
        <button type="button">Gerar excel</button>
        <br>
        <br>
        <table border="1" cellspacing="0" cellpadding="3">
            <tr>
                <td><input type="radio"></td>
                <td>Codigo</td>
                <td>Nome do produto</td>
                <td>Codigo produto</td>
                <td>Quantidade vendida</td>
                <td>Id funcionario</td>
                <td>Codigo filial</td>		
            </tr>
            <tr>
                <td><input type="radio"></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>		
                <td></td>
            </tr>
        </table>
    </body>
</html>
