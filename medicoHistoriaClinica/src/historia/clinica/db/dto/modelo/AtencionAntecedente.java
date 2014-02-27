package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class AtencionAntecedente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	int atencionId;
	int antecedenteId;
	int usuarioConectado;
	
	Atencion atencion;
	Antecedente antecedente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAtencionId() {
		return atencionId;
	}
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	public int getAntecedenteId() {
		return antecedenteId;
	}
	public void setAntecedenteId(int antecedenteId) {
		this.antecedenteId = antecedenteId;
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
	public Antecedente getAntecedente() {
		return antecedente;
	}
	public void setAntecedente(Antecedente antecedente) {
		this.antecedente = antecedente;
	}
	
	
	

}
