package admisiones.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admisiones.db.dao.interfaz.EntidadDao;
import admisiones.db.dto.modelo.Entidad;

public class EntidadServicio {
	
	@Autowired
	EntidadDao entidadDao;

	public List<Entidad> obtener() {
		try {
			return entidadDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return the entidadDao
	 */
	public EntidadDao getEntidadDao() {
		return entidadDao;
	}

	/**
	 * @param entidadDao the entidadDao to set
	 */
	public void setEntidadDao(EntidadDao entidadDao) {
		this.entidadDao = entidadDao;
	}

	public void borrar(int id) {
		Entidad entidad=new Entidad();
		entidad.setId(id);
		entidadDao.borrar(entidad);
		
	}

	public void guardar(String nombre, String codigo, String tipoUsuario,
			String usuarioConectado) {
		Entidad entidad=new Entidad();
		entidad.setNombre(nombre);
		entidad.setCodigo(codigo);
		entidad.setTipoUsuario(tipoUsuario);
		entidad.setUsuarioConectado(usuarioConectado);	
		try {
			entidadDao.guardar(entidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
