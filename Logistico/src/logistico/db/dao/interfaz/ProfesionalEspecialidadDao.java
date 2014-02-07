package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.ProfesionalEspecialidad;

/**
 * Descripción de la interfaz:contrato que contiene todos los métodos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad ProfesionalEntidad. 
 * @author Yedinzon Toro Gil
 *
 */


public interface ProfesionalEspecialidadDao  {	
	
	List<ProfesionalEspecialidad> obtenerPorProfesional(int profesionalId) throws Exception;
	
	List<ProfesionalEspecialidad> obtenerPorEspecialidad(int especialidadId) throws Exception;

	void actualizar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception;
	
	void guardar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception;

	void borrar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception;

}
