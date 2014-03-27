package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class GrupoProducto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String descripcion;
	int usuarioConectado;
	int grupoSubgrupoProductoId;
	
	
	GrupoSubGrupoProducto grupoSubgrupoProducto;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getUsuarioConectado() {
		return usuarioConectado;
	}


	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}


	public int getGrupoSubgrupoProductoId() {
		return grupoSubgrupoProductoId;
	}


	public void setGrupoSubgrupoProductoId(int grupoSubgrupoProductoId) {
		this.grupoSubgrupoProductoId = grupoSubgrupoProductoId;
	}


	public GrupoSubGrupoProducto getGrupoSubgrupoProducto() {
		return grupoSubgrupoProducto;
	}


	public void setGrupoSubgrupoProducto(GrupoSubGrupoProducto grupoSubgrupoProducto) {
		this.grupoSubgrupoProducto = grupoSubgrupoProducto;
	}
	
	
	
	}
