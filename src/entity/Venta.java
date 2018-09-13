package entity;

public class Venta {

	private int idVenta;
	private int idCliente;
	private int idEmpleado;
	private int numeroVenta;
	public Venta(int idVenta, int idCliente, int idEmpleado, int numeroVenta) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idEmpleado = idEmpleado;
		this.numeroVenta = numeroVenta;
	}

	public Venta(int numeroVenta) {
		super();
		this.numeroVenta = numeroVenta;
	}

	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getNumeroVenta() {
		return numeroVenta;
	}
	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado
				+ ", numeroVenta=" + numeroVenta + "]";
	}



}
