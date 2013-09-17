package agenda.db.dao.interfaz;

import java.util.List;


import agenda.db.dto.modelo.Festivo;
public interface FestivoDao  {

	/**
	 * Almacena la informacion del Consultorio
	 * @param consultorio es la instancia con los datos del consultorio a crear
	 * @throws Exception
	 */
	void guardar(Festivo festivo) throws Exception;
	
	List<Festivo> obtener();

	Festivo obtener(int id);

	void borrar(Festivo festivo);

	void actualizar(Festivo festivo) throws Exception;


}
