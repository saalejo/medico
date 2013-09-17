package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;


import admisiones.db.dto.modelo.Profesional;
import agenda.db.dto.modelo.Consultorio;
import agenda.servicio.ConsultorioServicio;

public class NuevoConsultorioCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox nombre;
	private Intbox codigo;
	private String consultorioId;
	int idConsultorio=-1;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		consultorioId = (String) Sessions.getCurrent().getAttribute("consultorioId");
		Sessions.getCurrent().setAttribute("consultorioId", null);
		
		if(consultorioId!=null){
			idConsultorio=Integer.parseInt(consultorioId);
			ConsultorioServicio consultorioServicio = (ConsultorioServicio) SpringUtil.getBean("consultorioServicio");
			Consultorio consultorio = consultorioServicio.obtener(idConsultorio);
			nombre.setText(consultorio.getNombre());
			codigo.setText(""+consultorio.getCodigo());
		}
	}
	
	public void onClick$cancelar(){
		Sessions.getCurrent().setAttribute("consultorioId", null);
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
		
	}
	
	
	public void onClick$guardar(){	
		
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		ConsultorioServicio consultorioServicio = (ConsultorioServicio) SpringUtil.getBean("consultorioServicio");
		try {
			if(idConsultorio!=-1){
				consultorioServicio.actualizar(idConsultorio, Integer.parseInt(codigo.getText()),
						nombre.getText(),
						usuarioConectado
						);
				
			}else{
				consultorioServicio.guardar(
				    Integer.parseInt(codigo.getText()),
					nombre.getText(),
					usuarioConectado
						);
			}
			Sessions.getCurrent().setAttribute("consultorioId", null);
			pintor.cerrarVentana();
			pintor.refrescarmodulo();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
}