package entity;

public class Receta {

	private int idReceta;
	private String descripccion;
	public Receta(int idReceta, String descripccion) {
		super();
		this.idReceta = idReceta;
		this.descripccion = descripccion;
	}
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public String getDescripccion() {
		return descripccion;
	}
	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}
	@Override
	public String toString() {
		return "Receta [idReceta=" + idReceta + ", descripccion=" + descripccion + "]";
	}
	
	
	
}
