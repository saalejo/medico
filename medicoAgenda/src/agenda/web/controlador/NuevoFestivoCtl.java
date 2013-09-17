package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;


import admisiones.db.dto.modelo.Profesional;
import agenda.db.dto.modelo.Festivo;
import agenda.servicio.FestivoServicio;

public class NuevoFestivoCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Datebox fecha;
	private Textbox motivo;
	private String festivoId;
	int idFestivo=-1;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		festivoId = (String) Sessions.getCurrent().getAttribute("festivoId");
		Sessions.getCurrent().setAttribute("festivoId", null);
		
		if(festivoId!=null){
			idFestivo=Integer.parseInt(festivoId);
			FestivoServicio festivoServicio = (FestivoServicio) SpringUtil.getBean("festivoServicio");
			Festivo festivo = festivoServicio.obtener(idFestivo);
			fecha.setValue(festivo.getFecha());
			motivo.setText(festivo.getMotivo());
		}
	}
	
	public void onClick$cancelar(){
		Sessions.getCurrent().setAttribute("festivoId", null);
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
		
	}
	
	
	public void onClick$guardar(){	
		
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		FestivoServicio festivoServicio = (FestivoServicio) SpringUtil.getBean("festivoServicio");
		try {
			if(idFestivo!=-1){
				festivoServicio.actualizar(idFestivo, fecha.getValue(),
						motivo.getText(),
						usuarioConectado
						);
				
			}else{
				festivoServicio.guardar(
						fecha.getValue(),
						motivo.getText(),
					usuarioConectado
						);
			}
			Sessions.getCurrent().setAttribute("festivoId", null);
			pintor.cerrarVentana();
			pintor.refrescarmodulo();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
}