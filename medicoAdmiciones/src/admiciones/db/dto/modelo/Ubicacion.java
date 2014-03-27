package admiciones.db.dto.modelo;

import java.io.Serializable;

public class Ubicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1584040242542511327L;
	int id;
	String descripcion;
	Pabellon pabellon;
	/**
	 * @return the id
	 */
	public int getId(){
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
	 * @return the pabellon
	 */
	public Pabellon getPabellon() {
		return pabellon;
	}
	/**
	 * @param pabellon the pabellon to set
	 */
	public void setPabellon(Pabellon pabellon) {
		this.pabellon = pabellon;
	}
	

}
