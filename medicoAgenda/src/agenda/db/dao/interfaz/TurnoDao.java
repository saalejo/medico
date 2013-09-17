package agenda.db.dao.interfaz;

import java.util.List;

import agenda.db.dto.modelo.Turno;
public interface TurnoDao  {

	/**
	 * Almacena la informacion del turno.
	 * @param atencion es la instancia con los datos de la atencion a crear
	 * @throws Exception
	 */
	void guardar(Turno turno) throws Exception;
	
	List<Turno> obtener();

	Turno obtener(int id);

	void borrar(Turno turno);

	void actualizar(Turno turno) throws Exception;
	



	
}
