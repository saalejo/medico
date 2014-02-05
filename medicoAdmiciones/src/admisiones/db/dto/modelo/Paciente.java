package admisiones.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Paciente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String identificacion;
	String tipoDocumento;
	String primerNombre;
	String segundoNombre;
	String primerApellido;
	String segundoApellido;
	Date fechaNacimiento;
	String genero;
	String zona;	
	String primerTelefono;
	String segundoTelefono;
	String direccion;
	String mail;
	String observaciones;
	String estadoCivil;
	String lugarNacimiento;
	String tipoUsuario;
	String atencionEspecial;
	String empresaLabora;
	String telefonoEmpresaLabora;
	String nivelEducativo;
	String barrio;
	String grupoPoblacional;
	//----------------------	
	Ocupacion ocupacion;
	Municipio municipio;	
	Set<Ingreso> ingresos;
	//--------------------
	int municipioId;
	int entidadId;
	int ocupacionId;
	
	
	
	
	
	
	
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
	 * @return the entidadId
	 */
	public int getEntidadId() {
		return entidadId;
	}
	/**
	 * @param entidadId the entidadId to set
	 */
	public void setEntidadId(int entidadId) {
		this.entidadId = entidadId;
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
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}
	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	/**
	 * @return the tipo_documento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param tipo_documento the tipo_documento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * @return the primer_nombre
	 */
	public String getPrimerNombre() {
		return primerNombre;
	}
	/**
	 * @param primer_nombre the primer_nombre to set
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	/**
	 * @return the segundo_nombre
	 */
	public String getSegundoNombre() {
		return segundoNombre;
	}
	/**
	 * @param segundo_nombre the segundo_nombre to set
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	/**
	 * @return the primer_apellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}
	/**
	 * @param primer_apellido the primer_apellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	/**
	 * @return the segundo_apellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}
	/**
	 * @param segundo_apellido the segundo_apellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	/**
	 * @return the fecha_nacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fecha_nacimiento the fecha_nacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}
	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
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
	 * @return the primerTelefono
	 */
	public String getPrimerTelefono() {
		return primerTelefono;
	}
	/**
	 * @param primerTelefono the primerTelefono to set
	 */
	public void setPrimerTelefono(String primerTelefono) {
		this.primerTelefono = primerTelefono;
	}
	/**
	 * @return the segundoTelefono
	 */
	public String getSegundoTelefono() {
		return segundoTelefono;
	}
	/**
	 * @param segundoTelefono the segundoTelefono to set
	 */
	public void setSegundoTelefono(String segundoTelefono) {
		this.segundoTelefono = segundoTelefono;
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
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the estadoCivil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}
	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil= estadoCivil;
	}
	/**
	 * @return the lugarNacimiento
	 */
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}
	/**
	 * @param lugarNacimiento the lugarNacimiento to set
	 */
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}	
	/**
	 * @return the tipoUsuario
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	/**
	 * @return the atencionEspecial
	 */
	public String getAtencionEspecial() {
		return atencionEspecial;
	}
	/**
	 * @param atencionEspecial the atencionEspecial to set
	 */
	public void setAtencionEspecial(String atencionEspecial) {
		this.atencionEspecial = atencionEspecial;
	}
	/**
	 * @return the empresaLabora
	 */
	public String getEmpresaLabora() {
		return empresaLabora;
	}
	/**
	 * @param empresaLabora the empresaLabora to set
	 */
	public void setEmpresaLabora(String empresaLabora) {
		this.empresaLabora = empresaLabora;
	}
	/**
	 * @return the telefonoEmpresaLabora
	 */
	public String getTelefonoEmpresaLabora() {
		return telefonoEmpresaLabora;
	}
	/**
	 * @param telefonoEmpresaLabora the telefonoEmpresaLabora to set
	 */
	public void setTelefonoEmpresaLabora(String telefonoEmpresaLabora) {
		this.telefonoEmpresaLabora = telefonoEmpresaLabora;
	}
	/**
	 * @return the nivelEducativo
	 */
	public String getNivelEducativo() {
		return nivelEducativo;
	}
	/**
	 * @param nivelEducativo the nivelEducativo to set
	 */
	public void setNivelEducativo(String nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}
	/**
	 * @return the barrio
	 */
	public String getBarrio() {
		return barrio;
	}
	/**
	 * @param barrio the barrio to set
	 */
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	
	/**
	 * @return the ocupacion
	 */
	public Ocupacion getOcupacion() {
		return ocupacion;
	}
	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}
	/**
	 * @return the ingresos
	 */
	public Set<Ingreso> getIngresos() {
		return ingresos;
	}
	/**
	 * @param ingresos the ingresos to set
	 */
	public void setIngresos(Set<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	/**
	 * @return the ocupacionId
	 */
	public int getOcupacionId() {
		return ocupacionId;
	}
	/**
	 * @param ocupacionId the ocupacionId to set
	 */
	public void setOcupacionId(int ocupacionId) {
		this.ocupacionId = ocupacionId;
	}

	
	
}
