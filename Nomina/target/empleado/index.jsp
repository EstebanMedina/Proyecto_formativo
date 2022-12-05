<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Creative - Start Bootstrap Theme</title>
       	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
 
   <!-- Favicon-->
   <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
   <!-- Font Awesome icons (free version)-->
   <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
   <!-- Simple line icons-->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" />
   <!-- Google fonts-->
   <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
   <!-- Core theme CSS (includes Bootstrap)-->
   <link rel="stylesheet" href="assets/css/login1.css">
   <link href="assets/css/styles.css" rel="stylesheet" />

        

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap Icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- SimpleLightbox plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="assets/css/login1.css">
        <link rel="stylesheet" href="assets/css/styles1.css">
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#page-top"></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto my-2 my-lg-0">
                        <li class="nav-item"><a class="nav-link" href="#">Inicio</a></li>
                        <li class="nav-item"><a class="nav-link" href="#services">Servicios</a></li>
                        <li class="nav-item"><a class="nav-link" href="#portfolio">Nosotros</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contact">Contactanos</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container px-4 px-lg-5 h-100">
                <div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
                    <div class="col-lg-8 align-self-end">
                        <h1 class="text-white font-weight-bold">Servicios y soluciones integrados S.A.S</h1>
                        <hr class="divider" />
                    </div>
                    <div class="col-lg-8 align-self-baseline">
                        <p class="text-white-75 mb-5"></p>
                        <a class="btn btn-primary btn-xl" href="#about">  INICIAR SESIÓN</a>
                    </div>
                </div>
            </div>
        </header>
 

        <!-- Contact-->
        <section class="page-section bg-primary" id="about">
        <section class="page-section" id="contact">
            <div>
                <div class="d-flex justify-content-center h-100">
                     <div class="user_card">
                        <div class="wrapper1">
                            <div class="wrapper">
                                <div class="logo">
                                    <img src="assets/img/logo-removebg-preview.png" alt="">
                                </div>
                                <div class="text-center mt-4 name">
                                   INICIO DE SESION
                                </div>
                                <form action="login" method="POST" class="p-3 mt-3">
                                    <div class="form-field d-flex align-items-center">
                                        <span class="far fa-user"></span>
                                        <input type="text" name="correo" placeholder="Username">
                                    </div>
                                    <div class="form-field d-flex align-items-center">
                                        <span class="fas fa-key"></span>
                                        <input type="password" name="ingreso" placeholder="Password">
                                    </div>
                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="customControlInline">
                                            <label class="custom-control-label" for="customControlInline">Recuerdame</label>
                                        </div>
                                    </div>
                                    <input type="submit" name="Botoncito" value="Ingresar" class="btn btn-block btn-primary">
                                </form>
                                <br>
                                
                                <div class="text-center fs-6">
                                    <a href="#">¿Contraseña olvidada?</a>
                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
            </div>
        </section>
        <br>
        <br>
    </section>
        <!-- Footer-->

        <footer class="footer text-center">
            <div class="container px-4 px-lg-5">
                <ul class="list-inline mb-5">
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white mr-3" href="https://www.facebook.com/profile.php?id=100037187124306"><i class="icon-social-facebook"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white mr-3" href="https://mobile.twitter.com/s_integrados/with_replies"><i class="icon-social-twitter"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a class="social-link rounded-circle text-white" href="data:image/jpeg;base64,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"><i class="icon-social-github"></i></a>
                    </li>
                </ul>
                <p class="text-muted small mb-0">Copyright &copy; Your Website 2022</p>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- SimpleLightbox plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>

