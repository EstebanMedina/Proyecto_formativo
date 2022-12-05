<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Required meta tags-->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Colorlib Templates">
  <meta name="author" content="Colorlib">
  <meta name="keywords" content="Colorlib Templates">

  <!-- Title Page-->
  <title>Au Register Forms by Colorlib</title>

  <!-- Icons font CSS-->
  <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
  <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
  <!-- Font special for pages-->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

  <!-- Vendor CSS-->
  <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
  <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

  <!-- Main CSS-->
 <link rel="stylesheet" href="assets/css/main.css">

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="icon" type="image/png" href="assets/img/icono.png" />
<link rel="stylesheet" href="assets/js/js.js">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<title>Rol</title>
</head>
<body background="assets/img/fondo.jpg">
  <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
    <div class="wrapper wrapper--w790" >
        <div class="card card-5">
            <div class="card-heading">
                <h2 class="title">Editar Rol</h2>
            </div>
            <div class="card-body">
                <c:forEach var="rolA" items="${listar}">
                    <form action="rol" method="post"> 
                      <div class="form-row m-b-55">
                        <div class="value">
                            <div class="row row-space">
                                <div class="col-2">
                                    <div class="input-group-desc">
                                      <div class="name">Nombre</div>
                                      <input type="text" name="nombreRol" id="nombreRol" class="col-lg-12" value="${rolA.getNombreRol()}"> 
                                      <label id="nombreRol" class="col-lg-12"></label>
                                  </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <button type="submit" class="btn btn--radius-2 btn--red"  name="accion" value="edit">Guardar</button>
   </form>
    </div>  
  </div>
</c:forEach>
</body>
</html>