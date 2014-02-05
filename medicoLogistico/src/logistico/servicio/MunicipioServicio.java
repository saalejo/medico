package logistico.servicio;

import java.io.Serializable;
import java.util.List;

import logistico.db.dao.interfaz.MunicipioDao;
import logistico.db.dto.modelo.Departamento;
import logistico.db.dto.modelo.Municipio;

import org.springframework.beans.factory.annotation.Autowired;

public class MunicipioServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	MunicipioDao municipioDao;
	@Autowired
	Departamento departamentoDao;	


	/**
	 * @return the municipioDao
	 */
	public MunicipioDao getMunicipioDao() {
		return municipioDao;
	}


	/**
	 * @param municipioDao the municipioDao to set
	 */
	public void setMunicipioDao(MunicipioDao municipioDao) {
		this.municipioDao = municipioDao;
	}


	public void guardar(String descripcion, int usuarioConectado, int departamentoId) {
		Municipio municipio = new Municipio(descripcion, usuarioConectado, departamentoId);
		try {
			municipioDao.guardar(municipio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void borrar(int id) {
		Municipio municipio = new Municipio();
		municipio.setId(id);
		municipioDao.borrar(municipio);
		
	}


	public List<Municipio> obtener(int departamentoId) {
		return municipioDao.obtener(departamentoId);
	}
	
}
