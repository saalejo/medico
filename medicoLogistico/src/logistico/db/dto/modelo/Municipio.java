package logistico.db.dto.modelo;

import java.io.Serializable;

public class Municipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1687771289669940085L;
	
	int id;
	String descripcion;
	Departamento departamento;
	int departamentoId;
	int usuarioConectado;
	
	
	public Municipio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Municipio(String descripcion, int departamentoId, int usuarioConectado) {
		super();
		this.descripcion = descripcion;
		this.departamentoId = departamentoId;
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
	
}
