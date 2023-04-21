package modelo;



import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloUsuario extends Connector{
	PreparedStatement pst;
	ResultSet resultado; 
	
	
	public ArrayList<Usuario> getUsuarios() throws SQLException {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		

		pst = con.prepareStatement("SELECT u.*, r.nombre AS rol_nombre FROM usuarios u JOIN roles r ON u.id_rol = r.id");
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		while(resultado.next()) {
			
			Usuario usuario = new Usuario();
			
			usuario.setId(resultado.getInt("id"));
			usuario.setId_rol(resultado.getInt("id_rol"));
			usuario.setNombre(resultado.getString("Nombre"));
			usuario.setFecha(resultado.getDate("fecha"));
			usuario.setRol_nombre(resultado.getString("rol_nombre"));
			usuarios.add(usuario);

		}
		
		
		return usuarios;
		
	}
public ArrayList<Rol> getRoles() throws SQLException {
		
		ArrayList<Rol> roles = new ArrayList<Rol>();
		

		pst = con.prepareStatement("SELECT * FROM roles");
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		while(resultado.next()) {
			
			Rol rol = new Rol();
			
			rol.setId(resultado.getInt("id"));
			rol.setNombre(resultado.getString("Nombre"));
			roles.add(rol);

		}
	
		return roles;	
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
	
public String getContraseña(String nombre) throws SQLException {
		
		pst = con.prepareStatement("SELECT contraseña FROM usuarios WHERE nombre=? ");
		
		pst.setString(1, nombre);
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		Usuario usuario = new Usuario();
		
		while(resultado.next()) {	
		usuario.setContraseña(resultado.getString("Contraseña"));
		}
		
		return usuario.getContraseña();
	}
	
	
	public Usuario getUsuario(int id) throws SQLException {
		
		pst = con.prepareStatement("SELECT u.*, r.nombre AS rol_nombre FROM usuarios u JOIN roles r ON u.id_rol = r.id WHERE u.id = ?");
		
		pst.setInt(1, id);
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		Usuario usuario = new Usuario();
		
		while(resultado.next()) {	
		
		usuario.setId(resultado.getInt("id"));
		usuario.setNombre(resultado.getString("Nombre"));
		usuario.setContraseña(resultado.getString("Contraseña"));
		usuario.setFecha(resultado.getDate("fecha"));
		usuario.setId_rol(resultado.getInt("id_rol"));
		usuario.setRol_nombre(resultado.getString("rol_nombre"));
		}
		
		return usuario;
	}
	
	public Usuario getUsuarioLogin(String nombre, String contraseña) throws SQLException {
		
		pst = con.prepareStatement("SELECT u.*, r.nombre AS rol_nombre FROM usuarios u JOIN roles r ON u.id_rol = r.id WHERE u.nombre = ? AND u.contraseña = ?");
		
		pst.setString(1, nombre);
		pst.setString(2, contraseña);
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		Usuario usuario = new Usuario();
		
		while(resultado.next()) {	
		
		usuario.setId(resultado.getInt("id"));
		usuario.setNombre(resultado.getString("Nombre"));
		usuario.setContraseña(resultado.getString("Contraseña"));
		usuario.setFecha(resultado.getDate("fecha"));
		usuario.setId_rol(resultado.getInt("id_rol"));
		usuario.setRol_nombre(resultado.getString("rol_nombre"));
		}
		
		return usuario;
	}
	
public Usuario getUsuarioNombre(String nombre) throws SQLException {
		
		pst = con.prepareStatement("SELECT u.*, r.nombre AS rol_nombre FROM usuarios u JOIN roles r ON u.id_rol = r.id WHERE u.nombre = ?");
		
		pst.setString(1, nombre);
		
		pst.executeQuery();

		resultado = pst.executeQuery();
		
		Usuario usuario = new Usuario();
		
		while(resultado.next()) {	
		
		usuario.setId(resultado.getInt("id"));
		usuario.setNombre(resultado.getString("Nombre"));
		usuario.setContraseña(resultado.getString("Contraseña"));
		usuario.setFecha(resultado.getDate("fecha"));
		usuario.setId_rol(resultado.getInt("id_rol"));
		usuario.setRol_nombre(resultado.getString("rol_nombre"));
		}
		
		return usuario;
	}
	
	public void insertarUsuario(Usuario usuario) throws SQLException {
		pst = con.prepareStatement("INSERT INTO usuarios( Nombre, Contraseña,id_rol,Fecha) VALUES (?,?,?,?)");
		
		pst.setString(1, usuario.getNombre());
		pst.setString(2, usuario.getContraseña());
		pst.setInt(3, usuario.getId_rol());
		pst.setDate(4, new Date(usuario.getFecha().getTime()));
		pst.execute();
	}
	public void modificarUsuario(Usuario usuario) throws SQLException {
		pst = con.prepareStatement("UPDATE usuarios SET id_rol=?,Nombre=?,Contraseña=?,Fecha=? WHERE id = ?");
		
		pst.setInt(1, usuario.getId_rol());
		pst.setString(2, usuario.getNombre());
		pst.setString(3, usuario.getContraseña());
		pst.setDate(4, new Date(usuario.getFecha().getTime()));
		pst.setInt(5, usuario.getId());
		pst.execute();
	}
}
