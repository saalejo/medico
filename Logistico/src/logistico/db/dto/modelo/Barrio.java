package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_BARRIO
 * @author Yedinzon Toro Gil
 * 
 */

public class Barrio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6471147463399313002L;
	
	int id;
	String descripcion;
	int usuarioConectado;
	// Corresponde al código del municipio.
	Municipio municipio;
	int municipioId;
	
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar y guardar de la clase BarrioServicio.
	 *
	 */
	public Barrio() {
		// TODO Auto-generated constructor stub
	}
	
	public Barrio(String descripcion, int usuarioConectado, int municipioId) {
		super();
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
		this.municipioId = municipioId;
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
	 * @return the municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the municipioId
	 */
	public int getMunicipioId() {
		return municipioId;
	}
	/**
	 * @param municipioId the municipioId to set
	 */
	public void setMunicipioId(int municipioId) {
		this.municipioId = municipioId;
	}
}
