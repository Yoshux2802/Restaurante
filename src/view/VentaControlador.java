package view;

import java.io.IOException;
import java.util.ArrayList;

import control.ClienteControl;
import control.Conexion;
import control.DetalleVentaControl;
import control.EmpleadoControl;
import control.InsumoControl;
import control.PlatoControl;
import control.VentaControl;
import entity.Cliente;
import entity.DetalleVenta;
import entity.Empleado;
import entity.Insumo;
import entity.Plato;
import entity.Venta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VentaControlador {

	@FXML
	private Pane panel;
	@FXML
	private ComboBox<String> cb_Plato;
	@FXML
	private TextField txtCantidad;
	@FXML
	private Label lb_lista;
	@FXML
	private ComboBox<String> cb_Empleado;
	@FXML
	private ComboBox<String> cb_Cliente;
	@FXML
	private Label lb_NumeroVenta;

	private ArrayList<Plato> platos;
	private ArrayList<Cliente> clientes;
	private ArrayList<Empleado> empleados;

	private int numeroVenta;

	private ArrayList<String> platosVenta;
	private ArrayList<String> cantidadVenta;

	public void initialize() {

		platosVenta = new ArrayList<>();
		cantidadVenta = new ArrayList<>();
		
		Conexion c = new Conexion();

		numeroVenta = 1;
		lb_NumeroVenta.setText(String.valueOf(numeroVenta));

		ClienteControl clienteControl = new ClienteControl(c);
		PlatoControl platoControl = new PlatoControl(c);
		EmpleadoControl empleadoControl = new EmpleadoControl(c);

		try {
			platos = platoControl.list();
			for(int i = 0; i < platos.size(); i++) {
				cb_Plato.getItems().add(platos.get(i).getNombre());	
			}

			clientes = clienteControl.list();
			for(int i = 0; i < clientes.size(); i++) {
				cb_Cliente.getItems().add(clientes.get(i).getNombre() + " " + clientes.get(i).getApellido());
			}

			empleados = empleadoControl.list();
			for(int i = 0; i < empleados.size(); i++) {
				cb_Empleado.getItems().add(empleados.get(i).getNombre() + " " +empleados.get(i).getApellido());
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void atras (ActionEvent event) {

		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmPlato.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void anadir () {
		String nombrePlato = cb_Plato.getValue().toString();		
		String cantidad = txtCantidad.getText().toString();

		lb_lista.setText(lb_lista.getText() + "\n" +nombrePlato + " " + cantidad);
		platosVenta.add(nombrePlato);
		cantidadVenta.add(cantidad);
	}

	public void ingresar() { 	
		String[] nombreEmpleado = cb_Empleado.getValue().toString().split(" ");
		String[] nombreCliente = cb_Cliente.getValue().toString().split(" ");

		int idEmpleado = -1;
		int idCliente = -1;

		for(int i = 0; i < empleados.size(); i++) {
			if(empleados.get(i).getNombre().equals(nombreEmpleado[0]) && empleados.get(i).getApellido().equals(nombreEmpleado[1])) {
				idEmpleado = empleados.get(i).getIdEmpleado();
			}
		}

		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getNombre().equals(nombreCliente[0]) && clientes.get(i).getApellido().equals(nombreCliente[1])) {
				idCliente = clientes.get(i).getIdCliente();
			}
		}

		Venta venta = new Venta(idCliente, idEmpleado, numeroVenta++);

		VentaControl ventaControl = new VentaControl(new Conexion());
		DetalleVentaControl detalleVentaControl = new DetalleVentaControl(new Conexion());
		
		try {
			ventaControl.insert(venta);
			ArrayList<Venta> ventas = ventaControl.list();
			int idVenta = ventas.get(ventas.size() - 1).getIdVenta();

			for(int i = 0; i < platosVenta.size(); i++) {
				for(int j = 0; j < platos.size(); j++) {
					if(platosVenta.get(i).equals(platos.get(j).getNombre())) {
						int idPlato = platos.get(j).getIdPlato();
						int cantidad = Integer.parseInt(cantidadVenta.get(j));
						
						DetalleVenta detalleVenta = new DetalleVenta(idVenta,idPlato,cantidad);
						
						detalleVentaControl.insert(detalleVenta);
					}
				}
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}



}