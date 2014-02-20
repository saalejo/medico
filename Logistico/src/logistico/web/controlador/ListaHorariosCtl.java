package logistico.web.controlador;

import java.io.Serializable;
import java.util.List;

import logistico.db.dto.modelo.Horario;
import logistico.servicio.HorarioServicio;

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

public class ListaHorariosCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaHorarios;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarHorarios();
	}
	
	
	private void cargarHorarios() throws Exception {
		
		final HorarioServicio horarioServicio = (HorarioServicio) SpringUtil.getBean("horarioServicio");
		List<Horario> horarios = horarioServicio.obtener();
		ListModel horariosDesplegable = new ListModelList(horarios);
		listaHorarios.setModel(horariosDesplegable);
		listaHorarios.setItemRenderer(new ListitemRenderer() {

			@SuppressWarnings("unchecked")
			@Override
			public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
				Horario horario = (Horario) arg1;
				try {					
					arg0.setLabel(horario.getDescripcion());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + horario.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0){
							String identificador = boton.getId();
							horarioServicio.borrar(Integer.parseInt(identificador));
						}
					});
				} catch (Exception e) {
				}				
			}			
		});
	}
}