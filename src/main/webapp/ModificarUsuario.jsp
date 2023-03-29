<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>ModificarUsuario</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card mt-5">
          <div class="card-header">
            <h4>Información de usuario</h4>
          </div>
          <div class="card-body">
            <form method="post" action="ModificarUsuarios">
            <div class="form-group">
                <label for="nombre">Id:</label>
               <input type="hidden" value="${usuario.id}" id="id" name="id">
    			<span class="form-control" id="id-display">${usuario.id}</span>
              </div>
              <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input value = "${usuario.nombre}" type="text" class="form-control" id="nombre" name="nombre">
              </div>
               <div class="form-group">
               <label for="id_rol"></label>
			   <select class="form-control" id="id_rol" name="id_rol">
			 		<option value="0"></option>
						<c:forEach var="roles" items="${roles}">
  							<c:if test="${usuario.id_rol == roles.id}">
    						<option value="${roles.id}" selected>${roles.nombre}</option>
  							</c:if>
  							<c:if test="${usuario.id_rol != roles.id}">
    						<option value="${roles.id}">${roles.nombre}</option>
  							</c:if>
  							
						</c:forEach>	
 				 </select>
              </div>
              <div class="form-group">
                <label for="contrasena">Contraseña:</label>
                <input value = "${usuario.contraseña}" type="text" class="form-control" id="contrasena" name="contrasena">
              </div>
               <div class="form-group">
                <label for="contrasena">Fecha:</label>
                <input value = "${usuario.fecha}" type="date" class="form-control" id="fecha" name="fecha">
              </div>
              <div class="form-group text-center">
                <input type="submit" class="btn btn-primary mr-2" value="Guardar"/>
               <a href ="verUsuarios" class="btn btn-primary mr-2" >Volver</a>
        
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>