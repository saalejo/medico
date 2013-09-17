package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Timebox;


import admisiones.db.dto.modelo.Profesional;
import agenda.db.dto.modelo.Configuracion;
import agenda.servicio.ConfiguracionServicio;


public class NuevaConfiguracionCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	private Radio  Ssi;
	private Radio  Sno;
	private Radio  Dsi;
	private Radio  Dno;
	private Radio  Fsi;
	private Radio  Fno;
	
	private Textbox mensaje1;
	private Textbox mensaje2;
	private Timebox horaInicial;
	private Timebox horaFinal;
	private String configuracionId;
	int idConfiguracion=-1;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		final ConfiguracionServicio configuracionServicio = (ConfiguracionServicio) SpringUtil.getBean("configuracionServicio");
		List<Configuracion> configuraciones = configuracionServicio.obtener();
		
		configuracionId = ""+configuraciones.get(0).getId();
		idConfiguracion = configuraciones.get(0).getId();
		
		if(configuracionId!=null){
			Configuracion configuracion = configuraciones.get(0);
			
			if(configuracion.getSabado())
			{
				Ssi.setChecked(true);
				Sno.setChecked(false);
			}
			else
			{
				Ssi.setChecked(false);
				Sno.setChecked(true);
			}
			
			if(configuracion.getDomingo())
			{
				Dsi.setChecked(true);
				Dno.setChecked(false);
			}
			else
			{
				Dsi.setChecked(false);
				Dno.setChecked(true);
			}
			
			if(configuracion.getFestivo())
			{
				Fsi.setChecked(true);
				Fno.setChecked(false);
			}
			else
			{
				Fsi.setChecked(false);
				Fno.setChecked(true);
			}
			
			mensaje1.setText(configuracion.getMensaje1());
			mensaje2.setText(configuracion.getMensaje2());
			horaInicial.setValue(configuracion.getHoraInicial());
			horaFinal.setValue(configuracion.getHoraFinal());
		}
		
			
			
		
		
	}
	
	
	
	public void onClick$guardar(){	
		
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		ConfiguracionServicio configuracionServicio = (ConfiguracionServicio) SpringUtil.getBean("configuracionServicio");
		
		Boolean sabado = false;
		Boolean domingo = false;
		Boolean festivo = false;
		Date horaIni = horaInicial.getValue();
		Date horaFi = horaFinal.getValue();
		
		
		if(Ssi.isChecked())
		{
			sabado = true;
		}
		if(Dsi.isChecked())
		{
			domingo = true;
		}
		if(Fsi.isChecked())
		{
			festivo = true;
		}
		
		try {
			
			if(horaInicial.getValue().before(horaFinal.getValue())){
			
				configuracionServicio.actualizar(idConfiguracion, 
						sabado, domingo, festivo, mensaje1.getText(), 
						mensaje2.getText(), horaIni, horaFi,
						usuarioConectado);
				
			Messagebox.show("La configuracion de la agenda ha sido actualizada.");
			}
			else
			{
				Messagebox.show("La hora Final debe ser mayor a la Hora Inicial ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	
	
	
	
}