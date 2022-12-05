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
				<th scope="col">Id </th>
				<th scope="col">Nombre</th>
				<th scope="col">Estado</th>
				<th scope="col">Cambiar estado</th>
                <th align="center"><em class="fa fa-cog"> Acciones</em></th>
                <th scope="col">Volver</th>
			</tr>
			<c:forEach var="rolA" items="${listar}">         
		</thead>
		<tbody>
			<tr>
                <td>${rolA.getIdRol()}</td>
				<td>${rolA.getNombreRol()}</td>
				<c:if test="${rolA.isEstadoRol() == true}">
           <td><span>Rol Activo</span></td> 
        </c:if>
        <c:if test="${rolA.isEstadoRol() == false}">
            <td><span></span>Rol Inactivo</span></td> 
        </c:if>
		<c:if test="${rolA.isEstadoRol() == true}">
			<td>
				<a href="rol?accion=estado&id=${rolA.getIdRol()}&estado=false"><button type="button" class="button">Inactivar</button></a>
			</td>
		</c:if>

		<c:if test="${rolA.isEstadoRol() == false}">
			<td>
				<a href="rol?accion=estado&id=${rolA.getIdRol()}&estado=true"><button type="button" class="button">Activar</button></a>
			</td>
		</c:if>
		<td align="center">
			<a href="rol?accion=editar&idRol=${rolA.getIdRol()}"class="btn btn-danger"><em class="fa fa-pencil"><button type="button" class="button">Editar</button></em></a>
			<a href="rol?accion=eliminar&idRol=${rolA.getIdRol()}" class="btn btn-default"><em class="fa fa-trash"><button type="button" class="button">Eliminar</button></em></a>
		  </td>

			<td>
				<a href="menu.jsp"><button type="button" class="button">Inicio</button></a>
			</td>
			<tr>		
	</c:forEach>    
			</tr>	
		</tbody>
	</table>
</div>
</center>
</body>