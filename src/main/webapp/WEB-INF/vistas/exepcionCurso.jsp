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
    <title>Error</title>
</head>
<body style="background: #cbac3bd9;">



<div style="
    margin: 40px;

    padding: 5px;
">
    <nav class="nav nav-pills nav-fill navbar navbar-dark bg-dark" >
        <a class="nav-link " aria-current="page" href="/proyecto_limpio_spring_war_exploded/home">Home</a>
        <a class="nav-link " href="irRegistrarAlumno">Agregar un alumno nuevo</a>
        <a class="nav-link " href="todos-los-alumnos">ver todos los Alumnos</a>
        <a class="nav-link" href="irRegistrarCurso">Agregar un Nuevo Curso</a>
        <a class="nav-link  " href="todos-los-cursos">ver todos los Cursos</a>
    </nav>

</div>


<div class=" w-100">
    <div class=" container-fluid px-2 h-100 w-100 d-flex justify-content-centerfondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-10 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="container">


                <div class="col-md-6 col-lg-6 mb-3 bg-danger d-none d-md-flex rounded-3 " style="margin-left: 17em;margin-right: 15em;margin-top:1em  ">
                    <div class="card text-center text-white bg-danger mb-3">
                        <div class="card-header"><i class="fas fa-exclamation-triangle"></i>Ocurrio un Error<i
                                class="fas fa-exclamation-triangle"></i></div>
                        <div class="card-body">
                            <p class="card-text">${error}</p>
                        </div>

                        <p>Intente de nuevo con otro Alumno</p>
                        <a class="nav-link active" aria-current="page" href="todos-los-cursos">Volver </a>

                    </div>
                </div>

            </div>
        </div>
        <br>
        <br>
    </div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>