<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="css/Login.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Factura servicio contratado</title>
</head>
<body>


<a href="irRegistrarAlumno">Agregar un alumno nuevo</a>

<table >
    <tr>

        <th style="width: 250px;">Nombre</th>
        <th style="width: 150px;">Id</th>
        <th style="width: 150px;">borrar</th>
        <th style="width: 150px;">editar</th>
    </tr>
    <c:forEach items="${alumnosDelCurso}" var="alumno"
    >
        <tr>

            <td>${alumno.nombre}</td>
            <td>${alumno.id}</td>
            <td><a href="borrar-alumno/${alumno.id}">borrar</a></td>
            <td>
                <form action="modificarAlumno" method="POST" modelAttribute="alumno">
                    <input type="hidden" name="id" id="id" value="${alumno.id}">
                    <button class="btn btn-lg btn-primary font-weight-bold" type="submit">Editar</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>