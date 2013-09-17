package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.servicio.RemisionServicio;

import java.io.Serializable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;

public class NuevaRemisionCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox motivo;
	private Textbox resultados;
	private Atencion atencion;
	private Paciente paciente;
	private Textbox idPaciente;
	private Textbox nombrePaciente;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		atencion=(Atencion)Sessions.getCurrent().getAttribute("atencion");
		if(atencion==null){
			
			Sessions.getCurrent().getAttributes().clear();
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			pintor.abrirVentana("historia/clinica/web/vista/Ingreso.zul", "contenidoPosicion",null);
		}else{
			paciente=(Paciente)Sessions.getCurrent().getAttribute("paciente");
			idPaciente.setText(paciente.getIdentificacion());
			nombrePaciente.setText(paciente.getPrimerNombre()+""+paciente.getPrimerApellido());
		}
		
	}
	
	public void onClick$cancelar(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}
	
	
	public void onClick$guardar(){	
		
		try {
			Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
			String usuarioConectado=profesional.getUsuario();
			RemisionServicio remisionServicio = (RemisionServicio) SpringUtil.getBean("remisionServicio");
			remisionServicio.guardar(atencion.getId(),motivo.getText(),resultados.getText(), usuarioConectado);
			Messagebox.show("Guardada la Remision", "Information", Messagebox.OK, Messagebox.INFORMATION);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			pintor.cerrarVentana();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}