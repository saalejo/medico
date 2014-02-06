package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Profesional;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Profesional. 
 * @author Yedinzon Toro Gil
 *
 */

public interface ProfesionalDao  {	
	
	List<Profesional> obtener() throws Exception;

	void actualizar(Profesional profesional) throws Exception;
	
	void guardar(Profesional profesional) throws Exception;

	void borrar(Profesional profesional) throws Exception;

}