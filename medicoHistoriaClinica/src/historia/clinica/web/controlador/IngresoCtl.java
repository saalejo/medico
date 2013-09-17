package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import historia.clinica.db.dto.modelo.Ingreso;
import historia.clinica.servicio.IngresoServicio;

import java.io.Serializable;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;

public class IngresoCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox estado;
	private Textbox fecha;
	Ingreso ingreso;
	Button cerrar;
	Paciente paciente;
	
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		paciente=(Paciente)Sessions.getCurrent().getAttribute("paciente");
		IngresoServicio ingresoServicio = (IngresoServicio) SpringUtil.getBean("ingresoServicio");
		ingreso =ingresoServicio.obtener(paciente.getId());	
		if(ingreso.getEstado()==null){
			Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
			ingresoServicio.nuevo(paciente.getId(), profesional.getUsuario());
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			pintor.abrirVentana("historia/clinica/web/vista/Ingreso.zul", "contenidoPosicion",null);
		}else{
			estado.setText(ingreso.getEstado());
			String stfecha=ingreso.getFecha().toString();
			fecha.setText(stfecha);
		}
	}
	
	public void onClick$guardar(){		
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();		
		ingreso.setUsuarioConectado(usuarioConectado);
		ingreso.setEstado(estado.getText());
		ingreso.setFecha(new Date());
		IngresoServicio ingresoServicio = (IngresoServicio) SpringUtil.getBean("ingresoServicio");
		ingresoServicio.guardar(ingreso);
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.refrescarmodulo();
	}
	
	public void onClick$cerrar(){			
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		IngresoServicio ingresoServicio = (IngresoServicio) SpringUtil.getBean("ingresoServicio");
		ingreso.setUsuarioConectado(usuarioConectado);		
			ingresoServicio.cerrar(ingreso);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			pintor.refrescarmodulo();
	}
}