package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.ProtocoloDao;
import logistico.db.dto.modelo.Protocolo;

import org.springframework.beans.factory.annotation.Autowired;

public class ProtocoloServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ProtocoloDao protocoloDao;
	
	
	/**
	 * @return the protocoloDao
	 */
	public ProtocoloDao getProtocoloDao() {
		return protocoloDao;
	}

	/**
	 * @param protocoloDao the protocoloDao to set
	 */
	public void setProtocoloDao(ProtocoloDao protocoloDao) {
		this.protocoloDao = protocoloDao;
	}

	
	public List<Protocolo> obtener() throws Exception {
		return protocoloDao.obtener();
	}	
	
	public void actualizar(int id, String nombre, String descripcion, Boolean tipo,
			int usuarioConectado) {
		Protocolo protocolo = new Protocolo(id, nombre, descripcion, tipo, usuarioConectado);
		try {
			protocoloDao.actualizar(protocolo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardar(String nombre, String descripcion, Boolean tipo,
			int usuarioConectado) {
		Protocolo protocolo = new Protocolo(nombre, descripcion, tipo, usuarioConectado);
		try {
			protocoloDao.guardar(protocolo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void borrar(int id) {
		Protocolo protocolo = new Protocolo();
		try {
			protocolo.setId(id);
			protocoloDao.borrar(protocolo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
