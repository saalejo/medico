package contratos.web.controlador;

import hcdigital.presentacion.util.Pintor;

import java.io.Serializable;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import contratos.db.dto.modelo.AreaServicios;
import contratos.db.dto.modelo.Servicio;
import contratos.servicio.AreaServiciosServicio;
import contratos.servicio.ServicioServicio;


public class NuevoServicioCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Textbox txtNombre;
	private Textbox txtCodigoCaps;
	private Textbox txtCodigoSoat;
	private Textbox txtCodigoIss;
	private Combobox comboPresentacion;
	private Combobox comboTipoTarifa;	
	private Combobox comboTipo;	
	private Combobox comboClase;
	private Combobox comboConceptofacturacion;
	private Combobox comboEstado;
	private Combobox comboAreaServicio;
	private Combobox comboComplejidad;
	private Radiogroup radioGenero;
	private Textbox txtEdadMinima;
	private Textbox txtEdadMaxima;
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		obtenerAreasDeServicio();
		
	}
	
	
	public void obtenerAreasDeServicio() {
		List<AreaServicios> areasServicio;
		try {
			AreaServiciosServicio areaServiciosServicio = (AreaServiciosServicio) SpringUtil.getBean("AreaServiciosServicio");
			areasServicio = areaServiciosServicio.obtener();
			ListModel tiposDesplegable = new ListModelList(areasServicio);
			comboAreaServicio.setModel(tiposDesplegable);
			comboAreaServicio.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					AreaServicios areaServicios = (AreaServicios) arg1;
					arg0.setLabel(areaServicios.getNombre());
					String id =""+areaServicios.getId();
					arg0.setId(id);	
					
				}

				
			
			});
			
		} catch (Exception e) {
			
		}

	}
	

	
	public void onClick$cancelar(){
		Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
		pintor.cerrarVentana();
	}
	
	
	public void onClick$guardar(){	
		try{
			Servicio servicio=new Servicio();
			servicio.setAreaServicioId(Integer.parseInt(comboAreaServicio.getSelectedItem().getId()));
			servicio.setClase(comboAreaServicio.getValue());
			servicio.setCodCups(txtCodigoCaps.getValue());
			servicio.setCodIss(txtCodigoIss.getValue());
			servicio.setCodSoat(txtCodigoSoat.getValue());
			servicio.setComplejidad(comboComplejidad.getValue());
			servicio.setConceptoFacturacion(comboConceptofacturacion.getValue());
			servicio.setEdadMaxima(Integer.parseInt(txtEdadMaxima.getValue()));
			servicio.setEdadMinima(Integer.parseInt(txtEdadMinima.getValue()));
			if(comboEstado.getSelectedItem().getLabel().equals("ACTIVO")){
				servicio.setEstado(true);
			}else{
				servicio.setEstado(false);
			}
			servicio.setGenero(radioGenero.getSelectedItem().getLabel());
			servicio.setNombre(txtNombre.getValue());
			servicio.setPresentacion(comboPresentacion.getValue());
			servicio.setTipo(comboTipo.getValue());
			servicio.setTipoTarifa(comboTipoTarifa.getValue());
			ServicioServicio ServiciosServicio = (ServicioServicio) SpringUtil.getBean("ServicioServicio");
			ServiciosServicio.guardar(servicio);
			Pintor pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
			if(pintor!=null ){	
				pintor.abrirVentana("contratos/web/vista/ListaServicios.zul","contenidoPosicion",null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
}