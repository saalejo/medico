package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class PrincipioActivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String codigoCorto;
	String codigoLargo;
	String descripcion;
	int usuarioConectado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoCorto() {
		return codigoCorto;
	}
	public void setCodigoCorto(String codigoCorto) {
		this.codigoCorto = codigoCorto;
	}
	public String getCodigoLargo() {
		return codigoLargo;
	}
	public void setCodigoLargo(String codigoLargo) {
		this.codigoLargo = codigoLargo;
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
	
	
}
