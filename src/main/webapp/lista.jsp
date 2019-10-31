<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Codice Fiscale</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${ListaUtenti}" var="user" >
            <tr>
                <td><c:out value= "${user.id}" /></td>
                <td><c:out value="${user.nome}" /></td>
                <td><c:out value="${user.cognome}" /></td>
                <td><c:out value="${user.codiceFiscale}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
