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
import admisiones.db.dto.modelo.MedicamentoMaestro;
import admisiones.db.dto.modelo.Municipio;
import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.EntidadServicio;
import admisiones.servicio.MunicipioServicio;
import admisiones.servicio.MedicamentoMaestroServicio;

public class NuevoMedicamentoMaestroCtl extends GenericForwardComposer
		implements Serializable {

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;

	private Textbox txtNombre;
	private Textbox txtCantidad;
	private Textbox txtPosologia;
	private Textbox txtCodigo;
	private Textbox txtFormaFarmaceutica;
	private Textbox txtViaDeAdministracion;
	private Textbox txtUnidadDeConsumo;
	private Textbox txtConcentracion;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

	public void onClick$cancelar() {
		Pintor pintor = (Pintor) Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}

	public void onClick$guardar(){	
		MedicamentoMaestro medicamentoMaestro=new MedicamentoMaestro();
		medicamentoMaestro.setNombre(txtNombre.getValue());
		medicamentoMaestro.setCodigo(txtCodigo.getValue());
		medicamentoMaestro.setCantidad(txtCantidad.getValue());
		medicamentoMaestro.setConcentracion(txtConcentracion.getValue());
		medicamentoMaestro.setFormaFarmaceutica(txtFormaFarmaceutica.getValue());
		medicamentoMaestro.setPosologia(txtPosologia.getValue());
		medicamentoMaestro.setUnidadDeConsumo(txtUnidadDeConsumo.getValue());
		medicamentoMaestro.setViaDeAdministracion(txtViaDeAdministracion.getValue());
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		medicamentoMaestro.setUsuarioConectado(usuarioConectado);		
		MedicamentoMaestroServicio medicamentoServicio = (MedicamentoMaestroServicio) SpringUtil.getBean("medicamentoMaestroServicio");
		medicamentoServicio.guardar(medicamentoMaestro);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("admisiones/web/vista/ListaMedicamentosMaestros.zul","contenidoPosicion",null);
			}		
	}
}