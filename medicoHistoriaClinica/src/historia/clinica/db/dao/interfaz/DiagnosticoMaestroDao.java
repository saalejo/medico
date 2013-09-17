package historia.clinica.db.dao.interfaz;

import java.util.List;

import historia.clinica.db.dto.modelo.Diagnostico;
import historia.clinica.db.dto.modelo.DiagnosticoMaestro;

public interface DiagnosticoMaestroDao {

	DiagnosticoMaestro obtener(int id);

	List<DiagnosticoMaestro> obtener();

	void guardar(DiagnosticoMaestro diagnosticoMaestro) throws Exception;

	void borrar(DiagnosticoMaestro diagnosticoMaestro);

	void actualizar(DiagnosticoMaestro diagnosticoMaestro) throws Exception;

	

}
