package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.CausaCancelacion;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad CausaCancelacion. 
 * @author Yedinzon Toro Gil
 *
 */

public interface CausaCancelacionDao  {	
		
	List<CausaCancelacion> obtener(int moduloSistemaId) throws Exception;
	
	List<CausaCancelacion> obtener() throws Exception;

	void actualizar(CausaCancelacion causaCancelacion) throws Exception;
	
	void guardar(CausaCancelacion causaCancelacion) throws Exception;

	void borrar(CausaCancelacion causaCancelacion) throws Exception;

}