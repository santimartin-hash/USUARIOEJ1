package Controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Usuario;

/**
 * Servlet implementation class verUsuariosCliente
 */
@WebServlet("/verUsuariosCliente")
public class verUsuariosCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verUsuariosCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Usuario usuariologueado = (Usuario) session.getAttribute("usuariologeado");
		
		if (usuariologueado == null) {//no logeado
			response.sendRedirect("Login");
		} else {//si esta logueado
			request.setAttribute("usuariologeado", usuariologueado);
			
			ModeloUsuario modeloUsuario = new ModeloUsuario();
			
			modeloUsuario.conectar();
		
			
			try {
				usuariologueado = modeloUsuario.getUsuario(usuariologueado.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			modeloUsuario.cerrar();
			
			request.setAttribute("usuario", usuariologueado);
			
			request.getRequestDispatcher("verUsuariosCliente.jsp").forward(request, response);
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
