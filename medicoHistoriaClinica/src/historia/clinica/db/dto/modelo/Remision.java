package historia.clinica.db.dto.modelo;

public class Remision {
	int id;
	String motivo;
	String resultadoExamenes;
	int atencionId;
	String usuarioConectado;
	
	
	
	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * @return the usuarioConectado
	 */
	public String getUsuarioConectado() {
		return usuarioConectado;
	}
	/**
	 * @param usuarioConectado the usuarioConectado to set
	 */
	public void setUsuarioConectado(String usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
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
	 * @return the resultadoExamenes
	 */
	public String getResultadoExamenes() {
		return resultadoExamenes;
	}
	/**
	 * @param resultadoExamenes the resultadoExamenes to set
	 */
	public void setResultadoExamenes(String resultadoExamenes) {
		this.resultadoExamenes = resultadoExamenes;
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
	
}
