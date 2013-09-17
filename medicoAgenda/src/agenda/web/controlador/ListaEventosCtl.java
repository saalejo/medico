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



import agenda.db.dto.modelo.Evento;


import agenda.servicio.EventoServicio;


public class ListaEventosCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaEventos;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarEventos();
	}
	
	public void onClick$btnNuevoEvento(){
		try {		
			
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
				if(profesional!=null ){
					pintor.abrirVentana("agenda/web/vista/NuevoEvento.zul", "", null);
				}else{
					
					pintor.abrirVentana("hcdigital/vista/Login.zul","",null);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
			
	}
	
	
	private void cargarEventos() {
		final EventoServicio eventoServicio = (EventoServicio) SpringUtil.getBean("eventoServicio");
		List<Evento> evento = eventoServicio.obtener();
		ListModel eventosDesplegable = new ListModelList(evento);
		listaEventos.setModel(eventosDesplegable);
		listaEventos.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				
				Evento evento = (Evento) arg1;
				arg0.setId(""+evento.getId());
				
				try {	
					final int eventoId=evento.getId();					
					Date fecha = evento.getFecha();
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
					
					Listcell fechaEvento = new Listcell(diaS+"/"+mesS+"/"+ano);
					fechaEvento.setParent(arg0);
					
					String segundosI = ""+evento.getHoraInicial().getSeconds();
					String minutosI = ""+evento.getHoraInicial().getMinutes();
					String horaI = ""+evento.getHoraInicial().getHours();
					
					String segundosF = ""+evento.getHoraFinal().getSeconds();
					String minutosF = ""+evento.getHoraFinal().getMinutes();
					String horaF = ""+evento.getHoraFinal().getHours();
					
					if(horaI.length()<2){
						horaI = "0"+horaI;}
					if(minutosI.length()<2){
						minutosI = "0"+minutosI;}
					if(segundosI.length()<2){
						segundosI = "0"+segundosI;}
					
					if(horaF.length()<2){
						horaF = "0"+horaF;}
					if(minutosF.length()<2){
						minutosF = "0"+minutosF;}
					if(segundosF.length()<2){
						segundosF = "0"+segundosF;}
					
					
					Listcell horaInicial = new Listcell(horaI+":"+minutosI+":"+segundosI);
					horaInicial.setParent(arg0);
					
					Listcell horaFinal = new Listcell(horaF+":"+minutosF+":"+segundosF);
					horaFinal.setParent(arg0);
					
					String todosD = "No";
					
					if(evento.getTodosDias()){
						todosD = "Si";
					}
				
					
					Listcell motivoEvento = new Listcell(evento.getMotivo());
					motivoEvento.setParent(arg0);
					
					Listcell todosDias = new Listcell(todosD);
					todosDias.setParent(arg0);
					
					Listcell eliminar = new Listcell();
					eliminar.setParent(arg0);
					final Button boton = new Button("Eliminar");
					boton.setParent(eliminar);					
					boton.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							eventoServicio.borrar(eventoId);
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							pintor.refrescarmodulo();
							
						}
					});
					arg0.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							
							Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
							Sessions.getCurrent().setAttribute("eventoId", ""+eventoId);
							pintor.abrirVentana("agenda/web/vista/NuevoEvento.zul", "", null);
						
						}
					});
				} catch (Exception e) {
					
				}
				
				
			}
			
		});
	}
}