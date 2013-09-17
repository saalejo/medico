package admisiones.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.ActividadDao;
import admisiones.db.dto.modelo.Actividad;

public class ActividadServicio {

	@Autowired
	ActividadDao actividadDao;

	public  List<Actividad> obtener() {
		try {
			return actividadDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the actividadDao
	 */
	public ActividadDao getActividadDao() {
		return actividadDao;
	}

	/**
	 * @param actividadDao the actividadDao to set
	 */
	public void setActividadDao(ActividadDao actividadDao) {
		this.actividadDao = actividadDao;
	}

	
	public Actividad obtener(int id) {
		try {
			return actividadDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void guardar(String nombre,int duracion,String usuarioConectado) {
		try {
			Actividad actividad=new Actividad();
			actividad.setNombre(nombre);
			actividad.setDuracion(duracion);
			actividad.setUsuarioConectado(usuarioConectado);		
			actividadDao.guardar(actividad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrar(int id) {
		Actividad actividad=new Actividad();
		actividad.setId(id);
		actividadDao.borrar(actividad);
		
	}

	public void actualizar(int actividadId, String nombre, int duracion,
			String usuarioConectado) {		
		try {
			Actividad actividad=new Actividad();
			actividad.setId(actividadId);
			actividad.setNombre(nombre);
			actividad.setDuracion(duracion);
			actividad.setUsuarioConectado(usuarioConectado);		
			actividadDao.actualizar(actividad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
}
