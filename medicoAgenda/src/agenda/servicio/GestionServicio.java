package agenda.servicio;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.EspecialidadDao;
import admisiones.db.dto.modelo.Especialidad;
import agenda.db.dao.interfaz.GestionDao;
import agenda.db.dto.modelo.Gestion;



public class GestionServicio {

	@Autowired
	GestionDao gestionDao;
	EspecialidadDao especialidadDao;

	
	public GestionDao getGestionDao() {
		return gestionDao;
	}

	public void setGestionDao(GestionDao gestionDao) {
		this.gestionDao = gestionDao;
	}

	public EspecialidadDao getEspecialidadDao() {
		return especialidadDao;
	}

	public void setEspecialidadDao(EspecialidadDao especialidadDao) {
		this.especialidadDao = especialidadDao;
	}

	public  List<Gestion> obtener() {
		try {
			return gestionDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}
	
	public Gestion obtener(int id) {
		try {
			return gestionDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void guardar(int idEspecialidad, int numero, int intervalo, String usuarioConectado) {
		try {
			Gestion gestion=new Gestion();
			Especialidad especialidad = especialidadDao.obtener(idEspecialidad);
			gestion.setEspecialidad(especialidad);
			gestion.setNumero(numero);
			gestion.setIntervalo(intervalo);
			gestion.setUsuarioConectado(usuarioConectado);		
			gestionDao.guardar(gestion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(int id, int idEspecialidad, int numero, int intervalo, String usuarioConectado) {
		try {
			Gestion gestion=new Gestion();
			gestion.setId(id);
			Especialidad especialidad = especialidadDao.obtener(idEspecialidad);
			gestion.setEspecialidad(especialidad);
			gestion.setNumero(numero);
			gestion.setIntervalo(intervalo);
			gestion.setUsuarioConectado(usuarioConectado);	
			gestionDao.actualizar(gestion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) {
		Gestion gestion=new Gestion();
		gestion.setId(id);
		gestionDao.borrar(gestion);
		
	}

	

	
   }
  

