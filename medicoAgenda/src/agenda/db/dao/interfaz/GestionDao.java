package agenda.db.dao.interfaz;

import java.util.List;

import agenda.db.dto.modelo.Gestion;



public interface GestionDao  {


	void guardar(Gestion gestion) throws Exception;
	
	List<Gestion> obtener();

	Gestion obtener(int id);

	void borrar(Gestion gestion);

	void actualizar(Gestion gestion) throws Exception;



	
}
