package admiciones.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Textbox;

import admiciones.db.dto.modelo.Actividad;
import admiciones.db.dto.modelo.Profesional;
import admisiones.servicio.ActividadServicio;

public class NuevaActividadCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox duracion;
	private Textbox nombre;
	private String actividadId;
	int idActividad=-1;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		actividadId=(String) comp.getAttribute("actividadId");
		if(actividadId!=null){
			idActividad=Integer.parseInt(actividadId);
			ActividadServicio actividadServicio = (ActividadServicio) SpringUtil.getBean("actividadServicio");
			Actividad actividad=actividadServicio.obtener(idActividad);
			nombre.setText(actividad.getNombre());
			duracion.setText(""+actividad.getDuracion());
		}
	}
	
	public void onClick$cancelar(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}
	
	
	public void onClick$guardar(){	
		
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		ActividadServicio actividadServicio = (ActividadServicio) SpringUtil.getBean("actividadServicio");
		try {
			if(idActividad!=-1){
				actividadServicio.actualizar(
						idActividad,
						nombre.getText(),
						Integer.parseInt(duracion.getText()),
						usuarioConectado
						);
			}else{
				actividadServicio.guardar(
					nombre.getText(),
					Integer.parseInt(duracion.getText()),
					usuarioConectado
						);
			}
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("admisiones/web/vista/ListaActividades.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
}