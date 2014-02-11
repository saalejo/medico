package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_MUNICIPIO
 * @author Yedinzon Toro Gil
 * 
 */

public class Municipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1687771289669940085L;
	
	int id;
	String descripcion;
	int usuarioConectado;
	// Corresponde al código del departamento.
	Departamento departamento;
	int departamentoId;
	
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase MunicipioServicio.
	 *
	 */
	public Municipio() {
		
	}
		
	public Municipio(String descripcion, int usuarioConectado,
			int departamentoId) {
		super();
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
		this.departamentoId = departamentoId;
	}
	
	public Municipio(int id, String descripcion, int usuarioConectado,
			int departamentoId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
		this.departamentoId = departamentoId;
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
	 * @return the departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	/**
	 * @return the departamentoId
	 */
	public int getDepartamentoId() {
		return departamentoId;
	}
	/**
	 * @param departamentoId the departamentoId to set
	 */
	public void setDepartamentoId(int departamentoId) {
		this.departamentoId = departamentoId;
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
