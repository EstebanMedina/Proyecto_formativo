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
                <li class="nav-item"> <a class="nav-link" href="concepto?accion=Registro"><img src="assets/img/vsg/calendar.svg" alt="">| Agregar una nómina</a></li>
                <li class="nav-item"> <a class="nav-link" href="concepto?accion=Consultar"><img src="assets/img/vsg/clipboard.svg" alt="">| Consultar una nómina</a></li>
              </ul>
            </div>
          </li>

          <!-- Usuario -->
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <img src="assets/img/vsg/user.svg" alt="">
              </span>
              <span class="menu-title">Usuarios</span>
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
              <span class="menu-title">Reportes</span>
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
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject mb-1"><a href="index.jsp">Cerrar Sesion</a> </p>
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
        <div class="main-panel">
          <div class="content-wrapper">
            <h1>Consultar rápidas</h1>
            <div class="row">
              <div class="col-xl-3 col-sm-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="row">
                      <div class="col-8">
                        <div class="d-flex align-items-center align-self-start">
                          <h4 class="mb-0 asd"><a href="empleado?accion=listar">Empleados</a></h4>
                        </div>
                      </div>
                      <div class="col-3">
                        <div class="icon icon-box-success ">
                          <img src="assets/img/vsg/user.svg" alt="">
                        </div>
                      </div>
                      <h6 class="text-muted font-weight-normal">Aquí podras consultar todos los empleados</h6>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xl-3 col-sm-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="row">
                      <div class="col-8">
                        <div class="d-flex align-items-center align-self-start">
                          <h4 class="mb-0 asd"><a href="nomina?accion=listar">Novedades</a></h4>
                        </div>
                      </div>
                      <div class="col-3">
                        <div class="icon icon-box-success">
                          <img src="assets/img/vsg/dollar-sign.svg" alt="">
                        </div>
                      </div>
                      <h6 class="text-muted font-weight-normal">Aquí podras consultar todos las novedades</h6>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-xl-3 col-sm-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="row">
                      <div class="col-8">
                        <div class="d-flex align-items-center align-self-start">
                          <h3 class="mb-0 asd"><a href="concepto?accion=Consultar">Nómina</a></h3>
                        </div>
                      </div>
                      <div class="col-3">
                        <div class="icon icon-box-success">
                          <img src="assets/img/vsg/clipboard.svg" alt="">
                        </div>
                      </div>
                    </div>
                    <h6 class="text-muted font-weight-normal">Aquí podras consultar todas las nominas</h6>
                  </div>
                </div>
              </div>
              <div class="col-xl-3 col-sm-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="row">
                      <div class="col-9">
                        <div class="d-flex align-items-center align-self-start">
                          <h3 class="mb-0 asd"><a href="usuario?accion=Listar">Usuario</a></h3>
                        </div>
                      </div>
                      <div class="col-3">
                        <div class="icon icon-box-success ">
                          <img src="assets/img/vsg/users.svg" alt="">
                        </div>
                      </div>
                    </div>
                    <h6 class="text-muted font-weight-normal">Aquí podras consultar todos los empleados</h6>
                  </div>
                </div>
              </div>
            </div>





            <div class="row">
              <div class="col-md-4 grid-margin stretch-card">
                <div class="card">
                  <img src="assets/img/logo-removebg-preview.png" alt="">
                </div>
              </div>
              <div class="col-md-8 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="d-flex flex-row justify-content-between">
                      <h4 class="card-title mb-1">Open Projects</h4>
                    </div>
                    <div class="row">
                      <div class="col-12">
                        <div class="preview-list">
                          <div class="preview-item border-bottom">
                            <div class="preview-thumbnail">
                              <div class="preview-icon bg-primary">
                                <img src="assets/img/vsg/clipboard.svg" alt="">
                              </div>
                            </div>
                            <div class="preview-item-content d-sm-flex flex-grow">
                              <div class="flex-grow">
                                <h6 class="preview-subject">Admin dashboard design</h6>
                                <p class="text-muted mb-0">Broadcast web app mockup</p>
                              </div>
                            </div>
                          </div>
                          <div class="preview-item border-bottom">
                            <div class="preview-thumbnail">
                              <div class="preview-icon bg-success">
                                <img src="assets/img/vsg/clipboard.svg" alt="">
                              </div>
                            </div>
                            <div class="preview-item-content d-sm-flex flex-grow">
                              <div class="flex-grow">
                                <h6 class="preview-subject">Wordpress Development</h6>
                                <p class="text-muted mb-0">Upload new design</p>
                              </div>
                            </div>
                          </div>
                          <div class="preview-item border-bottom">
                            <div class="preview-thumbnail">
                              <div class="preview-icon bg-info">
                                <img src="assets/img/vsg/clipboard.svg" alt="">
                              </div>
                            </div>
                            <div class="preview-item-content d-sm-flex flex-grow">
                              <div class="flex-grow">
                                <h6 class="preview-subject">Project meeting</h6>
                                <p class="text-muted mb-0">New project discussion</p>
                              </div>
                            </div>
                          </div>
                          <div class="preview-item border-bottom">
                            <div class="preview-thumbnail">
                              <div class="preview-icon bg-danger">
                                <img src="assets/img/vsg/clipboard.svg" alt="">
                              </div>
                            </div>
                            <div class="preview-item-content d-sm-flex flex-grow">
                              <div class="flex-grow">
                                <h6 class="preview-subject">Broadcast Mail</h6>
                                <p class="text-muted mb-0">Sent release details to team</p>
                              </div>
                            </div>
                          </div>
                          <div class="preview-item">
                            <div class="preview-thumbnail">
                              <div class="preview-icon bg-warning">
                                <img src="assets/img/vsg/clipboard.svg" alt="">
                              </div>
                            </div>
                            <div class="preview-item-content d-sm-flex flex-grow">
                              <div class="flex-grow">
                                <h6 class="preview-subject">UI Design</h6>
                                <p class="text-muted mb-0">New application planning</p>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>


            <!-- Cargos -->
            <div class="row">
              <div class="col-md-6 col-xl-4 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <div class="d-flex flex-row justify-content-between">
                      <h4 class="card-title">Cargos de la empresa</h4>
                    </div>
                    <div class="preview-list">
                      <div class="preview-item border-bottom">
                        <div class="preview-thumbnail">
                          <img src="assets/img/vsg/user.svg" alt="image" class="rounded-circle" />
                        </div>
                        <div class="preview-item-content d-flex flex-grow">
                          <div class="flex-grow">
                            <div class="d-flex d-md-block d-xl-flex justify-content-between">
                              <h6 class="preview-subject">Leonard</h6>
                            </div>
                            <p class="text-muted">Well, it seems to be working now.</p>
                          </div>
                        </div>
                      </div>
                      <div class="preview-item border-bottom">
                        <div class="preview-thumbnail">
                          <img src="assets/img/vsg/user.svg" alt="image" class="rounded-circle" />
                        </div>
                        <div class="preview-item-content d-flex flex-grow">
                          <div class="flex-grow">
                            <div class="d-flex d-md-block d-xl-flex justify-content-between">
                              <h6 class="preview-subject">Luella Mills</h6>
                            </div>
                            <p class="text-muted">Well, it seems to be working now.</p>
                          </div>
                        </div>
                      </div>
                      <div class="preview-item border-bottom">
                        <div class="preview-thumbnail">
                          <img src="assets/img/vsg/user.svg" alt="image" class="rounded-circle" />
                        </div>
                        <div class="preview-item-content d-flex flex-grow">
                          <div class="flex-grow">
                            <div class="d-flex d-md-block d-xl-flex justify-content-between">
                              <h6 class="preview-subject">Ethel Kelly</h6>
                            </div>
                            <p class="text-muted">Please review the tickets</p>
                          </div>
                        </div>
                      </div>
                      <div class="preview-item border-bottom">
                        <div class="preview-thumbnail">
                          <img src="assets/img/vsg/user.svg" alt="image" class="rounded-circle" />
                        </div>
                        <div class="preview-item-content d-flex flex-grow">
                          <div class="flex-grow">
                            <div class="d-flex d-md-block d-xl-flex justify-content-between">
                              <h6 class="preview-subject">Herman May</h6>
                            </div>
                            <p class="text-muted">Thanks a lot. It was easy to fix it .</p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>


              <!-- Imagenes para desplegar -->
              <div class="col-md-6 col-xl-4 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Fotos</h4>
                    <div class="owl-carousel owl-theme full-width owl-carousel-dash portfolio-carousel" id="owl-carousel-basic">
                      <div class="item">
                        <img src="assets/img/logo-removebg-preview.png" alt="">
                      </div>
                      <div class="item">
                        <img src="assets/img/fondo1E.jpg" alt="">
                      </div>
                      <div class="item">
                        <img src="assets/img/fondo2E.jpg" alt="">
                      </div>
                    </div>
                    <br><br>
                    <p class="text-muted">¡Aquí pueden escribir lo que quieran!. </p>
                    <div class="progress progress-md portfolio-progress">
                      <div class="progress-bar bg-success" role="progressbar" style="width: 50%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                  </div>
                </div>
              </div>



              <div class="col-md-12 col-xl-4 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Lista de tareas para hoy</h4>
                    <div class="add-items d-flex">
                      <input type="text" class="form-control todo-list-input" placeholder="Escribe tu tarea aquí...">
                      <button class="add btn btn-primary todo-list-add-btn">Agregar</button>
                    </div>
                    <div class="list-wrapper">
                      <ul class="d-flex flex-column-reverse text-white todo-list todo-list-custom">
                        
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2022</span>
              <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Todos los derechos para <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Servicios y soluciones integrados SAS</a>.</span>
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->

	<script src="assets/js/plantilla/vendors/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
	<script src="assets/js/plantilla/vendors/Chart.min.js"></script>
	<script src="assets/js/plantilla/vendors/progressbar.min.js"></script>
	<script src="assets/js/plantilla/vendors/jquery-jvectormap.min.js"></script>
	<script src="assets/js/plantilla/vendors/jquery-jvectormap-world-mill-en.js"></script>
	<script src="assets/js/plantilla/vendors/owl.carousel.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
	<script src="assets/js/plantilla/JS/off-canvas.js"></script>
	<script src="assets/js/plantilla/JS/hoverable-collapse.js"></script>
	<script src="assets/js/plantilla/JS/misc.js"></script>
	<script src="assets/js/plantilla/JS/settings.js"></script>
	<script src="assets/js/plantilla/JS/todolist.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
	<script src="assets/js/plantilla/JS/dashboard.js"></script>
    <!-- End custom js for this page -->
  </body>
</html>