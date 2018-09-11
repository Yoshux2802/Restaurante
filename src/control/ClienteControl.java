package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Cliente;

public class ClienteControl implements Control<Cliente> {

	private Conexion conexion;
	
	public ClienteControl(Conexion conexion) {
		this.conexion = conexion;
	}

	@Override
	public ArrayList<Cliente> list() throws Throwable {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente> ();
		
		ResultSet rs;
		conexion.SQL("SELECT * FROM cliente");
		rs = conexion.resultSet();
		
		while(rs.next()) {
			
			int idCliente = rs.getInt("idCliente");
			String nombre = rs.getString("nombre");
			int ci = rs.getInt("ci");
			int telefono = rs.getInt("telefono");
			Date fechaNaci = rs.getDate("fechaNaci");
			
			Cliente cliente = new Cliente (idCliente,nombre,"",ci,telefono,fechaNaci);
			clientes.add(cliente);
		}
			
		
		return clientes;
	}

	@Override
	public void insert(Cliente entity) throws Throwable {
		
		conexion.SQL("INSERT INTO cliente(nombre,apellido,ci,telefono,fechaNaci) VALUES(?,?,?,?,?)");
		conexion.preparedStatement().setString(1, entity.getNombre());
		conexion.preparedStatement().setString(2, entity.getApellido());
		conexion.preparedStatement().setInt(3, entity.getCi());
		conexion.preparedStatement().setInt(4, entity.getTelefono());
		conexion.preparedStatement().setDate(5, entity.getFechaNaci());
		conexion.CUD();
	}

	@Override
	public void search(Cliente entity) throws Throwable {
		
		ResultSet rs;
		
		conexion.SQL("SELECT * FROM cliente WHERE idCliente=? ");	
		conexion.preparedStatement().setInt(1, entity.getIdCliente());
		rs = conexion.resultSet();
		
		
		while(rs.next()) {
			
			entity.setNombre(rs.getString("nombre"));
			entity.setApellido(rs.getString("apellido"));
			entity.setCi(rs.getInt("ci"));
			entity.setTelefono(rs.getInt("telefono"));
			entity.setFechaNaci(rs.getDate("fechaNaci"));
		}
		rs.close();
	}

	@Override
	public void update(Cliente entity) throws Throwable {
		
		if(entity != null) {
			
			int idCliente = entity.getIdCliente();
			String nombre = entity.getNombre();
			String apellido = entity.getApellido();
			int ci = entity.getCi();
			int telefono = entity.getTelefono();
			Date fechaNaci = entity.getFechaNaci();
			
			conexion.SQL("UPDATE cliente SET nombre =?, apellido =?, ci=?, telefono=?, fechaNaci=? WHERE idCliente =?");
			
			conexion.preparedStatement().setString(1,nombre);
			conexion.preparedStatement().setString(2,apellido);
			conexion.preparedStatement().setInt(3,ci);
			conexion.preparedStatement().setInt(4,telefono);
			conexion.preparedStatement().setDate(5,fechaNaci);
			conexion.preparedStatement().setInt(6, idCliente);
			conexion.CUD();
			
			
			
			
			
			
			
		}
		
	}

}
