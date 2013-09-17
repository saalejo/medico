package historia.clinica.db.dto.modelo;

import java.util.Date;
import java.util.Set;

public class Formula {
	int id;
	String usuarioConectado;	
	Date fecha;
	int atencionId;
	Set<Medicamento> medicamentos;
	String planManejo;
	
	
	
	/**
	 * @return the planManejo
	 */
	public String getPlanManejo() {
		return planManejo;
	}
	/**
	 * @param planManejo the planManejo to set
	 */
	public void setPlanManejo(String planManejo) {
		this.planManejo = planManejo;
	}
	/**
	 * @return the atencionId
	 */
	public int getAtencionId() {
		return atencionId;
	}
	/**
	 * @param atencionId the atencionId to set
	 */
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	/**
	 * @return the medicamentos
	 */
	public Set<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	/**
	 * @param medicamentos the medicamentos to set
	 */
	public void setMedicamentos(Set<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
}
