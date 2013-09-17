package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.DiagnosticoDao;
import historia.clinica.db.dto.modelo.Diagnostico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DiagnosticoServicio {

	@Autowired
	DiagnosticoDao diagnosticoDao;

	public  List<Diagnostico> obtener() {
		try {
			return diagnosticoDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the diagnosticoDao
	 */
	public DiagnosticoDao getDiagnosticoDao() {
		return diagnosticoDao;
	}

	/**
	 * @param diagnosticoDao the diagnosticoDao to set
	 */
	public void setDiagnosticoDao(DiagnosticoDao diagnosticoDao) {
		this.diagnosticoDao = diagnosticoDao;
	}

	
	public Diagnostico obtener(int id) {
		try {
			return diagnosticoDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void guardar(String observaciones,int diagnosticoId,int atencionId) {
		try {
			Diagnostico diagnostico=new Diagnostico();
			diagnostico.setObservaciones(observaciones);
			diagnostico.setAtencionId(atencionId);
			diagnostico.setDiagnosticoId(diagnosticoId);
			diagnosticoDao.guardar(diagnostico);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrar(int id) {
		Diagnostico diagnostico=new Diagnostico();
		diagnostico.setId(id);
		diagnosticoDao.borrar(diagnostico);
		
	}

	

	
}
