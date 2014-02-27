package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class Anato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String descripcion;
	String codigoNivel2;
	String descripcionNivel2;
	String codigoNivel3;
	String descripcionNivel3;
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
	public String getCodigoNivel2() {
		return codigoNivel2;
	}
	public void setCodigoNivel2(String codigoNivel2) {
		this.codigoNivel2 = codigoNivel2;
	}
	public String getDescripcionNivel2() {
		return descripcionNivel2;
	}
	public void setDescripcionNivel2(String descripcionNivel2) {
		this.descripcionNivel2 = descripcionNivel2;
	}
	public String getCodigoNivel3() {
		return codigoNivel3;
	}
	public void setCodigoNivel3(String codigoNivel3) {
		this.codigoNivel3 = codigoNivel3;
	}
	public String getDescripcionNivel3() {
		return descripcionNivel3;
	}
	public void setDescripcionNivel3(String descripcionNivel3) {
		this.descripcionNivel3 = descripcionNivel3;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	
	
}
