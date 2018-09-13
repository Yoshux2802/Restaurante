package entity;

public class RecetaInsumo {
	
	private int idRecetaInsumo;
	private int idReceta;
	private int idInsumo;
	private int cantidad;
	public RecetaInsumo(int idRecetaInsumo, int idReceta, int idInsumo, int cantidad) {
		super();
		this.idRecetaInsumo = idRecetaInsumo;
		this.idReceta = idReceta;
		this.idInsumo = idInsumo;
		this.cantidad = cantidad;
	}
	public RecetaInsumo(int idInsumo, int cantidad) {
		
		this.cantidad = cantidad;
	}
	public int getIdRecetaInsumo() {
		return idRecetaInsumo;
	}
	public void setIdRecetaInsumo(int idRecetaInsumo) {
		this.idRecetaInsumo = idRecetaInsumo;
	}
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public int getIdInsumo() {
		return idInsumo;
	}
	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ResetaInsumo [idRecetaInsumo=" + idRecetaInsumo + ", idReceta=" + idReceta + ", idInsumo=" + idInsumo
				+ ", cantidad=" + cantidad + "]";
	}
	
}
