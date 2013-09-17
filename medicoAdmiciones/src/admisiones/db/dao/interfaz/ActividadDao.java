package admisiones.db.dao.interfaz;

import java.util.List;

import admisiones.db.dto.modelo.Actividad;

public interface ActividadDao {

	List<Actividad> obtener();

	Actividad obtener(int id);

	void guardar(Actividad actividad) throws Exception;

	void borrar(Actividad actividad);

	void actualizar(Actividad actividad) throws Exception;

}
