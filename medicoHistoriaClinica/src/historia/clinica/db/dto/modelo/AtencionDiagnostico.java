package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class AtencionDiagnostico implements Serializable

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	int diagnosticoId; 
	int atencionId;
	int usuarioConectado;
	
	Diagnostico diagnostico;
	Atencion    atencion;
	

}
