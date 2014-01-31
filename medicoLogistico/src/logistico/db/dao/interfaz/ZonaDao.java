package logistico.db.dao.interfaz;

import java.util.List;

import logistico.db.dto.modelo.Zona;


public interface ZonaDao {
	
	List<Zona> obtener(int municipioId);

	void guardar(Zona zona) throws Exception;

	void borrar(Zona zona);


}