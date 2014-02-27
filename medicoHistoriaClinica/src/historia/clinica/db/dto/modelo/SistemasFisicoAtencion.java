package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class SistemasFisicoAtencion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int id;
	String resultado;
	int atencionId;
	int sistemasFisicoId;
	int usuarioConectado;
	
	Atencion atencion;
	SistemasFisico sistemasFisico;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public int getAtencionId() {
		return atencionId;
	}
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	public int getSistemasFisicoId() {
		return sistemasFisicoId;
	}
	public void setSistemasFisicoId(int sistemasFisicoId) {
		this.sistemasFisicoId = sistemasFisicoId;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public Atencion getAtencion() {
		return atencion;
	}
	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}
	public SistemasFisico getSistemasFisico() {
		return sistemasFisico;
	}
	public void setSistemasFisico(SistemasFisico sistemasFisico) {
		this.sistemasFisico = sistemasFisico;
	}
	
	
	
}
