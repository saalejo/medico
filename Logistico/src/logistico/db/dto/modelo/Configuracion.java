package logistico.db.dto.modelo;

import historia.clinica.db.dto.modelo.Especialidad;

import java.io.Serializable;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_CONFIGURACION
 * @author Yedinzon Toro Gil
 * 
 */

public class Configuracion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String mensaje;
	int usuarioConectado;
	// Corresponde al codigo del modulo sistema
	ModuloSistema moduloSistema;
	int moduloSistemaId;
	// Corresponde al codigo de la especialidad 
	Especialidad especialidad;
	int especialidadId;
	

	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase ConfiguracionServicio.
	 *
	 */
	public Configuracion() {

	}
	
	public Configuracion(String mensaje, int usuarioConectado, int moduloSistemaId, int especialidadId) {
		super();
		this.mensaje = mensaje;
		this.usuarioConectado = usuarioConectado;
		this.moduloSistemaId = moduloSistemaId;
		this.especialidadId = especialidadId;
	}
	
	public Configuracion(int id, String mensaje, int usuarioConectado, int moduloSistemaId, int especialidadId) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.usuarioConectado = usuarioConectado;
		this.moduloSistemaId = moduloSistemaId;
		this.especialidadId = especialidadId;
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
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
	 * @return the moduloSistema
	 */
	public ModuloSistema getModuloSistema() {
		return moduloSistema;
	}
	/**
	 * @param moduloSistema the moduloSistema to set
	 */
	public void setModuloSistema(ModuloSistema moduloSistema) {
		this.moduloSistema = moduloSistema;
	}
	/**
	 * @return the moduloSistemaId
	 */
	public int getModuloSistemaId() {
		return moduloSistemaId;
	}
	/**
	 * @param moduloSistemaId the moduloSistemaId to set
	 */
	public void setModuloSistemaId(int moduloSistemaId) {
		this.moduloSistemaId = moduloSistemaId;
	}
	/**
	 * @return the especialidad
	 */
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	/**
	 * @return the especialidadId
	 */
	public int getEspecialidadId() {
		return especialidadId;
	}
	/**
	 * @param especialidadId the especialidadId to set
	 */
	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}
}