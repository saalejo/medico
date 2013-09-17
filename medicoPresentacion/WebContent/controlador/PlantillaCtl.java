package hcdigital.controlador;

import hcdigital.presentacion.util.Pintor;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import admisiones.db.dto.modelo.Paciente;
import admisiones.servicio.PacienteServicio;

public class PlantillaCtl extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Window content;


	private Textbox identificacion;
	
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		Sessions.getCurrent().setAttribute("moduloPosicion",content);
		Pintor pintor=new Pintor();
		if(Sessions.getCurrent().getAttribute("profesional") ==null){
			pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
		}
		Sessions.getCurrent().setAttribute("pintor",pintor);
	}
	public void onClick$buscarPaciente(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		if(pintor!=null){
			String id= identificacion.getText();			
			PacienteServicio pacienteServicio = (PacienteServicio) SpringUtil.getBean("pacienteServicio");
			Paciente paciente=pacienteServicio.obtener(id);		
			if(paciente==null){								
				try {
					Sessions.getCurrent().setAttribute("idPaciente", id);
					pintor.abrirVentana("admisiones/web/vista/NuevoPaciente.zul","",null);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			else{
				try {
					
					Sessions.getCurrent().setAttribute("paciente", paciente);
					pintor.abrirVentana("admisiones/web/vista/DatosPaciente.zul","contenidoPosicion",null);					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}			
		}		
	}	
	
	/**
	 *  Evento Click del boton Acceder
	 */
	public void onClick$logout(){
		Sessions.getCurrent().getAttributes().clear();
		Executions.sendRedirect("");
	}
	
}
