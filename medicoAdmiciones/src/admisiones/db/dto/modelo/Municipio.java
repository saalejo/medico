package admisiones.db.dto.modelo;

import java.io.Serializable;

public class Municipio implements Serializable {
	int id;
	String nombre;
	String codigo;
	String codigoDepartamento;
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
	/**
	 * @return the codigoMunicipio
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigoMunicipio the codigoMunicipio to set
	 */
	public void setCodigo(String codigoMunicipio) {
		this.codigo = codigoMunicipio;
	}
	/**
	 * @return the codigoDepartamento
	 */
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	/**
	 * @param codigoDepartamento the codigoDepartamento to set
	 */
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	

}
