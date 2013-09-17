package historia.clinica.db.dao.implementacion;


import historia.clinica.db.dao.interfaz.FormulaDao;
import historia.clinica.db.dto.modelo.Formula;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FormulaDaoImpl extends HibernateDaoSupport  implements FormulaDao{


	@Override
	public List<Formula> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Formula> formulaes = sesion.createCriteria(Formula.class)
				.list();		
		return formulaes;
	}

	@Override
	public void guardar(Formula formula) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(formula);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	@Override
	public void borrar(Formula formula) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(formula);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}