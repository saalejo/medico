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
import admisiones.servicio.PacienteServicio;

public class NuevoPacienteCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	Combobox municipiosCombo;
	private Textbox identificacion;
	private Textbox primerNombre;
	private InputElement tipoDocumento;
	private Textbox segundoNombre;
	private Textbox primerApellido;
	private Textbox segundoApellido;
	private Datebox fechaNacimiento;
	private Combobox genero;
	private Combobox estadoCivil;
	private Textbox lugarNacimiento;
	private Combobox zona;
	private Textbox primerTelefono;
	private Textbox direccion;
	private Textbox segundoTelefono;
	private Textbox mail;
	private Textbox ocupacion;
	private Combobox municipio;
	private Textbox antecedentesPatologicos;
	private Textbox antecedentesAlergicos;
	private Textbox antecedentesQuirurgicos;
	private Textbox antecedentesHabitos;
	private Textbox antecedentesFamiliares;
	private Textbox observaciones;
	private Textbox tipoUsuario;
	private Combobox entidad;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		identificacion.setText((String)Sessions.getCurrent().getAttribute("idPaciente"));
		Sessions.getCurrent().setAttribute("idPaciente",null);
		obtenerMunicipios();
		obtenerEntidades();
		
	}
	
	
	public void obtenerMunicipios() {
		List<Municipio> municipios;
		try {
			MunicipioServicio municipioServicio = (MunicipioServicio) SpringUtil.getBean("municipioServicio");
			municipios = municipioServicio.obtener();
			ListModel tiposDesplegable = new ListModelList(municipios);
			municipio.setModel(tiposDesplegable);
			municipio.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					Municipio municipio = (Municipio) arg1;
					arg0.setLabel(municipio.getNombre());
					String id =""+municipio.getId();
					arg0.setId(id);	
					
				}

				
			});
			
		} catch (Exception e) {
			
		}

	}
	
	public void obtenerEntidades() {
		List<Entidad> entidades;
		try {
			EntidadServicio entidadServicio = (EntidadServicio) SpringUtil.getBean("entidadServicio");
			entidades = entidadServicio.obtener();
			ListModel entidadDesplegable = new ListModelList(entidades);
			entidad.setModel(entidadDesplegable);
			entidad.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					Entidad entidad = (Entidad) arg1;
					arg0.setLabel(entidad.getNombre());
					String id =""+entidad.getId();					
					arg0.setId(id);
					
				}

				
				
			});
			
		} catch (Exception e) {
			
		}

	}
	
	public void onClick$cancelar(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}
	
	
	public void onClick$guardar(){	
		
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		PacienteServicio pacienteServicio = (PacienteServicio) SpringUtil.getBean("pacienteServicio");
		try {
			pacienteServicio.guardar(
					identificacion.getText(),
					tipoDocumento.getText(),
					primerNombre.getText(),
					segundoNombre.getText(), 
					primerApellido.getText(),				
					segundoApellido.getText(),
					fechaNacimiento.getValue(),
					genero.getText(),
					zona.getText(),
					Integer.parseInt(municipio.getSelectedItem().getId()),
					primerTelefono.getText(),
					segundoTelefono.getText(),
					direccion.getText(),
					antecedentesPatologicos.getText(),
					antecedentesQuirurgicos.getText(),				
					antecedentesAlergicos.getText(),
					antecedentesHabitos.getText(),
					antecedentesFamiliares.getText(),
					mail.getText(),
					observaciones.getText(),
					estadoCivil.getText(),
					lugarNacimiento.getText(),
					ocupacion.getText(),
					tipoUsuario.getText(),
					Integer.parseInt(entidad.getSelectedItem().getId()),
					usuarioConectado
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}