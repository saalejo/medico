package contratos.servicio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import contratos.db.dao.interfaz.AreaServiciosDao;
import contratos.db.dto.modelo.AreaServicios;




public class AreaServiciosServicio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551548767038400035L;
	@Autowired
	AreaServiciosDao areaServicioDao;
	
	
	/**
	 * @return the areaServicioDao
	 */
	public AreaServiciosDao getAreaServiciosDao() {
		return areaServicioDao;
	}


	/**
	 * @param areaServicioDao the areaServicioDao to set
	 */
	public void setAreaServiciosDao(AreaServiciosDao areaServicioDao) {
		this.areaServicioDao = areaServicioDao;
	}


	public void guardar(String usuario, String clave, String tipoUsuario, String nombre,
			String codigo, int prestadorId, String estado, String usuarioConectado) {
		AreaServicios servicio=new AreaServicios();
		try {
			areaServicioDao.guardar(servicio);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void borrar(int id) {
		AreaServicios servicio=new AreaServicios();
		servicio.setId(id);
		areaServicioDao.borrar(servicio);
		
	}


	public List<AreaServicios> obtener() {
		return areaServicioDao.obtener();
	}
	
}
