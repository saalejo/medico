package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_SEDE
 * @author Yedinzon Toro Gil
 * 
 */

public class Sede implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8975502198743379807L;
	
	int id;
	String nombre;
	String direccion;
	String telefono;
	String codigoHabilitacionIps;
	int usuarioConectado;
	// Corresponde al código de la compania.
	Compania compania;
	int companiaId;
	// Corresponde al código del departamento.
	Departamento departamento;
	int departamentoId;
	
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar y guardar de la clase SedeServicio.
	 *
	 */	
	public Sede() {
		
	}
	
	public Sede(String nombre, String direccion, String telefono,
			String codigoHabilitacionIps, int usuarioConectado, int companiaId,
			int departamentoId) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigoHabilitacionIps = codigoHabilitacionIps;
		this.usuarioConectado = usuarioConectado;
		this.companiaId = companiaId;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the codigoHabilitacionIps
	 */
	public String getCodigoHabilitacionIps() {
		return codigoHabilitacionIps;
	}
	/**
	 * @param codigoHabilitacionIps the codigoHabilitacionIps to set
	 */
	public void setCodigoHabilitacionIps(String codigoHabilitacionIps) {
		this.codigoHabilitacionIps = codigoHabilitacionIps;
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
	 * @return the compania
	 */
	public Compania getCompania() {
		return compania;
	}
	/**
	 * @param compania the compania to set
	 */
	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	/**
	 * @return the companiaId
	 */
	public int getCompaniaId() {
		return companiaId;
	}
	/**
	 * @param companiaId the companiaId to set
	 */
	public void setCompaniaId(int companiaId) {
		this.companiaId = companiaId;
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
}
