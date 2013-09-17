package historia.clinica.db.dto.modelo;

import admisiones.db.dto.modelo.MedicamentoMaestro;

public class Medicamento {
	int id;
	int formulaId;
	int medicamentoMaestroId;
	String cantidad;
	String posologia;
	MedicamentoMaestro medicamentoMaestro;
	boolean esPost;
	String justificacion;
	String aspectosAdversos;
	String razones;
	boolean existeRiesgo;
	String observaciones;
	String impactoDelMedicamentoEnLaEnfermedad;
	int grupoId;
	int laboratorioId;
	
	
	
	
	/**
	 * @return the medicamentoMaestroId
	 */
	public int getMedicamentoMaestroId() {
		return medicamentoMaestroId;
	}
	/**
	 * @param medicamentoMaestroId the medicamentoMaestroId to set
	 */
	public void setMedicamentoMaestroId(int medicamentoMaestroId) {
		this.medicamentoMaestroId = medicamentoMaestroId;
	}
	/**
	 * @param medicamentoMaestro the medicamentoMaestro to set
	 */
	public void setMedicamentoMaestro(MedicamentoMaestro medicamentoMaestro) {
		this.medicamentoMaestro = medicamentoMaestro;
	}
	/**
	 * @return the esPost
	 */
	public boolean isEsPost() {
		return esPost;
	}
	/**
	 * @param esPost the esPost to set
	 */
	public void setEsPost(boolean esPost) {
		this.esPost = esPost;
	}
	/**
	 * @return the justificacion
	 */
	public String getJustificacion() {
		return justificacion;
	}
	/**
	 * @param justificacion the justificacion to set
	 */
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	/**
	 * @return the aspectosAdversos
	 */
	public String getAspectosAdversos() {
		return aspectosAdversos;
	}
	/**
	 * @param aspectosAdversos the aspectosAdversos to set
	 */
	public void setAspectosAdversos(String aspectosAdversos) {
		this.aspectosAdversos = aspectosAdversos;
	}
	/**
	 * @return the razones
	 */
	public String getRazones() {
		return razones;
	}
	/**
	 * @param razones the razones to set
	 */
	public void setRazones(String razones) {
		this.razones = razones;
	}
	/**
	 * @return the existeRiesgo
	 */
	public boolean isExisteRiesgo() {
		return existeRiesgo;
	}
	/**
	 * @param existeRiesgo the existeRiesgo to set
	 */
	public void setExisteRiesgo(boolean existeRiesgo) {
		this.existeRiesgo = existeRiesgo;
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
	/**
	 * @return the impactoDelMedicamentoEnLaEnfermedad
	 */
	public String getImpactoDelMedicamentoEnLaEnfermedad() {
		return impactoDelMedicamentoEnLaEnfermedad;
	}
	/**
	 * @param impactoDelMedicamentoEnLaEnfermedad the impactoDelMedicamentoEnLaEnfermedad to set
	 */
	public void setImpactoDelMedicamentoEnLaEnfermedad(
			String impactoDelMedicamentoEnLaEnfermedad) {
		this.impactoDelMedicamentoEnLaEnfermedad = impactoDelMedicamentoEnLaEnfermedad;
	}
	/**
	 * @return the grupoId
	 */
	public int getGrupoId() {
		return grupoId;
	}
	/**
	 * @param grupoId the grupoId to set
	 */
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}
	/**
	 * @return the laboratorioId
	 */
	public int getLaboratorioId() {
		return laboratorioId;
	}
	/**
	 * @param laboratorioId the laboratorioId to set
	 */
	public void setLaboratorioId(int laboratorioId) {
		this.laboratorioId = laboratorioId;
	}
	/**
	 * @return the medicamento
	 */
	public MedicamentoMaestro getMedicamentoMaestro() {
		return medicamentoMaestro;
	}
	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(MedicamentoMaestro medicamentoMaestro) {
		this.medicamentoMaestro = medicamentoMaestro;
	}
	/**
	 * @return the cantidad
	 */
	public String getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
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
	 * @return the formulaId
	 */
	public int getFormulaId() {
		return formulaId;
	}
	/**
	 * @param formulaId the formulaId to set
	 */
	public void setFormulaId(int formulaId) {
		this.formulaId = formulaId;
	}
	
	
	/**
	 * @return the posologia
	 */
	public String getPosologia() {
		return posologia;
	}
	/**
	 * @param posologia the posologia to set
	 */
	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	
	

}
