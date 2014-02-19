package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.ModuloSistema;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad ModuloSistema. 
 * @author Yedinzon Toro Gil
 *
 */

public interface ModuloSistemaDao  {	
	
	List<ModuloSistema> obtener() throws Exception;

	void actualizar(ModuloSistema moduloSistema) throws Exception;
	
	void guardar(ModuloSistema moduloSistema) throws Exception;

	void borrar(ModuloSistema moduloSistema) throws Exception;

}