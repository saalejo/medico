package logistico.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.awt.Component;
import java.io.Serializable;

import logistico.db.dto.modelo.Profesional;
import logistico.servicio.HorarioServicio;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;

import sun.security.action.GetBooleanAction;

public class NuevoHorarioCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Datebox horaInicial;
	private Datebox horaFinal;
	private Textbox dia;
	private Boolean activo;


	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	

	}
	
	public void onClick$cancelar(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}
	
	
	public void onClick$guardar(){	
		//------------------------------------------
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		int usuarioConectado=profesional.getUsuarioConectado();
		//------------------------------------------
		
		HorarioServicio 	horarioServicio = (HorarioServicio)SpringUtil.getBean("horarioServicio");
		try {
			horarioServicio.guardar(
					horaInicial.getValue(),
					horaFinal.getValue(),
					dia.getText(),
					activo.booleanValue(),
					usuarioConectado
					
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("logistico/web/vista/ListaHorarios.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}