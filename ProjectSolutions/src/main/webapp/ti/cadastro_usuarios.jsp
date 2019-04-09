<%-- 
    Document   : cadastro_funcionarios
    Created on : 08/04/2019, 21:45:57
    Author     : nicolas.hgyoshioka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuários</title>
    </head>
    <body>
       <img src="assets/img/logo.png">
        <hr>
        <h2>Floricultura</h2>
        <a href="./produtos/listagem_produtos.jsp">Produtos</a>
        <a href="listagem_filiais.jsp">Filiais</a>
        <a href="./venda/relatorio.jsp">Relatorio</a>
        <a href="./venda/cadastro_vendas.jsp">Vendas</a>
        <hr>
        <br>
        <br>
        <form>
            <fieldset>
                Codigo Usuario:<br> 
                <input type="number" 
                       name="Codigo Usuario">
                <br>
                Nome:<br>
                <input type="text" 
                       name="Nome">
                <br>
                Email:<br>
                <input type="email" 
                       name="Email">
                <br>
                Senha:<br>
                <input type="password" 
                       name="Senha">
                <br>
                Confirmar senha:<br>
                <input type="password" 
                       name="Confirmar senha">
                <br>
                <br>
                <label for = "Filial:" > Filial: </label>
                <select name = "Filial">
                    <option value = "selecionar">Selecionar</option>
                </select> 
                <label for = "Setor:" > Setor: </label>
                <select name = "Setor">
                    <option value = "selecionar">Selecionar</option>
                </select> 
            </fieldset>
            <br>
            <input type="submit" value="Salvar">
            <button type="button">Cancelar!</button>
        </form>
    </body>
</html>
