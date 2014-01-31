package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Sede;


public interface SedeDao {
	
	List<Sede> obtener(int companiaId);

	void guardar(Sede sede) throws Exception;

	void borrar(Sede sede);

	

}