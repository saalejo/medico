package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import hcdigital.util.calculos.Matematico;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.db.dto.modelo.AutorizacionPaciente;
import historia.clinica.db.dto.modelo.Diagnostico;
import historia.clinica.db.dto.modelo.DiagnosticoMaestro;
import historia.clinica.db.dto.modelo.Formula;
import historia.clinica.db.dto.modelo.Medicamento;
import historia.clinica.servicio.AtencionServicio;
import historia.clinica.servicio.AutorizacionPacienteServicio;
import historia.clinica.servicio.DiagnosticoMaestroServicio;
import historia.clinica.servicio.FormulaServicio;
import historia.clinica.servicio.IncapacidadServicio;
import historia.clinica.servicio.RemisionServicio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import admisiones.db.dto.modelo.MedicamentoMaestro;
import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.MedicamentoMaestroServicio;


public class SubFormulariosAtencionCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;

	Paciente paciente;
	Pintor pintor;
	Atencion atencion;
	
	
	//-----------------Formula--------------------------------
	Radiogroup rdPlanManejo;
	Textbox txtCodigoMedicamento;
	Textbox txtConcentracionMedicamento;
	Textbox txtFormaFarmaceutica;
	Textbox txtViaDeAdministracion;
	Textbox txtUnidadDeConsumo;
	Textbox txtCantidad;
	Textbox txtPosologia;
	Listbox listaMedicamentos;
	Combobox medicamentosCombo;
	HashMap<String,Medicamento> medicamentos=new HashMap<String, Medicamento>();
	String codigoMedicamentoMaestro;
	//-------------------Ayudas Diagnosticas---------------------
	Textbox txtCodigoServicio;
	Textbox txtNombreServicio;
	Combobox comboEstado;	
	Textbox txtCantidadAyudas;
	Textbox txtObservaciones;
	//------------------Incapacidad--------------------------
	private Textbox orden;
	private Datebox fechaInicio;
	Datebox fechaFin;
	Textbox idPaciente;
	Textbox nombrePaciente;
	Label cantidadDias;
	//----------------Autorizacion Paciente------------------
	
	Radiogroup radioResponsable;
	Radiogroup radioTipoProcedimiento;
	Textbox txtNombreAutoriza;
	Textbox txtCodigoDiagnosticoAutorizacionPaciente;
	Combobox comboDescripcionDiagnostico;
	Textbox txtProcedimiento;
	Textbox txtAspectosProcedimiento;
	Textbox txtRiesgos;
	Textbox txtPreparacion;
	Textbox txtProximaCitaLugar;
	Textbox txtRequerimientoEspecial;
	Textbox txtTiempoQuirurgico;
	Window diagnosticosTab;
	
	//------------------Remision------------------------------
	private Textbox motivo;
	private Textbox resultados;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		
		//---------------Diagnosticos---------------
		pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.abrirVentana("historia/clinica/web/vista/diagnosticoForm.zul", diagnosticosTab);
		paciente=(Paciente)Sessions.getCurrent().getAttribute("paciente");
		atencion=(Atencion)Sessions.getCurrent().getAttribute("atencion");
		obtenerDiagnosticos();
		obtenerMedicamentos();
		
		
	}
	
	public void obtenerMedicamentos() {		
		List<MedicamentoMaestro> medicamentos;
		try {
			
			MedicamentoMaestroServicio medicamentoMaestroServicio = (MedicamentoMaestroServicio) SpringUtil.getBean("medicamentoMaestroServicio");		
			medicamentos = medicamentoMaestroServicio.obtener();
			ListModel tiposDesplegable = new ListModelList(medicamentos);
			medicamentosCombo.setModel(tiposDesplegable);
			medicamentosCombo.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					MedicamentoMaestro medicamento = (MedicamentoMaestro) arg1;
					arg0.setLabel(medicamento.getNombre());
					String id ="med"+medicamento.getId();
					arg0.setId(id);				
				}
				
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void onChange$txtCodigomedicamento() {		
		try {			
			String codigoMedicamento=txtCodigoMedicamento.getValue();
			MedicamentoMaestroServicio medicamentoMaestroServicio = (MedicamentoMaestroServicio) SpringUtil.getBean("medicamentoMaestroServicio");		
			MedicamentoMaestro medicamentoMaestro = medicamentoMaestroServicio.obtener(codigoMedicamento);
			medicamentosCombo.getSelectedItem().setId("med"+medicamentoMaestro.getId());
			medicamentosCombo.getSelectedItem().setLabel(medicamentoMaestro.getNombre());			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
	}
	public void onClick$nuevoMedicamento(){			
		final Medicamento medicamento=new Medicamento();
		medicamento.setCantidad(txtCantidad.getText());		
		medicamento.setMedicamentoMaestroId(Integer.parseInt(medicamentosCombo.getSelectedItem().getId().substring(3)));
		medicamento.setPosologia(txtPosologia.getText());		
		final Listitem listItem=new Listitem();
		listItem.appendChild(new Listcell(medicamentosCombo.getSelectedItem().getLabel()));
		listItem.appendChild(new Listcell(medicamento.getCantidad())); 
		listItem.appendChild(new Listcell(medicamento.getObservaciones())); 
		Button boton=new Button("remover");
		boton.addEventListener("onClick", new EventListener() {
			@Override
			public void onEvent(Event arg0) throws Exception {				
				listaMedicamentos.removeChild(listItem);
				medicamentos.remove(""+medicamento.getMedicamentoMaestroId());
			}
		});	
		Listcell listCell=new Listcell();
		listCell.appendChild(boton);
		listItem.appendChild(listCell);
		listaMedicamentos.appendChild(listItem);			
		medicamentos.put(""+medicamento.getMedicamentoMaestroId(), medicamento);
	}
	
	public void onClick$btnGuardarFormula(){
		
		Formula formula=new Formula();
		formula.setPlanManejo(rdPlanManejo.getSelectedItem().getLabel());
		formula.setAtencionId(atencion.getId());
		formula.setFecha(new Date());
		formula.setMedicamentos(new HashSet<Medicamento>(medicamentos.values()));
		FormulaServicio formulaServicio = (FormulaServicio) SpringUtil.getBean("formulaServicio");
		formulaServicio.guardar(formula);		
	}
	
	public void obtenerDiagnosticos() {
		List<DiagnosticoMaestro> diagnosticos;
		try {
			
			DiagnosticoMaestroServicio diagnosticoMaestroServicio = (DiagnosticoMaestroServicio) SpringUtil.getBean("diagnosticoMaestroServicio");
			diagnosticos= diagnosticoMaestroServicio.obtener();
			ListModel entidadDesplegable = new ListModelList(diagnosticos);			
			comboDescripcionDiagnostico.setModel(entidadDesplegable);
			comboDescripcionDiagnostico.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					DiagnosticoMaestro diagnostico = (DiagnosticoMaestro) arg1;
					arg0.setLabel(diagnostico.getDescripcion());
					String id ="aut"+diagnostico.getId();
					arg0.setId(id);
					
				}

				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void onClick$remitir(){	
			
			try {
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				String usuarioConectado=profesional.getUsuario();
				RemisionServicio remisionServicio = (RemisionServicio) SpringUtil.getBean("remisionServicio");
				remisionServicio.guardar(atencion.getId(),motivo.getText(),resultados.getText(), usuarioConectado);
				Messagebox.show("Guardada la Remision", "Information", Messagebox.OK, Messagebox.INFORMATION);
				Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
				pintor.cerrarVentana();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
	public void onClick$btnGuardarIncapacidad(){	
		try {
			Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
			String usuarioConectado=profesional.getUsuario();
			IncapacidadServicio incapacidadServicio = (IncapacidadServicio) SpringUtil.getBean("incapacidadServicio");
			incapacidadServicio.guardar(atencion.getId(),fechaInicio.getValue(), fechaFin.getValue(), orden.getText(), usuarioConectado);
			Messagebox.show("Guardada la incapacidad", "Information", Messagebox.OK, Messagebox.INFORMATION);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			pintor.cerrarVentana();
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	public void onClick$btnguardarAutorizacionPaciente(){	
		try {
			AutorizacionPaciente autorizacionPaciente=new AutorizacionPaciente();
			autorizacionPaciente.setAtencionId(atencion.getId());
			autorizacionPaciente.setDiagnosticoId(Integer.parseInt(comboDescripcionDiagnostico.getSelectedItem().getId().substring(3)));
			autorizacionPaciente.setAspectosProcedimiento(txtAspectosProcedimiento.getValue());
			autorizacionPaciente.setNombreAutoriza(txtNombreAutoriza.getValue());
			autorizacionPaciente.setResponsable(radioResponsable.getSelectedItem().getLabel());
			autorizacionPaciente.setTipoProcedimiento(radioTipoProcedimiento.getSelectedItem().getLabel());
			autorizacionPaciente.setProcedimiento(txtProcedimiento.getValue());
			autorizacionPaciente.setRequerimientoEspecial(txtRequerimientoEspecial.getValue());
			autorizacionPaciente.setRiesgos(txtRiesgos.getValue());
			autorizacionPaciente.setTiempoQuirurgico(txtTiempoQuirurgico.getValue());
			autorizacionPaciente.setPreparacion(txtPreparacion.getValue());
			AutorizacionPacienteServicio autorizacionPacienteServicio = (AutorizacionPacienteServicio) SpringUtil.getBean("autorizacionPacienteServicio");
			autorizacionPacienteServicio.guardar(autorizacionPaciente);
			Messagebox.show("Guardada la autorizacionPaciente", "Information", Messagebox.OK, Messagebox.INFORMATION);			
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
	public void onChange$fechaFin() {
		
		int cantidadDias=Matematico.fechasDiferenciaEnDias(fechaInicio.getValue(), fechaFin.getValue());
		this.cantidadDias.setValue(""+cantidadDias);	
	}
}