package admisiones.db.dao.interfaz;

import admisiones.db.dto.modelo.Paciente;

public interface PacienteDao {

	void guardar(Paciente paciente) throws Exception;

	Paciente obtener(String id);

}
