package historia.clinica.db.dao.interfaz;

import java.util.List;

import historia.clinica.db.dto.modelo.Remision;

public interface RemisionDao {

	void guardar(Remision remision) throws Exception;

	List<Remision> obtener();

	void actualizar(Remision remision) throws Exception;

	void borrar(Remision remision);

}
