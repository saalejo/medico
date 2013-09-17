package agenda.db.dao.interfaz;

import java.util.List;

import agenda.db.dto.modelo.Evento;


public interface EventoDao  {

	void guardar(Evento evento) throws Exception;
	
	List<Evento> obtener();

	Evento obtener(int id);

	void borrar(Evento evento);

	void actualizar(Evento evento) throws Exception;



	
}
