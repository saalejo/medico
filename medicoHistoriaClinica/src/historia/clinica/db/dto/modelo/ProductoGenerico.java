package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class ProductoGenerico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String descripcion;
	String observaciones;
	String codigoAtc;
	String codigoRips;
	Boolean medicamentoControl;
	int usuarioConectado;
	
	int anatoId;
	int principioActivoId;
	int formaFarmaceuticaId;
	int concentracionId;
	int unidadMedidaId;
	
	Anato anato;
	PrincipioActivo principioActivo;
	FormaFarmaceutica formaFarmaceutica;
	Concentracion concentracion;
	UnidadMedida unidadMedida;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getCodigoAtc() {
		return codigoAtc;
	}
	public void setCodigoAtc(String codigoAtc) {
		this.codigoAtc = codigoAtc;
	}
	public String getCodigoRips() {
		return codigoRips;
	}
	public void setCodigoRips(String codigoRips) {
		this.codigoRips = codigoRips;
	}
	public Boolean getMedicamentoControl() {
		return medicamentoControl;
	}
	public void setMedicamentoControl(Boolean medicamentoControl) {
		this.medicamentoControl = medicamentoControl;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public int getAnatoId() {
		return anatoId;
	}
	public void setAnatoId(int anatoId) {
		this.anatoId = anatoId;
	}
	public int getPrincipioActivoId() {
		return principioActivoId;
	}
	public void setPrincipioActivoId(int principioActivoId) {
		this.principioActivoId = principioActivoId;
	}
	public int getFormaFarmaceuticaId() {
		return formaFarmaceuticaId;
	}
	public void setFormaFarmaceuticaId(int formaFarmaceuticaId) {
		this.formaFarmaceuticaId = formaFarmaceuticaId;
	}
	public int getConcentracionId() {
		return concentracionId;
	}
	public void setConcentracionId(int concentracionId) {
		this.concentracionId = concentracionId;
	}
	public int getUnidadMedidaId() {
		return unidadMedidaId;
	}
	public void setUnidadMedidaId(int unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}
	public Anato getAnato() {
		return anato;
	}
	public void setAnato(Anato anato) {
		this.anato = anato;
	}
	public PrincipioActivo getPrincipioActivo() {
		return principioActivo;
	}
	public void setPrincipioActivo(PrincipioActivo principioActivo) {
		this.principioActivo = principioActivo;
	}
	public FormaFarmaceutica getFormaFarmaceutica() {
		return formaFarmaceutica;
	}
	public void setFormaFarmaceutica(FormaFarmaceutica formaFarmaceutica) {
		this.formaFarmaceutica = formaFarmaceutica;
	}
	public Concentracion getConcentracion() {
		return concentracion;
	}
	public void setConcentracion(Concentracion concentracion) {
		this.concentracion = concentracion;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
	
	
}
