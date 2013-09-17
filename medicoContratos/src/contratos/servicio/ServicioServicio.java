package contratos.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import contratos.db.dao.interfaz.ServicioDao;
import contratos.db.dto.modelo.Servicio;




public class ServicioServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	ServicioDao servicioDao;
	
	
	/**
	 * @return the servicioDao
	 */
	public ServicioDao getServicioDao() {
		return servicioDao;
	}


	/**
	 * @param servicioDao the servicioDao to set
	 */
	public void setServicioDao(ServicioDao servicioDao) {
		this.servicioDao = servicioDao;
	}

	public void borrar(int id) {
		Servicio servicio=new Servicio();
		servicio.setId(id);
		servicioDao.borrar(servicio);
		
	}


	public List<Servicio> obtener() {
		return servicioDao.obtener();
	}


	public void guardar(Servicio servicio) {
		try {
			servicioDao.guardar(servicio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
