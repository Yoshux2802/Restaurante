package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Factura;

public class FacturaControl implements Control<Factura> {

	private Conexion conexion;

	public FacturaControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Factura> list() throws Throwable {
		ArrayList<Factura> listaFactura = new ArrayList<Factura>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM FACTURA");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idVenta = rs.getInt("idVenta");
			Date fecha = rs.getDate("fecha");
			double precioTot = rs.getDouble("precioTot");

			listaFactura.add(new Factura(idVenta, fecha, precioTot));
		}

		return listaFactura;
	}

	public void insert(Factura factura) throws Throwable {
		conexion.SQL("INSERT INTO FACTURA(fecha, precioTot) VALUES(?, ?)");
		conexion.preparedStatement().setDate(1, factura.getFecha());
		conexion.preparedStatement().setDouble(2, factura.getPrecioTot());
		conexion.CUD();
	}

	public void search(Factura factura) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM FACTURA WHERE idVenta=?");
		conexion.preparedStatement().setInt(1, factura.getIdVenta());

		rs = conexion.resultSet();

		while (rs.next()) {
			factura.setFecha(rs.getDate("fecha"));
			factura.setPrecioTot(rs.getDouble("precioTot"));
		}

		rs.close();
	}

	public void update(Factura factura) throws Throwable {
		if(factura != null) {
			int idVenta = factura.getIdVenta();
			
			conexion.SQL("UPDATE FACTURA SET fecha = ?, precioTot = ? WHERE idVenta = ?");
			conexion.preparedStatement().setDate(1, factura.getFecha());
			conexion.preparedStatement().setDouble(2, factura.getPrecioTot());
			conexion.preparedStatement().setInt(3, idVenta);
			conexion.CUD();
		}
	}

}