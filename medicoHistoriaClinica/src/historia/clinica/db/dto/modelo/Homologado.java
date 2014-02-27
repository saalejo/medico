package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class Homologado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5404914749572984586L;

	int id;
	String descripcion;
	Double factor; // Factor del manual tarifario
	Double valor;  //Valor del procedimiento
	int procedimientoId;
	int tarifarioId;
	int usuarioConectado;
	String codigo;
	
	Procedimiento procedimiento;
	Tarifario     tarifario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getFactor() {
		return factor;
	}
	public void setFactor(Double factor) {
		this.factor = factor;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public int getProcedimientoId() {
		return procedimientoId;
	}
	public void setProcedimientoId(int procedimientoId) {
		this.procedimientoId = procedimientoId;
	}
	public int getTarifarioId() {
		return tarifarioId;
	}
	public void setTarifarioId(int tarifarioId) {
		this.tarifarioId = tarifarioId;
	}
	public Procedimiento getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}
	public Tarifario getTarifario() {
		return tarifario;
	}
	public void setTarifario(Tarifario tarifario) {
		this.tarifario = tarifario;
	}
	public int getUsuarioConectado() {
		return usuarioConectado;
	}
	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
	
	
}
