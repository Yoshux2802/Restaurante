package control;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Receta;

public class RecetaControl implements Control<Receta> {

	private Conexion conexion;

	public RecetaControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Receta> list() throws Throwable {
		ArrayList<Receta> listaReceta = new ArrayList<Receta>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM RECETA");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idReceta = rs.getInt("idReceta");
			String descripcion = rs.getString("descripcion");

			listaReceta.add(new Receta(idReceta, descripcion));
		}

		return listaReceta;
	}

	public void insert(Receta receta) throws Throwable {
		conexion.SQL("INSERT INTO RECETA(descripcion) VALUES(?)");
		conexion.preparedStatement().setString(1, receta.getDescripcion());
		conexion.CUD();
	}

	public void search(Receta receta) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM RECETA WHERE idReceta=?");
		conexion.preparedStatement().setInt(1, receta.getIdReceta());

		rs = conexion.resultSet();

		while (rs.next()) {
			receta.setDescripcion(rs.getString("descripcion"));
		}

		rs.close();
	}

	public void update(Receta receta) throws Throwable {
		if(receta != null) {
			int idReceta = receta.getIdReceta();

			conexion.SQL("UPDATE RECETA SET descripcion = ? WHERE idReceta = ?");
			conexion.preparedStatement().setString(1, receta.getDescripcion());
			conexion.preparedStatement().setInt(2, idReceta);
			conexion.CUD();
		}
	}

}