package admiciones.web.controlador;

import java.io.Serializable;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import admiciones.db.dto.modelo.Profesional;
import admisiones.servicio.ProfesionalServicio;

public class ListaProfesionalesCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaProfesionales;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarProfesionales();
	}
	
	
	private void cargarProfesionales() {
		final ProfesionalServicio profesionalServicio = (ProfesionalServicio) SpringUtil.getBean("profesionalServicio");
		List<Profesional> profesionales = profesionalServicio.obtener();
		ListModel profesionalesDesplegable = new ListModelList(profesionales);
		listaProfesionales.setModel(profesionalesDesplegable);
		listaProfesionales.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				Profesional profesional = (Profesional) arg1;
				try {					
					arg0.setLabel(profesional.getNombre());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + profesional.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							String identificador = boton.getId();
							profesionalServicio.borrar(Integer.parseInt(identificador));
							}
					});
				} catch (Exception e) {
					
				}
				
			}

			
		});
	}
}