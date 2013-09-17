package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import hcdigital.util.calculos.Matematico;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.db.dto.modelo.CampoHistoria;
import historia.clinica.db.dto.modelo.Diagnostico;
import historia.clinica.db.dto.modelo.Ingreso;
import historia.clinica.servicio.AtencionServicio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;


public class NuevaConsultaGeneralCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	Textbox tipoConsulta;	
	private Textbox observaciones;
	Paciente paciente;
	Listbox listaDiagnosticos;
	Textbox idPaciente;
	Textbox nombrePaciente;
	private Ingreso ingreso;
	Pintor pintor;
	Atencion atencion;
	private Set<CampoHistoria> camposHistoria=new HashSet<CampoHistoria>();
	Grid formularioDiscapacidad;
	
	
	//---------Motivo------------
	Textbox txtMotivoConsulta;
	Textbox txtEnfermedadActual;
	Textbox txtRemitirPacienteA;
	
	//formulario discapacidad
	Checkbox chBoxDiscapacitado;
	Combobox comboDiscapacidadCognitiva;
	Textbox textoDiscapacidadCognitiva;
	Combobox comboDiscapacidadFisica;
	Textbox textoDiscapacidadFisica;
	Combobox comboDiscapacidad;
	Textbox textoDiscapacidad;
	
	
	// revision sistemas
	Combobox neurologico;
	Textbox neurologicoObservaciones;
	Combobox organosDeLosSentidos;
	Textbox organosDeLosSentidosObservaciones;
	Combobox orofaringeYGarganta;
	Textbox orofaringeYGargantaObservaciones;
	Combobox cardioPulmonar;
	Textbox cardioPulmonarObservaciones;
	Combobox gastroIntestinal;
	Textbox gastroIntestinalObservaciones;
	Combobox endocrino;
	Textbox endocrinoObservaciones;
	Combobox vascularPeriferico;
	Textbox vascularPerifericoObservaciones;
	Combobox linfatico;
	Textbox linfaticoObservaciones;
	Combobox osteoMuscular;
	Textbox osteoMuscularObservaciones;
	Combobox genitoUrinario;
	Textbox genitoUrinarioObservaciones;
	Combobox sistemaReproductivo;
	Textbox sistemaReproductivoObservaciones;
	Combobox pielYTegumentarios;
	Textbox pielYTegumentariosObservaciones;
	Checkbox revisarActualisar;
	
	
	
	//EXAMEN FISICO

	Textbox textoIndiceMasaCorporal;
	Textbox talla;
	Textbox peso;
	Textbox textoPresionArterial;
	Textbox textoFrecuenciaCardiaca;
	Textbox textoFrecuenciaRespiratoria;
	Textbox textoTemperatura;
	Combobox cabezaYCuello;
	Textbox cabezaYCuelloObservaciones;
	Combobox examenFisicoOrganosDeLosSentidos;
	Textbox examenFisicoOrganosDeLosSentidosObservaciones;
	Combobox cardioVascular;
	Textbox cardioVascularObservaciones;
	Combobox pulmonar;
	Textbox pulmonarObservaciones;
	Combobox mamas;
	Textbox mamasObservaciones;
	Combobox abdomen;
	Textbox abdomenObservaciones;
	Combobox extremidades;
	Textbox extremidadesObservaciones;
	Combobox examenFisicoOsteoMuscular;
	Textbox examenFisicoOsteoMuscularObservaciones;
	Combobox examenFisicoVascularPeriferico;
	Textbox examenFisicoVascularPerifericoObservaciones;
	Combobox examenFisicoNeurologico;
	Textbox examenFisicoNeurologicoObservaciones;
	Combobox hematoPoyetico;
	Textbox hematoPoyeticoObservaciones;
	Combobox examenFisicoGenitoUrinario;
	Textbox examenFisicoGenitoUrinarioObservaciones;
	
	//INTERPRETACION AYUDAS DIAGNOSTICAS
	Textbox interpretacionAyudasDiagnosticas;
	Checkbox reaccionSi;
	Textbox reaccionMedicamentosa;
	Checkbox eventoSi;
	Checkbox enLaInstitucionSi;
	Combobox eventoAdverso;
	
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		atencion=(Atencion)Sessions.getCurrent().getAttribute("atencion");
		formularioDiscapacidad.setVisible(false);		
	}
	
	public void onCheck$chBoxDiscapacitado(){
		if(chBoxDiscapacitado.isChecked()){
			formularioDiscapacidad.setVisible(true);
		}else{
			formularioDiscapacidad.setVisible(false);
		}
	}
	
	public void onChange$peso(){
		if(!peso.getText().equals("") && !talla.getText().equals("")){
			int intPeso=Integer.parseInt(peso.getText());
			int intTalla=Integer.parseInt(talla.getText());
			textoIndiceMasaCorporal.setText(""+Matematico.calcularIndicedeMasaCorporal(intPeso, intTalla));			
		}
		
	}
	public void onChange$talla(){
		if(!peso.getText().equals("") && !talla.getText().equals("")){
			int intPeso=Integer.parseInt(peso.getText());
			int intTalla=Integer.parseInt(talla.getText());
			textoIndiceMasaCorporal.setText(""+Matematico.calcularIndicedeMasaCorporal(intPeso, intTalla));			
		}		
	}
	
	public void ajustarCamposHistoria(){
		CampoHistoria campoHistoria;
		campoHistoria=new CampoHistoria("MOTIVO",txtMotivoConsulta.getValue(),"","");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("ENFERMEDAD ACTUAL",txtEnfermedadActual.getValue(),"","");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("REMITIR PACIENTE A",txtRemitirPacienteA.getValue(),"","");
		camposHistoria.add(campoHistoria);
		// DISCAPACIDAD
		if(chBoxDiscapacitado.isChecked()){
			campoHistoria=new CampoHistoria("DISCAPACITADO","si","","formulario.discapacidad");
			camposHistoria.add(campoHistoria);
			campoHistoria=new CampoHistoria("DISCAPACIDAD COGNITIVA",comboDiscapacidadCognitiva.getSelectedItem().getLabel(),textoDiscapacidadCognitiva.getText(),"formulario.discapacidad");
			camposHistoria.add(campoHistoria);
			campoHistoria=new CampoHistoria("DISCAPACIDAD FISICA",comboDiscapacidadFisica.getSelectedItem().getLabel(),textoDiscapacidadFisica.getText(),"formulario.discapacidad");
			camposHistoria.add(campoHistoria);
			campoHistoria=new CampoHistoria("DISCAPACIDAD",comboDiscapacidad.getSelectedItem().getLabel(),textoDiscapacidad.getText(),"formulario.discapacidad");
			camposHistoria.add(campoHistoria);
		}		
		// REVISION SISTEMAS
			campoHistoria=new CampoHistoria("NEUROLOGICO",neurologico.getValue(),neurologicoObservaciones.getText(),"formulario.revision.sistemas");
			camposHistoria.add(campoHistoria);
		try{	
			campoHistoria=new CampoHistoria("ORGANOS DE LOS SENTIDOS",organosDeLosSentidos.getValue(),organosDeLosSentidosObservaciones.getText(),"formulario.revision.sistemas");
			camposHistoria.add(campoHistoria);
		}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("OROFARINGE Y GARGANTA",orofaringeYGarganta.getValue(),orofaringeYGargantaObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("CARDIOPULMONAR",cardioPulmonar.getValue(),cardioPulmonarObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("GASTROINTESTINAL",gastroIntestinal.getValue(),gastroIntestinalObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("ENDOCRINO",endocrino.getValue(),endocrinoObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("VASCULAR PERIFERICO",vascularPeriferico.getValue(),vascularPerifericoObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("LINFATICO",linfatico.getValue(),linfaticoObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("OSTEOMUSCULAR",osteoMuscular.getValue(),osteoMuscularObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("GENITOURINARIO",genitoUrinario.getValue(),genitoUrinarioObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("SISTEMA REPRODUCTIVO",sistemaReproductivo.getValue(),sistemaReproductivoObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("PIEL Y TEGUMENTARIOS",pielYTegumentarios.getValue(),pielYTegumentariosObservaciones.getText(),"formulario.revision.sistemas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}
		//EXAMEN FISICO
		campoHistoria=new CampoHistoria("PESO",peso.getText(),"","examen.fisico");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("TALLA",talla.getText(),"","examen.fisico");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("INDICE DE MASA CORPORAL",textoIndiceMasaCorporal.getText(),"","examen.fisico");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("PRESION ARTERIAL",textoPresionArterial.getText(),"","examen.fisico");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("FRECUENCIA CARDIACA",textoFrecuenciaCardiaca.getText(),"","examen.fisico");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("FRECUENCIA RESPIRATORIA",textoFrecuenciaRespiratoria.getText(),"","examen.fisico");
		camposHistoria.add(campoHistoria);
		campoHistoria=new CampoHistoria("TEMPERATURA",textoTemperatura.getText(),"" ,"examen.fisico");
		camposHistoria.add(campoHistoria);try{
		campoHistoria=new CampoHistoria("CABEZA Y CUELLO",cabezaYCuello.getValue(),cabezaYCuelloObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("ORGANOS DE LOS SENTIDOS",examenFisicoOrganosDeLosSentidos.getValue(),examenFisicoOrganosDeLosSentidosObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("CARDIO VASCULAR",cardioVascular.getValue(),cardioVascularObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("PULMONAR",pulmonar.getValue(),pulmonarObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("MAMAS",mamas.getValue(),mamasObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("ABDOMEN",abdomen.getValue(),abdomenObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("EXTREMIDADES",extremidades.getValue(),extremidadesObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("OSTEO MUSCULAR",examenFisicoOsteoMuscular.getValue(),examenFisicoOsteoMuscularObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("VASCULAR PERIFERICO",examenFisicoVascularPeriferico.getValue(),examenFisicoVascularPerifericoObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("NEUROLOGICO",examenFisicoNeurologico.getValue(),examenFisicoNeurologicoObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("HEMATOPOYETICO",hematoPoyetico.getValue(),examenFisicoGenitoUrinarioObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}try{
		campoHistoria=new CampoHistoria("GENITO URINARIO",examenFisicoGenitoUrinario.getValue(),examenFisicoGenitoUrinarioObservaciones.getText(),"examen.fisico");
		camposHistoria.add(campoHistoria);}catch(Exception e){}
		
		//AYUDAS DIAGNOSTICAS		
		campoHistoria=new CampoHistoria("INTERPRETACION AYUDAS DIAGNOSTICAS",interpretacionAyudasDiagnosticas.getText(),"","ayudas.diagnosticas");
		camposHistoria.add(campoHistoria);
		if(reaccionSi.isChecked()){
			campoHistoria=new CampoHistoria("REACCION MEDICAMENTOSA","si",reaccionMedicamentosa.getText(),"ayudas.diagnosticas");			
		}else{
			campoHistoria=new CampoHistoria("REACCION MEDICAMENTOSA","no","","ayudas.diagnosticas");			
		}
		camposHistoria.add(campoHistoria);
		if(eventoSi.isChecked()){
			campoHistoria=new CampoHistoria("EVENTO ADVERSO O INCIDENTE","si","","ayudas.diagnosticas");			
		}else{
			campoHistoria=new CampoHistoria("EVENTO ADVERSO O INCIDENTE","no","","ayudas.diagnosticas");			
		}
		camposHistoria.add(campoHistoria);
		if(enLaInstitucionSi.isChecked()){
			campoHistoria=new CampoHistoria("SE ORIGINO EN ESTA INSTITUCION","si","","ayudas.diagnosticas");			
		}else{
			campoHistoria=new CampoHistoria("SE ORIGINO EN ESTA INSTITUCION","no","","ayudas.diagnosticas");			
		}
		camposHistoria.add(campoHistoria);try{
		campoHistoria=new CampoHistoria("EVENTO ADVERSO",eventoAdverso.getValue(),"","ayudas.diagnosticas");
		camposHistoria.add(campoHistoria);}catch(Exception e){}
		
	}
	
	public void onClick$guardar(){
		try {
			if(atencion!=null){	
				ajustarCamposHistoria();
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				atencion.setCamposHistoria(camposHistoria);
				atencion.setIngresoId(ingreso.getId());
				atencion.setFechaAtencion(new Date());
				atencion.setObservaciones(observaciones.getText());
				atencion.setPacienteId(paciente.getId());
				atencion.setMunicipioId(profesional.getPrestador().getMunicipio().getId());
				atencion.setProfesionalId(profesional.getId());
				atencion.setDiagnosticos(new HashSet<Diagnostico>());	
				atencion.setCamposHistoria(camposHistoria);			
				AtencionServicio atencionServicio = (AtencionServicio) SpringUtil.getBean("atencionServicio");			
				atencionServicio.guardar(atencion);	
			}
			if(pintor!=null){			
				pintor.abrirVentana("historia/clinica/web/vista/SubFormulariosAtencion.zul","contenidoPosicion",null);
			}
		} catch (Exception e){
			e.printStackTrace();
			
		}
	}
	public void onClick$btnNuevaCausaExterna(){		
		if(pintor!=null){								
			try {
		pintor.abrirVentana("historia/clinica/web/vista/NuevaCausaExterna.zul","",null);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
				
	}
	public void onClick$btnNuevafinalidad(){	
		if(pintor!=null){								
			try {
		pintor.abrirVentana("historia/clinica/web/vista/NuevaFinalidad.zul","",null);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}
}