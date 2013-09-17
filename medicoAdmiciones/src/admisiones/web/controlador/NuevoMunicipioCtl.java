package admisiones.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.InputElement;

import admisiones.db.dto.modelo.Entidad;
import admisiones.db.dto.modelo.Municipio;
import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.EntidadServicio;
import admisiones.servicio.MunicipioServicio;
import admisiones.servicio.MunicipioServicio;

public class NuevoMunicipioCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox nombre;
	private Textbox codigoMunicipio;
	private Textbox codigoDepartamento;

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
		
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		MunicipioServicio municipioServicio = (MunicipioServicio) SpringUtil.getBean("municipioServicio");
		try {
			municipioServicio.guardar(
					nombre.getText(),
					codigoMunicipio.getText(),
					codigoDepartamento.getText(),
					usuarioConectado
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("admisiones/web/vista/ListaMunicipios.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}