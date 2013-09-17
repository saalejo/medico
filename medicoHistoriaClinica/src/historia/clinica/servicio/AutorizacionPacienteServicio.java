package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.AutorizacionPacienteDao;
import historia.clinica.db.dto.modelo.AutorizacionPaciente;

import java.util.List;


public class AutorizacionPacienteServicio {

	private AutorizacionPacienteDao autorizacionPacienteDao;

	
	/**
	 * @return the autorizacionPacienteDao
	 */
	public AutorizacionPacienteDao getAutorizacionPacienteDao() {
		return autorizacionPacienteDao;
	}

	/**
	 * @param autorizacionPacienteDao the autorizacionPacienteDao to set
	 */
	public void setAutorizacionPacienteDao(AutorizacionPacienteDao autorizacionPacienteDao) {
		this.autorizacionPacienteDao = autorizacionPacienteDao;
	}

	public List<AutorizacionPaciente> obtener(int pacienteId) {
		try {
			return autorizacionPacienteDao.obtenerAutorizacionesPacientePorPaciente(pacienteId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void actualizar(AutorizacionPaciente autorizacionPaciente) {
		try {
			autorizacionPacienteDao.actualizar(autorizacionPaciente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void guardar(AutorizacionPaciente autorizacionPaciente) {
		try {
			autorizacionPacienteDao.guardar(autorizacionPaciente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
