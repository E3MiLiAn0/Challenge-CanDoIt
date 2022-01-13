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
<body style="background: #323025c7;">


<div style="
    margin: 40px;
    border: orange solid 2px;
">
    <nav class="nav nav-pills nav-fill">
        <a class="nav-link " aria-current="page" href="/proyecto_limpio_spring_war_exploded/home">Home</a>
        <a class="nav-link" href="irRegistrarAlumno">Agregar un alumno nuevo</a>
        <a class="nav-link active" href="todos-los-alumnos">ver todos los Alumnos</a>
        <a class="nav-link" href="irRegistrarCurso">Agregar un Nuevo Curso</a>
        <a class="nav-link" href="todos-los-cursos">ver todos los Cursos</a>
    </nav>

</div>

<div class="container">
    <div class="row ">

        <div class="col align-self-center row  mt-4">
            <h1 >Todos los Alumnos</h1>
        </div>

    </div>
</div>



<div class="row mt-4">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <table class="table table-bordered text-center">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">NOMBRE</th>
                <th scope="col">APELLIDO</th>
                <th scope="col">DNI</th>
                <th scope="col">EDITAR</th>
                <th scope="col">BORRAR</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${alumnos}" var="alumno">
                <tr>
                    <td>${alumno.id}</td>
                    <td>${alumno.nombre}</td>
                    <td>${alumno.apellido}</td>
                    <td>${alumno.dni}</td>
                    <td>
                        <form action="modificarAlumno" method="POST" modelAttribute="alumno">
                            <input type="hidden" name="id" id="id" value="${alumno.id}">
                            <button class="btn btn-lg btn-primary font-weight-bold" type="submit">Editar</button>
                        </form>
                    </td>
                    <td><a  class="btn btn-lg btn-primary font-weight-bold" href="borrar-alumno/${alumno.id}">borrar</a></td>



                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>