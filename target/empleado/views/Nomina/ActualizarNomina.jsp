<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
	<link rel="stylesheet" href="assets/css/plantilla/vendors/materialdesignicons.min.css">
	<link rel="stylesheet" href="assets/css/plantilla/vendors/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
	<link rel="stylesheet" href="assets/css/plantilla/vendors/jquery-jvectormap.css">
	<link rel="stylesheet" href="assets/css/plantilla/vendors/flag-icon.min.css">
	<link rel="stylesheet" href="assets/css/plantilla/vendors/owl.carousel.min.css">
	<link rel="stylesheet" href="assets/css/plantilla/vendors/owl.theme.default.min.css">
  <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- End plugin css for this page -->
    <link rel="stylesheet" href="css/materialdesignicons.min.css" media="all" type="text/css">
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/plantilla/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/img/logo-removebg-preview.png" />
  </head>
  <body>
    <div class="container-scroller">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <div class="sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top">
          <a class="sidebar-brand brand-logo" href="menu.jsp"><img style="width: 100px; height:70px; margin-left: 45px;" src="assets/img/logo-removebg-preview.png" alt="logo" /></a>
          <a class="sidebar-brand brand-logo-mini" href="menu.jsp"><img src="assets/img/vsg/arrow-right.svg" alt=""></a>
        </div>
        <br>
        <ul class="nav">
          <li class="nav-item nav-category">
            <span class="nav-link">Navegación</span>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="menu.jsp">
              <span class="menu-icon">
                <img src="assets/img/vsg/grid.svg" alt="">
              </span>
              <span class="menu-title">Inicio</span>
            </a>
          </li>

          <li class="nav-item nav-category">
            <span class="nav-link"></span>
          </li>

          <li class="nav-item nav-category">
            <span class="nav-link">Tablas</span>
          </li>
          <!-- Empleado -->
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <img src="assets/img/vsg/user.svg" alt="">
              </span>
              <span class="menu-title">Empleados</span>
              <img src="assets/img/vsg/arrow-down.svg" alt="">
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="empleado?accion=abrirFormulario"><img src="assets/img/vsg/user-plus.svg" alt="">|  Agregar un empleado</a></li>
                <li class="nav-item"> <a class="nav-link" href="empleado?accion=listar"><img src="assets/img/vsg/users.svg" alt="">| Consultar un empleado</a></li>
              </ul>
            </div>
          </li>


          <!-- Nómina -->
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <img src="assets/img/vsg/dollar-sign.svg" alt="">
              </span>
              <span class="menu-title">Novedad</span>
              <img src="assets/img/vsg/arrow-down.svg" alt="">
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="nomina?accion=listar"><img src="assets/img/vsg/clipboard.svg" alt="">| Consultar una novedad</a></li>
              </ul>
            </div>
          </li>

          <!-- Concepto -->
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <img src="assets/img/vsg/edit-3.svg" alt="">
              </span>
              <span class="menu-title">Nómina</span>
              <img src="assets/img/vsg/arrow-down.svg" alt="">
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="concepto?accion=Registro"><img src="assets/img/vsg/calendar.svg" alt="">| Agregar un nómina</a></li>
                <li class="nav-item"> <a class="nav-link" href="concepto?accion=Consultar"><img src="assets/img/vsg/clipboard.svg" alt="">| Consultar un nómina</a></li>
              </ul>
            </div>
          </li>

          <!-- Usuario -->
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <img src="assets/img/vsg/user.svg" alt="">
              </span>
              <span class="menu-title">Usuario</span>
              <img src="assets/img/vsg/arrow-down.svg" alt="">
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="usuario?accion=Formulario"><img src="assets/img/vsg/user-plus.svg" alt="">| Agregar un usuario</a></li>
                <li class="nav-item"> <a class="nav-link" href="usuario?accion=Listar"><img src="assets/img/vsg/users.svg" alt="">| Consultar un usuario</a></li>
              </ul>
            </div>
          </li>

          <!-- Botón que no me acuerdo como se llama XD  -->
          <li class="nav-item menu-items">
            <a class="nav-link" href="concepto?accion=ConsultarNomina">
              <span class="menu-icon">
                <img src="assets/img/vsg/file-text.svg" alt="">
              </span>
              <span class="menu-title">Generar PDF</span>
            </a>
          </li>
      </nav>

      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_navbar.html -->
        <nav class="navbar p-0 fixed-top d-flex flex-row">
          <div class="navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center">
            <a class="navbar-brand brand-logo-mini" href="menu.jsp"><img src="assets/images/logo-mini.svg" alt="logo" /></a>
          </div>
          <div class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
            <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
              <img src="assets/img/vsg/align-justify (1).svg" alt="">
            </button>
            <ul class="navbar-nav navbar-nav-right">
              <li class="nav-item dropdown">
                <a class="nav-link" id="profileDropdown" href="#" data-toggle="dropdown">
                  <div class="navbar-profile">
                    <img src="assets/img/vsg/user.svg" alt="">
                    <p class="mb-0 d-none d-sm-block navbar-profile-name">User</p>
                    <i class="mdi mdi-menu-down d-none d-sm-block"></i>
                  </div>
                </a>
                <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="profileDropdown">
                  <h6 class="p-3 mb-0">Perfil</h6>
                  <div class="dropdown-divider"></div>
                  <img src="assets/img/vsg/arrow-down.svg" alt="">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <img src="assets/img/vsg/log-out.svg" alt="">
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject mb-1">Log out</p>
                    </div>
                  </a>
              </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
              <span class="mdi mdi-format-line-spacing"></span>
            </button>
          </div>
        </nav>

        <!-- partial -->
        <div class="container-fluid page-body-wrapper">
          <!-- partial:partials/_navbar.html -->
          <nav class="navbar p-0 fixed-top d-flex flex-row">
            <div class="navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center">
              <a class="navbar-brand brand-logo-mini" href="menu.jsp"><img src="assets/images/logo-mini.svg" alt="logo" /></a>
            </div>
            <div class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
              <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                <img src="assets/img/vsg/align-justify (1).svg" alt="">
              </button>
              <ul class="navbar-nav navbar-nav-right">
                <li class="nav-item dropdown">
                  <a class="nav-link" id="profileDropdown" href="#" data-toggle="dropdown">
                    <div class="navbar-profile">
                      <img src="assets/img/vsg/user.svg" alt="">
                      <p class="mb-0 d-none d-sm-block navbar-profile-name">User</p>
                      <i class="mdi mdi-menu-down d-none d-sm-block"></i>
                    </div>
                  </a>
                  <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="profileDropdown">
                    <h6 class="p-3 mb-0">Perfil</h6>
                    <div class="dropdown-divider"></div>
                      <div class="preview-thumbnail">
                        <div class="preview-icon bg-dark rounded-circle">
                          <img src="assets/img/vsg/log-out.svg" alt="">
                        </div>
                      </div>
                      <div class="preview-item-content">
                        <p class="preview-subject mb-1">Log out</p>
                      </div>
                    </a>
                </li>
              </ul>
              <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                <span class="mdi mdi-format-line-spacing"></span>
              </button>
            </div>
          </nav>
  




            <!-- partial -->
            <div class="col-12 grid-margin stretch-card">
                <div class="card">

                    <div class="card-body"><br><br><br>
                        <h4 class="card-title">Editar una nómina</h4>
                        <p class="card-description">Registra una nómina nueva</p>
                        <c:forEach var="NominaA" items="${listar}">
                        <form class="forms-sample" action="nomina" method="post">
                            <div class="form-group">
                                <label for="exampleInputName1">Nombre de la novedad</label>
                                <input type="text" class="form-control" id="exampleInputName1 nombreNovedad" name="nombreNovedad"
                                    placeholder="Puede colocar el nombre de está nueva novedad." value="${NominaA.getNombreNovedad()}">
                            </div>
                          <input type="hidden" class="input1" id="nombreNovedad validationCustom01" name="idNovedad" value="${NominaA.getIdNovedad()}" >
                        
                          <div class="form-group">
                                <label for="exampleInputName1">Valor de la novedad</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text bg-primary text-white">$</span>
                                    </div>
                                    <input type="number" class="form-control" aria-label="Amount (to the nearest dollar)" id="valorNovedad" name="valorNovedad" value="${NominaA.getValorNovedad()}">
                                    <div class="input-group-append">
                                        <span class="input-group-text">.00</span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                              <label for="exampleInputName1">Días de la novedad</label>
                              <input type="number" class="form-control" id="exampleInputName1 diasNovedad"
                                  placeholder="Coloque aquí los días de la novedad" name="diasNovedad" value="${NominaA.getDiasNovedad()}">
                          </div> 

                            <div class="form-group">
                                <label for="exampleSelectGender">Estado en la empresa</label>
                                <select class="form-control" id="exampleSelectGender">
                                    <option value="" selected disabled hidden>Escoje uno aquí</option>
                                    <option name="estadoRol">Activo</option>
                                    <option name="estadoRol">Inactivo</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="exampleInputName1">Tipo de la novedad</label>
                                <input type="text" class="form-control" id="exampleInputName1 tipoNovedad" name="tipoNovedad"
                                    placeholder="Puede colocar el tipo de está nueva novedad." value="${NominaA.getTipoNovedad()}">
                            </div>

                            <button type="submit" class="btn btn-primary mr-2" name="accion" value="edit">Enviar</button>
                            <a href="nomina?accion=listar"><button class="btn btn-dark">Cancelar</button></a>
                        </form>
                    </div>
                  </c:forEach>
                </div>
            </div>

          <!-- container-scroller -->
          <!-- plugins:js -->
          <script src="assets/js/plantilla/vendors/vendor.bundle.base.js"></script>
          <!-- endinject -->
          <!-- Plugin js for this page -->
          <script src="assets/js/plantilla/vendors/select2.min.js"></script>
          <script src="assets/js/plantilla/vendor/typeahead.bundle.min.js"></script>
          <!-- End plugin js for this page -->
          <!-- inject:js -->
          <script src="assets/js/plantilla/JS/off-canvas.js"></script>
          <script src="assets/js/plantilla/JS/hoverable-collapse.js"></script>
          <script src="assets/js/plantilla/JS/misc.js"></script>
          <script src="assets/js/plantilla/JS/settings.js"></script>
          <script src="assets/js/plantilla/JS/todolist.js"></script>
          <!-- endinject -->
          <!-- Custom js for this page -->
          <script src="assets/js/plantilla/JS/typeahead.js"></script>
          <script src="assets/js/plantilla/JS/select2.js"></script>
          <!-- End custom js for this page -->
</body>

</html>