package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Consultorio;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Consultorio. 
 * @author Yedinzon Toro Gil
 *
 */

public interface ConsultorioDao  {	
	
	List<Consultorio> obtener() throws Exception;

	void actualizar(Consultorio consultorio) throws Exception;
	
	void guardar(Consultorio consultorio) throws Exception;

	void borrar(Consultorio consultorio) throws Exception;

}