package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Barrio;

/**
 * Descripci�n de la interfaz:contrato que contiene todos los m�todos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Barrio.
 * @author Yedinzon Toro Gil
 *
 */

public interface BarrioDao {	

	void guardar(Barrio barrio) throws Exception;

	void borrar(Barrio barrio) throws Exception;
	
	List<Barrio> obtener(int municipioId) throws Exception;

}