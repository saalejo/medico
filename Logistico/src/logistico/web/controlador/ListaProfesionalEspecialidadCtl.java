package logistico.web.controlador;

import java.io.Serializable;
import java.util.List;

import logistico.db.dto.modelo.ProfesionalEspecialidad;
import logistico.servicio.ProfesionalEspecialidadServicio;

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

public class ListaProfesionalEspecialidadCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaProfesionalesPorEspecialidades;
	private Listbox listaEspecialidadesPorProfesionales;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarProfesionalesPorEspecialidades();
		cargarEspecialidadesPorProfesionales();
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void cargarProfesionalesPorEspecialidades() throws Exception {
		
		final ProfesionalEspecialidadServicio profesionalEspecialidadServicio = (ProfesionalEspecialidadServicio) SpringUtil.getBean("profesionalEspecialidadServicio");
		List<ProfesionalEspecialidad> profesionalesEspecialidades = profesionalEspecialidadServicio.obtenerPorEspecialidad(int especialidadId);
		ListModel profesionalesPorEspecialidadesDesplegable = new ListModelList(profesionalesEspecialidades);
		listaProfesionalesPorEspecialidades.setModel(profesionalesPorEspecialidadesDesplegable);
		listaProfesionalesPorEspecialidades.setItemRenderer(new ListitemRenderer() {

			@SuppressWarnings("unchecked")
			@Override
			public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
				ProfesionalEspecialidad profesionalEspecialidad = (ProfesionalEspecialidad) arg1;
				try {					
					arg0.setLabel(profesionalEspecialidad.getEspecialidad());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + profesionalEspecialidad.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0){
							String identificador = boton.getId();
							profesionalEspecialidadServicio.borrar(Integer.parseInt(identificador));
						}
					});
				} catch (Exception e) {
				}				
			}			
		});
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void cargarEspecialidadesPorProfesionales() throws Exception {
			
		final ProfesionalEspecialidadServicio profesionalEspecialidadServicio = (ProfesionalEspecialidadServicio) SpringUtil.getBean("profesionalEspecialidadServicio");
		List<ProfesionalEspecialidad> profesionalesEspecialidades = profesionalEspecialidadServicio.obtenerPorProfesional(int profesionalId);
		ListModel especialidadesPorProfesionalesDesplegable = new ListModelList(profesionalesEspecialidades);
		listaEspecialidadesPorProfesionales.setModel(especialidadesPorProfesionalesDesplegable);
		listaEspecialidadesPorProfesionales.setItemRenderer(new ListitemRenderer() {

			@SuppressWarnings("unchecked")
			@Override
			public void render(Listitem arg0, Object arg1, int arg2) throws Exception {
				ProfesionalEspecialidad profesionalEspecialidad = (ProfesionalEspecialidad) arg1;
				try {					
					arg0.setLabel(profesionalEspecialidad.getProfesional());
					Listcell lcButton = new Listcell();
					lcButton.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(lcButton);
					boton.setId("" + profesionalEspecialidad.getId());
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0){
							String identificador = boton.getId();
							profesionalEspecialidadServicio.borrar(Integer.parseInt(identificador));
						}
					});
				} catch (Exception e) {
				}				
			}			
		});
	}
}