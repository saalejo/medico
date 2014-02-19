package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Horario;

/**
 * Descripci�n de la interfaz:contrato que contiene todos los m�todos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Horario. 
 * @author Yedinzon Toro Gil
 *
 */

public interface HorarioDao  {	
	
	List<Horario> obtener() throws Exception;

	void actualizar(Horario horario) throws Exception;
	
	void guardar(Horario horario) throws Exception;

	void borrar(Horario horario) throws Exception;

}