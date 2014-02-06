package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Protocolo;

/**
 * Descripci�n de la interfaz:contrato que contiene todos los m�todos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Profesional. 
 * @author Yedinzon Toro Gil
 *
 */

public interface ProtocoloDao  {	
	
	List<Protocolo> obtener() throws Exception;

	void actualizar(Protocolo protocolo) throws Exception;
	
	void guardar(Protocolo protocolo) throws Exception;

	void borrar(Protocolo protocolo) throws Exception;

}