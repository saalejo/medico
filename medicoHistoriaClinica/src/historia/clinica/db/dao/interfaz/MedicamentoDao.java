package historia.clinica.db.dao.interfaz;

import historia.clinica.db.dto.modelo.Medicamento;

public interface MedicamentoDao {

	void guardar(Medicamento medicamento) throws Exception;

}
