package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.IncapacidadDao;
import historia.clinica.db.dto.modelo.Incapacidad;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class IncapacidadServicio {

	@Autowired
	IncapacidadDao incapacidadDao;

	

	/**
	 * @return the incapacidadDao
	 */
	public IncapacidadDao getIncapacidadDao() {
		return incapacidadDao;
	}

	/**
	 * @param incapacidadDao the incapacidadDao to set
	 */
	public void setIncapacidadDao(IncapacidadDao incapacidadDao) {
		this.incapacidadDao = incapacidadDao;
	}

	
	

	public void guardar(int atencionId,Date fechaInicio,Date fechaFin,String orden,String usuarioConectado) {
		try {
			Incapacidad incapacidad=new Incapacidad();
			incapacidad.setFechaInicio(fechaInicio);
			incapacidad.setFechaFin(fechaFin);
			incapacidad.setUsuarioConectado(usuarioConectado);
			incapacidad.setOrden(orden);
			incapacidad.setAtencionId(atencionId);
			incapacidadDao.guardar(incapacidad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	



	
}
