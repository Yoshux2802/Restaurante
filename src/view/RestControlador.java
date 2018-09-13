package view;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.ClienteControl;
import control.CompraControl;
import control.Conexion;
import control.EmpleadoControl;
import entity.Cliente;
import entity.Compra;
import entity.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RestControlador {

	@FXML
	private Pane panel;

	@FXML
	private TextField txtUsuario;

	@FXML
	private TextField txtContrasena;

	@FXML
	private Button botonValidar;

	@FXML
	public void initialize() {
	}

	public void validar(ActionEvent event){

		int id = Integer.parseInt(txtUsuario.getText().toString());
		String contrasena = txtContrasena.getText().toString();

		EmpleadoControl control = new EmpleadoControl(new Conexion());
		try {
			ArrayList<Empleado> empleados = control.list();
			for(int i = 0; i < empleados.size();i++) {
				int idEmp = empleados.get(i).getIdEmpleado();
				String cont = empleados.get(i).getContrasena();
				if(id == idEmp && contrasena.equals(cont)) {
					Pane pane;
					try {
						pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmPedidos.fxml"));
						Scene nuevaEscena = new Scene(pane);
						Stage ventana = (Stage) panel.getScene().getWindow();
						ventana.setScene(nuevaEscena);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
		}

	}


	public void nuevo () {

		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmEmpleado.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Correcto");	
	}	


}


