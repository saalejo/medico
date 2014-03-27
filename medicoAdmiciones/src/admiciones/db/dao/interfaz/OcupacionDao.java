package admiciones.db.dao.interfaz;

import admiciones.db.dto.modelo.Ocupacion;

public interface OcupacionDao {

	void guardar(Ocupacion ocupacion) throws Exception;

	void actualizar(Ocupacion ocupacion) throws Exception;

	public Ocupacion obtener(int pacienteId) throws Exception;

	void borrar(Ocupacion ocupacion) throws Exception;

}
