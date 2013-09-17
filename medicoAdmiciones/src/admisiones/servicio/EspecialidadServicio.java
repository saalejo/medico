package admisiones.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.EspecialidadDao;
import admisiones.db.dto.modelo.Especialidad;

public class EspecialidadServicio {
	
	@Autowired
	EspecialidadDao especialidadDao;

	public List<Especialidad> obtener() {
		try {
			return especialidadDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return the especialidadDao
	 */
	public EspecialidadDao getEspecialidadDao() {
		return especialidadDao;
	}

	/**
	 * @param especialidadDao the especialidadDao to set
	 */
	public void setEspecialidadDao(EspecialidadDao especialidadDao) {
		this.especialidadDao = especialidadDao;
	}

	public void borrar(int id) {
		Especialidad especialidad=new Especialidad();
		especialidad.setId(id);
		especialidadDao.borrar(especialidad);
		
	}

	public void guardar(String nombre, String usuarioConectado) {
		Especialidad especialidad=new Especialidad();
		especialidad.setNombre(nombre);
		especialidad.setUsuarioConectado(usuarioConectado);	
		try {
			especialidadDao.guardar(especialidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
