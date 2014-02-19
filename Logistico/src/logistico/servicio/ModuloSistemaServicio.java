package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.ModuloSistemaDao;
import logistico.db.dto.modelo.Barrio;
import logistico.db.dto.modelo.ModuloSistema;

import org.springframework.beans.factory.annotation.Autowired;

public class ModuloSistemaServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ModuloSistemaDao moduloSistemaDao;

	
	/**
	 * @return the moduloSistemaDao
	 */
	public ModuloSistemaDao getModuloSistemaDao() {
		return moduloSistemaDao;
	}

	/**
	 * @param moduloSistemaDao the moduloSistemaDao to set
	 */
	public void setModuloSistemaDao(ModuloSistemaDao moduloSistemaDao) {
		this.moduloSistemaDao = moduloSistemaDao;
	}

		
	public List<ModuloSistema> obtener() throws Exception {
		return moduloSistemaDao.obtener();
	}	
	
	public void actualizar(int id, String descripcion, int usuarioConectado) {
		ModuloSistema moduloSistema = new ModuloSistema(id, descripcion, usuarioConectado);
		try {
			moduloSistemaDao.actualizar(moduloSistema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String descripcion, int usuarioConectado) {
		ModuloSistema moduloSistema = new ModuloSistema(descripcion, usuarioConectado);
		try {
			moduloSistemaDao.guardar(moduloSistema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void borrar(int id) {
		ModuloSistema moduloSistema = new ModuloSistema();
		try {
			moduloSistema.setId(id);
			moduloSistemaDao.borrar(moduloSistema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
