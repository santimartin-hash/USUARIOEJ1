package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloUsuario;
import modelo.Rol;
import modelo.Usuario;

/**
 * Servlet implementation class ModificarUsuarios
 */
@WebServlet("/ModificarUsuarios")
public class ModificarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Recuperar el ID del usuario de la solicitud
	    int id = Integer.parseInt(request.getParameter("id"));

	    // Obtener los datos del usuario del modelo
	    ModeloUsuario modeloUsuario = new ModeloUsuario();
	    modeloUsuario.conectar();
	    Usuario usuario;
		try {
			usuario = modeloUsuario.getUsuario(id);
			 request.setAttribute("usuario", usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    modeloUsuario.cerrar();
	   
		
	
		ArrayList<Rol> roles = new ArrayList<Rol>();
		
		modeloUsuario.conectar();
		try {
			roles = modeloUsuario.getRoles();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modeloUsuario.cerrar();
		
		request.setAttribute("roles", roles);
	
		
	    // Despachar la solicitud a la vista "ModificarUsuario.jsp"
	    RequestDispatcher dispatcher = request.getRequestDispatcher("ModificarUsuario.jsp");
	    dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = new Usuario();
		int id = Integer.parseInt(request.getParameter("id"));
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
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setContraseña(contraseña);
		usuario.setId_rol(id_rol);

	
		try {
			modeloUsuario.modificarUsuario(usuario);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modeloUsuario.cerrar();
		
		response.sendRedirect("verUsuarios");
		
	
		
		
	}

}
