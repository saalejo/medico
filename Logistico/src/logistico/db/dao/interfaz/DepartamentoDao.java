package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Departamento;

/**
 * Descripci�n de la interfaz:contrato que contiene todos los m�todos (servicios) 
 * ofrecidos por la capa de acceso a datos correspondiente a la entidad Departamento.
 * @author Yedinzon Toro Gil
 *
 */

public interface DepartamentoDao {
	
	List<Departamento> obtener() throws Exception;	
	
	void actualizar(Departamento departamento) throws Exception;
	
	void guardar(Departamento departamento) throws Exception;

	void borrar(Departamento departamento) throws Exception;

}