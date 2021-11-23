<%-- 
    Document   : formulario.jsp
    Created on : 10 de nov de 2021, 16:53:26
    Author     : Luciane Cunha
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<c:set var="id" value="${param.idc}" />
<jsp:useBean class="Model.CursoDAO" id="dao" />
<c:set var="curso" value="${dao.buscar(id)}" />

  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de curso</title>
    </head>
    <body>
        <h1>Formulário cadastro de curso</h1>
        <form action="Exec" method="post">
            <label>Nome:</label>
            <br>
            <input type="text" name="nome" value="${curso.nome}" readonly="true">
            <br><br>
            <label>Descrição:</label>
            <br>
            <textarea rows="5" name="descricao" cols="20" readonly="true" >${curso.descricao}</textarea>
            <br><br>
            <label>Resumo:</label>
            <br>
            <textarea rows="3" name="resumo" cols="20" readonly="true" >${curso.resumo}</textarea>
            <br><br>
            <label>Valor:</label>
            <br>
            <input type="text" name="valor" value="${curso.valor}" readonly="true">
            <br><br>
            <input type="hidden" name="excluir" value="excluir" >
            <button type="Submit">Excluir</button>
        </form>
    </body>
</html>
