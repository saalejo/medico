package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_CONSULTORIO
 * @author Yedinzon Toro Gil
 * 
 */

public class Consultorio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1687771289689940085L;
	
	int id;
	String descripcion;
	int usuarioConectado;
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase ConsultorioServicio.
	 *
	 */
	public Consultorio() {
		
	}
	
	public Consultorio(String descripcion, int usuarioConectado) {
		super();
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
	}
	
	public Consultorio(int id, String descripcion, int usuarioConectado) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
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
	
	
}