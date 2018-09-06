package entity;

public class Compra {

	private int idCompra;
	private int fecha;
	private int idProveedor;
	public Compra(int idCompra, int fecha, int idProveedor) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.idProveedor = idProveedor;
	}
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fecha=" + fecha + ", idProveedor=" + idProveedor + "]";
	}
	
	
	
}
