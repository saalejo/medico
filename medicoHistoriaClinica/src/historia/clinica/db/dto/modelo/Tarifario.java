package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class Tarifario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2552038785052457229L;

	int id;
	String descripcion;
	int usuarioConectado;
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
	
	
	
}
