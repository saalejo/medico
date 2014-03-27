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

import admiciones.db.dto.modelo.Entidad;
import admisiones.servicio.EntidadServicio;

public class ListaEntidadesCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaEntidades;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarEntidades();
	}
	
	
	private void cargarEntidades() {
		final EntidadServicio entidadServicio = (EntidadServicio) SpringUtil.getBean("entidadServicio");
		List<Entidad> entidades = entidadServicio.obtener();
		ListModel entidadesDesplegable = new ListModelList(entidades);
		listaEntidades.setModel(entidadesDesplegable);
		listaEntidades.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				Entidad entidad = (Entidad) arg1;
				try {					
					arg0.setLabel(entidad.getNombre());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + entidad.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							String identificador = boton.getId();
							entidadServicio.borrar(Integer.parseInt(identificador));
							}
					});
				} catch (Exception e) {
					
				}

				
			}

			
		});
	}
}