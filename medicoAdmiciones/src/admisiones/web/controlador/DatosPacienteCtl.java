package admisiones.web.controlador;


import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Textbox;

import admisiones.db.dto.modelo.Paciente;

public class DatosPacienteCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	Textbox identificacion;
	Textbox tipoDocumento;
	Textbox primerNombre;
	Textbox segundoNombre;
	Textbox primerApellido;
	Textbox segundoApellido;
	Textbox fechaNacimiento;
	Textbox genero;
	Textbox estadoCivil;
	Textbox lugarNacimiento;
	Textbox zona;
	Textbox municipio;
	Textbox primerTelefono;
	Textbox SegundoTelefono;
	Textbox direccion;
	Textbox mail;
	Menuitem btnAtencion;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		Paciente paciente=(Paciente)Sessions.getCurrent().getAttribute("paciente");
		identificacion.setText(paciente.getIdentificacion());
		tipoDocumento.setText(paciente.getTipoDocumento());
		primerNombre.setText(paciente.getPrimerNombre());		
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.setModulo("admisiones/web/vista/Menu.zul");
		pintor.refrescarmodulo();	
	}
	
	
}