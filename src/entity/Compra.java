package entity;

import java.sql.Date;

public class Compra {

	private int idCompra;
	private Date fecha;
	private int idProveedor;
	public Compra(int idCompra, Date fecha, int idProveedor) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.idProveedor = idProveedor;
	}
	
	
	public Compra(Date fecha, int idProveedor) {
		super();
		this.fecha = fecha;
		this.idProveedor = idProveedor;
	}


	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
