<%-- 
    Document   : listagem_filiais
    Created on : 17/04/2019, 14:57:07
    Author     : guilherme.pereira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/navbar-top.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/main.css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    </head>
    <body>
    <tbody>
        <tr>
            <td><input type="radio"></td>
            <td><c:out value="${codigo}" /></td>
            <td><c:out value="${logradouro}" /></td>
            <td><c:out value="${numero}" /></td>
            <td><c:out value="${cep}" /></td>
            <td><c:out value="${bairro}" /></td>
            <td><c:out value="${cidade}" /></td>
            <td><c:out value="${estado}" /></td>
            <td><c:out value="${telefone}" /></td>          
            <td class="btn-group">
                <button type="button" class="btn btn-success">
                    <a href="../../ti/cadastro_filiais.jsp">
                        <i class="fas fa-pen"></i>
                    </a>
                </button>
                <button type="button" class="btn btn-danger">
                    <i class="far fa-trash-alt"></i>
                </button>
            </td>
        </tr>
    </tbody>
</body>
</html>
