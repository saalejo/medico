package admisiones.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.MedicamentoMaestroDao;
import admisiones.db.dto.modelo.MedicamentoMaestro;

public class MedicamentoMaestroServicio {
	
	@Autowired
	MedicamentoMaestroDao medicamentoMaestroDao;

	
	
	
	/**
	 * @return the medicamentoMaestroDao
	 */
	public MedicamentoMaestroDao getMedicamentoMaestroDao() {
		return medicamentoMaestroDao;
	}

	/**
	 * @param medicamentoMaestroDao the medicamentoMaestroDao to set
	 */
	public void setMedicamentoMaestroDao(MedicamentoMaestroDao medicamentoMaestroDao) {
		this.medicamentoMaestroDao = medicamentoMaestroDao;
	}

	public List<MedicamentoMaestro> obtener() {
		try {
			return medicamentoMaestroDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void borrar(int id) {
		MedicamentoMaestro medicamento=new MedicamentoMaestro();
		medicamento.setId(id);
		medicamentoMaestroDao.borrar(medicamento);
		
	}
	

	public MedicamentoMaestro obtener(String codigoMedicamento) {
		try {
			return medicamentoMaestroDao.obtener(codigoMedicamento);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}

	public void guardar(MedicamentoMaestro medicamentoMaestro) {
		try {
			medicamentoMaestroDao.guardar(medicamentoMaestro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}



	
}
