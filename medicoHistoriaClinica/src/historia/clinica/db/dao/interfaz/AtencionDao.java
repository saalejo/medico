package historia.clinica.db.dao.interfaz;

import historia.clinica.db.dto.modelo.Atencion;

import java.util.List;
public interface AtencionDao {

	/**
	 * Almacena la informacion de la atencion.
	 * @param atencion es la instancia con los datos de la atencion a crear
	 * @return 
	 * @throws Exception
	 */
	public Atencion guardar(Atencion atencion) throws Exception;


	
	/**
	 * 
	 * @param pacienteId: es el id del paciente del que queremos consultar la historia
	 * clinica ya que este metodo devuelve todas las atenciones asociadas al paciente.
	 * @return List<Atencion>: es la lista de las atenciones organizadas por fecha.
	 * @throws Exception
	 */
	List<Atencion> obtenerAtencionesPorPaciente(int pacienteId) throws Exception;



	public void actualizar(Atencion atencion) throws Exception;
}
