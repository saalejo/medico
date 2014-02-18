package logistico.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.awt.Component;
import java.io.Serializable;

import logistico.db.dto.modelo.Profesional;
import logistico.servicio.ProtocoloServicio;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Textbox;

public class NuevoProtocoloCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox nombre;
	private Textbox descripcion;
	private Textbox tipo;

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
		
		ProtocoloServicio protocoloServicio = (ProtocoloServicio)SpringUtil.getBean("protocoloServicio");
		try {
			protocoloServicio.guardar(
					nombre.getText(),
					descripcion.getText(),
					Boolean.parseBoolean(tipo.getText()),
					usuarioConectado
					
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("logistico/web/vista/ListaProtocolos.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}