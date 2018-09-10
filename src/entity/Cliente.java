package entity;

import java.sql.Date;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String apellido;
	private int ci;
	private int telefono;
	private Date fechaNaci;
	
	public Cliente(int idCliente, String nombre, String apellido, int ci, int telefono, Date fechaNaci) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
		this.telefono = telefono;
		this.fechaNaci = fechaNaci;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
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
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", ci=" + ci
				+ ", telefono=" + telefono + ", fechaNaci=" + fechaNaci + "]";
	}
	
	

}
