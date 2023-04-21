package Controlador;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class verUsuarios
 */
@WebServlet("/verUsuarios")
public class verUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
		
		if (usuariologueado == null) {//no logeado
			response.sendRedirect("Login");
		} else {//si esta logueado
		
		if (usuariologueado.getId_rol() == 2) {
			
		
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		modeloUsuario.conectar();
		try {
			usuarios = modeloUsuario.getUsuarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		modeloUsuario.cerrar();
		
		request.setAttribute("usuarios", usuarios);
		
		
		request.getRequestDispatcher("verUsuarios.jsp").forward(request, response);
		
		} else {
			response.sendRedirect("verUsuariosCliente");
		}
		
	}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
