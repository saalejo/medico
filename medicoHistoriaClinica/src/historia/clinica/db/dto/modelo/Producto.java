package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String codigoInterno;
	String codigoCum;
	String descripcion;
	String invima;
	Boolean plan;  //indica si es POS O NO POS 
	String presentacion;
	Double contenido;
	int    usuarioConectado;
	
	int grupoProductoId;
	int grupoSubgrupoProductoId;
	int productoGenericoId;
	int unidadMedidaId;
	
	GrupoProducto         grupoProducto;
	GrupoSubGrupoProducto grupoSubgrupoProducto;
	ProductoGenerico      ProductoGenericoId;
	UnidadMedida          unidadMedida;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoInterno() {
		return codigoInterno;
	}
	public void setCodigoInterno(String codigoInterno) {
		this.codigoInterno = codigoInterno;
	}
	public String getCodigoCum() {
		return codigoCum;
	}
	public void setCodigoCum(String codigoCum) {
		this.codigoCum = codigoCum;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getInvima() {
		return invima;
	}
	public void setInvima(String invima) {
		this.invima = invima;
	}
	public Boolean getPlan() {
		return plan;
	}
	public void setPlan(Boolean plan) {
		this.plan = plan;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public Double getContenido() {
		return contenido;
	}
	public void setContenido(Double contenido) {
		this.contenido = contenido;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public int getGrupoProdcutoId() {
		return grupoProdcutoId;
	}
	public void setGrupoProdcutoId(int grupoProdcutoId) {
		this.grupoProdcutoId = grupoProdcutoId;
	}
	public int getGrupoSubgrupoProductoId() {
		return grupoSubgrupoProductoId;
	}
	public void setGrupoSubgrupoProductoId(int grupoSubgrupoProductoId) {
		this.grupoSubgrupoProductoId = grupoSubgrupoProductoId;
	}
	public int getAnatoId() {
		return anatoId;
	}
	public void setAnatoId(int anatoId) {
		this.anatoId = anatoId;
	}
	public int getUnidadMedidaId() {
		return unidadMedidaId;
	}
	public void setUnidadMedidaId(int unidadMedidaId) {
		this.unidadMedidaId = unidadMedidaId;
	}
	public GrupoProducto getGrupoProducto() {
		return grupoProducto;
	}
	public void setGrupoProducto(GrupoProducto grupoProducto) {
		this.grupoProducto = grupoProducto;
	}
	public GrupoSubGrupoProducto getGrupoSubgrupoProducto() {
		return grupoSubgrupoProducto;
	}
	public void setGrupoSubgrupoProducto(GrupoSubGrupoProducto grupoSubgrupoProducto) {
		this.grupoSubgrupoProducto = grupoSubgrupoProducto;
	}
	public Anato getAnato() {
		return anato;
	}
	public void setAnato(Anato anato) {
		this.anato = anato;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
	

}
