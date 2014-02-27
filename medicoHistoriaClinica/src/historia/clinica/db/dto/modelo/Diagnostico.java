package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

public class Diagnostico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	String descripcion;
	Date  edadInicial;
	Date  edadFinal;
	Boolean sexo;
	Boolean altoCosto;
	int  protocoloId;
	int  especialidadId;
	int  usuarioConectado;
	
	Protocolo protocolo;
	Especialidad especialidad;
	
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
	public Date getEdadInicial() {
		return edadInicial;
	}
	public void setEdadInicial(Date edadInicial) {
		this.edadInicial = edadInicial;
	}
	public Date getEdadFinal() {
		return edadFinal;
	}
	public void setEdadFinal(Date edadFinal) {
		this.edadFinal = edadFinal;
	}
	public Boolean getSexo() {
		return sexo;
	}
	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}
	public Boolean getAltoCosto() {
		return altoCosto;
	}
	public void setAltoCosto(Boolean altoCosto) {
		this.altoCosto = altoCosto;
	}
	public int getProtocoloId() {
		return protocoloId;
	}
	public void setProtocoloId(int protocoloId) {
		this.protocoloId = protocoloId;
	}
	public int getEspecialidadId() {
		return especialidadId;
	}
	public void setEspecialidadId(int especialidadId) {
		this.especialidadId = especialidadId;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public Protocolo getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(Protocolo protocolo) {
		this.protocolo = protocolo;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
		
	
	

	
}
