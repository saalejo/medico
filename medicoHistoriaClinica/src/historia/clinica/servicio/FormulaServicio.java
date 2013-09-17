package historia.clinica.servicio;

import historia.clinica.db.dao.interfaz.FormulaDao;
import historia.clinica.db.dto.modelo.Formula;
import historia.clinica.db.dto.modelo.Medicamento;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class FormulaServicio {

	@Autowired
	FormulaDao formulaDao;

	public  List<Formula> obtener() {
		try {
			return formulaDao.obtener();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * @return the formulaDao
	 */
	public FormulaDao getFormulaDao() {
		return formulaDao;
	}

	/**
	 * @param formulaDao the formulaDao to set
	 */
	public void setFormulaDao(FormulaDao formulaDao) {
		this.formulaDao = formulaDao;
	}

	
	public void guardar(int atencionId,Date fecha,Set<Medicamento> medicamentosLista,String usuarioConectado) {
		try {
			Formula formula=new Formula();
			formula.setFecha(fecha);
			formula.setAtencionId(atencionId);
			formula.setUsuarioConectado(usuarioConectado);		
			formula.setMedicamentos(medicamentosLista);
			formulaDao.guardar(formula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardar(Formula formula) {
		try {
			formulaDao.guardar(formula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	
}
