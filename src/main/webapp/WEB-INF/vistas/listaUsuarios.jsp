<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
    <div class = "container">
        <h1>Bienvenidos a Taller Web 1</h1>
    </div>

        </br>
        Rol buscado: ${ROL_BUSCADO}
    </br>
    </br>
        Lista de Usuarios
    </br>
        <c:forEach items="${USUARIOS}" var="USER">
            ${USER.email} - ${USER.rol}
            </br>
        </c:forEach>
    </br></br></br>
    ${ERROR}
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
