package Capitulo8.EjercicioClase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.PreparedStatement;

import tutorialJava.capitulo7_Acceso_A_Datos.ConnectionManagerV2;
import tutorialJava.capitulo7_Acceso_A_Datos.ImposibleConectarException;


public class VentanaPrincipal extends JFrame{
	
	JTextField tfId;
	JTextField tfCif;
	JTextField tfNombre;

	public VentanaPrincipal () {
		super ("Primera gestión Fabricante");
		
		// Tamaño por defecto, basado en los valores estáticos de esta misma clase
		setDimensionesBasicas();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Construcción elementos básicos sobre el ContentPanel
		this.setContentPane(getPanelPrincipal());

	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelPrincipal () {
		JPanel panel = new JPanel();
		panel.setBackground(Color.lightGray);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(getPanelId());
		panel.add(getPanelCif());
		panel.add(getPanelNombre());
		panel.add(getPanelBotones());
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelId() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		
		JLabel lbl = new JLabel("Id:");
		panel.add(lbl);
		
		tfId = new JTextField();
		tfId.setColumns(20);
		panel.add(tfId);
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelCif() {
		JPanel panel = new JPanel();
		
		JLabel lbl = new JLabel("cif:");
		panel.add(lbl);
		
		tfCif = new JTextField();
		tfCif.setColumns(20);
		panel.add(tfCif);
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelNombre() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		
		JLabel lbl = new JLabel("Nombre:");
		panel.add(lbl);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(20);
		panel.add(tfNombre);
		
		return panel;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel getPanelBotones() {
		JPanel panel = new JPanel();
		
		JButton button = new JButton("Guardar");
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		
		return panel;
	}
	
	/**
	 * 
	 */
	private void guardar() {
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO tutorialjavacoches.fabricante (id, cif, nombre) "
					+ " values (?, ?, ?) ");
			
			ps.setInt(1, Integer.parseInt(tfId.getText()));
			ps.setString(2, tfCif.getText());
			ps.setString(3, tfNombre.getText());
			
			int filasAfectadas = ps.executeUpdate();
			
			if (filasAfectadas == 1) {
				System.out.println("Registro insertado");
			}
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ImposibleConectarException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	private void setDimensionesBasicas () {
		this.setExtendedState(JFrame.NORMAL);
		this.setBounds(0, 0, 800, 600);
	}
}
