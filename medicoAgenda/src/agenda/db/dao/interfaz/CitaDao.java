package agenda.db.dao.interfaz;

import agenda.db.dto.modelo.Cita;
public interface CitaDao  {

	/**
	 * Almacena la informacion de la Cita.
	 * @param atencion es la instancia con los datos de la cita a crear
	 * @throws Exception
	 */
	void guardar(Cita cita) throws Exception;
}
