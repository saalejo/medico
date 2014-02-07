package logistico.db.dto.modelo;

import java.io.Serializable;

public class Protocolo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6029756362868820905L;
	
	int id;
	String nombre;
	String descripcion;
	Boolean tipo; 
	int usuarioConectado;
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar y guardar de la clase SedeServicio.
	 */	
	public Protocolo(){
		
	}
	
	public Protocolo(int id, String nombre, String descripcion, Boolean tipo,
			int usuarioConectado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.usuarioConectado = usuarioConectado;
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
	 * @return the tipo
	 */
	public Boolean getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
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
