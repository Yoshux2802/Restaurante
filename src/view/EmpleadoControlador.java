package view;

import java.io.IOException;
import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;

import control.Conexion;
import control.EmpleadoControl;
import entity.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EmpleadoControlador {
	
	@FXML
	private Pane panel;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtTelefono;
	@FXML
	private DatePicker dtFecha;
	@FXML
	private TextField txtContrasena;
	@FXML
	private Label lbId;
	
	public void initialize() {
		EmpleadoControl control = new EmpleadoControl(new Conexion());
		try {
			ArrayList<Empleado> empleados = control.list();
			int cantidad = empleados.size() + 1;
			System.out.println(cantidad);
			lbId.setText(cantidad + "");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ingresar (ActionEvent event) {		
		Pane pane;
		try {
			newEmpleado();
			System.out.println("Empleado registrado+");
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("App.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void newEmpleado () {
		String nombre = txtNombre.getText().toString();
		String apellido = txtApellido.getText().toString();
		int telefono = Integer.parseInt(txtTelefono.getText().toString());
		Date fecha = new java.sql.Date(Date.from(dtFecha.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());
		String contrasena = txtContrasena.getText().toString();
		Empleado empleado = new Empleado(nombre,apellido,telefono,fecha,contrasena);
		EmpleadoControl control = new EmpleadoControl(new Conexion());
		try {
			ArrayList<Empleado> empleados = control.list();
			control.insert(empleado);
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
