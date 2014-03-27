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
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the diagnosticoId
	 */
	public int getDiagnosticoId() {
		return diagnosticoId;
	}
	/**
	 * @param diagnosticoId the diagnosticoId to set
	 */
	public void setDiagnosticoId(int diagnosticoId) {
		this.diagnosticoId = diagnosticoId;
	}
	/**
	 * @return the atencionId
	 */
	public int getAtencionId() {
		return atencionId;
	}
	/**
	 * @param atencionId the atencionId to set
	 */
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	/**
	 * @return the usuarioConectado
	 */
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	/**
	 * @param usuarioConectado the usuarioConectado to set
	 */
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	/**
	 * @return the diagnostico
	 */
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	/**
	 * @return the atencion
	 */
	public Atencion getAtencion() {
		return atencion;
	}
	/**
	 * @param atencion the atencion to set
	 */
	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}
}
