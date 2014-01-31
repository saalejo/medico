package logistico.db.dto.modelo;

import java.io.Serializable;

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
	Departamento departamento;
	int departamentoId;
	Municipio municipio;
	int municipioId;
	Zona zona;
	int zonaId;
	int usuarioConectado;
	
	public Compania() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compania(String nit, String direccion, String telefono,
			String codigoHabilitacionIps, String sloganIps, int departamentoId, int municipioId,
			int zonaId, int usuarioConectado) {
		super();
		this.nit = nit;
		this.direccion = direccion;
		this.telefono = telefono;
		this.codigoHabilitacionIps = codigoHabilitacionIps;
		this.sloganIps = sloganIps;
		this.departamentoId = departamentoId;
		this.municipioId = municipioId;
		this.zonaId = zonaId;
		this.usuarioConectado = usuarioConectado;
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
	 * @return the zonaId
	 */
	public int getZonaId() {
		return zonaId;
	}
	/**
	 * @param zonaId the zonaId to set
	 */
	public void setZonaId(int zonaId) {
		this.zonaId = zonaId;
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
	 * @return the zona
	 */
	public Zona getZona() {
		return zona;
	}
	/**
	 * @param zona the zona to set
	 */
	public void setZona(Zona zona) {
		this.zona = zona;
	}		

}
