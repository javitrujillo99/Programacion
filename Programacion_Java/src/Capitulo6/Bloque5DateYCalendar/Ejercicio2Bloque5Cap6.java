package Capitulo6.Bloque5DateYCalendar;

import java.util.Calendar;
import java.util.TimeZone;

public class Ejercicio2Bloque5Cap6 {

	public static void main(String[] args) {
		Calendar ahoraEnRoma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		Calendar ahoraEnSidney = Calendar.getInstance(TimeZone.getTimeZone("Australia/Sydney"));
		int horaEnRoma = ahoraEnRoma.get(Calendar.HOUR_OF_DAY);
		int horaEnSidney = ahoraEnSidney.get(Calendar.HOUR_OF_DAY);
		System.out.println("Ahora en Roma: " + horaEnRoma
		+ "\nAhora en Sidney: " + horaEnSidney);
		
		int diferenciaHoraria = horaEnSidney - horaEnRoma;
		System.out.println("Diferencia horaria entre Roma y Sidney: " + diferenciaHoraria + " horas");
	}

}
