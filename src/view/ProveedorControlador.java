package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProveedorControlador {
	
	
	@FXML
	private Pane panel;
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private TextField txtTelefono;
	
	
	public void initialize() {
		
	}
	
	public void ingresar (ActionEvent event) {		
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
	
	public void newProveedor () {
		
		String nombre = txtNombre.getText().toString();
		int telefono = Integer.parseInt(txtTelefono.getText().toString());		
	}
	
}
