<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "modelo.Usuario" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>verUsuario</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card mt-5">
          <div class="card-header">
            <h4>Información de usuario</h4>
          </div>
          <div class="card-body">
            <div class="form-group">
              <label for="id">ID:</label>
              <p class="form-control-static" id="id"><%out.print(usuario.getId()); %></p>
            </div>
            <div class="form-group">
              <label for="nombre">Nombre:</label>
              <p class="form-control-static" id="nombre"><%out.print(usuario.getNombre()); %></p>
            </div>
            <div class="form-group">
              <label for="nombre">Contraseña:</label>
              <p class="form-control-static" id="nombre"><%out.print(usuario.getContraseña()); %></p>
            </div>
            <div class="form-group">
              <label for="nombre">Fecha Nacimiento:</label>
              <p class="form-control-static" id="nombre"><%out.print(usuario.getFecha()); %></p>
            </div>
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