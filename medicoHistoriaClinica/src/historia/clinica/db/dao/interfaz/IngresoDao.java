package historia.clinica.db.dao.interfaz;

import historia.clinica.db.dto.modelo.Ingreso;

import java.util.List;

public interface IngresoDao {

	List<Ingreso> obtener();

	Ingreso obtener(int id);

	void guardar(Ingreso ingreso) throws Exception;

	void borrar(Ingreso ingreso);

	void actualizar(Ingreso ingreso) throws Exception;

}
