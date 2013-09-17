package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class AutorizacionPaciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9036019237292964310L;
	int id;
	int atencionId;
	String responsable;
	String nombreAutoriza;
	String tipoProcedimiento;
	int diagnosticoId;
	String procedimiento;
	String aspectosProcedimiento;
	String riesgos;
	String preparacion;
	String tiempoQuirurgico;
	String requerimientoEspecial;
	
	
	/**
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}
	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
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
	 * @return the nombreAutoriza
	 */
	public String getNombreAutoriza() {
		return nombreAutoriza;
	}
	/**
	 * @param nombreAutoriza the nombreAutoriza to set
	 */
	public void setNombreAutoriza(String nombreAutoriza) {
		this.nombreAutoriza = nombreAutoriza;
	}
	/**
	 * @return the tipoProcedimiento
	 */
	public String getTipoProcedimiento() {
		return tipoProcedimiento;
	}
	/**
	 * @param tipoProcedimiento the tipoProcedimiento to set
	 */
	public void setTipoProcedimiento(String tipoProcedimiento) {
		this.tipoProcedimiento = tipoProcedimiento;
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
	 * @return the procedimiento
	 */
	public String getProcedimiento() {
		return procedimiento;
	}
	/**
	 * @param procedimiento the procedimiento to set
	 */
	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}
	/**
	 * @return the aspectosProcedimiento
	 */
	public String getAspectosProcedimiento() {
		return aspectosProcedimiento;
	}
	/**
	 * @param aspectosProcedimiento the aspectosProcedimiento to set
	 */
	public void setAspectosProcedimiento(String aspectosProcedimiento) {
		this.aspectosProcedimiento = aspectosProcedimiento;
	}
	/**
	 * @return the riesgos
	 */
	public String getRiesgos() {
		return riesgos;
	}
	/**
	 * @param riesgos the riesgos to set
	 */
	public void setRiesgos(String riesgos) {
		this.riesgos = riesgos;
	}
	/**
	 * @return the preparacion
	 */
	public String getPreparacion() {
		return preparacion;
	}
	/**
	 * @param preparacion the preparacion to set
	 */
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	/**
	 * @return the tiempoQuirurgico
	 */
	public String getTiempoQuirurgico() {
		return tiempoQuirurgico;
	}
	/**
	 * @param tiempoQuirurgico the tiempoQuirurgico to set
	 */
	public void setTiempoQuirurgico(String tiempoQuirurgico) {
		this.tiempoQuirurgico = tiempoQuirurgico;
	}
	/**
	 * @return the requerimientoEspecial
	 */
	public String getRequerimientoEspecial() {
		return requerimientoEspecial;
	}
	/**
	 * @param requerimientoEspecial the requerimientoEspecial to set
	 */
	public void setRequerimientoEspecial(String requerimientoEspecial) {
		this.requerimientoEspecial = requerimientoEspecial;
	}
	
	
	

}
