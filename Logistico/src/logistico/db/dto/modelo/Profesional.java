package logistico.db.dto.modelo;

import java.io.Serializable;

public class Profesional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7013548757803348003L;

	int id;
	String identificacion;
	String nombre;
	String apellido;
	Boolean tipoProfesional;
	int usuarioConectado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Boolean getTipoProfesional() {
		return tipoProfesional;
	}
	public void setTipoProfesional(Boolean tipoProfesional) {
		this.tipoProfesional = tipoProfesional;
	}
	
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	
}
