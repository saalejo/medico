package agenda.db.dao.interfaz;

import java.util.List;


import agenda.db.dto.modelo.Configuracion;
public interface ConfiguracionDao  {

	/**
	 * Almacena la informacion del Consultorio
	 * @param consultorio es la instancia con los datos del consultorio a crear
	 * @throws Exception
	 */
	
	List<Configuracion> obtener();

	Configuracion obtener(int id);

	void actualizar(Configuracion configuracion) throws Exception;



	
}
