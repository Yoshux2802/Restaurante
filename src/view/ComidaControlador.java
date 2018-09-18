package view;

import java.io.IOException;
import java.util.ArrayList;

import control.Conexion;
import control.InsumoControl;
import control.PlatoControl;
import control.RecetaControl;
import entity.Insumo;
import entity.Plato;
import entity.Receta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ComidaControlador {
	@FXML
	private Pane panel;
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private TextField txtPrecio;
	
	@FXML
	private ComboBox<String> cb_Descripccion;

	private ArrayList<String>receta;
	
	public void initialize() {
		Conexion c = new Conexion();

		RecetaControl recetaControl = new RecetaControl(c);
		try {
			ArrayList<Receta> lista = recetaControl.list();
			for(int i = 0; i < lista.size(); i++) {
				cb_Descripccion.getItems().add(lista.get(i).getDescripcion());	
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		receta = new ArrayList<String>();
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

	public void ingresar () {
		String nombre = txtNombre.getText();
		String precio = txtPrecio.getText();
		String descripcion = cb_Descripccion.getValue().toString();
		
		ArrayList<Receta> lista = null;
		try {
			lista = new RecetaControl(new Conexion()).list();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		
		int idReceta = -1;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getDescripcion().equals(descripcion)) {
				idReceta = lista.get(i).getIdReceta();
			}
		}
		
		PlatoControl platoControl = new PlatoControl(new Conexion());
		
		Plato plato = new Plato(idReceta, nombre, Double.parseDouble(precio));
		
		try {
			platoControl.insert(plato);
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

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
