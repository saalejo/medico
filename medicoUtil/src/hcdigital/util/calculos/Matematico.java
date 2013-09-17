package hcdigital.util.calculos;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Matematico {
	
	public static int calcularEdad(Date bornDate) {
		 Calendar cal = Calendar.getInstance(); // current date
		int currYear = cal.get(Calendar.YEAR);
		int currMonth = cal.get(Calendar.MONTH);
		int currDay = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(bornDate); // now born date
		int years = currYear - cal.get(Calendar.YEAR);
		int bornMonth = cal.get(Calendar.MONTH);
		if (bornMonth == currMonth) { // same month
			return cal.get(Calendar.DAY_OF_MONTH) <= currDay ? years: years - 1;
		} else {
			return bornMonth < currMonth ? years  : years - 1;
		}
	}
	
	public static int calcularIndicedeMasaCorporal(int peso, int talla){
		return peso/(talla*talla);		
	}

	public static int fechasDiferenciaEnDias(Date fechaInicial, Date fechaFinal) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String fechaInicioString = df.format(fechaInicial);		
		try {
			fechaInicial = df.parse(fechaInicioString);
			String fechaFinalString = df.format(fechaFinal);
			fechaFinal = df.parse(fechaFinalString);
		}
		catch (ParseException ex) {}
		long fechaInicialMs = fechaInicial.getTime();
		long fechaFinalMs = fechaFinal.getTime();
		long diferencia = fechaFinalMs - fechaInicialMs;
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		return ( (int) dias);
	}
}
