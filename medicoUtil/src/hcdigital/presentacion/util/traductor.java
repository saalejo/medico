package hcdigital.presentacion.util;

import java.util.Locale;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class traductor {
	
	/**
	 * Cambia el idioma de la aplicación por el definido
	 * @param locale Codigo locale del idioma a definir ej. es, en, fr
	 */
	public static void changeLanguage(String locale){
		Locale prefer_locale = locale.length() > 2 ? new Locale(locale.substring(0,2)
				, locale.substring(3)) : new Locale(locale);
		Sessions.getCurrent().setAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE, prefer_locale);
		Executions.sendRedirect("");
	}
	
	/**
	 * Devuelve el Locale que identifica el lenguaje de la aplicación
	 * @return String con el lenguaje de la aplicación o 'es' (español) por defecto
	 */
	public static String getLanguage(){
		if(Sessions.getCurrent().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE) != null)
			return Sessions.getCurrent().getAttribute(org.zkoss.web.Attributes.PREFERRED_LOCALE).toString();
		return "es";
	}

}
