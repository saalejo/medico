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
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;

import admisiones.db.dto.modelo.Prestador;
import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.PrestadorServicio;
import admisiones.servicio.ProfesionalServicio;

public class NuevoProfesionalCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox usuario;
	private Textbox clave;
	private Textbox tipoUsuario;
	private Textbox nombre;
	private Textbox codigo;
	private Combobox prestador;
	private Combobox estado;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		obtenerPrestadores();
		
	}
	
	
	public void obtenerPrestadores() {
		List<Prestador> prestadores;
		try {
			PrestadorServicio prestadorServicio = (PrestadorServicio) SpringUtil.getBean("prestadorServicio");
			prestadores = prestadorServicio.obtener();
			ListModel tiposDesplegable = new ListModelList(prestadores);
			prestador.setModel(tiposDesplegable);
			prestador.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					Prestador prestador = (Prestador) arg1;
					arg0.setLabel(prestador.getNombre());
					String id =""+prestador.getId();
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
		ProfesionalServicio profesionalServicio = (ProfesionalServicio) SpringUtil.getBean("profesionalServicio");
		try {
			profesionalServicio.guardar(
					usuario.getText(),
					clave.getText(),										
					tipoUsuario.getText(),
					nombre.getText(),
					codigo.getText(),
					Integer.parseInt(prestador.getSelectedItem().getId()),
					estado.getSelectedItem().getLabel(),
					usuarioConectado
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("admisiones/web/vista/ListaProfesionales.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}