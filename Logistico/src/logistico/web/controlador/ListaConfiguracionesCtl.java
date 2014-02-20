package logistico.web.controlador;

import java.io.Serializable;
import java.util.List;

import logistico.db.dto.modelo.Configuracion;
import logistico.servicio.ConfiguracionServicio;

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

public class ListaConfiguracionesCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaConfiguraciones;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarConfiguraciones();
	}
	
	
	private void cargarConfiguraciones() throws Exception {
		
		final ConfiguracionServicio configuracionServicio = (ConfiguracionServicio) SpringUtil.getBean("configuracionServicio");
		List<Configuracion> configuraciones = configuracionServicio.obtener();
		ListModel configuracionesDesplegable = new ListModelList(configuraciones);
		listaConfiguraciones.setModel(configuracionesDesplegable);
		listaConfiguraciones.setItemRenderer(new ListitemRenderer() {

			@SuppressWarnings("unchecked")
			@Override
			public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
				Configuracion configuracion = (Configuracion) arg1;
				try {					
					arg0.setLabel(configuracion.getDescripcion());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + configuracion.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0){
							String identificador = boton.getId();
							configuracionServicio.borrar(Integer.parseInt(identificador));
						}
					});
				} catch (Exception e) {
				}				
			}			
		});
	}
}