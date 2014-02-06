package logistico.db.dto.modelo;

import java.io.Serializable;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad LO_COMPANIA
 * @author Yedinzon Toro Gil
 * 
 */

public class Compania implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3858417501493761846L;
	
	int id;
	String nit;
	String direccion;
	String telefono;
	String codigoHabilitacionIps;
	String sloganIps;
	int usuarioConectado;
	// Corresponde al c�digo del departamento.
	Departamento departamento;
	int departamentoId;	
	// Corresponde al c�digo del municipio.
	Municipio municipio;
	int municipioId;
	// Corresponde al c�digo del barrio.
	Barrio barrio;
	int barrioId;
	
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar y guardar de la clase CompaniaServicio.
	 *
	 */
	public Compania() {
		// TODO Auto-generated constructor stub
	}
	
	public Compania(String nit, String direccion, String telefono,
			String codigoHabilitacionIps, String sloganIps, int usuarioConectado, int departamentoId, int municipioId, int barrioId2) {
		// TODO Auto-generated constructor stub
	}
	

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
	 * @return the nit
	 */
	public String getNit() {
		return nit;
	}
	/**
	 * @param nit the nit to set
	 */
	public void setNit(String nit) {
		this.nit = nit;
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
	 * @return the sloganIps
	 */
	public String getSloganIps() {
		return sloganIps;
	}
	/**
	 * @param sloganIps the sloganIps to set
	 */
	public void setSloganIps(String sloganIps) {
		this.sloganIps = sloganIps;
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
	/**
	 * @return the barrio
	 */
	public Barrio getBarrio() {
		return barrio;
	}
	/**
	 * @param barrio the barrio to set
	 */
	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}
	/**
	 * @return the barrioId
	 */
	public int getBarrioId() {
		return barrioId;
	}
	/**
	 * @param barrioId the barrioId to set
	 */
	public void setBarrioId(int barrioId) {
		this.barrioId = barrioId;
	}	
}
