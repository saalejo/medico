package logistico.db.dto.modelo;

import java.io.Serializable;

public class Protocolo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6029756362868820905L;
	
	int id;
	String nombre;
	String descripcion;
	Boolean tipo; 
	int usuarioConectado;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getTipo() {
		return tipo;
	}
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	} 	

}
