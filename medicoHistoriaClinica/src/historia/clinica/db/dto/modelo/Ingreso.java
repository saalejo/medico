package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

public class Ingreso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String estado;
	Date fecha;
	int pacienteId;
	String usuarioConectado;
	String observaciones;
	int tipoIngresoId;
	int areaServicioId;
	int causaIngresoId;
	Date fechaAccidente;
	int contratoId;
	int centroAtencionId;
	String acudiente;
	String autorizacion;
	String acompanante;
	String parentezco;
	String telefonoAcompanante;
	
	
	

	/**
	 * @return the acompanante
	 */
	public String getAcompanante() {
		return acompanante;
	}
	/**
	 * @param acompanante the acompanante to set
	 */
	public void setAcompanante(String acompanante) {
		this.acompanante = acompanante;
	}
	/**
	 * @return the parentezco
	 */
	public String getParentezco() {
		return parentezco;
	}
	/**
	 * @param parentezco the parentezco to set
	 */
	public void setParentezco(String parentezco) {
		this.parentezco = parentezco;
	}
	/**
	 * @return the telefonoAcompanante
	 */
	public String getTelefonoAcompanante() {
		return telefonoAcompanante;
	}
	/**
	 * @param telefonoAcompanante the telefonoAcompanante to set
	 */
	public void setTelefonoAcompanante(String telefonoAcompanante) {
		this.telefonoAcompanante = telefonoAcompanante;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @return the autorizacion
	 */
	public String getAutorizacion() {
		return autorizacion;
	}
	/**
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(String autorizacion) {
		this.autorizacion = autorizacion;
	}
	/**
	 * @return the tipoIngresoId
	 */
	public int getTipoIngresoId() {
		return tipoIngresoId;
	}
	/**
	 * @param tipoIngresoId the tipoIngresoId to set
	 */
	public void setTipoIngresoId(int tipoIngresoId) {
		this.tipoIngresoId = tipoIngresoId;
	}
	/**
	 * @return the areaServicioId
	 */
	public int getAreaServicioId() {
		return areaServicioId;
	}
	/**
	 * @param areaServicioId the areaServicioId to set
	 */
	public void setAreaServicioId(int areaServicioId) {
		this.areaServicioId = areaServicioId;
	}
	/**
	 * @return the causaIngresoId
	 */
	public int getCausaIngresoId() {
		return causaIngresoId;
	}
	/**
	 * @param causaIngresoId the causaIngresoId to set
	 */
	public void setCausaIngresoId(int causaIngresoId) {
		this.causaIngresoId = causaIngresoId;
	}
	/**
	 * @return the fechaAccidente
	 */
	public Date getFechaAccidente() {
		return fechaAccidente;
	}
	/**
	 * @param fechaAccidente the fechaAccidente to set
	 */
	public void setFechaAccidente(Date fechaAccidente) {
		this.fechaAccidente = fechaAccidente;
	}
	/**
	 * @return the contratoId
	 */
	public int getContratoId() {
		return contratoId;
	}
	/**
	 * @param contratoId the contratoId to set
	 */
	public void setContratoId(int contratoId) {
		this.contratoId = contratoId;
	}
	/**
	 * @return the centroAtencionId
	 */
	public int getCentroAtencionId() {
		return centroAtencionId;
	}
	/**
	 * @param centroAtencionId the centroAtencionId to set
	 */
	public void setCentroAtencionId(int centroAtencionId) {
		this.centroAtencionId = centroAtencionId;
	}
	/**
	 * @return the acudiente
	 */
	public String getAcudiente() {
		return acudiente;
	}
	/**
	 * @param acudiente the acudiente to set
	 */
	public void setAcudiente(String acudiente) {
		this.acudiente = acudiente;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
