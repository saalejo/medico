package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Municipio;

/**
 * Descripci�n de la interfaz:contrato que contiene todos los m�todos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Municipio.
 * @author Yedinzon Toro Gil
 *
 */

public interface MunicipioDao {
	
	void guardar(Municipio municipio) throws Exception;

	void borrar(Municipio municipio);

	List<Municipio> obtener(int departamentoId);

}