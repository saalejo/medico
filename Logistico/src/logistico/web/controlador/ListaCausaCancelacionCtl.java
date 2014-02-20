package logistico.web.controlador;

import java.io.Serializable;
import java.util.List;

import logistico.db.dto.modelo.CausaCancelacion;
import logistico.servicio.CausaCancelacionServicio;

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

public class ListaCausaCancelacionCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaCausaCancelaciones;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarCausaCancelaciones();
	}
	
	
	private void cargarCausaCancelaciones() throws Exception {
		
		final CausaCancelacionServicio causaCancelacionServicio = (CausaCancelacionServicio) SpringUtil.getBean("causaCancelacionServicio");
		List<CausaCancelacion> causaCancelaciones = causaCancelacionServicio.obtener();
		ListModel causaCancelacionesDesplegable = new ListModelList(causaCancelaciones);
		listaCausaCancelaciones.setModel(causaCancelacionesDesplegable);
		listaCausaCancelaciones.setItemRenderer(new ListitemRenderer() {

			@SuppressWarnings("unchecked")
			@Override
			public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
				CausaCancelacion causaCancelacion = (CausaCancelacion) arg1;
				try {					
					arg0.setLabel(causaCancelacion.getDescripcion());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + causaCancelacion.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0){
							String identificador = boton.getId();
							causaCancelacionServicio.borrar(Integer.parseInt(identificador));
						}
					});
				} catch (Exception e) {
				}				
			}			
		});
	}
}