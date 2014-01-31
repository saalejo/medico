package contratos.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import contratos.db.dao.interfaz.ContratoDao;
import contratos.db.dao.interfaz.RegimenDao;
import contratos.db.dto.modelo.Contrato;




public class ContratoServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ContratoDao contratoDao;
	@Autowired
	RegimenDao regimenDao;
	
	/**
	 * @return the contratoDao
	 */
	public ContratoDao getContratoDao() {
		return contratoDao;
	}


	/**
	 * @param contratoDao the contratoDao to set
	 */
	public void setContratoDao(ContratoDao contratoDao) {
		this.contratoDao = contratoDao;
	}


	public void guardar(String codigo, String descripcion,int regimenId,int usuarioConectado) {
		Contrato contrato=new Contrato(codigo,descripcion,regimenId,usuarioConectado);
		try {
			contratoDao.guardar(contrato);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void borrar(int id) {
		Contrato contrato=new Contrato();
		contrato.setId(id);
		contratoDao.borrar(contrato);
		
	}


	public List<Contrato> obtener(int entidadId) {
		return contratoDao.obtener(entidadId);
	}
	
}
