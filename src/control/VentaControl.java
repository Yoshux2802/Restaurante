package control;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Venta;

public class VentaControl implements Control<Venta> {

	private Conexion conexion;

	public VentaControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> listaVenta = new ArrayList<Venta>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM VENTA");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idVenta = rs.getInt("idVenta");
			int idCliente = rs.getInt("idCliente");
			int idEmpleado = rs.getInt("idEmpleado");
			int numeroVenta = rs.getInt("numeroVenta");

			listaVenta.add(new Venta(idVenta, idCliente, idEmpleado, numeroVenta));
		}

		return listaVenta;
	}

	public void insert(Venta venta) throws Throwable {
		conexion.SQL("INSERT INTO VENTA(idCliente, idEmpleado, numeroVenta) VALUES(?, ?, ?)");
		conexion.preparedStatement().setInt(1, venta.getIdCliente());
		conexion.preparedStatement().setInt(2, venta.getIdEmpleado());
		conexion.preparedStatement().setInt(3, venta.getNumeroVenta());
		conexion.CUD();
	}

	public void search(Venta venta) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM VENTA WHERE idVenta=?");
		conexion.preparedStatement().setInt(1, venta.getIdVenta());

		rs = conexion.resultSet();

		while (rs.next()) {
			venta.setIdCliente(rs.getInt("idCliente"));
			venta.setIdEmpleado(rs.getInt("idEmpleado"));
			venta.setNumeroVenta(rs.getInt("numeroVenta"));
		}

		rs.close();
	}

	public void update(Venta venta) throws Throwable {
		if(venta != null) {
			int idVenta = venta.getIdVenta();
			
			conexion.SQL("UPDATE VENTA SET idCliente = ?, idEmpleado = ?, numeroVenta = ? WHERE idVenta = ?");
			conexion.preparedStatement().setInt(1, venta.getIdCliente());
			conexion.preparedStatement().setInt(2, venta.getIdEmpleado());
			conexion.preparedStatement().setInt(3, venta.getNumeroVenta());
			conexion.preparedStatement().setInt(4, idVenta);
			conexion.CUD();
		}
	}

}