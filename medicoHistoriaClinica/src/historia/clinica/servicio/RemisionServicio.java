package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.RemisionDao;
import historia.clinica.db.dto.modelo.Remision;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class RemisionServicio {

	@Autowired
	RemisionDao remisionDao;

	

	/**
	 * @return the remisionDao
	 */
	public RemisionDao getRemisionDao() {
		return remisionDao;
	}

	/**
	 * @param remisionDao the remisionDao to set
	 */
	public void setRemisionDao(RemisionDao remisionDao) {
		this.remisionDao = remisionDao;
	}

	
	

	public void guardar(int atencionId,String motivo,String resultados,String usuarioConectado) {
		try {
			Remision remision=new Remision();
			remision.setAtencionId(atencionId);
			remision.setMotivo(motivo);
			remision.setResultadoExamenes(resultados);
			remision.setUsuarioConectado(usuarioConectado);
			remisionDao.guardar(remision);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	



	
}
