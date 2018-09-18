package entity;

public class Receta {

	private int idReceta;
	private String descripcion;
	public Receta(int idReceta, String descripccion) {
		super();
		this.idReceta = idReceta;
		this.descripcion = descripccion;
	}
	
	
	public Receta(String descripcion) {
		super();
		this.descripcion = descripcion;
	}


	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Receta [idReceta=" + idReceta + ", descripccion=" + descripcion + "]";
	}
	
	
	
}
