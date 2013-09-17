package historia.clinica.db.dao.interfaz;

import historia.clinica.db.dto.modelo.CausaExterna;

import java.util.List;

public interface CausaExternaDao {

	List<CausaExterna> obtener() throws Exception;

	CausaExterna obtener(int id) throws Exception;

}
