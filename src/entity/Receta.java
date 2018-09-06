package entity;

public class Receta {

	private int idPlato;
	private int idInsumo;
	private int cantidad;
	public Receta(int idPlato, int idInsumo, int cantidad) {
		super();
		this.idPlato = idPlato;
		this.idInsumo = idInsumo;
		this.cantidad = cantidad;
	}
	public int getIdPlato() {
		return idPlato;
	}
	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
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
		return "Receta [idPlato=" + idPlato + ", idInsumo=" + idInsumo + ", cantidad=" + cantidad + "]";
	}
	
	
	
}
