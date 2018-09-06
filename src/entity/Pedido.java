package entity;

public class Pedido {
	
	private int idPedido;
	private int idCliente;
	private String dirrecion;
	private int numeroCasa;
	public Pedido(int idPedido, int idCliente, String dirrecion, int numeroCasa) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.dirrecion = dirrecion;
		this.numeroCasa = numeroCasa;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDirrecion() {
		return dirrecion;
	}
	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", idCliente=" + idCliente + ", dirrecion=" + dirrecion
				+ ", numeroCasa=" + numeroCasa + "]";
	}
	
	
	

}
