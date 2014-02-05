package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Sede;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Sede.
 * @author Yedinzon Toro Gil
 *
 */

public interface SedeDao {
	
	void guardar(Sede sede) throws Exception;

	void borrar(Sede sede);

	List<Sede> obtener(int companiaId);

}