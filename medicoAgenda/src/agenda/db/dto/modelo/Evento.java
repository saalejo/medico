package agenda.db.dto.modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Evento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	Date fecha;
	Date horaInicial;
    Date horaFinal;
    String motivo;
    Boolean todosDias;
	String usuarioConectado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}
	public Date getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Boolean getTodosDias() {
		return todosDias;
	}
	public void setTodosDias(Boolean todosDias) {
		this.todosDias = todosDias;
	}
	public String getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(String usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	
	
	
	
	
	
	
}