package agenda.db.dto.modelo;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

public class Configuracion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
    Boolean sabado;
    Boolean domingo;
    Boolean festivo;
    String mensaje1;
    String mensaje2;
    Date horaInicial;
    Date horaFinal;
	String usuarioConectado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getSabado() {
		return sabado;
	}
	public void setSabado(Boolean sabado) {
		this.sabado = sabado;
	}
	public Boolean getDomingo() {
		return domingo;
	}
	public void setDomingo(Boolean domingo) {
		this.domingo = domingo;
	}
	public Boolean getFestivo() {
		return festivo;
	}
	public void setFestivo(Boolean festivo) {
		this.festivo = festivo;
	}
	public String getMensaje1() {
		return mensaje1;
	}
	public void setMensaje1(String mensaje1) {
		this.mensaje1 = mensaje1;
	}
	public String getMensaje2() {
		return mensaje2;
	}
	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
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
	public String getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(String usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	
	
	
}