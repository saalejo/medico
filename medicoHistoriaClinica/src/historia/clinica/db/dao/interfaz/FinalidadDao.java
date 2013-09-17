package historia.clinica.db.dao.interfaz;

import historia.clinica.db.dto.modelo.Finalidad;

import java.util.List;

public interface FinalidadDao {

	List<Finalidad> obtener()throws Exception;

	Finalidad obtener(int id)throws Exception;

}
