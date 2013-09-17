package agenda.db.dao.interfaz;

import java.util.List;

import agenda.db.dto.modelo.CausaCancelacion;
public interface CausaCancelacionDao  {

	void guardar(CausaCancelacion causaCancelacion) throws Exception;
	
	List<CausaCancelacion> obtener();

	CausaCancelacion obtener(int id);

	void borrar(CausaCancelacion causaCancelacion);

	void actualizar(CausaCancelacion causaCancelacion) throws Exception;



	
}
