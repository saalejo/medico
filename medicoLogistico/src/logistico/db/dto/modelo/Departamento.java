package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad LO_DEPARTAMENTO
 * @author Yedinzon Toro Gil
 * 
 */

public class Departamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511298699104575038L;
	
	int id;
	String descripcion;
	int usuarioConectado;
	
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
