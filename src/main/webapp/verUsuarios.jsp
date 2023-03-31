<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Página Principal</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Página Principal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<a class="nav-link" href="CerrarSession">Cerrar Sesión</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container my-3">
		<div class="row justify-content-between">
			<div class="col-auto">
				<h1>Opciones de Administrador:</h1>
			</div>
			<div class="col-auto">
				<a href="InsertarUsuario" class="btn btn-success">Insertar</a>
			</div>
		</div>
		<table class="table table-dark table-striped mt-3">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nombre</th>
					<th scope="col">Rol</th>
					<th scope="col">Fecha</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nombre}</td>
						<td>${usuario.rol_nombre}</td>
						<td>${usuario.fecha}</td>
						<td>
							<a href="verUsuario?id=${usuario.id}" class="btn btn-success">Ver</a>
							<a href="ModificarUsuarios?id=${usuario.id}" class="btn btn-primary">Modificar</a>
							<a href="EliminarUsuario?id=${usuario.id}" class="btn btn-danger">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-hrYrYwUCn0jzZaieafSEaQeZoViEy5d5I9BXAk8WLy03jmdvmb0z+gKL5xM8WFG4" crossorigin="anonymous"></script>
</body>
</html>