package logistico.web.controlador;

import java.io.Serializable;
import java.util.List;

import logistico.db.dto.modelo.Consultorio;
import logistico.servicio.ConsultorioServicio;

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

public class ListaConsultoriosCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaConsultorios;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarConsultorios();
	}
	
	
	private void cargarConsultorios() throws Exception {
		
		final ConsultorioServicio consultorioServicio = (ConsultorioServicio) SpringUtil.getBean("consultorioServicio");
		List<Consultorio> consultorios = consultorioServicio.obtener();
		ListModel consultoriosDesplegable = new ListModelList(consultorios);
		listaConsultorios.setModel(consultoriosDesplegable);
		listaConsultorios.setItemRenderer(new ListitemRenderer() {

			@SuppressWarnings("unchecked")
			@Override
			public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
				Consultorio consultorio = (Consultorio) arg1;
				try {					
					arg0.setLabel(consultorio.getDescripcion());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + consultorio.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0){
							String identificador = boton.getId();
							consultorioServicio.borrar(Integer.parseInt(identificador));
						}
					});
				} catch (Exception e) {
				}				
			}			
		});
	}
}