package view;

import java.io.IOException;

import control.Conexion;
import control.InsumoControl;
import entity.Insumo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InsumoControlador {
	
	@FXML
	private Pane panel;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtPrecio;
	
	public void initialize() {

	}
	
	public void ingresar (ActionEvent event) {		
		Pane pane;
		try {
			newInsumo();
			System.out.println("Insumo registrado+");
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmPedidos.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		public void newInsumo () {
			String nombre = txtNombre.getText().toString();
			double precio = Double.parseDouble(txtPrecio.getText().toString());
			
			Insumo insumo = new Insumo(nombre,precio);
			InsumoControl control = new InsumoControl(new Conexion());
			try {
				control.insert(insumo);
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
