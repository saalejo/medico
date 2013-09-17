package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.db.dto.modelo.CausaExterna;
import historia.clinica.db.dto.modelo.Diagnostico;
import historia.clinica.db.dto.modelo.DiagnosticoMaestro;
import historia.clinica.db.dto.modelo.Finalidad;
import historia.clinica.db.dto.modelo.Ingreso;
import historia.clinica.servicio.AtencionServicio;
import historia.clinica.servicio.CausaExternaServicio;
import historia.clinica.servicio.DiagnosticoMaestroServicio;
import historia.clinica.servicio.FinalidadServicio;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.InputElement;
import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;


public class DiagnosticoCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;	

	Paciente paciente;	
	Pintor pintor;
	Atencion atencion;
	//---------------Diagnosticos---------------
		HashMap<String,Diagnostico> diagnosticos=new HashMap<String, Diagnostico>();
		Combobox diagnosticosCombo;
		Listbox listaDiagnosticos;
		Textbox observaciones;
		Textbox txtCodigoDiagnostico;
		Radiogroup rdDiagnosticoPrincipal;
		Radiogroup rdDiagnosticoIngresoEgreso;
		Combobox comboTipoDiagnostico;
		Combobox comboClaseDiagnostico;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		paciente=(Paciente)Sessions.getCurrent().getAttribute("paciente");
		atencion=(Atencion)Sessions.getCurrent().getAttribute("atencion");
		obtenerDiagnosticos();
	}
	
	public void obtenerDiagnosticos() {
		List<DiagnosticoMaestro> diagnosticos;
		try {
			
			DiagnosticoMaestroServicio diagnosticoMaestroServicio = (DiagnosticoMaestroServicio) SpringUtil.getBean("diagnosticoMaestroServicio");
			diagnosticos= diagnosticoMaestroServicio.obtener();
			ListModel entidadDesplegable = new ListModelList(diagnosticos);
			diagnosticosCombo.setModel(entidadDesplegable);
			diagnosticosCombo.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					DiagnosticoMaestro diagnostico = (DiagnosticoMaestro) arg1;
					arg0.setLabel(diagnostico.getDescripcion());
					String id ="dia"+diagnostico.getId();
					arg0.setId(id);
					
				}

				
				
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void onClick$nuevoDiagnostico(){	
		
		final Diagnostico diagnostico=new Diagnostico();
		if (rdDiagnosticoPrincipal.getSelectedItem().getId().equals("si")){
			diagnostico.setPrinsipal(true);		
		}
		diagnostico.setIngresoEgreso(rdDiagnosticoIngresoEgreso.getSelectedItem().getLabel());
		diagnostico.setTipo(comboTipoDiagnostico.getValue());
		diagnostico.setClase(comboClaseDiagnostico.getValue());
		diagnostico.setDiagnosticoId(Integer.parseInt(diagnosticosCombo.getSelectedItem().getId().substring(3)));
		diagnostico.setObservaciones(observaciones.getText());		
		final Listitem listItem=new Listitem();
		listItem.appendChild(new Listcell(diagnosticosCombo.getSelectedItem().getLabel()));
		listItem.appendChild(new Listcell(diagnostico.getObservaciones())); 
		Button boton=new Button("remover");
		boton.addEventListener("onClick", new EventListener() {
			@Override
			public void onEvent(Event arg0) throws Exception {				
				listaDiagnosticos.removeChild(listItem);
				diagnosticos.remove(""+diagnostico.getDiagnosticoId());
			}
		});	
		Listcell listCell=new Listcell();
		listCell.appendChild(boton);
		listItem.appendChild(listCell);
		observaciones.setText("");
		listaDiagnosticos.appendChild(listItem);			
		diagnosticos.put(""+diagnostico.getDiagnosticoId(), diagnostico);
	}
	
	public void onClick$btnGuardarDiagnosticos(){			
		atencion.getDiagnosticos().addAll(diagnosticos.values());
		AtencionServicio atencionServicio = (AtencionServicio) SpringUtil.getBean("atencionServicio");
		atencionServicio.actualizar(atencion);		
	}
		
}