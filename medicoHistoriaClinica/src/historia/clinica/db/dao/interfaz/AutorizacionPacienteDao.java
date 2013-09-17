package historia.clinica.db.dao.interfaz;

import java.util.List;

import historia.clinica.db.dto.modelo.AutorizacionPaciente;

public interface AutorizacionPacienteDao {

	AutorizacionPaciente guardar(AutorizacionPaciente autorizacionPaciente);

	void actualizar(AutorizacionPaciente autorizacionPaciente) throws Exception;

	List<AutorizacionPaciente> obtenerAutorizacionesPacientePorPaciente(
			int pacienteId) throws Exception;

}
