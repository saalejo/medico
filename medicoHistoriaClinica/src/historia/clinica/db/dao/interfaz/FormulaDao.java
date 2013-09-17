package historia.clinica.db.dao.interfaz;

import java.util.List;

import historia.clinica.db.dto.modelo.Formula;

public interface FormulaDao {

	void guardar(Formula formula) throws Exception;

	List<Formula> obtener();

	void borrar(Formula formula);

}
