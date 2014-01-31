package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Departamento;


public interface DepartamentoDao {
	
	void guardar(Departamento departamento) throws Exception;

	void borrar(Departamento departamento);

	List<Departamento> obtener();

	
}