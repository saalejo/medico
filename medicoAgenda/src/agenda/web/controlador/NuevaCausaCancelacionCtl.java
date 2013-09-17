package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Textbox;


import admisiones.db.dto.modelo.Profesional;
import agenda.db.dto.modelo.CausaCancelacion;
import agenda.servicio.CausaCancelacionServicio;

public class NuevaCausaCancelacionCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox nombre;
	private String causaCancelacionId;
	int idCausaCancelacion=-1;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		causaCancelacionId = (String) Sessions.getCurrent().getAttribute("causaCancelacionId");
		Sessions.getCurrent().setAttribute("causaCancelacionId", null);
		
		
		if(causaCancelacionId!=null){
			idCausaCancelacion=Integer.parseInt(causaCancelacionId);
			CausaCancelacionServicio causaCancelacionServicio = (CausaCancelacionServicio) SpringUtil.getBean("causaCancelacionServicio");
			CausaCancelacion causaCancelacion = causaCancelacionServicio.obtener(idCausaCancelacion);
			nombre.setText(causaCancelacion.getNombre());
		}
	}
	
	public void onClick$cancelar(){
		Sessions.getCurrent().setAttribute("causaCancelacionId", null);
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
		
	}
	
	
	public void onClick$guardar(){	
		
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		CausaCancelacionServicio causaCancelacionServicio = (CausaCancelacionServicio) SpringUtil.getBean("causaCancelacionServicio");
		try {
			if(idCausaCancelacion!=-1){
				causaCancelacionServicio.actualizar(idCausaCancelacion,
						nombre.getText(),
						usuarioConectado
						);
				
			}else{
				causaCancelacionServicio.guardar(
					nombre.getText(),
					usuarioConectado
						);
			}
			Sessions.getCurrent().setAttribute("causaCancelacionId", null);
			pintor.cerrarVentana();
			pintor.refrescarmodulo();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
}