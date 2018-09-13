package control;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Insumo;

public class InsumoControl implements Control<Insumo> {

	private Conexion conexion;

	public InsumoControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Insumo> list() throws Throwable {
		ArrayList<Insumo> listaInsumo = new ArrayList<Insumo>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM INSUMO");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idInsumo = rs.getInt("idInsumo");
			String nombre = rs.getString("nombre");
			double precio = rs.getInt("precio");

			listaInsumo.add(new Insumo(idInsumo, nombre, precio));
		}

		return listaInsumo;
	}

	public void insert(Insumo insumo) throws Throwable {
		conexion.SQL("INSERT INTO INSUMO(nombre, precio) VALUES(?, ?)");
		conexion.preparedStatement().setString(1, insumo.getNombre());
		conexion.preparedStatement().setDouble(2, insumo.getPrecio());
		conexion.CUD();
	}

	public void search(Insumo insumo) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM INSUMO WHERE idInsumo=?");
		conexion.preparedStatement().setInt(1, insumo.getIdInsumo());

		rs = conexion.resultSet();

		while (rs.next()) {
			insumo.setNombre(rs.getString("nombre"));
			insumo.setPrecio(rs.getInt("precio"));
		}

		rs.close();
	}

	public void update(Insumo insumo) throws Throwable {
		if(insumo != null) {
			int idInsumo = insumo.getIdInsumo();
			
			conexion.SQL("UPDATE INSUMO SET nombre = ?, precio = ? WHERE idInsumo = ?");
			conexion.preparedStatement().setString(1, insumo.getNombre());
			conexion.preparedStatement().setDouble(2, insumo.getPrecio());
			conexion.preparedStatement().setInt(3, idInsumo);
			conexion.CUD();
		}
	}

}