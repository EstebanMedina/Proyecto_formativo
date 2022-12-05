<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"   rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/est.css">
<body background="assets/img/fondo3Em.jpg">

		<nav id="mainNav">
			<div class="inicio">
				<center>
			   <h1 class="disco1">LISTA </h1>
			</center>
			 </div>
		
		   </nav>
      
<center>
<div class="tabla">
	<table border="2px"class="ss">
	  <thead class="ss">
			<tr>
                <th scope="col">ID</th>
                <th scope="col">Nombre Novedad</th>
                <th scope="col">Fecha Novedad</th>
                <th scope="col">Dias Novedad</th>
                <th scope="col">Salario Base</th>
                <th scope="col">Censatias</th>
                <th scope="col">Dias trabajados</th>x
                <th scope="col">Salud</th>
                <th scope="col">Pension</th>
                <th scope="col">Sena</th>
                <th scope="col">Seguridad Social</th>
                <th scope="col">Tipo Concepto</th>
                <th scope="col">Empleado</th>
                <th align="center"><em class="fa fa-cog"> Acciones</em></th>
                <th scope="col">Volver</th>
			</tr>
			<c:forEach var="Concepto" items="${listars}">         
		</thead>
		<tbody>
			<tr>
                <td>${Concepto.getIdConcepto()}</td>
                <td>${Concepto.getSalarioBaseLista()}</td>
                <td>${Concepto.getDiasTrabajados()}</td>
                <td>${Concepto.getSalarioBase()}</td>
                <td>${Concepto.getSalud()}</td>
                <td>${Concepto.getPension()}</td>
                <td>${Concepto.getSena()}</td>
                <td>${Concepto.getSeguridadSocial()}</td>
                <c:if test="${Concepto.getIdEmpleado() == 1}">
                    <td>
                        Juan
                    </td>
                </c:if>

		<td align="center">
			<a href="concepto?accion=Editar&id=${Concepto.getIdConcepto()}"class="btn btn-danger"><em class="fa fa-pencil"><button type="button" class="button">Editar</button></em></a>
			<a href="concepto?accion=Eliminar&id=${Concepto.getIdConcepto()}" class="btn btn-default"><em class="fa fa-trash"><button type="button" class="button">Eliminar</button></em></a>
		  </td>

			<td>
				<a href="menu.jsp"><button type="button" class="button">Inicio</button></a>
			</td>
			<tr>		
			</tr>	
        </c:forEach>  
		</tbody>
	</table>
</div>
</center>
</body>