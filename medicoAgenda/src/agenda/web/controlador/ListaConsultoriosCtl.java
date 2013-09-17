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
import agenda.db.dto.modelo.Consultorio;
import agenda.servicio.ConsultorioServicio;

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
	
	public void onClick$btnNuevoConsultorio(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("agenda/web/vista/NuevoConsultorio.zul", "", null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
			
	}
	
	
	private void cargarConsultorios() {
		final ConsultorioServicio consultorioServicio = (ConsultorioServicio) SpringUtil.getBean("consultorioServicio");
		List<Consultorio> consultorio = consultorioServicio.obtener();
		ListModel consultoriosDesplegable = new ListModelList(consultorio);
		listaConsultorios.setModel(consultoriosDesplegable);
		listaConsultorios.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				
				Consultorio consultorio = (Consultorio) arg1;
				arg0.setId(""+consultorio.getId());
				
				try {	
					final int consultorioId=consultorio.getId();					
					
					Listcell codigoConsultorio = new Listcell(""+consultorio.getCodigo());
					codigoConsultorio.setParent(arg0);
					
					Listcell nombreConsultorio = new Listcell(consultorio.getNombre());
					nombreConsultorio.setParent(arg0);
					
					Listcell eliminar = new Listcell();
					eliminar.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(eliminar);					
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							consultorioServicio.borrar(consultorioId);
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							pintor.refrescarmodulo();
							
						}
					});
					arg0.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							Sessions.getCurrent().setAttribute("consultorioId", ""+consultorioId);
							pintor.abrirVentana("agenda/web/vista/NuevoConsultorio.zul", "", null);
						
						}
					});
				} catch (Exception e) {
					
				}
				
				
			}
			
		});
	}
}