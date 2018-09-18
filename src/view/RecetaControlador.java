package view;

import java.io.IOException;
import java.util.ArrayList;

import control.Conexion;
import control.InsumoControl;
import control.RecetaControl;
import entity.Insumo;
import entity.Receta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RecetaControlador {


	@FXML
	private Pane panel;
	@FXML
	private ComboBox cb_Insumo;
	@FXML 
	private TextField txtCantidad;
	@FXML
	private Button btnAtras;
	@FXML
	private Button btnAnadir;
	@FXML
	private Button btnIngresar;
	@FXML
	private Label lbReceta;

	private ArrayList<String>insumo;
	private ArrayList<String>cantidad;

	public void initialize() {

		Conexion c = new Conexion();

		InsumoControl insumoControl = new InsumoControl(c);
		try {
			ArrayList<Insumo> lista = insumoControl.list();
			for(int i = 0; i < lista.size(); i++) {
				cb_Insumo.getItems().add(lista.get(i).getNombre());	
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		insumo = new ArrayList<String>();
		cantidad = new ArrayList<String>();
	}

	public void newReceta ( ) {
		String descripcion = lbReceta.getText().toString();

		Receta receta = new Receta(descripcion);
		RecetaControl recetaControl = new RecetaControl(new Conexion());
		try {
			recetaControl.insert(receta);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void atras (ActionEvent event) {

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

	public void anadir () {

		String ins = cb_Insumo.getValue().toString();
		String cant = txtCantidad.getText().toString();

		insumo.add(ins);
		cantidad.add(cant);

		lbReceta.setText("");
		for(int i = 0; i < insumo.size(); i++) {
			lbReceta.setText(lbReceta.getText().toString() + " " + cantidad.get(i).toString() + " " + insumo.get(i).toString());
		}
	}

	public void ingresar () {
		
		newReceta();
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

	public void limpiar() {
		lbReceta.setText("");
		insumo.clear();
		cantidad.clear();
	}
}
