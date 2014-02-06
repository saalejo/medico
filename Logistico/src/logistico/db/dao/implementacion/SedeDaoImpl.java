package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.SedeDao;
import logistico.db.dto.modelo.Sede;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz SedeDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class SedeDaoImpl extends HibernateDaoSupport  implements SedeDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Sede> obtener(int companiaId) {
		Session sesion = null;
		sesion = getSession();		
		List<Sede> sedes = sesion.createCriteria(Sede.class)
				.add(Restrictions.eq("companiaId", companiaId))
				.list();		
		return sedes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sede> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Sede> sedes = sesion.createCriteria(Sede.class)
				.list();		
		return sedes;
	}
	
	@Override
	public void actualizar(Sede sede) throws Exception {		
		
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
	public void borrar(Sede sede) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(sede);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}			
	}
}
