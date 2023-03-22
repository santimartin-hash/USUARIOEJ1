package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario extends Connector{
	PreparedStatement pst;
	ResultSet resultado; 
	public ArrayList<Usuario> getUsuarios() throws SQLException {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		

		pst = con.prepareStatement("SELECT * FROM usuarios");
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		while(resultado.next()) {
			
			Usuario usuario = new Usuario();
			
			usuario.setId(resultado.getInt("id"));
			usuario.setNombre(resultado.getString("Nombre"));
		
			usuarios.add(usuario);

		}
		
		
		return usuarios;
		
	}
	
	public void EliminarUsuario(int id) {
		
		try {
			pst = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
			
			pst.setInt(1, id);
			
			pst.execute();	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Usuario getUsuario(int id) throws SQLException {
		
		pst = con.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
		
		pst.setInt(1, id);
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		Usuario usuario = new Usuario();
		
		while(resultado.next()) {	
		
		usuario.setId(resultado.getInt("id"));
		usuario.setNombre(resultado.getString("Nombre"));
		
		}
		return usuario;
	}
}
