package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Configuracion;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Configuracion. 
 * @author Yedinzon Toro Gil
 *
 */

public interface ConfiguracionDao  {	
	
	List<Configuracion> obtenerPorModuloSistema(int moduloSistemaId) throws Exception;
	
	List<Configuracion> obtenerPorEspecialidad(int especialidadId) throws Exception;

	void actualizar(Configuracion configuracion) throws Exception;
	
	void guardar(Configuracion configuracion) throws Exception;

	void borrar(Configuracion configuracion) throws Exception;

}