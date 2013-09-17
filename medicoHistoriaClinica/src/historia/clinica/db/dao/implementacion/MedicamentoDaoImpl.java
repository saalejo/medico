package historia.clinica.db.dao.implementacion;


import historia.clinica.db.dao.interfaz.MedicamentoDao;
import historia.clinica.db.dto.modelo.Medicamento;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MedicamentoDaoImpl extends HibernateDaoSupport  implements MedicamentoDao{

	
	
	
	@Override
	public void guardar(Medicamento medicamento) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(medicamento);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	
}