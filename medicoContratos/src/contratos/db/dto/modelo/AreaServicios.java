package contratos.db.dto.modelo;

public class AreaServicios {
	int id;
	String Codigo;
	String Nombre;
	int centroAtencionId;
	int almacenId;
	String cuentaIngresosEntidad;
	String cuentaIngresosParticular;
	String cuentaSuministrosPaciente;
	String cuentadeDescuento;
	String cuentaGastosHonorarios;
	int centroCostosId;
	
	
	
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
		return Codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * @return the centroAtencionId
	 */
	public int getCentroAtencionId() {
		return centroAtencionId;
	}
	/**
	 * @param centroAtencionId the centroAtencionId to set
	 */
	public void setCentroAtencionId(int centroAtencionId) {
		this.centroAtencionId = centroAtencionId;
	}
	/**
	 * @return the almacenId
	 */
	public int getAlmacenId() {
		return almacenId;
	}
	/**
	 * @param almacenId the almacenId to set
	 */
	public void setAlmacenId(int almacenId) {
		this.almacenId = almacenId;
	}
	/**
	 * @return the cuentaIngresosEntidad
	 */
	public String getCuentaIngresosEntidad() {
		return cuentaIngresosEntidad;
	}
	/**
	 * @param cuentaIngresosEntidad the cuentaIngresosEntidad to set
	 */
	public void setCuentaIngresosEntidad(String cuentaIngresosEntidad) {
		this.cuentaIngresosEntidad = cuentaIngresosEntidad;
	}
	/**
	 * @return the cuentaIngresosParticular
	 */
	public String getCuentaIngresosParticular() {
		return cuentaIngresosParticular;
	}
	/**
	 * @param cuentaIngresosParticular the cuentaIngresosParticular to set
	 */
	public void setCuentaIngresosParticular(String cuentaIngresosParticular) {
		this.cuentaIngresosParticular = cuentaIngresosParticular;
	}
	/**
	 * @return the cuentaSuministrosPaciente
	 */
	public String getCuentaSuministrosPaciente() {
		return cuentaSuministrosPaciente;
	}
	/**
	 * @param cuentaSuministrosPaciente the cuentaSuministrosPaciente to set
	 */
	public void setCuentaSuministrosPaciente(String cuentaSuministrosPaciente) {
		this.cuentaSuministrosPaciente = cuentaSuministrosPaciente;
	}
	/**
	 * @return the cuentadeDescuento
	 */
	public String getCuentadeDescuento() {
		return cuentadeDescuento;
	}
	/**
	 * @param cuentadeDescuento the cuentadeDescuento to set
	 */
	public void setCuentadeDescuento(String cuentadeDescuento) {
		this.cuentadeDescuento = cuentadeDescuento;
	}
	/**
	 * @return the cuentaGastosHonorarios
	 */
	public String getCuentaGastosHonorarios() {
		return cuentaGastosHonorarios;
	}
	/**
	 * @param cuentaGastosHonorarios the cuentaGastosHonorarios to set
	 */
	public void setCuentaGastosHonorarios(String cuentaGastosHonorarios) {
		this.cuentaGastosHonorarios = cuentaGastosHonorarios;
	}
	/**
	 * @return the centroCostosId
	 */
	public int getCentroCostosId() {
		return centroCostosId;
	}
	/**
	 * @param centroCostosId the centroCostosId to set
	 */
	public void setCentroCostosId(int centroCostosId) {
		this.centroCostosId = centroCostosId;
	}
	 
}
