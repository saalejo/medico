package admiciones.db.dao.interfaz;

import java.util.List;

import admiciones.db.dto.modelo.Ingreso;

public interface IngresoDao {

	Ingreso guardar(Ingreso ingreso);

	void actualizar(Ingreso ingreso) throws Exception;

	List<Ingreso> obtenerIngresosPorPaciente(int pacienteId) throws Exception;

}
