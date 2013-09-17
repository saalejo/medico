package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.DiagnosticoMaestroDao;
import historia.clinica.db.dto.modelo.DiagnosticoMaestro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DiagnosticoMaestroServicio {

	@Autowired
	DiagnosticoMaestroDao diagnosticoMaestroDao;

	public  List<DiagnosticoMaestro> obtener() {
		try {
			return diagnosticoMaestroDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the diagnosticoMaestroDao
	 */
	public DiagnosticoMaestroDao getDiagnosticoMaestroDao() {
		return diagnosticoMaestroDao;
	}

	/**
	 * @param diagnosticoMaestroDao the diagnosticoMaestroDao to set
	 */
	public void setDiagnosticoMaestroDao(DiagnosticoMaestroDao diagnosticoMaestroDao) {
		this.diagnosticoMaestroDao = diagnosticoMaestroDao;
	}

	
	public DiagnosticoMaestro obtener(int id) {
		try {
			return diagnosticoMaestroDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void guardar(String descripcion) {
		try {
			DiagnosticoMaestro diagnosticoMaestro=new DiagnosticoMaestro();
			diagnosticoMaestro.setDescripcion(descripcion);
			diagnosticoMaestroDao.guardar(diagnosticoMaestro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrar(int id) {
		DiagnosticoMaestro diagnosticoMaestro=new DiagnosticoMaestro();
		diagnosticoMaestro.setId(id);
		diagnosticoMaestroDao.borrar(diagnosticoMaestro);
		
	}

	public void actualizar(String descripcion,
			String usuarioConectado) {		
		try {
			DiagnosticoMaestro diagnosticoMaestro=new DiagnosticoMaestro();
			diagnosticoMaestro.setDescripcion(descripcion);
			diagnosticoMaestroDao.actualizar(diagnosticoMaestro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
