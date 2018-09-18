package view;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.CompraControl;
import control.Conexion;
import control.DetalleCompraControl;
import control.InsumoControl;
import control.ProveedorControl;
import entity.Compra;
import entity.DetalleCompra;
import entity.Insumo;
import entity.Proveedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CompraControlador {
	@FXML
	private Pane panel;
	@FXML
	private ComboBox cb_proveedor;
	@FXML
	private ComboBox cb_insumo;
	@FXML
	private TextField txtCantidad;

	ArrayList<Insumo> lista;
	ArrayList<Proveedor> lista2;


	public void initialize() {

		Conexion c = new Conexion();

		InsumoControl insumoControl = new InsumoControl(c);
		ProveedorControl proveedorControl = new ProveedorControl(c);
		try {
			lista = insumoControl.list();
			lista2 = proveedorControl.list();			
			for(int i = 0; i < lista.size(); i++) {
				cb_insumo.getItems().add(lista.get(i).getNombre());	
			}
			for(int i = 0 ; i < lista2.size(); i++) {
				cb_proveedor.getItems().add(lista2.get(i).getNombre());
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	public void ingresar (ActionEvent event) {		
		Pane pane;
		try {
			newCompra();
			System.out.println("Insumo registrado+");
			pane = (AnchorPane)FXMLLoader.load(getClass().getResource("frmPedidos.fxml"));
			Scene nuevaEscena = new Scene(pane);
			Stage ventana = (Stage) panel.getScene().getWindow();
			ventana.setScene(nuevaEscena);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void newCompra () {
		
		String nombre = cb_proveedor.getValue().toString();
		String insumo = cb_insumo.getValue().toString();
		int cantidad = Integer.parseInt(txtCantidad.getText().toString());
		
		int codNombre = 0;
		int codInsumo = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			if( lista.get(i).getNombre().equals(insumo)) {
				codInsumo = lista.get(i).getIdInsumo();
			}	
		}
		for (int i = 0 ; i < lista2.size(); i++) {
			if(lista2.get(i).getNombre().equals(nombre)) {
				codNombre = lista2.get(i).getIdProveedor();
			}
		}

		LocalDate localDate = LocalDate.now();
		Date fechaActual = java.sql.Date.valueOf(localDate);
		
		CompraControl controlCompra = new CompraControl(new Conexion());
		Compra compra = new Compra(fechaActual,codNombre);
		
		try {
			controlCompra.insert(compra);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		
		ArrayList<Compra> listacompra;
		try {
			listacompra = controlCompra.list();
			int codigoCompra = listacompra.get(listacompra.size() - 1).getIdCompra();
			
			DetalleCompra det = new DetalleCompra(codInsumo, codigoCompra, cantidad);
			DetalleCompraControl control = new DetalleCompraControl(new Conexion());
			try {
				
				control.insert(det);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
