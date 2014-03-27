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

import admiciones.db.dto.modelo.Prestador;
import admisiones.servicio.PrestadorServicio;

public class ListaPrestadoresCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaPrestadores;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarPrestadores();
	}
	
	
	private void cargarPrestadores() {
		final PrestadorServicio prestadorServicio = (PrestadorServicio) SpringUtil.getBean("prestadorServicio");
		List<Prestador> prestadores = prestadorServicio.obtener();
		ListModel prestadoresDesplegable = new ListModelList(prestadores);
		listaPrestadores.setModel(prestadoresDesplegable);
		listaPrestadores.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				Prestador prestador = (Prestador) arg1;
				try {					
					arg0.setLabel(prestador.getNombre());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + prestador.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							String identificador = boton.getId();
							prestadorServicio.borrar(Integer.parseInt(identificador));
							}
					});
				} catch (Exception e) {
					
				}
			}

			
		});
	}
}