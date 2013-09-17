package admisiones.db.dao.interfaz;

import java.util.List;

import admisiones.db.dto.modelo.Prestador;

public interface PrestadorDao {

	void guardar(Prestador prestador) throws Exception;

	void borrar(Prestador prestador);

	List<Prestador> obtener();

}
