package logistico.db.dto.modelo;

import java.io.Serializable;

public class Zona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6471147463399313002L;
	
	int id;
	String descripcion;
	Municipio municipio;
	int municipioId;
	int usuarioConectado;
	
	public Zona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Zona(String descripcion, int municipioId,
			int usuarioConectado) {
		super();
		this.descripcion = descripcion;
		this.municipioId = municipioId;
		this.usuarioConectado = usuarioConectado;
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
	

}
