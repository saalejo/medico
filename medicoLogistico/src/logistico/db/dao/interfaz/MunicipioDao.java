package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Municipio;


public interface MunicipioDao {
	
	List<Municipio> obtener(int departamentoId);

	void guardar(Municipio municipio) throws Exception;

	void borrar(Municipio municipio);

	

}