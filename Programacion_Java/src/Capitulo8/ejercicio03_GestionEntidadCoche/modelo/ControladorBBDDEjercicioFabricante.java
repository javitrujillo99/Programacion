package Capitulo8.ejercicio03_GestionEntidadCoche.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Capitulo8.ejercicio03_GestionEntidadCoche.modelo.entidades.Fabricante;

public class ControladorBBDDEjercicioFabricante {
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante getPrimerFabricante() {
		Fabricante fabricante = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fabricante = getFabricanteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante getUltimoFabricante () {
		Fabricante fabricante = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fabricante = getFabricanteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante getSiguienteFabricante (Fabricante fabricanteActual) {
		Fabricante fabricanteResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante where id > ? order by id limit 1");
			ps.setInt(1, fabricanteActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fabricanteResultado = getFabricanteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricanteResultado;
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public static Fabricante getAnteriorFabricante (Fabricante fabricanteActual) {
		Fabricante fabricanteResultado = null;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM tutorialjavacoches.fabricante where id < ? order by id desc limit 1");
			ps.setInt(1, fabricanteActual.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fabricanteResultado = getFabricanteFromResultSet(rs);		
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricanteResultado;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean guardarNuevoFabricante (Fabricante fabricante) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "INSERT INTO tutorialjavacoches.fabricante values (?, ?, ?) ");
			ps.setInt(1, getUltimoFabricante().getId() + 1);
			ps.setString(2, fabricante.getCif());
			ps.setString(3, fabricante.getNombre());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean modificarFabricante (Fabricante fabricante) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "UPDATE tutorialjavacoches.fabricante SET id = ?, cif = ?, nombre = ?, where id = ?");
			ps.setInt(1, fabricante.getId());
			ps.setString(2, fabricante.getCif());
			ps.setString(3, fabricante.getNombre());
			
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	public static boolean eliminarFabricante (Fabricante fabricante) {
		boolean resultado = true;
		try {
			Connection conn = ConnectionManagerV2.getConexion();
			
			PreparedStatement ps = conn.prepareStatement(""
					+ "DELETE FROM tutorialjavacoches.fabricante where id = ?");
			ps.setInt(1, fabricante.getId());
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados != 1) {
				resultado = false;		
			}
			ps.close();
			conn.close();
		} catch (SQLException | ImposibleConectarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
	
	
	
	
	private static Fabricante getFabricanteFromResultSet (ResultSet rs) {
		Fabricante fabricante = new Fabricante();
		
		try {
			fabricante.setId(rs.getInt("id"));
			fabricante.setCif(rs.getString("cif"));
			fabricante.setNombre(rs.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fabricante;
	}
}
