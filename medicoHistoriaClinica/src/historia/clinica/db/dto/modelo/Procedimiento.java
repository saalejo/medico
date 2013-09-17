package historia.clinica.db.dto.modelo;

public class Procedimiento {
	int id;
	String  procedimiento;
	String resultadoExamenes;
	int atencionId;
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
	 * @return the procedimiento
	 */
	public String getProcedimiento() {
		return procedimiento;
	}
	/**
	 * @param procedimiento the procedimiento to set
	 */
	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}
	/**
	 * @return the resultadoExamenes
	 */
	public String getResultadoExamenes() {
		return resultadoExamenes;
	}
	/**
	 * @param resultadoExamenes the resultadoExamenes to set
	 */
	public void setResultadoExamenes(String resultadoExamenes) {
		this.resultadoExamenes = resultadoExamenes;
	}
	public int getAtencionId() {
		return atencionId;
	}
	public void setAtencionId(int atencionId) {
		this.atencionId = atencionId;
	}
	
	
}
