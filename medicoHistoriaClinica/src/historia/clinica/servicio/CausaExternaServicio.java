package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.CausaExternaDao;
import historia.clinica.db.dto.modelo.CausaExterna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CausaExternaServicio {

	@Autowired
	CausaExternaDao causaExternaDao;

	
	/**
	 * metodo para obtener todas las causas esternas
	 */
	public  List<CausaExterna> obtener() {
		try {
			return causaExternaDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}



	
	public CausaExterna obtener(int id) {
		try {
			return causaExternaDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * @return the causaExternaDao
	 */
	public CausaExternaDao getCausaExternaDao() {
		return causaExternaDao;
	}

	/**
	 * @param causaExternaDao the causaExternaDao to set
	 */
	public void setCausaExternaDao(CausaExternaDao causaExternaDao) {
		this.causaExternaDao = causaExternaDao;
	}
}
