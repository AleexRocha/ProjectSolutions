<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="container">
            <table class="table table-striped">
                <c:forEach var="filiais" items="${lista}">
                    <tbody id="teste">                  
                        <tr>
                            <td><input type="radio"></td>
                            <td name="codigo" ><c:out value="${filiais.codigo}" /></td>
                            <td name="logradouro" ><c:out value="${filiais.logradouro}" /></td>
                            <td name="numero" ><c:out value="${filiais.numero}" /></td>
                            <td name="cep" ><c:out value="${filiais.cep}" /></td>
                            <td name="bairro" ><c:out value="${filiais.bairro}" /></td>
                            <td name="estado" ><c:out value="${filiais.estado}" /></td>
                            <td name="cidade" ><c:out value="${filiais.cidade}" /></td>
                            <td name="telefone" ><c:out value="${filiais.telefone}" /></td>        
                            <td class="btn-group">
                                <a href="cadastro_filiais.jsp?codigo=${filiais.codigo}">
                                    <button type="button" class="btn btn-success">
                                        <i class="fas fa-pen"></i>
                                    </button>
                                </a>
                                <button type="button" class="btn btn-danger">
                                    <i class="far fa-trash-alt"></i>
                                </button>
                            </td>
                        </tr>

                    </tbody>    
                </c:forEach>
            </table>
        </div>
    </body>
</html>