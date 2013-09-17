package admisiones.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.ProfesionalDao;
import admisiones.db.dto.modelo.Profesional;

public class ProfesionalServicio {
	
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


	public Profesional obtenerPorUsuario(String usuario){
		return profesionalDao.obtener(usuario);
	}


	public void guardar(String usuario, String clave, String tipoUsuario, String nombre,
			String codigo, int prestadorId, String estado, String usuarioConectado) {
		Profesional profesional=new Profesional();
		profesional.setUsuario(usuario);
		profesional.setClave(clave);
		profesional.setTipoUsuario(tipoUsuario);
		profesional.setNombre(nombre);
		profesional.setCodigo(codigo);
		profesional.setPrestadorId(prestadorId);
		profesional.setEstado(estado);
		profesional.setUsuarioConectado(usuarioConectado);
		try {
			profesionalDao.guardar(profesional);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void borrar(int id) {
		Profesional profesional=new Profesional();
		profesional.setId(id);
		profesionalDao.borrar(profesional);
		
	}


	public List<Profesional> obtener() {
		return profesionalDao.obtener();
	}
	
}
