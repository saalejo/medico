package contratos.db.dto.modelo;

import java.io.Serializable;



public class Servicio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String codigo;
	String nombre;
	String codCups;
	String codSoat;
	String codIss;
	String presentacion;
	String tipoTarifa;
	String tipo;
	String clase;
	String conceptoFacturacion;
	boolean estado;
	int areaServicioId;
	String complejidad;
	String genero;
	int edadMinima;
	int edadMaxima;
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
	 * @return the presentacion
	 */
	public String getPresentacion() {
		return presentacion;
	}
	/**
	 * @param presentacion the presentacion to set
	 */
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	
	/**
	 * @return the codCups
	 */
	public String getCodCups() {
		return codCups;
	}
	/**
	 * @param codCups the codCups to set
	 */
	public void setCodCups(String codCups) {
		this.codCups = codCups;
	}
	/**
	 * @return the codSoat
	 */
	public String getCodSoat() {
		return codSoat;
	}
	/**
	 * @param codSoat the codSoat to set
	 */
	public void setCodSoat(String codSoat) {
		this.codSoat = codSoat;
	}
	/**
	 * @return the codIss
	 */
	public String getCodIss() {
		return codIss;
	}
	/**
	 * @param codIss the codIss to set
	 */
	public void setCodIss(String codIss) {
		this.codIss = codIss;
	}
	/**
	 * @return the tipoTarifa
	 */
	public String getTipoTarifa() {
		return tipoTarifa;
	}
	/**
	 * @param tipoTarifa the tipoTarifa to set
	 */
	public void setTipoTarifa(String tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}
	/**
	 * @param clase the clase to set
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}
	/**
	 * @return the conceptoFacturacion
	 */
	public String getConceptoFacturacion() {
		return conceptoFacturacion;
	}
	/**
	 * @param conceptoFacturacion the conceptoFacturacion to set
	 */
	public void setConceptoFacturacion(String conceptoFacturacion) {
		this.conceptoFacturacion = conceptoFacturacion;
	}
	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	/**
	 * @return the areaServicioId
	 */
	public int getAreaServicioId() {
		return areaServicioId;
	}
	/**
	 * @param areaServicioId the areaServicioId to set
	 */
	public void setAreaServicioId(int areaServicioId) {
		this.areaServicioId = areaServicioId;
	}
	/**
	 * @return the complejidad
	 */
	public String getComplejidad() {
		return complejidad;
	}
	/**
	 * @param complejidad the complejidad to set
	 */
	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * @return the edadMinima
	 */
	public int getEdadMinima() {
		return edadMinima;
	}
	/**
	 * @param edadMinima the edadMinima to set
	 */
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	/**
	 * @return the edadMaxima
	 */
	public int getEdadMaxima() {
		return edadMaxima;
	}
	/**
	 * @param edadMaxima the edadMaxima to set
	 */
	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
