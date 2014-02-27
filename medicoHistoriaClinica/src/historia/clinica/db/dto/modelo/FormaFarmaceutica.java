package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class FormaFarmaceutica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String descripcion;
	int usuarioConectado;
	int viaAplicacionId;
	
	ViaAplicacion viaAplicacion;

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

	public int getUsuarioConectado() {
		return usuarioConectado;
	}

	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}

	public int getViaAplicacionId() {
		return viaAplicacionId;
	}

	public void setViaAplicacionId(int viaAplicacionId) {
		this.viaAplicacionId = viaAplicacionId;
	}

	public ViaAplicacion getViaAplicacion() {
		return viaAplicacion;
	}

	public void setViaAplicacion(ViaAplicacion viaAplicacion) {
		this.viaAplicacion = viaAplicacion;
	}
	
	
	
}
