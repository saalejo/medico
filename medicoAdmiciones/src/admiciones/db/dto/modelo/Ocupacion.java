package admiciones.db.dto.modelo;

import java.io.Serializable;

public class Ocupacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2743130036578223754L;
	int id;
	String nombre;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
