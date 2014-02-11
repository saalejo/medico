package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.ProfesionalDao;
import logistico.db.dao.interfaz.ProfesionalEspecialidadDao;
import logistico.db.dto.modelo.ProfesionalEspecialidad;
import historia.clinica.db.dao.interfaz.EspecialidadDao;

import org.springframework.beans.factory.annotation.Autowired;

public class ProfesionalEspecialidadServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ProfesionalEspecialidadDao profesionalEspecialidadDao;
	@Autowired
	ProfesionalDao profesionalDao;
	@Autowired
	EspecialidadDao especialidadDao;
	
	/**
	 * @return the profesionalEspecialidadDao
	 */
	public ProfesionalEspecialidadDao getProfesionalEspecialidadDao() {
		return profesionalEspecialidadDao;
	}

	/**
	 * @param profesionalEspecialidadDao the profesionalEspecialidadDao to set
	 */
	public void setProfesionalEspecialidadDao(ProfesionalEspecialidadDao profesionalEspecialidadDao) {
		this.profesionalEspecialidadDao = profesionalEspecialidadDao;
	}

	
	public List<ProfesionalEspecialidad> obtenerPorProfesional(int profesionalId) throws Exception {
		return profesionalEspecialidadDao.obtenerPorProfesional(profesionalId);
	}	
	
	public List<ProfesionalEspecialidad> obtenerPorEspecialidad(int especialidadId) throws Exception {
		return profesionalEspecialidadDao.obtenerPorEspecialidad(especialidadId);
	}	
	
	public void actualizar(int id, String registroMedico, int usuarioConectado, int profesionalId, int especialidadId) {
		ProfesionalEspecialidad profesionalEspecialidad = new ProfesionalEspecialidad(id, registroMedico, usuarioConectado, profesionalId, especialidadId);
		try {
			profesionalEspecialidadDao.actualizar(profesionalEspecialidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String registroMedico, int usuarioConectado, int profesionalId, int especialidadId) {
		ProfesionalEspecialidad profesionalEspecialidad = new ProfesionalEspecialidad(registroMedico, usuarioConectado, profesionalId, especialidadId);
		try {
			profesionalEspecialidadDao.guardar(profesionalEspecialidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) throws Exception {
		ProfesionalEspecialidad profesionalEspecialidad = new ProfesionalEspecialidad();
		try {
			profesionalEspecialidad.setId(id);
			profesionalEspecialidadDao.borrar(profesionalEspecialidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
