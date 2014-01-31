package contratos.db.dao.implementacion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import contratos.db.dao.interfaz.RegimenDao;
import contratos.db.dto.modelo.Regimen;



public class RegimenDaoImpl extends HibernateDaoSupport  implements RegimenDao{

	
	@Override
	public Regimen obtener(int regimenId) {
		Session sesion = null;
		sesion = getSession();		
		Regimen regimen = (Regimen)sesion.createCriteria(Regimen.class)
				.add(Restrictions.eq("id", regimenId))
				.uniqueResult();		
		return regimen;
	}

	@Override
	public void guardar(Regimen regimen) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(regimen);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Regimen regimen) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(regimen);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
