package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class UnidadMedida implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String abreviatura;
	String descripcion;
	int usuarioConectado;
	int tipoUnidadMedidaID;
	
	TipoUnidadMedida tipoUnidadMedida;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getUsuarioConectado() {
		return usuarioConectado;
	}

	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}

	public int getTipoUnidadMedidaID() {
		return tipoUnidadMedidaID;
	}

	public void setTipoUnidadMedidaID(int tipoUnidadMedidaID) {
		this.tipoUnidadMedidaID = tipoUnidadMedidaID;
	}

	public TipoUnidadMedida getTipoUnidadMedida() {
		return tipoUnidadMedida;
	}

	public void setTipoUnidadMedida(TipoUnidadMedida tipoUnidadMedida) {
		this.tipoUnidadMedida = tipoUnidadMedida;
	}
	

	
}
