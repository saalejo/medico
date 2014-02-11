package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.BarrioDao;
import logistico.db.dto.modelo.Barrio;
import logistico.db.dto.modelo.Municipio;

import org.springframework.beans.factory.annotation.Autowired;

public class BarrioServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	BarrioDao barrioDao;
	@Autowired
	Municipio municipioDao;	

	
	/**
	 * @return the barrioDao
	 */
	public BarrioDao getBarrioDao() {
		return barrioDao;
	}

	/**
	 * @param barrioDao the barrioDao to set
	 */
	public void setBarrioDao(BarrioDao barrioDao) {
		this.barrioDao = barrioDao;
	}

	
	public List<Barrio> obtener(int municipioId) throws Exception {
		return barrioDao.obtener(municipioId);
	}	
	
	public List<Barrio> obtener() throws Exception {
		return barrioDao.obtener();
	}	
	
	public void actualizar(int id, String descripcion, int usuarioConectado, int municipioId) {
		Barrio barrio = new Barrio(id, descripcion, usuarioConectado, municipioId);
		try {
			barrioDao.actualizar(barrio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String descripcion, int usuarioConectado, int municipioId) {
		Barrio barrio = new Barrio(descripcion, usuarioConectado, municipioId);
		try {
			barrioDao.guardar(barrio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void borrar(int id) {
		Barrio barrio = new Barrio();
		try {
			barrio.setId(id);
			barrioDao.borrar(barrio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
