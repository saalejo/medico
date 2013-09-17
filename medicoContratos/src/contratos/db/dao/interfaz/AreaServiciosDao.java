package contratos.db.dao.interfaz;

import java.util.List;

import contratos.db.dto.modelo.AreaServicios;
import contratos.db.dto.modelo.Servicio;

public interface AreaServiciosDao {

	List<AreaServicios> obtener();

	AreaServicios obtener(String usuario);

	void guardar(AreaServicios areaServicios) throws Exception;

	void borrar(AreaServicios areaServicios);

	

}
