package logistico.web.controlador;

import hcdigital.presentacion.util.Pintor;
import logistico.db.dto.modelo.Profesional;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;


public class MenuLogisticoCtl extends GenericForwardComposer{

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
	public void onClick$btnNuevaCompania(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevaCompania.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevaSede(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevaSede.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevoBarrio(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevoBarrio.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevoDepartamento(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevoDepartamento.zul","contenidoPosicion",null);
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
					pintor.abrirVentana("logistico/web/vista/NuevoMunicipio.zul","contenidoPosicion",null);
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
					pintor.abrirVentana("logistico/web/vista/NuevoProfesional.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevoProtocolo(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevoProtocolo.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevaCausaCancelacion(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevaCausaCancelacion.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevaConfiguracion(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevaConfiguracion.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevoConsultorio(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevoConsultorio.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevoHorario(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevoHorario.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void onClick$btnNuevoModuloSistema(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("logistico/web/vista/NuevoModuloSistema.zul","contenidoPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
}