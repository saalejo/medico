package agenda.db.dto.modelo;

import java.util.Date;
import java.util.Set;

public class Turno {
	int id;
	int profesionalId;
	int duracion;
	int duracionCita;
	String nombre;
	Date fecha;
	Set<Cita> citas;	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProfesionalId() {
		return profesionalId;
	}
	public void setProfesionalId(int profesionalId) {
		this.profesionalId = profesionalId;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public int getDuracionCita() {
		return duracionCita;
	}
	public void setDuracionCita(int duracionCita) {
		this.duracionCita = duracionCita;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
	public Set<Cita> getCitas() {
		return citas;
	}
	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
}
