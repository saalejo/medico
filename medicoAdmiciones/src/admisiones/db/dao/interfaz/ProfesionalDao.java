package admisiones.db.dao.interfaz;

import java.util.List;

import admisiones.db.dto.modelo.Profesional;

public interface ProfesionalDao {

	Profesional obtener(String profesionalLogin);

	void guardar(Profesional profesional) throws Exception;

	void borrar(Profesional profesional);

	List<Profesional> obtener();

}
