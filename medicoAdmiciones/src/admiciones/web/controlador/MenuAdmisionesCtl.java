package admiciones.web.controlador;

import hcdigital.presentacion.util.Pintor;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Window;

import admiciones.db.dto.modelo.Paciente;
import admiciones.db.dto.modelo.Profesional;


public class MenuAdmisionesCtl extends GenericForwardComposer{

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
	 *  Evento Click del boton Acceder
	 */
	public void onClick$btnNuevoPaciente(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevoPaciente.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevoProfesional(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevoProfesional.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevoPrestador(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevoPrestador.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevoMedicamento(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevoMedicamentoMaestro.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevoMunicipio(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevoMunicipio.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevaActividad(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevaActividad.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevaEntidad(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevaEntidad.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevaEspecialidad(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/NuevaEspecialidad.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnNuevoIngreso(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("historia/clinica/web/vista/Menu.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnListaActividades(){
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
	public void onClick$btnListaEntidades(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/ListaEntidades.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnListaEspecialidades(){
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
	public void onClick$btnListaMedicamentos(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/ListaMedicamentosMaestros.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnListaMunicipios(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/ListaMunicipios.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}

	public void onClick$btnListaPrestadores(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/ListaPrestadores.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void onClick$btnListaProfesionales(){
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
	
}