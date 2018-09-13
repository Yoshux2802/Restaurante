package control;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Empleado;

public class EmpleadoControl implements Control<Empleado> {

	private Conexion conexion;

	public EmpleadoControl(Conexion conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Empleado> list() throws Throwable {
		ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();
		ResultSet rs;

		conexion.SQL("SELECT * FROM EMPLEADO");

		rs = conexion.resultSet();

		while (rs.next()) {
			int idEmpleado = rs.getInt("idEmpleado");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int telefono = rs.getInt("telefono");
			Date fechaNaci = rs.getDate("fechaNaci");
			String contrasena = rs.getString("contrasena");

			listaEmpleado.add(new Empleado(idEmpleado, nombre, apellido, telefono, fechaNaci,contrasena));
		}

		return listaEmpleado;
	}

	public void insert(Empleado empleado) throws Throwable {
		conexion.SQL("INSERT INTO EMPLEADO(nombre, apellido, telefono, fechaNaci,contrasena) VALUES(?, ?, ?, ?, ?)");
		conexion.preparedStatement().setString(1, empleado.getNombre());
		conexion.preparedStatement().setString(2, empleado.getApellido());
		conexion.preparedStatement().setInt(3, empleado.getTelefono());
		conexion.preparedStatement().setDate(4, empleado.getFechaNaci());
		conexion.preparedStatement().setString(5, empleado.getContrasena());
		conexion.CUD();
	}

	public void search(Empleado empleado) throws Throwable {
		ResultSet rs;

		conexion.SQL("SELECT * FROM EMPLEADO WHERE idEmpleado=?");
		conexion.preparedStatement().setInt(1, empleado.getIdEmpleado());

		rs = conexion.resultSet();

		while (rs.next()) {
			empleado.setNombre(rs.getString("nombre"));
			empleado.setApellido(rs.getString("apellido"));
			empleado.setTelefono(rs.getInt("telefono"));
			empleado.setFechaNaci(rs.getDate("fechaNaci"));
			empleado.setContrasena(rs.getString("contrasena"));
		}

		rs.close();
	}

	public void update(Empleado empleado) throws Throwable {
		if(empleado != null) {
			int idEmpleado = empleado.getIdEmpleado();
			
			conexion.SQL("UPDATE EMPLEADO SET nombre = ?, apellido = ?, telefono = ?, fechaNaci = ?, contrasena = ? WHERE idEmpleado = ?");
			conexion.preparedStatement().setString(1, empleado.getNombre());
			conexion.preparedStatement().setString(2, empleado.getApellido());
			conexion.preparedStatement().setInt(3, empleado.getTelefono());
			conexion.preparedStatement().setDate(4, empleado.getFechaNaci());
			conexion.preparedStatement().setString(5, empleado.getContrasena());
			conexion.preparedStatement().setInt(6,idEmpleado);
			conexion.CUD();
		}
	}

}