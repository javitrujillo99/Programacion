package Capitulo8.ejercicio03_GestionEntidadCoche.gui;


import java.awt.Color;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Capitulo8.ejercicio03_GestionEntidadCoche.CacheImagenes;
import Capitulo8.ejercicio03_GestionEntidadCoche.modelo.ControladorBBDDCoche;
import Capitulo8.ejercicio03_GestionEntidadCoche.modelo.ControladorBBDDFabricante;
import Capitulo8.ejercicio03_GestionEntidadCoche.modelo.entidades.Coche;
import Capitulo8.ejercicio03_GestionEntidadCoche.modelo.entidades.Fabricante;

public class PanelGestionCoche extends JPanel {

	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JTextField jtfId = new JTextField();
	JComboBox<Fabricante> jcbFabricante = new JComboBox<Fabricante>();
	JTextField jtfBastidor = new JTextField();
	JTextField jtfModelo = new JTextField();
	JTextField jtfColor = new JTextField();
	JButton jbtNavPrimero = new JButton();
	JButton jbtNavUltimo = new JButton();
	JButton jbtNavAnterior = new JButton();
	JButton jbtNavSiguiente = new JButton();
	JButton jbtGuardar = new JButton();
	JButton jbtNuevo = new JButton();
	JButton jbtEliminar = new JButton();
	JSlider jslColorRojo = new JSlider();
	JSlider jslColorVerde= new JSlider();
	JSlider jslColorAzul = new JSlider();
	String hexadecimalCompleto;
	
	Coche coche = new Coche(); // Coche mostrado en pantalla
	
	/**
	 * 
	 */
	public PanelGestionCoche () {
		
		this.maquetarVentana();
		
		// Manejo de la navegación de registros por rueda de ratón
		this.controlRuedaRaton();
		
		// Finalmente, después de la construcción, cargamos el primer registro
		navegaAPrimero();
	}
	
	
	/**
	 * 
	 */
	private void controlRuedaRaton () {
		this.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getUnitsToScroll() < 0) {
					if (ControladorBBDDCoche.getSiguienteCoche(coche) != null) {
						navegaASiguiente();
					}
				}
				else {
					if (ControladorBBDDCoche.getAnteriorCoche(coche) != null) {
						navegaAAnterior();
					}
				}
			}
		});
	}
	
	/**
	 * 
	 */
	private void maquetarVentana() {
		double pesoCol1 = 0.15, pesoCol2 = 1;
		
		this.setLayout(new GridBagLayout());

		gridBagConstraints.insets = new Insets(5, 5, 5, 5);

		// Incorporamos los components del Id
		colocaComponente(0, 0, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Id:"), gridBagConstraints);
		
		colocaComponente(1, 0, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfId, gridBagConstraints);
		
		// Incorporamos el fabricante
		colocaComponente(0, 1, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Fabricante:"), gridBagConstraints);
		
		colocaComponente(1, 1, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		inicializaComboBoxFabricante();
		this.add(jcbFabricante, gridBagConstraints);
		
		// Incorporamos el bastidor
		colocaComponente(0, 2, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("IdBastidor:"), gridBagConstraints);
		
		colocaComponente(1, 2, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfBastidor, gridBagConstraints);
		
		// Incorporamos el Modelo
		colocaComponente(0, 3, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Modelo:"), gridBagConstraints);
		
		colocaComponente(1, 3, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(jtfModelo, gridBagConstraints);
		
		// Incorporamos el Color
		colocaComponente(0, 4, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Cantidad de Rojo:"), gridBagConstraints);
		
		colocaComponente(1, 4, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(modificarColor(jslColorRojo), gridBagConstraints);
		String hexadecimalRojo = convertirAHexadecimal(jslColorRojo.getValue());
		
		colocaComponente(0, 5, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Cantidad de Verde:"), gridBagConstraints);
		
		colocaComponente(1, 5, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(modificarColor(jslColorVerde), gridBagConstraints);
		String hexadecimalVerde = convertirAHexadecimal(jslColorRojo.getValue());
		
		colocaComponente(0, 6, GridBagConstraints.EAST, pesoCol1, 0, GridBagConstraints.NONE);
		this.add(new JLabel("Cantidad de Azul:"), gridBagConstraints);
		
		colocaComponente(1, 6, GridBagConstraints.EAST, pesoCol2, 0, GridBagConstraints.HORIZONTAL);
		this.add(modificarColor(jslColorAzul), gridBagConstraints);
		String hexadecimalAzul = convertirAHexadecimal(jslColorRojo.getValue());
		
		System.out.println(hexadecimalRojo + hexadecimalVerde + hexadecimalAzul);
		
		
		// Incorporamos fila botones
		colocaComponente(0, 7, GridBagConstraints.NORTH, 1, 1, GridBagConstraints.BOTH);
		gridBagConstraints.gridwidth = 2;
		this.add(getBotonera(), gridBagConstraints);		
	}
	
	/**
	 * 
	 * @param jslColor
	 * @return
	 */
	private JSlider modificarColor(JSlider jslColor) {
		ChangeListener changeListener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				jslColor.setMinimum(0);
				jslColor.setMaximum(255);
				String hexadecimal = convertirAHexadecimal(jslColor.getValue());
				hexadecimalCompleto += hexadecimal;
				System.out.println(hexadecimalCompleto.toString());
			}
		};
		jslColor.addChangeListener(changeListener);
		return jslColor;
	}
	
	
	
	/**
	 * 
	 * @param numero
	 */
	private String convertirAHexadecimal(int numero) {
		String string = Integer.toHexString(numero);
		return string;
	}
	
	
	/**
	 * 
	 */
	private void inicializaComboBoxFabricante () {
		List<Fabricante> fabricantes = ControladorBBDDFabricante.getTodosFabricantes();
		for (Fabricante fabricante : fabricantes) {
			jcbFabricante.addItem(fabricante);
		}
	}
	
	/**
	 * 
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
		configuraBoton(jbtGuardar, "guardar.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		configuraBoton(jbtNuevo, "nuevo.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		configuraBoton(jbtEliminar, "eliminar.png", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		
		//Incluímos los botones
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
	private void eliminar() {
		// Por regla general, siempre que eliminemos un coche navegaremos al siguiente
		// registro
		Coche cocheAEliminar = this.coche;
		
		// Compruebo si el coche actual es el último coche
		if (ControladorBBDDCoche.getUltimoCoche().getId() == this.coche.getId()) {
			navegaAAnterior();
		}
		else {
			navegaASiguiente();
		}
		
		// Finalmente elimino el coche
		ControladorBBDDCoche.eliminarCoche(cocheAEliminar);
		
		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void nuevo () {
		this.coche = new Coche();
		this.coche.setId(-1);
		this.jtfId.setText("" + -1);
		this.jcbFabricante.setSelectedIndex(0);
		this.jtfBastidor.setText("");
		this.jtfModelo.setText("");
		this.jtfColor.setText("");

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 * @param jbt
	 * @param icono
	 */
	private void configuraBoton (JButton jbt, String icono, ActionListener actionListener) {
		jbt.setIcon(CacheImagenes.getCacheImagenes().getIcono(icono));
		jbt.addActionListener(actionListener);
	}
	
	
	
	private void guardar() {
		// Es un alta nueva o una modificación
		cargaCocheDesdeComponentesVisuales();
		if (this.coche.getId() == -1) { // Alta
			ControladorBBDDCoche.guardarNuevoCoche(this.coche);
			this.navegaAUltimo();
		}
		else { // Modificación
			ControladorBBDDCoche.modificarCoche(this.coche);
		}

		// Actualizo la botonera
		this.actualizaEstadoBotonera();
	}
	
	
	/**
	 * 
	 */
	private void navegaAPrimero () {
		coche = ControladorBBDDCoche.getPrimerCoche();
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAUltimo () {
		coche = ControladorBBDDCoche.getUltimoCoche();
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaASiguiente () {
		coche = ControladorBBDDCoche.getSiguienteCoche(this.coche);
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	/**
	 * 
	 */
	private void navegaAAnterior () {
		coche = ControladorBBDDCoche.getAnteriorCoche(this.coche);
		cargaCocheEnComponentesVisuales();
		actualizaEstadoBotonera();
	}
	
	
	
	/**
	 * 
	 */
	private void actualizaEstadoBotonera () {
		if (ControladorBBDDCoche.getAnteriorCoche(this.coche) == null) {
			jbtNavPrimero.setEnabled(false);
			jbtNavAnterior.setEnabled(false);
		}
		else {
			jbtNavPrimero.setEnabled(true);
			jbtNavAnterior.setEnabled(true);
		}
		if (ControladorBBDDCoche.getSiguienteCoche(this.coche) == null) {
			jbtNavSiguiente.setEnabled(false);
			jbtNavUltimo.setEnabled(false);
		}
		else {
			jbtNavSiguiente.setEnabled(true);
			jbtNavUltimo.setEnabled(true);
		}
	}
	
	/**
	 * 
	 */
	private void cargaCocheEnComponentesVisuales () {
		this.jtfId.setText("" + coche.getId());
		this.jtfBastidor.setText(coche.getBastidor());
		this.jtfModelo.setText(coche.getModelo());
		this.jtfColor.setText(coche.getColor());
		// Cargo el valor del JComboBox del fabricante
		for (int i = 0; i < this.jcbFabricante.getItemCount(); i++) {
			if (coche.getIdFabricante() == this.jcbFabricante.getItemAt(i).getId()) {
				this.jcbFabricante.setSelectedIndex(i);
				break;
			}
		}		
	}
	
	/**
	 * 
	 */
	private void cargaCocheDesdeComponentesVisuales () {
		this.coche.setBastidor(this.jtfBastidor.getText());
		this.coche.setModelo(this.jtfModelo.getText());
		this.coche.setColor(this.jtfColor.getText());
		this.coche.setIdFabricante(((Fabricante) this.jcbFabricante.getSelectedItem()).getId());
	}
	
	/**
	 * 
	 * @param gridX
	 * @param gridY
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
