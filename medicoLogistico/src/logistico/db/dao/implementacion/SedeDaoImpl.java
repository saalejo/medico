package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.SedeDao;
import logistico.db.dto.modelo.Sede;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class SedeDaoImpl extends HibernateDaoSupport  implements SedeDao{

	
	@Override
	public List<Sede> obtener(int companiaId) {
		Session sesion = null;
		sesion = getSession();		
		List<Sede> sedes = sesion.createCriteria(Sede.class)
				.add(Restrictions.eq("lo_compania_id", companiaId))
				.list();		
		return sedes;
	}

	@Override
	public void guardar(Sede sede) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(sede);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Sede sede) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(sede);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
