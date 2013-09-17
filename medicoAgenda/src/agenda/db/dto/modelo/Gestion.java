package agenda.db.dto.modelo;


import java.io.Serializable;
import java.util.Set;

import admisiones.db.dto.modelo.Especialidad;

public class Gestion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	Especialidad especialidad;
	int numero;
	int intervalo;
	String usuarioConectado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	public String getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(String usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	
	
	
	
	
	
	
	
	
}
