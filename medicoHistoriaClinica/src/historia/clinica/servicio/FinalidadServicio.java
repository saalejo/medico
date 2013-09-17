package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.FinalidadDao;
import historia.clinica.db.dto.modelo.Finalidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FinalidadServicio {
	@Autowired
	FinalidadDao finalidadDao;

	public  List<Finalidad> obtener() {
		try {
			return finalidadDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the finalidadDao
	 */
	public FinalidadDao getFinalidadDao() {
		return finalidadDao;
	}

	/**
	 * @param finalidadDao the finalidadDao to set
	 */
	public void setFinalidadDao(FinalidadDao finalidadDao) {
		this.finalidadDao = finalidadDao;
	}

	
	public Finalidad obtener(int id) {
		try {
			return finalidadDao.obtener(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
