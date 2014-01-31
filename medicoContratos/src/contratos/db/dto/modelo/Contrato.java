package contratos.db.dto.modelo;

import java.io.Serializable;

public class Contrato implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3716475037800252906L;
	int id;
	String codigo;
	String descripcion;
	Regimen regimen;
	int usuarioConectado;
	int regimenId;
	
	
	public Contrato() {
		super();
	}
	public Contrato(String codigo, String descripcion,int regimenId,
			int usuarioConectado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.regimenId = regimenId;
		this.usuarioConectado = usuarioConectado;
	}
	
	/**
	 * @return the regimenId
	 */
	public int getRegimenId() {
		return regimenId;
	}
	/**
	 * @param regimenId the regimenId to set
	 */
	public void setRegimenId(int regimenId) {
		this.regimenId = regimenId;
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
	 * @return the regimen
	 */
	public Regimen getRegimen() {
		return regimen;
	}
	/**
	 * @param regimen the regimen to set
	 */
	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
