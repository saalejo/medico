package contratos.db.dao.interfaz;

import java.util.List;

import contratos.db.dto.modelo.Contrato;



public interface ContratoDao {

	List<Contrato> obtener(int entidadId);

	void guardar(Contrato contrato) throws Exception;

	void borrar(Contrato contrato);

	

}
