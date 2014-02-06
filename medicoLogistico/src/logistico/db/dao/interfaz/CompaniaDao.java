package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Compania;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Compania.
 * @author Yedinzon Toro Gil
 *
 */

public interface CompaniaDao {
	
	List<Compania> obtener() throws Exception;
	
	void actualizar(Compania compania) throws Exception;
	
	void guardar(Compania compania) throws Exception;

	void borrar(Compania compania) throws Exception;

}