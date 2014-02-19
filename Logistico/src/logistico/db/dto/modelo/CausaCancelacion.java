package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_CAUSA_CANCELACION
 * @author Yedinzon Toro Gil
 * 
 */

public class CausaCancelacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1687771289569940085L;
	
	int id;
	String descripcion;
	int usuarioConectado;
	// Corresponde al codigo del modulo
	ModuloSistema moduloSistema;
	int moduloSistemaId;
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase CausaCancelacionServicio.
	 *
	 */
	
	public CausaCancelacion() {

	}
	

	public CausaCancelacion(String descripcion, int usuarioConectado, int moduloSistemaId) {
		super();
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
		this.moduloSistemaId = moduloSistemaId;
	}
	
	public CausaCancelacion(int id, String descripcion, int usuarioConectado, int moduloSistemaId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
		this.moduloSistemaId = moduloSistemaId;
	}
	
	
	// Generación de métodos getters y setters para los atributos de la clase.	
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
	
	/**
	 * @return the moduloSistema
	 */
	public ModuloSistema getModuloSistema() {
		return moduloSistema;
	}

	/**
	 * @param moduloSistema the moduloSistema to set
	 */
	public void setModuloSistema(ModuloSistema moduloSistema) {
		this.moduloSistema = moduloSistema;
	}

	/**
	 * @return the moduloSistemaId
	 */
	public int getModuloSistemaId() {
		return moduloSistemaId;
	}

	/**
	 * @param moduloSistemaId the moduloSistemaId to set
	 */
	public void setModuloSistemaId(int moduloSistemaId) {
		this.moduloSistemaId = moduloSistemaId;
	}

}