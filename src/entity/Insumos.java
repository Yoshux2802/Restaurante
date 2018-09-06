package entity;

public class Insumos {
	
	private int IdInsumo;
	private String nombre;
	private int cantidad;
	private int unidad;
	public Insumos(int idInsumo, String nombre, int cantidad, int unidad) {
		super();
		IdInsumo = idInsumo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.unidad = unidad;
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getUnidad() {
		return unidad;
	}
	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}
	@Override
	public String toString() {
		return "Insumos [IdInsumo=" + IdInsumo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", unidad=" + unidad
				+ "]";
	}
	
	

}
