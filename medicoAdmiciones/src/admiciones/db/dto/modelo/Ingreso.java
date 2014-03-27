package admiciones.db.dto.modelo;

import java.io.Serializable;

public class Ingreso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6645765621873129978L;
	int id;
	int consecutivo;
	String responsableId;
	String responsableTipoDocumento;
	String responsableNombre;
	String responsableApellido;
	String responsableTelefono;
	String responsableDireccion;
	String responsableEmpresa;
	String responsableEmpresaTelefono;
	String responsableParentesco;
	int usuarioConectado;
	Paciente paciente;
	Servicio servicio;
	Ubicacion ubicacion;
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
	 * @return the consecutivo
	 */
	public int getConsecutivo() {
		return consecutivo;
	}
	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	/**
	 * @return the responsableId
	 */
	public String getResponsableId() {
		return responsableId;
	}
	/**
	 * @param responsableId the responsableId to set
	 */
	public void setResponsableId(String responsableId) {
		this.responsableId = responsableId;
	}
	/**
	 * @return the responsableTipoDocumento
	 */
	public String getResponsableTipoDocumento() {
		return responsableTipoDocumento;
	}
	/**
	 * @param responsableTipoDocumento the responsableTipoDocumento to set
	 */
	public void setResponsableTipoDocumento(String responsableTipoDocumento) {
		this.responsableTipoDocumento = responsableTipoDocumento;
	}
	/**
	 * @return the responsableNombre
	 */
	public String getResponsableNombre() {
		return responsableNombre;
	}
	/**
	 * @param responsableNombre the responsableNombre to set
	 */
	public void setResponsableNombre(String responsableNombre) {
		this.responsableNombre = responsableNombre;
	}
	/**
	 * @return the responsableApellido
	 */
	public String getResponsableApellido() {
		return responsableApellido;
	}
	/**
	 * @param responsableApellido the responsableApellido to set
	 */
	public void setResponsableApellido(String responsableApellido) {
		this.responsableApellido = responsableApellido;
	}
	/**
	 * @return the responsableTelefono
	 */
	public String getResponsableTelefono() {
		return responsableTelefono;
	}
	/**
	 * @param responsableTelefono the responsableTelefono to set
	 */
	public void setResponsableTelefono(String responsableTelefono) {
		this.responsableTelefono = responsableTelefono;
	}
	/**
	 * @return the responsableDireccion
	 */
	public String getResponsableDireccion() {
		return responsableDireccion;
	}
	/**
	 * @param responsableDireccion the responsableDireccion to set
	 */
	public void setResponsableDireccion(String responsableDireccion) {
		this.responsableDireccion = responsableDireccion;
	}
	/**
	 * @return the responsableEmpresa
	 */
	public String getResponsableEmpresa() {
		return responsableEmpresa;
	}
	/**
	 * @param responsableEmpresa the responsableEmpresa to set
	 */
	public void setResponsableEmpresa(String responsableEmpresa) {
		this.responsableEmpresa = responsableEmpresa;
	}
	/**
	 * @return the responsableEmpresaTelefono
	 */
	public String getResponsableEmpresaTelefono() {
		return responsableEmpresaTelefono;
	}
	/**
	 * @param responsableEmpresaTelefono the responsableEmpresaTelefono to set
	 */
	public void setResponsableEmpresaTelefono(String responsableEmpresaTelefono) {
		this.responsableEmpresaTelefono = responsableEmpresaTelefono;
	}
	/**
	 * @return the responsableParentesco
	 */
	public String getResponsableParentesco() {
		return responsableParentesco;
	}
	/**
	 * @param responsableParentesco the responsableParentesco to set
	 */
	public void setResponsableParentesco(String responsableParentesco) {
		this.responsableParentesco = responsableParentesco;
	}
	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}
	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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
	 * @return the ubicacion
	 */
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
}
