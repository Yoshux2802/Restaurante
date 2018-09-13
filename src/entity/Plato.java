package entity;

public class Plato {

	private int idPlato;
	private int idReceta;
	private String nombre;
	private double precio;
	public Plato(int idPlato, int idReceta, String nombre, double precio) {
		super();
		this.idPlato = idPlato;
		this.idReceta = idReceta;
		this.nombre = nombre;
		this.precio = precio;
	}
	public Plato(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}


	public int getIdPlato() {
		return idPlato;
	}
	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", idReceta=" + idReceta + ", nombre=" + nombre + ", precio=" + precio
				+ "]";
	}
	
	
}
