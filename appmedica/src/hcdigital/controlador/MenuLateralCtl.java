package hcdigital.controlador;

import hcdigital.presentacion.util.Pintor;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Window;

import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;


public class MenuLateralCtl extends GenericForwardComposer{

	Menuitem btnAdmisiones;
	
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		if(profesional!=null){
			if(profesional.getTipoUsuario().equals("administrador")){
				btnAdmisiones.setVisible(true);
			}else{
				btnAdmisiones.setVisible(false);
			}
		}
		
	}
	
	/**
	 *  Evento Click del boton Acceder
	 */
	public void onClick$btnAdmisiones(){
		try {				
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("admisiones/web/vista/Menu.zul","moduloPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnAgenda(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("agenda/web/vista/Menu.zul","moduloPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	public void onClick$btnHistoriaClinica(){
		try {			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");			
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("historia/clinica/web/vista/Menu.zul","moduloPosicion",null);
				}else{
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
}