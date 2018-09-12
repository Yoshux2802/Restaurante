package entity;

import java.sql.Date;

public class Empleado {
	
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private int telefono;
	private Date fechaNaci;
	public Empleado(int idEmpleado, String nombre, String apellido, int telefono, Date fechaNaci) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNaci = fechaNaci;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNaci() {
		return fechaNaci;
	}
	public void setFechaNaci(Date fechaNaci) {
		this.fechaNaci = fechaNaci;
	}
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", fechaNaci=" + fechaNaci + "]";
	}
	
	

}
