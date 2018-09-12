package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Compra;

public class CompraControl implements Control<Compra>{
	
	private Conexion conexion;

	public CompraControl(Conexion conexion) {
		super();
		this.conexion = conexion;
	}

	@Override
	public ArrayList<Compra> list() throws Throwable {
		
		ArrayList<Compra> compras = new ArrayList<Compra>();
		
		ResultSet rs;
		conexion.SQL("SELECT * FROM compra");
		rs = conexion.resultSet();
		
		while(rs.next()) {
			
			int idCompra = rs.getInt("idCompra");
			Date fecha = rs.getDate("fecha");
			int idProveedor = rs.getInt("idProveedor");
			
			Compra compra = new Compra (idCompra,fecha,idProveedor);
			compras.add(compra);
		}
		
		return compras;
	}

	@Override
	public void insert(Compra entity) throws Throwable {
		conexion.SQL("INSERT INTO compra (fecha,idProveedor) VALUES(?,?)");
		conexion.preparedStatement().setDate(1,entity.getFecha());
		conexion.preparedStatement().setInt(2,entity.getIdProveedor());
		conexion.CUD();
	}

	@Override
	public void search(Compra entity) throws Throwable {
		
		ResultSet rs;
		
		conexion.SQL("SELECT * FROM Compra WHERE idCompra=? ");	
		conexion.preparedStatement().setInt(1, entity.getIdCompra());
		rs = conexion.resultSet();
		
		
		while(rs.next()) {
			
			entity.setFecha(rs.getDate("fecha"));
			entity.setIdCompra(rs.getInt("idCompra"));
		}
		rs.close();
	}

	@Override
	public void update(Compra entity) throws Throwable {
		
		if(entity != null) {
			
			int idCompra = entity.getIdCompra();
			Date fecha = entity.getFecha();
			int idProveedor = entity.getIdProveedor();
			
			conexion.SQL("UPDATE compra SET fecha =?,idProveedor =? WHERE idCompra");
			conexion.preparedStatement().setDate(1,fecha);
			conexion.preparedStatement().setInt(2, idProveedor);
			conexion.preparedStatement().setInt(3,idCompra);
			conexion.CUD();
			
		}
		
	}

}
