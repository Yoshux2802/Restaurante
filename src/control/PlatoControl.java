package control;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Plato;

public class PlatoControl implements Control<Plato> {

	private Conexion conexion;

	public PlatoControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Plato> list() throws Throwable {
		ArrayList<Plato> listaPlato = new ArrayList<Plato>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM PLATO");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idPlato = rs.getInt("idPlato");
			int idReceta = rs.getInt("idReceta");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");

			listaPlato.add(new Plato(idPlato, idReceta, nombre, precio));
		}

		return listaPlato;
	}

	public void insert(Plato plato) throws Throwable {
		conexion.SQL("INSERT INTO PLATO(idReceta, nombre, precio) VALUES(?, ?, ?)");
		conexion.preparedStatement().setInt(1, plato.getIdReceta());
		conexion.preparedStatement().setString(2, plato.getNombre());
		conexion.preparedStatement().setDouble(3, plato.getPrecio());
		conexion.CUD();
	}

	public void search(Plato plato) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM PLATO WHERE idPlato=?");
		conexion.preparedStatement().setInt(1, plato.getIdPlato());

		rs = conexion.resultSet();

		while (rs.next()) {
			plato.setIdReceta(rs.getInt("idReceta"));
			plato.setNombre(rs.getString("nombre"));
			plato.setPrecio(rs.getDouble("precio"));
		}

		rs.close();
	}

	public void update(Plato plato) throws Throwable {
		if(plato != null) {
			int idPlato = plato.getIdPlato();
			
			conexion.SQL("UPDATE PLATO SET idReceta = ?, nombre = ?, precio = ? WHERE idPlato = ?");
			conexion.preparedStatement().setInt(1, plato.getIdReceta());
			conexion.preparedStatement().setString(2, plato.getNombre());
			conexion.preparedStatement().setDouble(3, plato.getPrecio());
			conexion.preparedStatement().setInt(4, idPlato);
			conexion.CUD();
		}
	}

}