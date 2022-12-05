<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Reporte</title>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>Corona Admin</title>
      <!-- plugins:css -->
      <link rel="stylesheet" href="assets/css/plantilla/vendors/materialdesignicons.min.css">
      <link rel="stylesheet" href="assets/css/plantilla/vendors/vendor.bundle.base.css">
      <link rel="stylesheet" href="assets/css/estilos.css">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <!--El script de la librería-->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js" integrity="sha512-GsLlZN/3F2ErC5ifS5QtgpiJtWd43JWSuIgh7mbzZ8zBps+dvLusV+eNQATqgA/HdeKFVgA5v3S/cIrLF7QnIg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
      <!--Nuestro script, que se encarga de crear el PDF usando la librería-->
      <script src="assets/js/scriptpdf.js"></script>
    </head>

    <body>
          <!-- Tabla -->
          <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
              <div class="card-body"><br><br><br>
                <h1>Tabla de nómina</h1>
                </p>
                <br>
                <h3>Reporte de Nomina</h3>
                <br>
                <center>
                <button id="btnCrearPdf" type="button" class="btn btn-outline-danger">Generar PDF</button>
                <a href="menu.jsp"><button type="button" class="btn btn-outline-primary">Volver</button></a>
              </center>
              <br>
                <div>
                  <table>
                    <thead class="ss">
                        <tr>
                            <th>Nombre Empleado</th> 
                            <th>Documento empleado</th>
                            <th>Nombre novedad</th>
                            <th>Fecha novedad</th>
                            <th>Valor novedad</th>
                            <th>Días novedad</th>
                            <th>Salario base</th>
                            <th>Cesantías</th>
                            <th>Días trabajados</th>
                            <th>Salud</th>
                            <th>Pensión</th>
                            <th>Sena</th>
                            <th>Seguridad social</th>
                            <th>Valor Total N</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="Concepto" items="${nomina}">
                        <tr>
                            <td>${Concepto.getnombreEmpleado()}</td>
                            <td>${Concepto.getDocumentoEmpleado()}</td>
                            <td>${Concepto.getNombreNovedad()}</td>
                            <td>${Concepto.getFechaNovedad()}</td>
                            <td>${Concepto.getValorNovedad()}</td>
                            <td>${Concepto.getDiasNovedad()}</td>
                            <td>${Concepto.getSalarioBase()}</td>
                            <td>${Concepto.getCesantias()}</td>
                            <td>${Concepto.getDiasTrabajados()}</td>
                            <td>${Concepto.getSalud()}</td>
                            <td>${Concepto.getPension()}</td>
                            <td>${Concepto.getSena()}</td>
                            <td>${Concepto.getSeguridadSocial()}</td>
                            <td>${Concepto.getValorTotal()}</td>
                    </c:forEach>  
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
    </body>

    </html>