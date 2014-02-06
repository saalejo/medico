package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Municipio;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Municipio.
 * @author Yedinzon Toro Gil
 *
 */

public interface MunicipioDao {
	
	List<Municipio> obtener(int departamentoId)  throws Exception;
	
	List<Municipio> obtener()  throws Exception;
	
	void actualizar(Municipio municipio) throws Exception;
	
	void guardar(Municipio municipio) throws Exception;

	void borrar(Municipio municipio)  throws Exception;	

}