package admisiones.db.dao.interfaz;


import java.util.List;

import admisiones.db.dto.modelo.Especialidad;

public interface EspecialidadDao {

	List<Especialidad> obtener() throws Exception;

	Especialidad obtener(int id);

	void borrar(Especialidad especialidad);

	void guardar(Especialidad especialidad) throws Exception;

}
