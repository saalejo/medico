package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.BarrioDao;
import logistico.db.dto.modelo.Barrio;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz BarrioDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class BarrioDaoImpl extends HibernateDaoSupport  implements BarrioDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Barrio> obtener(int municipioId) {
		Session sesion = null;
		sesion = getSession();		
		List<Barrio> barrios = sesion.createCriteria(Barrio.class).add(Restrictions.eq("lo_municipio_id", municipioId))
				.list();		
		return barrios;
	}

	@Override
	public void guardar(Barrio barrio) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(barrio);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Barrio barrio) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(barrio);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
