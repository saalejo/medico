package admisiones.db.dao.interfaz;

import java.util.List;

import admisiones.db.dto.modelo.MedicamentoMaestro;

public interface MedicamentoMaestroDao {

	void guardar(MedicamentoMaestro medicamento) throws Exception;

	void borrar(MedicamentoMaestro medicamento);

	List<MedicamentoMaestro> obtener() throws Exception;

	MedicamentoMaestro obtener(int id);

	MedicamentoMaestro obtener(String codigoMedicamento) throws Exception;

}
