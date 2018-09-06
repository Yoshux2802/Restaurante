package entity;

public class Factura {
	
	private int idFactura;
	private String nombre;
	private String apellidos;
	private double precioUni;
	private double precioTot;
	public Factura(int idFactura, String nombre, String apellidos, double precioUni, double precioTot) {
		super();
		this.idFactura = idFactura;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.precioUni = precioUni;
		this.precioTot = precioTot;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public double getPrecioUni() {
		return precioUni;
	}
	public void setPrecioUni(double precioUni) {
		this.precioUni = precioUni;
	}
	public double getPrecioTot() {
		return precioTot;
	}
	public void setPrecioTot(double precioTot) {
		this.precioTot = precioTot;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", nombre=" + nombre + ", apellidos=" + apellidos + ", precioUni="
				+ precioUni + ", precioTot=" + precioTot + "]";
	}
	
	
	

}
