package agenda.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;
import java.util.List;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;


import admisiones.db.dto.modelo.Especialidad;
import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.EspecialidadServicio;
import agenda.db.dto.modelo.Consultorio;
import agenda.db.dto.modelo.Gestion;
import agenda.servicio.ConsultorioServicio;
import agenda.servicio.GestionServicio;

public class NuevaGestionCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaEspecialidades;
	private Intbox numero;
	private Textbox valor;
	private Intbox intervalo;
	private String gestionId;
	int idGestion=-1;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		gestionId = (String) Sessions.getCurrent().getAttribute("gestionId");
		Sessions.getCurrent().setAttribute("gestionId", null);
		
		if(gestionId!=null){
			idGestion=Integer.parseInt(gestionId);
			GestionServicio gestionServicio = (GestionServicio) SpringUtil.getBean("gestionServicio");
			Gestion gestion = gestionServicio.obtener(idGestion);
			Listitem items = new Listitem();
			items.setLabel(gestion.getEspecialidad().getNombre());
			items.setId(""+gestion.getEspecialidad().getId());
			listaEspecialidades.getChildren().add(items);
			listaEspecialidades.setSelectedItem(items);
			numero.setText(""+gestion.getNumero());
			intervalo.setText(""+gestion.getIntervalo());
		}
		else
		{
			cargarEspecialidades();
		}
		
			
			
		
		
	}
	
	public void onClick$cancelar(){
		Sessions.getCurrent().setAttribute("gestionId", null);
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
		
	}
	
	
	public void onClick$guardar(){	
		
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		GestionServicio gestionServicio = (GestionServicio) SpringUtil.getBean("gestionServicio");
		try {
			if(idGestion!=-1){
				gestionServicio.actualizar(idGestion, 
						Integer.parseInt(listaEspecialidades.getSelectedItem().getId()), 
						Integer.parseInt(numero.getText()),
						Integer.parseInt(intervalo.getText()),
						usuarioConectado);
				
				Sessions.getCurrent().setAttribute("gestionId", null);
				pintor.cerrarVentana();
				pintor.refrescarmodulo();
						
				
			}else{
				
				if(listaEspecialidades.getSelectedItem() == null)
				{
					Messagebox.show("Debe seleccionar una Especialidad");
					
					
				}
				else
				{
					
					Boolean repetido = false;
					List<Gestion> gestion = gestionServicio.obtener();
					
					for(int i = 0; i<gestion.size(); i++)
					{
						if(gestion.get(i).getEspecialidad().getId() == Integer.parseInt(listaEspecialidades.getSelectedItem().getId()) )
						{
							repetido = true;
							break;
						}
					}
					
					
					if(repetido)
					{
						Messagebox.show("Ya existe una gestion de agenda para esa Especialidad");
						
					}
					else
					{
						gestionServicio.guardar(
								Integer.parseInt(listaEspecialidades.getSelectedItem().getId()), 
								Integer.parseInt(numero.getText()),
								Integer.parseInt(intervalo.getText()),
								usuarioConectado);
						
						Sessions.getCurrent().setAttribute("gestionId", null);
						pintor.cerrarVentana();
						pintor.refrescarmodulo();
					}
				}
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	
   public void cargarEspecialidades(){	
		
		try {
			EspecialidadServicio especialidadServicio = (EspecialidadServicio) SpringUtil.getBean("especialidadServicio");
			List<Especialidad> especialidad = especialidadServicio.obtener();
			ListModel especialidadesDesplegable = new ListModelList(especialidad);
			listaEspecialidades.setModel(especialidadesDesplegable);
			
			listaEspecialidades.setItemRenderer(new ListitemRenderer() {

				@Override
				public void render(Listitem arg0, Object arg1, int arg2)
						throws Exception {
					
					Especialidad especialidad = (Especialidad) arg1;
					arg0.setId(""+especialidad.getId());
					
					try {	
						final int especialidadId=especialidad.getId();					
						
						Listcell especialidadNombre = new Listcell(especialidad.getNombre());
						especialidadNombre.setParent(arg0);
						
					} catch (Exception e) {
						
					}

					
						}
				
					});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	
	
}