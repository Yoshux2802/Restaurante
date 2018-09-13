package entity;

public class Insumo {
	
	private int IdInsumo;
	private String nombre;
	private double precio;
	public Insumo(int idInsumo, String nombre, double precio) {
		super();
		IdInsumo = idInsumo;
		this.nombre = nombre;
		this.precio = precio;
	}
	public Insumo(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	public int getIdInsumo() {
		return IdInsumo;
	}
	public void setIdInsumo(int idInsumo) {
		IdInsumo = idInsumo;
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
		return "Insumo [IdInsumo=" + IdInsumo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	
}	