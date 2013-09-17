package agenda.web.controlador;

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


import admisiones.db.dto.modelo.Profesional;
import agenda.db.dto.modelo.Gestion;
import agenda.servicio.GestionServicio;


public class ListaGestionesCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaGestiones;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarGestiones();
	}
	
	public void onClick$btnNuevaGestion(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("agenda/web/vista/NuevaGestion.zul", "", null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
			
	}
	
	
	private void cargarGestiones() {
		
		final GestionServicio gestionServicio = (GestionServicio) SpringUtil.getBean("gestionServicio");
		List<Gestion> gestion = gestionServicio.obtener();
		ListModel gestionesDesplegable = new ListModelList(gestion);
		listaGestiones.setModel(gestionesDesplegable);
		listaGestiones.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				
				Gestion gestion = (Gestion) arg1;
				arg0.setId(""+gestion.getId());
				
				try {	
					final int gestionId=gestion.getId();					
					
					Listcell especialidadGestion = new Listcell(gestion.getEspecialidad().getNombre());
					especialidadGestion.setParent(arg0);
					
					Listcell numeroGestion = new Listcell(""+gestion.getNumero());
					numeroGestion.setParent(arg0);
					
					Listcell intervaloGestion = new Listcell(""+gestion.getIntervalo());
					intervaloGestion.setParent(arg0);
					
					Listcell eliminar = new Listcell();
					eliminar.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(eliminar);					
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							gestionServicio.borrar(gestionId);
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							pintor.refrescarmodulo();
							
						}
					});
					arg0.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							Sessions.getCurrent().setAttribute("gestionId", ""+gestionId);
							pintor.abrirVentana("agenda/web/vista/NuevaGestion.zul", "", null);
						
						}
					});
				} catch (Exception e) {
					
				}
				
				
			}
			
		});
	}
}