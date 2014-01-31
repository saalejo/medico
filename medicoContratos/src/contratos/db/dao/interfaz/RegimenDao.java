package contratos.db.dao.interfaz;

import java.util.List;

import contratos.db.dto.modelo.Regimen;



public interface RegimenDao {

	void guardar(Regimen regimen) throws Exception;

	void borrar(Regimen regimen);

	List<Regimen> obtener();

	

}
