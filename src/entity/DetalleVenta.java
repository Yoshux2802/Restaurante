package entity;

public class DetalleVenta {

	private int idDetalleVenta;
	private int idVenta;
	private int idPlato;
	private int cantidad;
	public DetalleVenta(int idDetalleVenta, int idVenta, int idPlato, int cantidad) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.idVenta = idVenta;
		this.idPlato = idPlato;
		this.cantidad = cantidad;
	}
	
	
	public DetalleVenta(int cantidad) {
		super();
		this.cantidad = cantidad;
	}


	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}
	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdPlato() {
		return idPlato;
	}
	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "DetalleVenta [idDetalleVenta=" + idDetalleVenta + ", idVenta=" + idVenta + ", idPlato=" + idPlato
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
}
