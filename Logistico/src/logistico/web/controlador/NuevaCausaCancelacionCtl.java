package logistico.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.awt.Component;
import java.io.Serializable;

import logistico.db.dto.modelo.Profesional;
import logistico.servicio.CausaCancelacionServicio;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class NuevaCausaCancelacionCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox descripcion;
	private Combobox moduloSistema;
	
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
		
		CausaCancelacionServicio 	causaCancelacionServicio = (CausaCancelacionServicio)SpringUtil.getBean("causaCancelacionServicio");
		try {
			causaCancelacionServicio.guardar(
					descripcion.getText(),
					usuarioConectado,
					Integer.parseInt(moduloSistema.getSelectedItem().getLabel())
					
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("logistico/web/vista/ListaCausaCancelacion.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}