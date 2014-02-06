package admisiones.db.dto.modelo;

import java.io.Serializable;

import logistico.db.dto.modelo.Sede;

public class Pabellon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7412418101264256453L;	
	int id;
	Servicio servicio;
	Sede sede;
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
	 * @return the servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}
	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	/**
	 * @return the sede
	 */
	public Sede getSede() {
		return sede;
	}
	/**
	 * @param sede the sede to set
	 */
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	
	

}
