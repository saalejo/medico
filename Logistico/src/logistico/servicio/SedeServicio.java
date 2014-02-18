package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.CompaniaDao;
import logistico.db.dao.interfaz.DepartamentoDao;
import logistico.db.dao.interfaz.SedeDao;
import logistico.db.dto.modelo.Sede;

import org.springframework.beans.factory.annotation.Autowired;

public class SedeServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	SedeDao sedeDao;
	@Autowired
	CompaniaDao companiaDao;
	@Autowired
	DepartamentoDao departamentoDao;
	
	/**
	 * @return the sedeDao
	 */
	public SedeDao getSedeDao() {
		return sedeDao;
	}

	
	/**
	 * @param sedeDao the sedeDao to set
	 */
	public void setSedeDao(SedeDao sedeDao) {
		this.sedeDao = sedeDao;
	}

	
	public List<Sede> obtener(int companiaId) throws Exception {
		return sedeDao.obtener(companiaId);
	}	
	
	public List<Sede> obtener() throws Exception {
		return sedeDao.obtener();
	}	
	
	public void actualizar(int id, String nombre, String direccion,String telefono,String codigoHabilitacionIps, int usuarioConectado, int companiaId, int departamentoId ) {
		Sede sede = new Sede(id, nombre, direccion, telefono, codigoHabilitacionIps, usuarioConectado, companiaId, departamentoId);
		try {
			sedeDao.actualizar(sede);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String nombre, String direccion,String telefono,String codigoHabilitacionIps, int usuarioConectado, int companiaId, int departamentoId ) {
		Sede sede = new Sede(nombre, direccion, telefono, codigoHabilitacionIps, usuarioConectado, companiaId, departamentoId);
		try {
			sedeDao.guardar(sede);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) {
		Sede sede = new Sede();
		try {
			sede.setId(id);
			sedeDao.borrar(sede);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
