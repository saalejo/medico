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
	
	List<ProfesionalEspecialidad> obtener(int profesionalId, int especialidadId) throws Exception;
	
	List<ProfesionalEspecialidad> obtener() throws Exception;

	void actualizar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception;
	
	void guardar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception;

	void borrar(ProfesionalEspecialidad profesionalEspecialidad) throws Exception;

}