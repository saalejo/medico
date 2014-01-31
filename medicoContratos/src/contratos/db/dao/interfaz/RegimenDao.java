package contratos.db.dao.interfaz;

import contratos.db.dto.modelo.Regimen;



public interface RegimenDao {

	Regimen obtener(int regimenId);

	void guardar(Regimen regimen) throws Exception;

	void borrar(Regimen regimen);

	

}
