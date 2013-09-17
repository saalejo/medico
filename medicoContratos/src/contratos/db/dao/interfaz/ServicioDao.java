package contratos.db.dao.interfaz;

import java.util.List;

import contratos.db.dto.modelo.Servicio;

public interface ServicioDao {

	Servicio obtener(String usuario);

	void guardar(Servicio servicio) throws Exception;

	void borrar(Servicio servicio);

	List<Servicio> obtener();

}
