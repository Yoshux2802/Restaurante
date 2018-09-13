package entity;

import java.sql.Date;

public class Factura {
	
	private int idVenta;
	private Date fecha;
	private double precioTot;
	public Factura(int idVenta, Date fecha, double precioTot) {
		super();
		this.idVenta = idVenta;
		this.fecha = fecha;
		this.precioTot = precioTot;
	}
	
	
	public Factura(Date fecha, double precioTot) {
		super();
		this.fecha = fecha;
		this.precioTot = precioTot;
	}


	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getPrecioTot() {
		return precioTot;
	}
	public void setPrecioTot(double precioTot) {
		this.precioTot = precioTot;
	}
	@Override
	public String toString() {
		return "Factura [idVenta=" + idVenta + ", fecha=" + fecha + ", precioTot=" + precioTot + "]";
	}
	
}	
	