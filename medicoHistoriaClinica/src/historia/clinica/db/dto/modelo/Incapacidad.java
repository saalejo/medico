package historia.clinica.db.dto.modelo;

import java.util.Date;

public class Incapacidad {
	int id;
	Date fechaInicio;
	Date fechaFin;
	String orden;
	int atencionId;
	String usuarioConectado;
	
	
	
	
	
	
	/**
	 * @return the usuarioConectado
	 */
	public String getUsuarioConectado() {
		return usuarioConectado;
	}
	/**
	 * @param usuarioConectado the usuarioConectado to set
	 */
	public void setUsuarioConectado(String usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
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
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
	/**
	 * @return the orden
	 */
	public String getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public int getAtencionId() {
		return atencionId;
	}
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	

}
