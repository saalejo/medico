package logistico.db.dao.interfaz;

import java.util.List;
import logistico.db.dto.modelo.Compania;


public interface CompaniaDao {
	
	void guardar(Compania compania) throws Exception;

	void borrar(Compania compania);

	List<Compania> obtener();

	

}