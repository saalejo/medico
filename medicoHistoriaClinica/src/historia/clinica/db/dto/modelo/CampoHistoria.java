package historia.clinica.db.dto.modelo;

import java.io.Serializable;

public class CampoHistoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3800467501459870843L;
	int id;
	int atencionId;
	String clave;
	String valor;
	String observaciones;
	String padre;
	
	 
	
	
	
	public CampoHistoria() {
		super();
	}



	public CampoHistoria(String clave, String valor, String observaciones,
			String padre) {
		super();
		this.clave = clave;
		this.valor = valor;
		this.observaciones = observaciones;
		this.padre = padre;
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
	 * @return the padre
	 */
	public String getPadre() {
		return padre;
	}
	/**
	 * @param padre the padre to set
	 */
	public void setPadre(String padre) {
		this.padre = padre;
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
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	

}
