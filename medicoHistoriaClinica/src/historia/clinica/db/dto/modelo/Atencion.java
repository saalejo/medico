package historia.clinica.db.dto.modelo;

import java.io.Serializable;
import java.util.Date;

import admisiones.db.dto.modelo.Ingreso;
import admisiones.db.dto.modelo.Paciente;

public class Atencion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4057760841339817046L;

	int	id;
	int folio;
	Boolean telemedicina; // valor booleano que indica si la atencion se realiza por telemedicina o no 
	Date fecha;
	String evolucion;
	String recomendaciones;
	String motivoConsulta;
	String enfermedadActual;
	Boolean tipoConsulta;
	int  usuarioConectado;
	int pacienteId;
	int profesionalId;
	int ingresoId;
	
	Paciente paciente;
	Profesional profesional;  // se encuentra en modulo logistico
	Ingreso ingreso;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public Boolean getTelemedicina() {
		return telemedicina;
	}
	public void setTelemedicina(Boolean telemedicina) {
		this.telemedicina = telemedicina;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEvolucion() {
		return evolucion;
	}
	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}
	public String getRecomendaciones() {
		return recomendaciones;
	}
	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public String getEnfermedadActual() {
		return enfermedadActual;
	}
	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}
	public Boolean getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(Boolean tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
	public int getProfesionalId() {
		return profesionalId;
	}
	public void setProfesionalId(int profesionalId) {
		this.profesionalId = profesionalId;
	}
	public int getIngresoId() {
		return ingresoId;
	}
	public void setIngresoId(int ingresoId) {
		this.ingresoId = ingresoId;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	public Ingreso getIngreso() {
		return ingreso;
	}
	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}
	
	
	
	

	
	
	
}
