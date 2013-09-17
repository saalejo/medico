package historia.clinica.web.controlador;

import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.servicio.AtencionServicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import admisiones.db.dto.modelo.Paciente;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

public class ListaAtencionesCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	private Listbox listaAtenciones;

	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);	
		cargarAtenciones();
	}
	
	public void onClick$imprimir(){
		Paciente paciente=(Paciente) Sessions.getCurrent().getAttribute("paciente");
		final AtencionServicio atencionServicio = (AtencionServicio) SpringUtil.getBean("atencionServicio");
		Filedownload.save(
			atencionServicio.obtenerHistoriaClinica(paciente),
			"application/pdf",
			"historia clinica "+paciente.getPrimerNombre()+" "+paciente.getPrimerApellido()+".pdf"
		);		
	}
	private void cargarAtenciones() {
		Paciente paciente=(Paciente) Sessions.getCurrent().getAttribute("paciente");
		final AtencionServicio atencionServicio = (AtencionServicio) SpringUtil.getBean("atencionServicio");
		List<Atencion> atenciones = atencionServicio.obtener(paciente.getId());
		ListModel atencionesDesplegable = new ListModelList(atenciones);
		listaAtenciones.setModel(atencionesDesplegable);
		listaAtenciones.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				Atencion atencion = (Atencion) arg1;
				try {	
					final int atencionId=atencion.getId();	
					new Listcell(atencion.getFechaAtencion().toString()).setParent(arg0);
					new Listcell(atencion.getTipoConsulta()).setParent(arg0);
					new Listcell(atencion.getObservaciones()).setParent(arg0);
					arg0.addEventListener("onClick", new EventListener() {
						@Override
						public void onEvent(Event arg0) throws Exception {
							
						
						}
					});
				} catch (Exception e) {
					
				}
				
			}
			
		});
	}
}