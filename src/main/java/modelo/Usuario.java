package modelo;

public class Usuario {
private int id;
private String Nombre;
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

}
