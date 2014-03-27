package logistico.db.dto.modelo;

import java.io.Serializable;

public class Profesional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7013548757803348003L;

	int id;
	String identificacion;
	String usario;
	String clave;
	String nombre;
	String apellido;
	Boolean tipoProfesional;
	int usuarioConectado;
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase ProfecionalServicio.
	 */
	
	public  Profesional() {
			
	}
		
	public Profesional(String identificacion, String nombre,
		String apellido, Boolean tipoProfesional, int usuarioConectado) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoProfesional = tipoProfesional;
		this.usuarioConectado = usuarioConectado;
	}
	
	public Profesional(int id, String identificacion, String nombre,
			String apellido, Boolean tipoProfesional, int usuarioConectado) {
			this.id = id;
			this.identificacion = identificacion;
			this.nombre = nombre;
			this.apellido = apellido;
			this.tipoProfesional = tipoProfesional;
			this.usuarioConectado = usuarioConectado;
	}
	
	//Generación de Getters y Setters 
	
	
	
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
	 * @return the usario
	 */
	public String getUsario() {
		return usario;
	}

	/**
	 * @param usario the usario to set
	 */
	public void setUsario(String usario) {
		this.usario = usario;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * @return the tipoProfesional
	 */
	public Boolean getTipoProfesional() {
		return tipoProfesional;
	}
	/**
	 * @param tipoProfesional the tipoProfesional to set
	 */
	public void setTipoProfesional(Boolean tipoProfesional) {
		this.tipoProfesional = tipoProfesional;
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
