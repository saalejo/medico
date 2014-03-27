package admiciones.web.controlador;

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

import admiciones.db.dto.modelo.Municipio;
import admiciones.db.dto.modelo.Profesional;
import admisiones.servicio.MunicipioServicio;
import admisiones.servicio.PrestadorServicio;

public class NuevoPrestadorCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox nombre;
	private Textbox identificacion;
	private Textbox tipoIdentificacion;
	private Textbox razonSocial;
	private Combobox municipio;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		obtenerMunicipios();
		
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
	

	
	public void onClick$cancelar(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}
	
	
	public void onClick$guardar(){	
		
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		PrestadorServicio prestadorServicio = (PrestadorServicio) SpringUtil.getBean("prestadorServicio");
		try {
			prestadorServicio.guardar(
					
					identificacion.getText(),
					nombre.getText(),
					tipoIdentificacion.getText(),
					razonSocial.getText(),
					Integer.parseInt(municipio.getSelectedItem().getId()),
					usuarioConectado
			);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("admisiones/web/vista/ListaPrestadores.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}