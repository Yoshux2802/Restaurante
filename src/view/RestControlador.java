package view;

import java.io.IOException;

import control.ClienteControl;
import control.CompraControl;
import control.Conexion;
import entity.Cliente;
import entity.Compra;
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
	@FXML
	public void validar(ActionEvent event){
		
		String usuario = txtUsuario.getText().toString();
		String contrasena = txtContrasena.getText().toString();
	
		if (usuario.equals("")){
			if (contrasena.equals("")) {
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
				

			System.out.println("Correcto");	
			}	
		}
	}
	
}
