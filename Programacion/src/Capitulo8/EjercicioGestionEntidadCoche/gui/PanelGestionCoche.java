package Capitulo8.EjercicioGestionEntidadCoche.gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Capitulo8.EjercicioGestionEntidadCoche.modelo.ControladorBBDDCoche;
import Capitulo8.EjercicioGestionEntidadCoche.modelo.ControladorBBDDFabricante;
import Capitulo8.EjercicioGestionEntidadCoche.modelo.entidades.Coche;
import Capitulo8.EjercicioGestionEntidadCoche.modelo.entidades.Fabricante;
import tutorialJava.capitulo8_AWT_SWING.utils.CacheImagenes;

public class PanelGestionCoche extends JPanel{
	
	JTextField jtfId = new JTextField();
	JComboBox<Fabricante> jcbFabricante = new JComboBox<Fabricante>();
	JTextField jtfBastidor = new JTextField();
	JTextField jtfModelo = new JTextField();
	JTextField jtfColor = new JTextField();
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JButton jbtNavPrimero = new JButton();
	JButton jbtNavUltimo = new JButton();
	JButton jbtNavAnterior = new JButton();
	JButton jbtNavSiguiente = new JButton();
	JButton jbtGuardar = new JButton();
	JButton jbtNuevo = new JButton();
	JButton jbtEliminar = new JButton();
	
	// Coche mostrado en pantalla
	Coche coche = new Coche();

	/**
	 * 
	 */
	public PanelGestionCoche() {
		double pesoCol1 = 0.15, pesoCol2 = 1;
		
		this.setLayout(new GridBagLayout());
		
		// Incorporamos los components del Id
		colocaComponente(0, 0, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Id:"), gridBagConstraints);
		
		colocaComponente(1, 0, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfId, gridBagConstraints);
		
		// Incorporamos el fabricante
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		inicializarComboBoxFabricante();
		this.add(new JLabel ("Fabricante:"), gridBagConstraints);
		
		colocaComponente(1, 1, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jcbFabricante, gridBagConstraints);
		
		// Incorporamos el bastidor
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Bastidor:"), gridBagConstraints);
		
		colocaComponente(1, 2, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfBastidor, gridBagConstraints);
		
		// Incorporamos el modelo
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Modelo:"), gridBagConstraints);
		
		colocaComponente(1, 3, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfModelo, gridBagConstraints);
		
		// Incorporamos el color
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel ("Color:"), gridBagConstraints);
		
		colocaComponente(1, 4, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfColor, gridBagConstraints);
		
		// Incorporamos fila botones
		colocaComponente(0, 5, GridBagConstraints.NORTH, 1, 1, GridBagConstraints.BOTH);
		gridBagConstraints.gridwidth = 2;
		this.add(getBotonera(), gridBagConstraints);
		
		//Manejo de la navegacion de registros por rueda de raton
		this.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getUnitsToScroll() < 0) {
					navegaASiguiente();
				}
				else {
					navegaAAnterior();
				}
				
			}
		});
	}
	
	/**
	 * 
	 */
	private void inicializarComboBoxFabricante() {
		List<Fabricante> fabricantes = ControladorBBDDFabricante.getTodosFabricantes();
		for (Fabricante fabricante : fabricantes) {
			jcbFabricante.addItem(fabricante);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getBotonera() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		// Configuramos los botones
		configuraBoton(jbtNavPrimero, "gotostart.png", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAPrimero();
				
			}
		});
		configuraBoton(jbtNavAnterior, "previous.png", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAAnterior();
				
			}
		});
		configuraBoton(jbtNavSiguiente, "next.png", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaASiguiente();
				
			}
		});
		configuraBoton(jbtNavUltimo, "gotoend.png", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				navegaAUltimo();
				
			}
		});
		
		configuraBoton(jbtGuardar, "ruedadentada.png", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
			
		});
		
		configuraBoton(jbtNuevo, "duke1-32x32.png", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
			
		});
		
		configuraBoton(jbtEliminar, "goku.png", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
			
		});
		
		// Incluimos los botones
		panel.add(jbtNavPrimero);
		panel.add(jbtNavAnterior);
		panel.add(jbtNavSiguiente);
		panel.add(jbtNavUltimo);
		panel.add(jbtGuardar);
		panel.add(jbtNuevo);
		panel.add(jbtEliminar);
		
		return panel;
	}
	
	/**
	 * 
	 */
	private void nuevo() {
		this.coche = new Coche();
		this.coche.setId(-1);
		this.jtfId.setText("" + -1);
		this.jcbFabricante.setSelectedIndex(0);
		this.jtfBastidor.setText("");
		this.jtfModelo.setText("");
		this.jtfColor.setText("");
	}
	
	/**
	 * 
	 */
	private void guardar() {
		//Es un alta nueva o una modificacion
		if (this.coche.getId() == -1) { //Alta
			ControladorBBDDCoche.guardarNuevoCoche(this.coche);
		}
		else { //Modificacion
			ControladorBBDDCoche.modificarCoche(this.coche);
		}
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		//Por regla general, siempre que eliminemos un coche navegaremos al siguiente registro
		Coche cocheAEliminar = this.coche;
		//Compruebo si el 
		ControladorBBDDCoche.eliminarCoche(this.coche);
	}
	
	/**
	 * 
	 * @param jbt
	 * @param icono
	 */
	private void configuraBoton(JButton jbt, String icono, ActionListener actionListener) {
		jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
		jbt.addActionListener(actionListener);
	}
	
	private void navegaAPrimero() {
		coche = ControladorBBDDCoche.getPrimerCoche();
		cargaCocheEnCompomentesVisuales();
		actualizarEstadoBotonera();
	}
	
	private void navegaAAnterior() {
		coche = ControladorBBDDCoche.getAnteriorCoche(this.coche);
		cargaCocheEnCompomentesVisuales();
		actualizarEstadoBotonera();
	}
	
	private void navegaASiguiente() {
		coche = ControladorBBDDCoche.getSiguienteCoche(this.coche);
		cargaCocheEnCompomentesVisuales();
		actualizarEstadoBotonera();
	}
	
	
	private void navegaAUltimo() {
		coche = ControladorBBDDCoche.getUltimoCoche();
		cargaCocheEnCompomentesVisuales();
		actualizarEstadoBotonera();
	}
	
	private void actualizarEstadoBotonera() {
		if (ControladorBBDDCoche.getPrimerCoche() == null) {
			jbtNavPrimero.setEnabled(false);
		}
		else {
			jbtNavPrimero.setEnabled(true);
		}
		
		if (ControladorBBDDCoche.getAnteriorCoche(this.coche) == null) {
			jbtNavAnterior.setEnabled(false);
			jbtNavPrimero.setEnabled(false);
		}
		else {
			jbtNavAnterior.setEnabled(true);
			jbtNavPrimero.setEnabled(true);
		}
		
		if (ControladorBBDDCoche.getSiguienteCoche(this.coche) == null) {
			jbtNavSiguiente.setEnabled(false);
			jbtNavUltimo.setEnabled(false);
		}
		else {
			jbtNavSiguiente.setEnabled(true);
			jbtNavUltimo.setEnabled(true);
		}
		
		if (ControladorBBDDCoche.getUltimoCoche() == null) {
			jbtNavUltimo.setEnabled(false);
		}
		else {
			jbtNavUltimo.setEnabled(true);
		}
	}
	
	/**
	 * 
	 */
	private void cargaCocheEnCompomentesVisuales () {
		this.jtfId.setText("" + coche.getId());
		this.jtfBastidor.setText(coche.getBastidor());
		this.jtfModelo.setText(coche.getModelo());
		this.jtfColor.setText(coche.getColor());
		
		// Cargo el valor del JComboBox del fabricante
		for (int i = 0; i < this.jcbFabricante.getItemCount(); i++) {
			if (coche.getIdFabricante() == this.jcbFabricante.getItemAt(i).getId()) {
				this.jcbFabricante.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * 
	 */
	private void cargaCocheDesdeCompomentesVisuales () {
		this.coche.setBastidor(this.jtfBastidor.getText());
		this.coche.setModelo(this.jtfModelo.getText());
		this.coche.setColor(this.jtfColor.getText());
		this.coche.setIdFabricante(((Fabricante) this.jcbFabricante.getSelectedItem()).getId());
		
		// Cargo el valor del JComboBox del fabricante
		for (int i = 0; i < this.jcbFabricante.getItemCount(); i++) {
			if (coche.getIdFabricante() == this.jcbFabricante.getItemAt(i).getId()) {
				this.jcbFabricante.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * 
	 * @param gridX
	 * @param gridY
	 * @param anchor
	 * @param pesoColumna
	 * @param pesoFila
	 * @param fill
	 */
	private void colocaComponente (int gridX, int gridY, int anchor, double pesoColumna, double pesoFila, int fill) {
		gridBagConstraints.gridx = gridX;
		gridBagConstraints.gridy = gridY;
		gridBagConstraints.anchor = anchor;
		gridBagConstraints.weightx = pesoColumna;
		gridBagConstraints.weighty = pesoFila;
		gridBagConstraints.fill = fill;
	}
 
}
