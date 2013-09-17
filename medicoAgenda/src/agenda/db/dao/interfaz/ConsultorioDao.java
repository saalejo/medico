package agenda.db.dao.interfaz;

import java.util.List;


import agenda.db.dto.modelo.Consultorio;
public interface ConsultorioDao  {

	/**
	 * Almacena la informacion del Consultorio
	 * @param consultorio es la instancia con los datos del consultorio a crear
	 * @throws Exception
	 */
	void guardar(Consultorio consultorio) throws Exception;
	
	List<Consultorio> obtener();

	Consultorio obtener(int id);

	void borrar(Consultorio consultorio);

	void actualizar(Consultorio consultorio) throws Exception;



	
}
