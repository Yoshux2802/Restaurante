package control;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.RecetaInsumo;

public class RecetaInsumoControl implements Control<RecetaInsumo> {

	private Conexion conexion;

	public RecetaInsumoControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<RecetaInsumo> list() throws Throwable {
		ArrayList<RecetaInsumo> listaRecetaInsumo = new ArrayList<RecetaInsumo>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM RECETAINSUMO");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idRecetaInsumo = rs.getInt("idRecetaInsumo");
			int idReceta = rs.getInt("idReceta");
			int idInsumo = rs.getInt("idInsumo");
			int cantidad = rs.getInt("cantidad");

			listaRecetaInsumo.add(new RecetaInsumo(idRecetaInsumo, idReceta, idInsumo, cantidad));
		}

		return listaRecetaInsumo;
	}

	public void insert(RecetaInsumo recetainsumo) throws Throwable {
		conexion.SQL("INSERT INTO RECETAINSUMO(idReceta, idInsumo, cantidad) VALUES(?, ?, ?)");
		conexion.preparedStatement().setInt(1, recetainsumo.getIdReceta());
		conexion.preparedStatement().setInt(2, recetainsumo.getIdInsumo());
		conexion.preparedStatement().setInt(3, recetainsumo.getCantidad());
		conexion.CUD();
	}

	public void search(RecetaInsumo recetainsumo) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM RECETAINSUMO WHERE idRecetaInsumo=?");
		conexion.preparedStatement().setInt(1, recetainsumo.getIdRecetaInsumo());

		rs = conexion.resultSet();

		while (rs.next()) {
			recetainsumo.setIdReceta(rs.getInt("idReceta"));
			recetainsumo.setIdInsumo(rs.getInt("idInsumo"));
			recetainsumo.setCantidad(rs.getInt("cantidad"));
		}

		rs.close();
	}

	public void update(RecetaInsumo recetainsumo) throws Throwable {
		if(recetainsumo != null) {
			int idRecetaInsumo = recetainsumo.getIdRecetaInsumo();

			conexion.SQL("UPDATE RECETAINSUMO SET idReceta = ?, idInsumo = ?, cantidad = ? WHERE idRecetaInsumo = ?");
			conexion.preparedStatement().setInt(1, recetainsumo.getIdReceta());
			conexion.preparedStatement().setInt(2, recetainsumo.getIdInsumo());
			conexion.preparedStatement().setInt(3, recetainsumo.getCantidad());
			conexion.preparedStatement().setInt(4, idRecetaInsumo);
			conexion.CUD();
		}
	}

}