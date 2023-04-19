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
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Rol;
import modelo.Usuario;

/**
 * Servlet implementation class RegistrarUsuario
 */
@WebServlet("/RegistrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = new Usuario();
	
		String nombre = request.getParameter("username");
		String contraseña = request.getParameter("password");
		
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
			modeloUsuario.insertarUsuario(usuario);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modeloUsuario.cerrar();
		
		String ContraseñaBBDD;
		
		
		
		
		modeloUsuario.conectar();
		

			try {
				ContraseñaBBDD = modeloUsuario.getContraseña(nombre);
				
				if (contraseña.equals(ContraseñaBBDD)) {
					
					
					Usuario usuariologeado = modeloUsuario.getUsuarioNombre(nombre);
					
					HttpSession session = request.getSession();
					
					session.setAttribute("usuariologeado", usuariologeado);
					
					response.sendRedirect("verUsuarios");
				} else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			modeloUsuario.cerrar();
		
	}

}
