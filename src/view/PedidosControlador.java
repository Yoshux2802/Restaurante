package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PedidosControlador {
	
	@FXML
	private Pane panel;
	
	public void cliente (ActionEvent event) {
		System.out.println("HOLA");
		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmCliente.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void comida (ActionEvent event) {		
		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmPlato.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void proveedor (ActionEvent event) {		
		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmProveedor.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receta (ActionEvent event){
		
		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmReceta.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void compra(ActionEvent event) {
		
		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmCompra.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insumo (ActionEvent event) {
		
		Pane pane;
		try {
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmInsumo.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}