<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Principal</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<table class="table table-dark">
	<thead>
	  <tr>
	    <th scope="col">Id</th>
	    <th scope="col">Nombre</th>
	    <th scope="col">id_rol</th>
	     <th scope="col">fecha</th>
	    <th scope="col">Acciones <button type="button" class="btn btn-success" style="margin-left: 100px;"><a href="InsertarUsuario" style='text-decoration:none;color:white;(otros)'>Insertar</a></button></th>
	  </tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="usuario">
	 	<tr>
	  		<td>${usuario.id}</td>
	        <td>${usuario.nombre}</td>
	        <td>${usuario.id_rol}</td>
	         <td>${usuario.fecha}</td>
	         <td><button type="button" class="btn btn-success" style="margin-right: 10px;"><a href="verUsuario?id=${usuario.id}" style='text-decoration:none;color:white;(otros)'>Ver</a>
	         </button><button type="button" class="btn btn-primary mr-3" style="margin-right: 10px;"><a href="ModificarUsuarios?id=${usuario.id}" style='text-decoration:none;color:white;(otros)'>Modificar</a></button>
	         <button type="button" class="btn btn-danger mr-3" style="margin-right: 10px;"><a href="EliminarUsuario?id=${usuario.id}" style='text-decoration:none;color:white;(otros)'>Eliminar</a></button></td>
	    </tr>
		</c:forEach>
    </tbody>
</table>
</body>
</html>