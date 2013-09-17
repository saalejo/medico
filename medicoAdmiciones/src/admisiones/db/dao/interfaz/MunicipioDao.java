package admisiones.db.dao.interfaz;


import java.util.List;

import admisiones.db.dto.modelo.Municipio;

public interface MunicipioDao {

	List<Municipio> obtener() throws Exception;

	Municipio obtener(int id);

	void guardar(Municipio municipio) throws Exception;

	void borrar(Municipio municipio);

}
