package modelo;

import java.sql.Date;

public class Usuario {
private int id;
private String Nombre;
private String Contraseña;
private Date fecha;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
@Override
public String toString() {
	return id + Nombre;
}
public String getContraseña() {
	return Contraseña;
}
public void setContraseña(String contraseña) {
	Contraseña = contraseña;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}

}
