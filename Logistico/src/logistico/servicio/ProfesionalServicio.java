package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.ProfesionalDao;
import logistico.db.dto.modelo.Profesional;

import org.springframework.beans.factory.annotation.Autowired;

public class ProfesionalServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ProfesionalDao profesionalDao;
	
		
	/**
	 * @return the profesionalDao
	 */
	public ProfesionalDao getProfesionalDao() {
		return profesionalDao;
	}

	/**
	 * @param profesionalDao the profesionalDao to set
	 */
	public void setProfesionalDao(ProfesionalDao profesionalDao) {
		this.profesionalDao = profesionalDao;
	}

		
	public List<Profesional> obtener() throws Exception {
		return profesionalDao.obtener();
	}	
	
	public void actualizar(int id, String identificacion, String nombre,
			String apellido, Boolean tipoProfesional, int usuarioConectado) {
		Profesional profesional = new Profesional(id, identificacion, nombre, apellido, tipoProfesional, usuarioConectado);
		try {
			profesionalDao.actualizar(profesional);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String identificacion, String nombre,
			String apellido, Boolean tipoProfesional, int usuarioConectado) {
		Profesional profesional = new Profesional(identificacion, nombre, apellido, tipoProfesional, usuarioConectado);
		try {
			profesionalDao.guardar(profesional);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) throws Exception {
		Profesional profesional = new Profesional();
		try {
			profesional.setId(id);
			profesionalDao.borrar(profesional);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
