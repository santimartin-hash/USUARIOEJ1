<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "modelo.ModeloUsuario" %>
<%@ page import = "modelo.Usuario" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<%
ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
%>
<table class="table table-dark">
	<thead>
	  <tr>
	    <th scope="col">Id</th>
	    <th scope="col">Nombre</th>
	    <th scope="col">Acciones</th>
	  </tr>
	</thead>
	<tbody>
<%
for (Usuario u : usuarios) {
    int id = u.getId();
    String nombre = u.getNombre();
    %>
    <tr>
  		<td><%out.print(id); %></td>
        <td><%out.print(nombre); %></td>
         <td><button type="button" class="btn btn-success" style="margin-right: 10px;"><a href="URL" style='text-decoration:none;color:white;(otros)'>Ver</a></button><button type="button" class="btn btn-primary mr-3" style="margin-right: 10px;"><a href="URL" style='text-decoration:none;color:white;(otros)'>Modificar</a></button><button type="button" class="btn btn-danger mr-3" style="margin-right: 10px;"><a href="EliminarUsuario?id=<%out.print(u.getId()); %>" style='text-decoration:none;color:white;(otros)'>Eliminar</a></button></td>
     
    </tr>
<%} %>
    </tbody>
</table>
</body>
</html>