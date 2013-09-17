package admisiones.db.dao.interfaz;


import java.util.List;

import admisiones.db.dto.modelo.Entidad;

public interface EntidadDao {

	List<Entidad> obtener() throws Exception;

	Entidad obtener(int id);

	void borrar(Entidad entidad);

	void guardar(Entidad entidad) throws Exception;

}
