package admisiones.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.SuspendNotAllowedException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Window;

import admisiones.db.dto.modelo.Actividad;
import admisiones.servicio.ActividadServicio;

public class ListaActividadesCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaActividades;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarActividades();
	}
	
	
	private void cargarActividades() {
		final ActividadServicio actividadServicio = (ActividadServicio) SpringUtil.getBean("actividadServicio");
		List<Actividad> actividades = actividadServicio.obtener();
		ListModel actividadesDesplegable = new ListModelList(actividades);
		listaActividades.setModel(actividadesDesplegable);
		listaActividades.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				Actividad actividad = (Actividad) arg1;
				try {	
					final int actividadId=actividad.getId();					
					Listcell nombreActividad = new Listcell(actividad.getNombre());
					nombreActividad.setParent(arg0);
					Listcell duracionActividad = new Listcell(""+actividad.getDuracion());
					duracionActividad.setParent(arg0);
					Listcell eliminar = new Listcell();
					eliminar.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(eliminar);					
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							actividadServicio.borrar(actividadId);
						}
					});
					arg0.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							java.io.InputStream zulInput = getClass().getClassLoader().getResourceAsStream("admisiones/web/vista/NuevaActividad.zul") ;
							java.io.Reader zulReader = new java.io.InputStreamReader(zulInput) ;		
							Window popup;
							try {
								popup = (Window)Executions.createComponentsDirectly(zulReader, "zul", null, null);
								popup.setClosable(true);
								popup.setAttribute("actividadId", ""+actividadId);
								popup.doModal();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SuspendNotAllowedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				} catch (Exception e) {
					
				}
				
			}
			
		});
	}
}