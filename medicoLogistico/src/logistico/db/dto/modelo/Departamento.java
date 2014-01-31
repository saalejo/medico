package logistico.db.dto.modelo;

import java.io.Serializable;

public class Departamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511298699104575038L;
	
	int id;
	String descripcion;
	int usuarioConectado;
	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Departamento(String descripcion, int usuarioConectado) {
		super();
		this.descripcion = descripcion;
		this.usuarioConectado = usuarioConectado;
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
	
	
	

}
