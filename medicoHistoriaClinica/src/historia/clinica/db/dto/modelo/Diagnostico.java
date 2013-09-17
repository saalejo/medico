package historia.clinica.db.dto.modelo;

public class Diagnostico {
	int id;
	String observaciones;
	DiagnosticoMaestro diagnostico;
	int atencionId;
	int diagnosticoId;
	boolean prinsipal;
	String ingresoEgreso;
	String tipo;
	String clase;
	String Codigo;
	
	
	
	
	
	
	/**
	 * @return the principal
	 */
	public boolean isPrinsipal() {
		return prinsipal;
	}
	/**
	 * @param principal the principal to set
	 */
	public void setPrinsipal(boolean prinsipal) {
		this.prinsipal = prinsipal;
	}
	/**
	 * @return the ingresoEgreso
	 */
	public String getIngresoEgreso() {
		return ingresoEgreso;
	}
	/**
	 * @param ingresoEgreso the ingresoEgreso to set
	 */
	public void setIngresoEgreso(String ingresoEgreso) {
		this.ingresoEgreso = ingresoEgreso;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}
	/**
	 * @param clase the clase to set
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return Codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		Codigo = codigo;
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
	 * @return the diagnosticoid
	 */
	public int getDiagnosticoId() {
		return diagnosticoId;
	}
	/**
	 * @param diagnosticoid the diagnosticoid to set
	 */
	public void setDiagnosticoId(int diagnosticoId) {
		this.diagnosticoId = diagnosticoId;
	}
	/**
	 * @return the diagnostico
	 */
	public DiagnosticoMaestro getDiagnostico() {
		return diagnostico;
	}
	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(DiagnosticoMaestro diagnostico) {
		this.diagnostico = diagnostico;
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
	 * @return the codigo
	 */
	
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
