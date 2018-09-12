package control;

import java.sql.ResultSet;
import java.util.ArrayList;

import entity.DetalleCompra;

public class DetalleCompraControl implements Control<DetalleCompra> {

	private Conexion conexion;

	public DetalleCompraControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<DetalleCompra> list() throws Throwable {
		ArrayList<DetalleCompra> listaDetalleCompra = new ArrayList<DetalleCompra>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM DETALLECOMPRA");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idInsumo = rs.getInt("idInsumo");
			int idCompra = rs.getInt("idCompra");
			int cantidad = rs.getInt("cantidad");

			listaDetalleCompra.add(new DetalleCompra(idInsumo, idCompra, cantidad));
		}

		return listaDetalleCompra;
	}

	public void insert(DetalleCompra detallecompra) throws Throwable {
		conexion.SQL("INSERT INTO DETALLECOMPRA(idCompra, cantidad) VALUES(?, ?)");
		conexion.preparedStatement().setInt(1, detallecompra.getIdCompra());
		conexion.preparedStatement().setInt(2, detallecompra.getCantidad());
		conexion.CUD();
	}

	public void search(DetalleCompra detallecompra) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM DETALLECOMPRA WHERE idInsumo=?");
		conexion.preparedStatement().setInt(1, detallecompra.getIdInsumo());

		rs = conexion.resultSet();

		while (rs.next()) {
			detallecompra.setIdCompra(rs.getInt("idCompra"));
			detallecompra.setCantidad(rs.getInt("cantidad"));
		}

		rs.close();
	}

	public void update(DetalleCompra detallecompra) throws Throwable {
		if(detallecompra != null) {
			int idInsumo = detallecompra.getIdInsumo();

			conexion.SQL("UPDATE DETALLECOMPRA SET idCompra = ?, cantidad = ? WHERE idInsumo = ?");
			conexion.preparedStatement().setInt(1, detallecompra.getIdCompra());
			conexion.preparedStatement().setInt(2, detallecompra.getCantidad());
			conexion.preparedStatement().setInt(3, idInsumo);
			conexion.CUD();
		}
	}

}