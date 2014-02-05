package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class Procedimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 790225010552224721L;
	
	int id;
	String codigo;
	String descripcion;
	String tipo;
	String plan;
	String edadInicial;
	String edadFinal;
	String sexo;
	String telefono;
	Boolean deLey; //Atributo que indica si el procedimiento es de ley y tiene por lo tanto manual tarifario
	int usuarioConectado;  
	Protocolo protocolo;
	int protocoloId;
	
	public int getProtocoloId() {
		return protocoloId;
	}
	public void setProtocoloId(int protocoloId) {
		this.protocoloId = protocoloId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getEdadInicial() {
		return edadInicial;
	}
	public void setEdadInicial(String edadInicial) {
		this.edadInicial = edadInicial;
	}
	public String getEdadFinal() {
		return edadFinal;
	}
	public void setEdadFinal(String edadFinal) {
		this.edadFinal = edadFinal;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Boolean getDeLey() {
		return deLey;
	}
	public void setDeLey(Boolean deLey) {
		this.deLey = deLey;
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
	
	
	
	
	
	

}
