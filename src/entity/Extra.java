package entity;

public class Extra {
	
	private int idExtra;
	private int idPlato;
	private String nombre;
	private String descripcion;
	private double precio;
	public Extra(int idExtra, int idPlato, String nombre, String descripcion, double precio) {
		super();
		this.idExtra = idExtra;
		this.idPlato = idPlato;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public int getIdExtra() {
		return idExtra;
	}
	public void setIdExtra(int idExtra) {
		this.idExtra = idExtra;
	}
	public int getIdPlato() {
		return idPlato;
	}
	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Extra [idExtra=" + idExtra + ", idPlato=" + idPlato + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + "]";
	}
	
	

}
