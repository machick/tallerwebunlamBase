<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/10/2020
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--@elvariable id="usuario" type="ar.edu.unlam.tallerweb1.modelo.Usuario"--%>
        <form action="actualizar-usuario" method="POST" >
            <input name="id" value="${usuarioTraido.getId()}" type="text"/> <br>
            <label path="email"> Email</label><br>
            <input path="email" type="email" name="email" value="${usuarioTraido.getEmail()}" /><br>
            <label path="password"> contraseña</label><br>
            <input path="password" type="password" name="password"/><br>
            <input type="submit" value="actualizar"/><br>
        </form>

</body>
</html>
