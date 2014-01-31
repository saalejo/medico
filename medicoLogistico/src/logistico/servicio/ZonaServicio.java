package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.ZonaDao;
import logistico.db.dto.modelo.Municipio;
import logistico.db.dto.modelo.Zona;

import org.springframework.beans.factory.annotation.Autowired;




public class ZonaServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ZonaDao zonaDao;
	@Autowired
	Municipio municipioDao;	

	/**
	 * @return the zonaDao
	 */
	public ZonaDao getZonaDao() {
		return zonaDao;
	}


	/**
	 * @param zonaDao the zonaDao to set
	 */
	public void setZonaDao(ZonaDao zonaDao) {
		this.zonaDao = zonaDao;
	}


	public void guardar(String descripcion, int municipioId, int usuarioConectado) {
		Zona zona = new Zona(descripcion, municipioId, usuarioConectado);
		try {
			zonaDao.guardar(zona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void borrar(int id) {
		Zona zona=new Zona();
		zona.setId(id);
		zonaDao.borrar(zona);
		
	}


	public List<Zona> obtener(int municipioId) {
		return zonaDao.obtener(municipioId);
	}
	
}
