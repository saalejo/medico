package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import hcdigital.util.calculos.Matematico;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.db.dto.modelo.CausaExterna;
import historia.clinica.db.dto.modelo.Finalidad;
import historia.clinica.db.dto.modelo.Ingreso;
import historia.clinica.servicio.CausaExternaServicio;
import historia.clinica.servicio.FinalidadServicio;
import historia.clinica.servicio.IngresoServicio;

import java.io.Serializable;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import admisiones.db.dto.modelo.Paciente;
import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.PacienteServicio;


public class MenuHCCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Window contenidoHC;
	Paciente paciente;
	Ingreso ingreso;
	Menuitem btnAtenciones;
	Menuitem btnIngreso;
	Pintor pintor;
	Combobox finalidad;
	Combobox causaExterna;
	Combobox tipoHistoria;
	Combobox areaServicio;
	Textbox idPaciente;
	Textbox nombrePaciente;
	Textbox idIngreso;
	Textbox edad;
	Textbox sexo;
	Atencion atencion;
	Row filaHistoria;
	
	
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		iniciar();
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		if(profesional.getTipoUsuario().equals("medico")){
			filaHistoria.setVisible(true);	
			btnIngreso.setVisible(false);
			obtenerCausasExternas();
			obtenerFinalidades();
		}else{
			filaHistoria.setVisible(false);	
			btnIngreso.setVisible(true);
		}	
		
	}	
	
	public void iniciar() {
		paciente=(Paciente)Sessions.getCurrent().getAttribute("paciente");
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		Sessions.getCurrent().setAttribute("contenidoPosicion",contenidoHC);
		if(paciente!=null){			
			btnAtenciones.setVisible(true);
			nombrePaciente.setText(paciente.getPrimerNombre()+" "+paciente.getSegundoNombre()+" "+paciente.getPrimerApellido()+" "+paciente.getSegundoApellido());
			idPaciente.setText(paciente.getIdentificacion());
			edad.setText(""+Matematico.calcularEdad(paciente.getFechaNacimiento()));
			sexo.setText(paciente.getGenero());
			IngresoServicio ingresoServicio = (IngresoServicio) SpringUtil.getBean("ingresoServicio");
			ingreso = ingresoServicio.obtener(paciente.getId());
			if(ingreso!=null){					
				Sessions.getCurrent().setAttribute("ingreso",ingreso);
				if(!ingreso.getEstado().equals("cerrado")){	
					idIngreso.setText(""+ingreso.getId());
				}else{
					idIngreso.setText(ingreso.getEstado());			
				}
			}else{				
				idIngreso.setText("");
			}
		}else{
			btnAtenciones.setVisible(false);
			btnIngreso.setVisible(false);
			nombrePaciente.setText("");
			idPaciente.setText("");
			edad.setText("");
			sexo.setText("");
		}
	}
	public void onChange$tipoHistoria(){
		atencion=new Atencion();
		atencion.setCausaExternaId(Integer.parseInt(causaExterna.getSelectedItem().getId()));
		atencion.setFinalidadId(Integer.parseInt(finalidad.getSelectedItem().getId()));
		atencion.setTipoConsulta(tipoHistoria.getSelectedItem().getLabel());
		Sessions.getCurrent().setAttribute("atencion", atencion);
		String zul="";
		
		if(atencion.getTipoConsulta().equals("CONSULTA MEDICA GENERAL")){
			zul="historia/clinica/web/vista/ConsultaGeneral.zul";
		}
		if(pintor!=null && zul!=""){								
			try {
				pintor.abrirVentana(zul,"contenidoPosicion",null);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}
	
	/**
	 *  Evento Click del boton Acceder
	 */
	public void onClick$btnPaciente(){
		try {	
			if(pintor!=null){	
				if(paciente==null){
					pintor.abrirVentana("admisiones/web/vista/BuscarPaciente.zul","contenidoPosicion",null);
					//Sessions.getCurrent().setAttribute("contenido", contenido);					
				}else{
					pintor.abrirVentana("admisiones/web/vista/DatosPaciente.zul","contenidoPosicion",null);
				}					
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}	

	public void onClick$btnIngreso(){
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		if(pintor!=null && profesional!=null){								
			try {
				if(ingreso!=null){	
						if(ingreso.getEstado().equals("cerrado")){ 
							IngresoServicio ingresoServicio = (IngresoServicio) SpringUtil.getBean("ingresoServicio");
							ingresoServicio.nuevo(paciente.getId(),profesional.getUsuario());							
						}
				}else{
					IngresoServicio ingresoServicio = (IngresoServicio) SpringUtil.getBean("ingresoServicio");
					ingresoServicio.nuevo(paciente.getId(),profesional.getUsuario());				
				}	
				pintor.setModulo("historia/clinica/web/vista/Menu.zul");
				pintor.setContenido("historia/clinica/web/vista/Ingreso.zul");
				pintor.refrescarmodulo();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		}
		
		
	}	
	
	
	public void onClick$btnAtenciones(){
		if(pintor!=null){								
			try {
				pintor.abrirVentana("historia/clinica/web/vista/Atenciones.zul","contenidoPosicion",null);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	public void onOK$idPaciente(){
		try {	
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null){
				String id= idPaciente.getText();			
				PacienteServicio pacienteServicio = (PacienteServicio) SpringUtil.getBean("pacienteServicio");
				Paciente paciente=pacienteServicio.obtener(id);		
				if(paciente==null){								
					Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
					if(profesional.getTipoUsuario().equals("medico")){
						Messagebox.show("El paciente no tiene un ingreso activo", "", Messagebox.OK, Messagebox.EXCLAMATION);						
					}else{
							btnIngreso.setVisible(true);
							filaHistoria.setVisible(false);
							Sessions.getCurrent().setAttribute("idPaciente", id);
							pintor.setModulo("admisiones/web/vista/Menu.zul");
							pintor.setContenido("admisiones/web/vista/NuevoPaciente.zul");
							pintor.refrescarmodulo();
					}
					
				}
				else{
					Sessions.getCurrent().setAttribute("paciente", paciente);				
					pintor.refrescarmodulo();				
				}			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
public void obtenerFinalidades() {
		
		List<Finalidad> finalidades;
		try {
			
			FinalidadServicio finalidadServicio = (FinalidadServicio) SpringUtil.getBean("finalidadServicio");			
			finalidades = finalidadServicio.obtener();
			ListModel tiposDesplegable = new ListModelList(finalidades);
			finalidad.setModel(tiposDesplegable);
			finalidad.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					Finalidad finalidad = (Finalidad) arg1;
					arg0.setLabel(finalidad.getFinalidad());
					String id =""+finalidad.getId();
					arg0.setId(id);
					
				}

				
				
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void obtenerCausasExternas() {
		List<CausaExterna> CausasExternas;
		try {
			CausaExternaServicio causaExternaServicio = (CausaExternaServicio) SpringUtil.getBean("causaExternaServicio");
			CausasExternas = causaExternaServicio.obtener();
			ListModel entidadDesplegable = new ListModelList(CausasExternas);
			causaExterna.setModel(entidadDesplegable);
			causaExterna.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					CausaExterna causaExterna = (CausaExterna) arg1;
					arg0.setLabel(causaExterna.getDescripcion());
					String id =""+causaExterna.getId();
					arg0.setId(id);
					
				}

				
				
			});
			
		} catch (Exception e) {
			
		}

	}
	
	
}