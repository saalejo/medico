package logistico.servicio;

import historia.clinica.db.dto.modelo.Especialidad;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.ConfiguracionDao;
import logistico.db.dto.modelo.Barrio;
import logistico.db.dto.modelo.Configuracion;
import logistico.db.dto.modelo.ModuloSistema;

import org.springframework.beans.factory.annotation.Autowired;

public class ConfiguracionServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ConfiguracionDao configuracionDao;
	@Autowired
	ModuloSistema moduloSistema;
	@Autowired
	Especialidad especialidad;

	/**
	 * @return the configuracionDao
	 */
	public ConfiguracionDao getConfiguracionDao() {
		return configuracionDao;
	}

	/**
	 * @param configuracionDao the configuracionDao to set
	 */
	public void setConfiguracionDao(ConfiguracionDao configuracionDao) {
		this.configuracionDao = configuracionDao;
	}

	public List<Configuracion> obtenerPorModuloSistema(int moduloSistemaId) throws Exception {
		return configuracionDao.obtenerPorModuloSistema(moduloSistemaId);
	}	
	
	public List<Configuracion> obtenerPorEspecialidad(int especialidadId) throws Exception {
		return configuracionDao.obtenerPorEspecialidad(especialidadId);
	}	
	
	public void actualizar(int id, String mensaje, int usuarioConectado, int moduloSistemaId, int especialidadId) {
		Configuracion configuracion = new Configuracion(id, mensaje, usuarioConectado, moduloSistemaId, especialidadId);
		try {
			configuracionDao.actualizar(configuracion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String mensaje, int usuarioConectado, int moduloSistemaId, int especialidadId) {
		Configuracion configuracion = new Configuracion(mensaje, usuarioConectado, moduloSistemaId, especialidadId);
		try {
			configuracionDao.guardar(configuracion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void borrar(int id) {
		Configuracion configuracion = new Configuracion();
		try {
			configuracion.setId(id);
			configuracionDao.borrar(configuracion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
