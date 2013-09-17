package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
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



import agenda.db.dto.modelo.Festivo;


import agenda.servicio.FestivoServicio;

public class ListaFestivosCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaFestivos;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarFestivos();
	}
	
	public void onClick$btnNuevoFestivo(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("agenda/web/vista/NuevoFestivo.zul", "", null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
			
	}
	
	
	private void cargarFestivos() {
		final FestivoServicio festivoServicio = (FestivoServicio) SpringUtil.getBean("festivoServicio");
		List<Festivo> festivo = festivoServicio.obtener();
		ListModel festivosDesplegable = new ListModelList(festivo);
		listaFestivos.setModel(festivosDesplegable);
		listaFestivos.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				
				Festivo festivo = (Festivo) arg1;
				arg0.setId(""+festivo.getId());
				
				try {	
					final int festivoId=festivo.getId();					
					Date fecha = festivo.getFecha();
					int ano = 1900 + fecha.getYear();
					int mes = 1 + fecha.getMonth();
					int dia = fecha.getDate();
					String diaS = ""+dia;
					String mesS = ""+mes;
					
					
					if(dia<10)
					{
						diaS = "0" + diaS;
					}
					
					if(mes<10)
					{
						mesS = "0" + mesS;
					}
					
					Listcell fechaFestivo = new Listcell(diaS+"/"+mesS+"/"+ano);
					fechaFestivo.setParent(arg0);
					
					Listcell motivoFestivo = new Listcell(festivo.getMotivo());
					motivoFestivo.setParent(arg0);
					
					Listcell eliminar = new Listcell();
					eliminar.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(eliminar);					
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							festivoServicio.borrar(festivoId);
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							pintor.refrescarmodulo();
							
						}
					});
					arg0.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							Sessions.getCurrent().setAttribute("festivoId", ""+festivoId);
							pintor.abrirVentana("agenda/web/vista/NuevoFestivo.zul", "", null);
						
						}
					});
				} catch (Exception e) {
					
				}
				
				
			}
			
		});
	}
}