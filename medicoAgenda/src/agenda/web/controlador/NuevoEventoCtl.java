package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timebox;


import admisiones.db.dto.modelo.Profesional;
import agenda.db.dto.modelo.Evento;
import agenda.servicio.EventoServicio;


public class NuevoEventoCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Datebox fecha;
	private Timebox horaInicial;
	private Timebox horaFinal;
	private Textbox motivo;
	private Radio  Tsi;
	private Radio  Tno;
	private String eventoId;
	int idEvento=-1;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		eventoId = (String) Sessions.getCurrent().getAttribute("eventoId");
		Sessions.getCurrent().setAttribute("eventoId", null);
		
		if(eventoId!=null){
			idEvento=Integer.parseInt(eventoId);
			EventoServicio eventoServicio = (EventoServicio) SpringUtil.getBean("eventoServicio");
			Evento evento = eventoServicio.obtener(idEvento);
			fecha.setValue(evento.getFecha());
			horaInicial.setValue(evento.getHoraInicial());
			horaFinal.setValue(evento.getHoraFinal());
			motivo.setText(evento.getMotivo());
			
			if(evento.getTodosDias())
			{
				Tsi.setChecked(true);
				Tno.setChecked(false);
			}
			else
			{
				Tsi.setChecked(false);
				Tno.setChecked(true);
			}
			
		}
	}
	
	public void onClick$cancelar(){
		Sessions.getCurrent().setAttribute("eventoId", null);
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
		
	}
	
	
	public void onClick$guardar(){	
		
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		
		EventoServicio eventoServicio = (EventoServicio) SpringUtil.getBean("eventoServicio");
		Boolean todos = false;
		
		if(Tsi.isChecked())
		{
			todos = true;
		}
		
		try {
			
			if(horaInicial.getValue().before(horaFinal.getValue())){
			
			
			if(idEvento!=-1){
				eventoServicio.actualizar(idEvento, fecha.getValue(),
						horaInicial.getValue(),
						horaFinal.getValue(), 
						motivo.getText(), todos,
					    usuarioConectado
						);
				
			}else{
				eventoServicio.guardar(
						fecha.getValue(),
						horaInicial.getValue(),
						horaFinal.getValue(), 
						motivo.getText(), todos,
					    usuarioConectado
						);
			}
		
			Sessions.getCurrent().setAttribute("eventoId", null);
			pintor.cerrarVentana();
			pintor.refrescarmodulo();}

			else{
				Messagebox.show("La hora Final debe ser mayor a la Hora Inicial ");
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}