package historia.clinica.db.dao.interfaz;

import historia.clinica.db.dto.modelo.Diagnostico;

import java.util.List;

public interface DiagnosticoDao {

	List<Diagnostico> obtener();

	Diagnostico obtener(int id);

	void guardar(Diagnostico diagnostico) throws Exception;

	void borrar(Diagnostico diagnostico);

	void actualizar(Diagnostico diagnostico) throws Exception;

}
