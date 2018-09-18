package entity;

public class DetalleCompra {
	
	private int idDetalleCompra;
	private int idInsumo;
	private int idCompra;
	private int cantidad;
	public DetalleCompra(int idDetalleCompra, int idInsumo, int idCompra, int cantidad) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.idInsumo = idInsumo;
		this.idCompra = idCompra;
		this.cantidad = cantidad;
	}
	
	public DetalleCompra(int idInsumo, int idCompra, int cantidad) {
		super();
		this.idInsumo = idInsumo;
		this.idCompra = idCompra;
		this.cantidad = cantidad;
	}

	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}
	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}
	public int getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "DetalleCompra [idDetalleCompra=" + idDetalleCompra + ", idInsumo=" + idInsumo + ", idCompra=" + idCompra
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
	
}