package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Sede;

/**
 * Descripci�n de la interfaz:contrato que contiene todos los m�todos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Sede.
 * @author Yedinzon Toro Gil
 *
 */

public interface SedeDao {
	
	List<Sede> obtener(int companiaId) throws Exception;
	
	List<Sede> obtener() throws Exception;
	
	void actualizar(Sede sede) throws Exception;
	
	void guardar(Sede sede) throws Exception;

	void borrar(Sede sede) throws Exception;

}