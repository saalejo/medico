package logistico.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.awt.Component;
import java.io.Serializable;

import logistico.db.dto.modelo.Profesional;
import logistico.servicio.ConsultorioServicio;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class NuevoConsultorioCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox descripcion;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	

	}
	
	public void onClick$cancelar(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}
	
	
	public void onClick$guardar(){	
		//------------------------------------------
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		int usuarioConectado=profesional.getUsuarioConectado();
		//------------------------------------------
		
		ConsultorioServicio 	consultorioServicio = (ConsultorioServicio)SpringUtil.getBean("consultorioServicio");
		try {
			consultorioServicio.guardar(
					descripcion.getText(),
					usuarioConectado
					
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("logistico/web/vista/ListaConsultorios.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}