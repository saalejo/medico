package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad LO_MODULO_SISTEMA
 * @author Yedinzon Toro Gil
 * 
 */

public class ModuloSistema implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String descripcion;
	int usuarioConectado;
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase ModuloSistemaServicio.
	 *
	 */
	
	public ModuloSistema() {

	}
	
	public ModuloSistema(String descripcion, int usuarioConectado) {
		super();
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
	}
	
	public ModuloSistema(int id, String descripcion, int usuarioConectado) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
	}
	
	// Generaci�n de m�todos getters y setters para los atributos de la clase.	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the usuarioConectado
	 */
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	/**
	 * @param usuarioConectado the usuarioConectado to set
	 */
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
}