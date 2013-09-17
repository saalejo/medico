package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Window;

import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;


public class MenuAgendaCtl extends GenericForwardComposer{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Window contenido;
	
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		Sessions.getCurrent().setAttribute("contenidoPosicion",contenido);
	}
	
	/**
	 *  Evento Click del boton causas cancelacion
	 */
	public void onClick$btnCausasCancelacion(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("agenda/web/vista/ListaCausasCancelacion.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnConsultorios(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("agenda/web/vista/ListaConsultorios.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnFestivos(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("agenda/web/vista/ListaFestivos.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnEventos(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("agenda/web/vista/ListaEventos.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	
	public void onClick$btnGestiones(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("agenda/web/vista/ListaGestiones.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnConfiguraciones(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("agenda/web/vista/NuevaConfiguracion.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnProfesiones(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("admisiones/web/vista/ListaProfesiones.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnProfesionales(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("admisiones/web/vista/ListaProfesionales.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnEspecialidades(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("admisiones/web/vista/ListaEspecialidades.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnActividades(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					
					pintor.abrirVentana("admisiones/web/vista/ListaActividades.zul","contenidoPosicion",null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	
}