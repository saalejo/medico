package historia.clinica.db.dto.modelo;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Atencion  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8844642997637644949L;
	int id;
	Set<Diagnostico> diagnosticos;
	Set<CampoHistoria> camposHistoria;
	CausaExterna causaExterna;
	Finalidad finalidad;
	Date fechaAtencion;
	String tipoConsulta;
	String observaciones;
	int causaExternaId;
	int finalidadId;
	int pacienteId;
	int municipioId;
	int profesionalId;
	Ingreso ingreso;
	private int ingresoId;
	String antecedentesMedicos;
	String  antecedentesQuirurgicos;
	String antecedentesGinecologicos;
	String antecedentesAlergicos;
	String antecedentesTraumaticos;
	String antecedentesPsiquiatricos;
	
	
	

	/**
	 * @return the ingreso
	 */
	public Ingreso getIngreso() {
		return ingreso;
	}
	/**
	 * @param ingreso the ingreso to set
	 */
	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}
	/**
	 * @return the antecedentesMedicos
	 */
	public String getAntecedentesMedicos() {
		return antecedentesMedicos;
	}
	/**
	 * @param antecedentesMedicos the antecedentesMedicos to set
	 */
	public void setAntecedentesMedicos(String antecedentesMedicos) {
		this.antecedentesMedicos = antecedentesMedicos;
	}
	/**
	 * @return the antecedentesGinecologicos
	 */
	public String getAntecedentesGinecologicos() {
		return antecedentesGinecologicos;
	}
	/**
	 * @param antecedentesGinecologicos the antecedentesGinecologicos to set
	 */
	public void setAntecedentesGinecologicos(String antecedentesGinecologicos) {
		this.antecedentesGinecologicos = antecedentesGinecologicos;
	}
	/**
	 * @return the antecedentesTraumaticos
	 */
	public String getAntecedentesTraumaticos() {
		return antecedentesTraumaticos;
	}
	/**
	 * @param antecedentesTraumaticos the antecedentesTraumaticos to set
	 */
	public void setAntecedentesTraumaticos(String antecedentesTraumaticos) {
		this.antecedentesTraumaticos = antecedentesTraumaticos;
	}
	/**
	 * @return the antecedentesPsiquiatricos
	 */
	public String getAntecedentesPsiquiatricos() {
		return antecedentesPsiquiatricos;
	}
	/**
	 * @param antecedentesPsiquiatricos the antecedentesPsiquiatricos to set
	 */
	public void setAntecedentesPsiquiatricos(String antecedentesPsiquiatricos) {
		this.antecedentesPsiquiatricos = antecedentesPsiquiatricos;
	}
	/**
	 * @return the camposHistoria
	 */
	public Set<CampoHistoria> getCamposHistoria() {
		return camposHistoria;
	}
	/**
	 * @param camposHistoria the camposHistoria to set
	 */
	public void setCamposHistoria(Set<CampoHistoria> camposHistoria) {
		this.camposHistoria = camposHistoria;
	}
	/**
	 * @return the antecedentesQuirurgicos
	 */
	public String getAntecedentesQuirurgicos() {
		return antecedentesQuirurgicos;
	}
	/**
	 * @param antecedentesQuirurgicos the antecedentesQuirurgicos to set
	 */
	public void setAntecedentesQuirurgicos(String antecedentesQuirurgicos) {
		this.antecedentesQuirurgicos = antecedentesQuirurgicos;
	}
	/**
	 * @return the antecedentesAlergicos
	 */
	public String getAntecedentesAlergicos() {
		return antecedentesAlergicos;
	}
	/**
	 * @param antecedentesAlergicos the antecedentesAlergicos to set
	 */
	public void setAntecedentesAlergicos(String antecedentesAlergicos) {
		this.antecedentesAlergicos = antecedentesAlergicos;
	}
	
	/**
	 * @return the ingresoId
	 */
	public int getIngresoId() {
		return ingresoId;
	}
	/**
	 * @param ingresoId the ingresoId to set
	 */
	public void setIngresoId(int ingresoId) {
		this.ingresoId = ingresoId;
	}
	/**
	 * @return the diagnosticos
	 */
	public Set<Diagnostico> getDiagnosticos() {
		return diagnosticos;
	}
	/**
	 * @param diagnosticos the diagnosticos to set
	 */
	public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
		this.diagnosticos = diagnosticos;
	}
	/**
	 * @return the causaExterna
	 */
	public CausaExterna getCausaExterna() {
		return causaExterna;
	}
	/**
	 * @param causaExterna the causaExterna to set
	 */
	public void setCausaExterna(CausaExterna causaExterna) {
		this.causaExterna = causaExterna;
	}
	/**
	 * @return the finalidad
	 */
	public Finalidad getFinalidad() {
		return finalidad;
	}
	/**
	 * @param finalidad the finalidad to set
	 */
	public void setFinalidad(Finalidad finalidad) {
		this.finalidad = finalidad;
	}
	/**
	 * @return the pacienteId
	 */
	public int getPacienteId() {
		return pacienteId;
	}
	/**
	 * @param pacienteId the pacienteId to set
	 */
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
	/**
	 * @return the causaExternaId
	 */
	public int getCausaExternaId() {
		return causaExternaId;
	}
	/**
	 * @param causaExternaId the causaExternaId to set
	 */
	public void setCausaExternaId(int causaExternaId) {
		this.causaExternaId = causaExternaId;
	}
	/**
	 * @return the finalidadId
	 */
	public int getFinalidadId() {
		return finalidadId;
	}
	/**
	 * @param finalidadId the finalidadId to set
	 */
	public void setFinalidadId(int finalidadId) {
		this.finalidadId = finalidadId;
	}
	/**
	 * @return the municipioId
	 */
	public int getMunicipioId() {
		return municipioId;
	}
	/**
	 * @param municipioId the municipioId to set
	 */
	public void setMunicipioId(int municipioId) {
		this.municipioId = municipioId;
	}
	/**
	 * @return the profesionalId
	 */
	public int getProfesionalId() {
		return profesionalId;
	}
	/**
	 * @param profesionalId the profesionalId to set
	 */
	public void setProfesionalId(int profesionalId) {
		this.profesionalId = profesionalId;
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
	 * @return the fechaAtencion
	 */
	public Date getFechaAtencion() {
		return fechaAtencion;
	}
	/**
	 * @param fechaAtencion the fechaAtencion to set
	 */
	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	/**
	 * @return the tipoConsulta
	 */
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	/**
	 * @param tipoConsulta the tipoConsulta to set
	 */
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}	
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
