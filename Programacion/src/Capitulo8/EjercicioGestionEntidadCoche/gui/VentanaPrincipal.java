package Capitulo8.EjercicioGestionEntidadCoche.gui;


import javax.swing.JFrame;


public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal () {
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(new PanelGestionCoche());
	}
}
			
