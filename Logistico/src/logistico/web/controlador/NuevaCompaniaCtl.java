package logistico.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.awt.Component;
import java.io.Serializable;

import logistico.db.dto.modelo.Profesional;
import logistico.servicio.CompaniaServicio;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class NuevaCompaniaCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox nit;
	private Textbox direccion;
	private Textbox telefono;
	private Textbox codigoHabilitacionIps;
	private Textbox sloganIps;
	private Combobox departamento;
	private Combobox municipio;
	private Combobox barrio;
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
		
		CompaniaServicio companiaServicio = (CompaniaServicio)SpringUtil.getBean("companiaServicio");
		try {
			companiaServicio.guardar(
					nit.getText(),
					direccion.getText(),
					telefono.getText(),
					codigoHabilitacionIps.getText(),
					sloganIps.getText(),
					usuarioConectado,
					Integer.parseInt(departamento.getSelectedItem().getLabel()),
					Integer.parseInt(municipio.getSelectedItem().getLabel()),
					Integer.parseInt(barrio.getSelectedItem().getLabel())
					
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("logistico/web/vista/ListaSedes.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}