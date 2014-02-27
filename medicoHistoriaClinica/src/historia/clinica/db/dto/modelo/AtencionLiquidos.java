package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

public class AtencionLiquidos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	int id;
	Double dosis;
	Double frecuencia;
	String observaciones;
	Boolean estado;
	Date fechaInicial;
	Date fechaFin;
	int usuarioConectado;
	int atencionId;
	int liquidosId;
	
	Atencion atencion;
	Liquidos liquidos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getDosis() {
		return dosis;
	}
	public void setDosis(Double dosis) {
		this.dosis = dosis;
	}
	public Double getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(Double frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public int getAtencionId() {
		return atencionId;
	}
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	public int getLiquidosId() {
		return liquidosId;
	}
	public void setLiquidosId(int liquidosId) {
		this.liquidosId = liquidosId;
	}
	public Atencion getAtencion() {
		return atencion;
	}
	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}
	public Liquidos getLiquidos() {
		return liquidos;
	}
	public void setLiquidos(Liquidos liquidos) {
		this.liquidos = liquidos;
	}
	
	
}
