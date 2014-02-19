package logistico.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad LO_HORARIO
 * @author Yedinzon Toro Gil
 * 
 */

public class Horario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1687771279669940085L;

	int id;
	Date horaInicial;
	Date horaFinal;
	String dia;
	Boolean activo;
	int usuarioConectado;
	
	/*
	 * Creacion del constructor para los atributos que seran recibidos como 
	 * parametros por los metodos borrar, guardar y actualizar de la clase HorarioServicio.
	 *
	 */
	
	public Horario() {
		
	}
	
	public Horario(Date horaInicial, Date horaFinal, String dia,
			Boolean activo, int usuarioConectado) {
		super();
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.dia = dia;
		this.activo = activo;
		this.usuarioConectado = usuarioConectado;
	}
	
	public Horario(int id, Date horaInicial, Date horaFinal, String dia,
			Boolean activo, int usuarioConectado) {
		super();
		this.id = id;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.dia = dia;
		this.activo = activo;
		this.usuarioConectado = usuarioConectado;
	}
	
	// Generación de métodos getters y setters para los atributos de la clase.
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
	 * @return the horaInicial
	 */
	public Date getHoraInicial() {
		return horaInicial;
	}
	/**
	 * @param horaInicial the horaInicial to set
	 */
	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}
	/**
	 * @return the horaFinal
	 */
	public Date getHoraFinal() {
		return horaFinal;
	}
	/**
	 * @param horaFinal the horaFinal to set
	 */
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	/**
	 * @return the dia
	 */
	public String getDia() {
		return dia;
	}
	/**
	 * @param dia the dia to set
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
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
	
}
