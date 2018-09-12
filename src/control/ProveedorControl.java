package control;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Proveedor;

public class ProveedorControl implements Control<Proveedor> {

	private Conexion conexion;

	public ProveedorControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Proveedor> list() throws Throwable {
		ArrayList<Proveedor> listaProveedor = new ArrayList<Proveedor>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM PROVEEDOR");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idProveedor = rs.getInt("idProveedor");
			String nombre = rs.getString("nombre");
			int telefono = rs.getInt("telefono");

			listaProveedor.add(new Proveedor(idProveedor, nombre, telefono));
		}

		return listaProveedor;
	}

	public void insert(Proveedor proveedor) throws Throwable {
		conexion.SQL("INSERT INTO PROVEEDOR(nombre, telefono) VALUES(?, ?)");
		conexion.preparedStatement().setString(1, proveedor.getNombre());
		conexion.preparedStatement().setInt(2, proveedor.getTelefono());
		conexion.CUD();
	}

	public void search(Proveedor proveedor) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM PROVEEDOR WHERE idProveedor=?");
		conexion.preparedStatement().setInt(1, proveedor.getIdProveedor());

		rs = conexion.resultSet();

		while (rs.next()) {
			proveedor.setNombre(rs.getString("nombre"));
			proveedor.setTelefono(rs.getInt("telefono"));
		}

		rs.close();
	}

	public void update(Proveedor proveedor) throws Throwable {
		if(proveedor != null) {
			int idProveedor = proveedor.getIdProveedor();

			conexion.SQL("UPDATE PROVEEDOR SET nombre = ?, telefono = ? WHERE idProveedor = ?");
			conexion.preparedStatement().setString(1, proveedor.getNombre());
			conexion.preparedStatement().setInt(2, proveedor.getTelefono());
			conexion.preparedStatement().setInt(3, idProveedor);
			conexion.CUD();
		}
	}

}