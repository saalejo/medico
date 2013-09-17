package historia.clinica.web.controlador;

import hcdigital.presentacion.util.Pintor;
import historia.clinica.db.dto.modelo.Atencion;
import historia.clinica.db.dto.modelo.Medicamento;
import historia.clinica.servicio.FormulaServicio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import admisiones.db.dto.modelo.MedicamentoMaestro;
import admisiones.db.dto.modelo.Profesional;
import admisiones.servicio.MedicamentoMaestroServicio;

public class NuevaFormulaCtl extends GenericForwardComposer implements Serializable{

	/**
	 * Id Serializable
	 */
	private static final long serialVersionUID = 1L;
	Textbox cantidad;
	Textbox posologia;
	Listbox listaMedicamentos;
	Combobox medicamentosCombo;
	Set<Medicamento> medicamentosLista=new HashSet<Medicamento>();
	private int atencionId;
	Pintor pintor;
	
	/**
	 * Al cargar el zul
	 */
	public void doAfterCompose(Component comp) throws Exception{
		super.doAfterCompose(comp);
		Atencion atencion=(Atencion)Sessions.getCurrent().getAttribute("atencion");
		if(atencion!=null){
			atencionId=atencion.getId();	
			obtenerMedicamentos();
		}
		pintor=(Pintor)Sessions.getCurrent().getAttribute("pintor");
	}
	
	public void obtenerMedicamentos() {		
		List<MedicamentoMaestro> medicamentos;
		try {
			
			MedicamentoMaestroServicio medicamentoMaestroServicio = (MedicamentoMaestroServicio) SpringUtil.getBean("medicamentoMaestroServicio");		
			medicamentos = medicamentoMaestroServicio.obtener();
			ListModel tiposDesplegable = new ListModelList(medicamentos);
			medicamentosCombo.setModel(tiposDesplegable);
			medicamentosCombo.setItemRenderer(new ComboitemRenderer() {

				@Override
				public void render(Comboitem arg0, Object arg1, int arg2)
						throws Exception {
					MedicamentoMaestro medicamento = (MedicamentoMaestro) arg1;
					arg0.setLabel(medicamento.getNombre());
					String id =""+medicamento.getId();
					arg0.setId(id);
					
				}
				
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public void onClick$nuevoMedicamento(){		
		Listitem listItem=new Listitem();
		listItem.appendChild(new Listcell(cantidad.getText()));
		listItem.appendChild(new Listcell(medicamentosCombo.getSelectedItem().getLabel()));
		listItem.appendChild(new Listcell(posologia.getText()));
		listaMedicamentos.appendChild(listItem);		
		Medicamento medicamento=new Medicamento();
		medicamento.setCantidad(cantidad.getText());
		medicamento.setMedicamentoMaestroId(Integer.parseInt(medicamentosCombo.getSelectedItem().getId()));
		medicamento.setPosologia(posologia.getText());
		medicamentosLista.add(medicamento);
	}
	
	
	public void onClick$guardar(){			
		Profesional profesional=(Profesional)Sessions.getCurrent().getAttribute("profesional");
		String usuarioConectado=profesional.getUsuario();
		FormulaServicio formulaServicio = (FormulaServicio) SpringUtil.getBean("formulaServicio");
		try {
			if(formulaServicio!=null){
				formulaServicio.guardar(
						atencionId,
						new Date(),
						medicamentosLista,
						usuarioConectado
				);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pintor!=null){								
			try {
		pintor.cerrarVentana();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public void onClick$cancelar(){				
		if(pintor!=null){								
			try {
		pintor.cerrarVentana();
			}
			catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
}