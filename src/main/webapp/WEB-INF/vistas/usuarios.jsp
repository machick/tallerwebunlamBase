<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/10/2020
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mostramos usuarios</title>
</head>
<body>
        <c:forEach items="${USUARIOS}" var="USER">
            <a href="update/${USER.id}"> update user </a>
            <a href="delete/${USER.id}"> delete user </a>
            ${USER.email} - ${USER.rol}
            </br>
        </c:forEach>
</body>
</html>
