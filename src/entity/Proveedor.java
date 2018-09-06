package entity;

public class Proveedor {

	private int idProveedor;
	private String nombre;
	private int telefono;
	public Proveedor(int idProveedor, String nombre, int telefono) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	
	
	
}
