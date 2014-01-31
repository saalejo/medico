package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.CompaniaDao;
import logistico.db.dao.interfaz.DepartamentoDao;
import logistico.db.dao.interfaz.MunicipioDao;
import logistico.db.dao.interfaz.ZonaDao;
import logistico.db.dto.modelo.Compania;

import org.springframework.beans.factory.annotation.Autowired;




public class CompaniaServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;

	@Autowired
	CompaniaDao companiaDao;
	@Autowired
	DepartamentoDao departamentoDao;
	@Autowired
	MunicipioDao municipioDao;
	@Autowired
	ZonaDao zonaDao;
	
	
	/**
	 * @return the companiaDao
	 */
	public CompaniaDao getCompaniaDao() {
		return companiaDao;
	}


	/**
	 * @param companiaDao the companiaDao to set
	 */
	public void setCompaniaDao(CompaniaDao companiaDao) {
		this.companiaDao = companiaDao;
	}


	public void guardar(String nit, String direccion, String telefono, String codigoHabilitacionIps, String sloganIps, int departamentoId, int municipioId, int zonaId, int usuarioConectado) {
		Compania compania = new Compania(nit, direccion, telefono, codigoHabilitacionIps, sloganIps, departamentoId, municipioId, zonaId, usuarioConectado);
		try {
			companiaDao.guardar(compania);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void borrar(int id) {
		Compania compania=new Compania();
		compania.setId(id);
		companiaDao.borrar(compania);
		
	}


	public List<Compania> obtener() {
		return companiaDao.obtener();
	}
	
}
