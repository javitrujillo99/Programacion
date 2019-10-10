package Capitulo6.Bloque5DateYCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Ejercicio1Bloque5Cap6 {

	public static void main(String[] args) {
		//Formato en el que queremos la fecha y la hora
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		//Lo metemos en el formato anterior
		String fechaString = JOptionPane.showInputDialog("Introduzca fecha en dd/MM/yyyy:");
		
		Date fechaDate = null;
		try {
			fechaDate = sdf.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar fechaCalendar = Calendar.getInstance();
		//Introducir la fecha tipo Date en la fecha tipo Calendar
		fechaCalendar.setTime(fechaDate);
		System.out.println("Fecha desde Date:");
		System.out.println("\nAño: " + (new SimpleDateFormat("yyyy").format(fechaDate)));
		System.out.println("Mes: " + (new SimpleDateFormat("MM").format(fechaDate)));
		System.out.println("Dia: " + (new SimpleDateFormat("dd").format(fechaDate)));
		System.out.println("Horas: " + (new SimpleDateFormat("HH").format(fechaDate)));
		System.out.println("Minutos: " + (new SimpleDateFormat("mm").format(fechaDate)));
		System.out.println("Segundos: " + (new SimpleDateFormat("ss").format(fechaDate)));
		
		System.out.println("\nFecha desde Calendar:");
		System.out.println("\nAño: " + fechaCalendar.get(Calendar.YEAR));
		System.out.println("Mes: " + fechaCalendar.get(Calendar.MONTH + 1));
		System.out.println("Dia: " + fechaCalendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("Horas: " + fechaCalendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minutos: " + fechaCalendar.get(Calendar.MINUTE));
		System.out.println("Segundos: " + fechaCalendar.get(Calendar.SECOND));
		
	}

}
