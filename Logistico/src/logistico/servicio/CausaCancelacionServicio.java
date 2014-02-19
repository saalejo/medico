package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.CausaCancelacionDao;
import logistico.db.dao.interfaz.ModuloSistemaDao;
import logistico.db.dto.modelo.CausaCancelacion;

import org.springframework.beans.factory.annotation.Autowired;

public class CausaCancelacionServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	CausaCancelacionDao causaCancelacionDao;
	@Autowired
	ModuloSistemaDao moduloSistemaDao;	

	
	/**
	 * @return the causaCancelacionDao
	 */
	public CausaCancelacionDao getCausaCancelacionDao() {
		return causaCancelacionDao;
	}

	/**
	 * @param causaCancelacionDao the causaCancelacionDao to set
	 */
	public void setCausaCancelacionDao(CausaCancelacionDao causaCancelacionDao) {
		this.causaCancelacionDao = causaCancelacionDao;
	}

	
	public List<CausaCancelacion> obtener(int moduloSistemaId) throws Exception {
		return causaCancelacionDao.obtener(moduloSistemaId);
	}	
	
	public List<CausaCancelacion> obtener() throws Exception {
		return causaCancelacionDao.obtener();
	}	
	
	public void actualizar(int id, String descripcion, int usuarioConectado, int moduloSistemaId) {
		CausaCancelacion causaCancelacion = new CausaCancelacion(id, descripcion, usuarioConectado, moduloSistemaId);
		try {
			causaCancelacionDao.actualizar(causaCancelacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String descripcion, int usuarioConectado, int moduloSistemaId) {
		CausaCancelacion causaCancelacion = new CausaCancelacion(descripcion, usuarioConectado, moduloSistemaId);
		try {
			causaCancelacionDao.guardar(causaCancelacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void borrar(int id) {
		CausaCancelacion causaCancelacion = new CausaCancelacion();
		try {
			causaCancelacion.setId(id);
			causaCancelacionDao.borrar(causaCancelacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
