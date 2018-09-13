package entity;

public class Insumo {
	
	private int IdInsumo;
	private String nombre;
	private int precio;
	public Insumo(int idInsumo, String nombre, int precio) {
		super();
		IdInsumo = idInsumo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Insumo(String nombre, int precio) {
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Insumo [IdInsumo=" + IdInsumo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	
	
}	