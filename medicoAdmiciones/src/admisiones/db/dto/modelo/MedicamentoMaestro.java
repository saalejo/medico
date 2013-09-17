package admisiones.db.dto.modelo;

import java.io.Serializable;
import java.util.Set;

public class MedicamentoMaestro implements Serializable{
	int id;
	String codigo;
	String concentracion;
	String formaFarmaceutica;
	String unidadDeConsumo;
	String viaDeAdministracion;
	String nombre;
	String cantidad;
	String posologia;
	String usuarioConectado;
		
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the concentracion
	 */
	public String getConcentracion() {
		return concentracion;
	}
	/**
	 * @param concentracion the concentracion to set
	 */
	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}
	/**
	 * @return the formaFarmaceutica
	 */
	public String getFormaFarmaceutica() {
		return formaFarmaceutica;
	}
	/**
	 * @param formaFarmaceutica the formaFarmaceutica to set
	 */
	public void setFormaFarmaceutica(String formaFarmaceutica) {
		this.formaFarmaceutica = formaFarmaceutica;
	}
	/**
	 * @return the unidadDeConsumo
	 */
	public String getUnidadDeConsumo() {
		return unidadDeConsumo;
	}
	/**
	 * @param unidadDeConsumo the unidadDeConsumo to set
	 */
	public void setUnidadDeConsumo(String unidadDeConsumo) {
		this.unidadDeConsumo = unidadDeConsumo;
	}
	/**
	 * @return the viaDeAdministracion
	 */
	public String getViaDeAdministracion() {
		return viaDeAdministracion;
	}
	/**
	 * @param viaDeAdministracion the viaDeAdministracion to set
	 */
	public void setViaDeAdministracion(String viaDeAdministracion) {
		this.viaDeAdministracion = viaDeAdministracion;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the cantidad
	 */
	public String getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the posologia
	 */
	public String getPosologia() {
		return posologia;
	}
	/**
	 * @param posologia the posologia to set
	 */
	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	
}
