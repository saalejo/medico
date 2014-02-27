package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

public class ProcedimientoAtencion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8087667173550911850L;

	int id;
	Date fechaOrden;
	Date fechaAplica;
	String resultado;
	Atencion atencion;
	int usuarioConectado;
	int procedimientoId;
	int profesionalId;
	int atencionId;
	Procedimiento procedimiento;
	Profesional profesional;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public Date getFechaAplica() {
		return fechaAplica;
	}
	public void setFechaAplica(Date fechaAplica) {
		this.fechaAplica = fechaAplica;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Atencion getAtencion() {
		return atencion;
	}
	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	
	public int getProcedimientoId() {
		return procedimientoId;
	}
	public void setProcedimientoId(int procedimientoId) {
		this.procedimientoId = procedimientoId;
	}
	public int getProfesionalId() {
		return profesionalId;
	}
	public void setProfesionalId(int profesionalId) {
		this.profesionalId = profesionalId;
	}
	
	public int getAtencionId() {
		return atencionId;
	}
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	public Procedimiento getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	
	
	
	
}
