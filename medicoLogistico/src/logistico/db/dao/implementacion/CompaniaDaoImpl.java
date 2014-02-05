package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.CompaniaDao;
import logistico.db.dto.modelo.Compania;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz CompaniaDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class CompaniaDaoImpl extends HibernateDaoSupport  implements CompaniaDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Compania> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Compania> companias = sesion.createCriteria(Compania.class)
				.list();		
		return companias;
	}

	@Override
	public void guardar(Compania compania) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(compania);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Compania compania) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(compania);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}			
	}
}
