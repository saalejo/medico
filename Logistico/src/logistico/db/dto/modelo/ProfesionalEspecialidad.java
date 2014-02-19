package logistico.db.dto.modelo;

import historia.clinica.db.dto.modelo.Especialidad;
import java.io.Serializable;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_PROFESIONAL_ESPECIALIDAD
 * @author Yedinzon Toro Gil
 * 
 */

public class ProfesionalEspecialidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6402006175524959568L;

	int id;
	String registroMedico;
	int usuarioConectado;	
	// Corresponde al código del profesional.
	Profesional profesional;
	int profesionalId;
	// Corresponde al código de la especialidad.
	Especialidad especialidad;
	int especialidadId;
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase MunicipioServicio.
	 *
	 */
	public ProfesionalEspecialidad() {
		
	}
	
	public ProfesionalEspecialidad(String registroMedico, int usuarioConectado, int profesionalId, int especialidadId) {
		super();
		this.registroMedico = registroMedico;
		this.usuarioConectado = usuarioConectado;
		this.profesionalId = profesionalId;
		this.especialidadId = especialidadId;
	}
	
	public ProfesionalEspecialidad(int id, String registroMedico, int usuarioConectado, int profesionalId, int especialidadId) {
		super();
		this.id = id;
		this.registroMedico = registroMedico;
		this.usuarioConectado = usuarioConectado;
		this.profesionalId = profesionalId;
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
	 * @return the profesional
	 */
	public Profesional getProfesional() {
		return profesional;
	}
	

	/**
	 * @param profesional the profesional to set
	 */
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
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
	 * @return the registroMedico
	 */
	public String getRegistroMedico() {
		return registroMedico;
	}
	/**
	 * @param registroMedico the registroMedico to set
	 */
	public void setRegistroMedico(String registroMedico) {
		this.registroMedico = registroMedico;
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
	 * @return the profesionalId
	 */
	public int getProfesionalId() {
		return profesionalId;
	}
	/**
	 * @param profesionalId the profesionalId to set
	 */
	public void setProfesionalId(int profesionalId) {
		this.profesionalId = profesionalId;
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
