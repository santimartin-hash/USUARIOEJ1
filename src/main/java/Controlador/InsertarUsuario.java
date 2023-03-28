package Controlador;

import java.io.IOException;




import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloUsuario;
import modelo.Rol;
import modelo.Usuario;

/**
 * Servlet implementation class InsertarUsuario
 */
@WebServlet("/InsertarUsuario")
public class InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("InsertarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Rol> roles = new ArrayList<Rol>();
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = new Usuario();
	
		String nombre = request.getParameter("nombre");
		String contraseña = request.getParameter("contrasena");
		
		// Obtener la fecha como String desde la solicitud del cliente
		String fechaStr = request.getParameter("fecha");

		// Crear un objeto SimpleDateFormat para el formato de fecha deseado
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

		try {
		    // Parsear la cadena de fecha utilizando el formato especificado
		    Date fecha = formatoFecha.parse(fechaStr);
		    // La fecha se ha convertido en un objeto Dat
			usuario.setFecha(fecha);
		    
		    // Luego, puedes trabajar con el objeto Date como sea necesario
		    
		} catch (ParseException e) {
		    // Manejar cualquier excepción que se genere al parsear la fecha
		    e.printStackTrace();
		}
		int id_rol = Integer.parseInt(request.getParameter("id_rol"));
				
	
		
		modeloUsuario.conectar();
		usuario.setNombre(nombre);
		usuario.setContraseña(contraseña);
		usuario.setId_rol(id_rol);

		try {
			roles = modeloUsuario.getRoles();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("roles", roles);
		try {
			modeloUsuario.insertarUsuario(usuario);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modeloUsuario.cerrar();
		
		response.sendRedirect("verUsuarios");
		
	}

}
