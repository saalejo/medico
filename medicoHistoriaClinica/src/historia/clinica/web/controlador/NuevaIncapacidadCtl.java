package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.servicio.IncapacidadServicio;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;

public class NuevaIncapacidadCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox orden;
	private Datebox fechaInicio;
	Datebox fechaFin;
	Textbox idPaciente;
	Textbox nombrePaciente;
	Label cantidadDias;
	private Paciente paciente;
	private Atencion atencion;
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
			IncapacidadServicio incapacidadServicio = (IncapacidadServicio) SpringUtil.getBean("incapacidadServicio");
			incapacidadServicio.guardar(atencion.getId(),fechaInicio.getValue(), fechaFin.getValue(), orden.getText(), usuarioConectado);
			Messagebox.show("Guardada la incapacidad", "Information", Messagebox.OK, Messagebox.INFORMATION);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			pintor.cerrarVentana();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public void onChange$fechaFin() {
		
		int cantidadDias=fechasDiferenciaEnDias(fechaInicio.getValue(), fechaFin.getValue());
		this.cantidadDias.setValue(""+cantidadDias);
		
	}
	
	public static int fechasDiferenciaEnDias(Date fechaInicial, Date fechaFinal) {

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String fechaInicioString = df.format(fechaInicial);
		try {
		fechaInicial = df.parse(fechaInicioString);
		}
		catch (ParseException ex) {
		}

		String fechaFinalString = df.format(fechaFinal);
		try {
		fechaFinal = df.parse(fechaFinalString);
		}
		catch (ParseException ex) {
		}

		long fechaInicialMs = fechaInicial.getTime();
		long fechaFinalMs = fechaFinal.getTime();
		long diferencia = fechaFinalMs - fechaInicialMs;
		double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		return ( (int) dias);
		}
	
}