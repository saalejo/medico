package agenda.db.dto.modelo;

import java.util.Date;

public class Cita {
	int id;
	int pacienteId;
	int turnoId;
	int usuarioLogueado;
	Date hora;
	
	
	
	public int getTurnoId() {
		return turnoId;
	}
	public void setTurnoId(int turnoId) {
		this.turnoId = turnoId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
	public int getUsuarioLogueado() {
		return usuarioLogueado;
	}
	public void setUsuarioLogueado(int usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}
	
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}	
	
}
