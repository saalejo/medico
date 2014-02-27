package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

public class AtencionProducto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	int id;
	Double dosis;
	Double tiempo;
	Double cantidad;
	String observacion;
	Boolean urgente;
	Date  fechaProgramacion;
	int estado;
	int usuarioConectado;
	
	
	Producto producto;
	Atencion atencion;
	Frecuencia frecuencia;
	ViaAplicacion  viaAplicacion;
	UnidadMedida   unidadMedida;
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
	public Double getTiempo() {
		return tiempo;
	}
	public void setTiempo(Double tiempo) {
		this.tiempo = tiempo;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Boolean getUrgente() {
		return urgente;
	}
	public void setUrgente(Boolean urgente) {
		this.urgente = urgente;
	}
	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}
	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Atencion getAtencion() {
		return atencion;
	}
	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}
	public Frecuencia getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(Frecuencia frecuencia) {
		this.frecuencia = frecuencia;
	}
	public ViaAplicacion getViaAplicacion() {
		return viaAplicacion;
	}
	public void setViaAplicacion(ViaAplicacion viaAplicacion) {
		this.viaAplicacion = viaAplicacion;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

		
	
	
	
	
}
