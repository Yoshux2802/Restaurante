package view;

import java.io.IOException;
import java.sql.Date;
import java.time.ZoneId;

import control.ClienteControl;
import control.Conexion;
import entity.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClienteControlador {

	@FXML
	private Pane panel;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtApellido;

	@FXML
	private TextField txtCi;

	@FXML
	private TextField txtTelefono;

	@FXML
	private DatePicker txtFechaNacimiento;

	public void initialize() {

	}

	public void ingresar (ActionEvent event) {		
		Pane pane;
		try {
			newCliente();
			System.out.println("Cliente registrado+");
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmPedidos.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void newCliente () {
		String nombre = txtNombre.getText().toString();
		String apellido = txtApellido.getText().toString();
		int ci = Integer.parseInt(txtCi.getText().toString());
		int telefono = Integer.parseInt(txtTelefono.getText().toString());
		Date fechaNacimiento = new java.sql.Date(Date.from(txtFechaNacimiento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());

		Cliente cliente = new Cliente(nombre,apellido,ci,telefono,fechaNacimiento);
		ClienteControl control = new ClienteControl(new Conexion());
		try {
			control.insert(cliente);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void atras(ActionEvent event) {

		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmPedidos.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
