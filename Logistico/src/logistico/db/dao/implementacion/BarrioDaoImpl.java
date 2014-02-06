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
	public List<Barrio> obtener(int municipioId) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Barrio> barrios = sesion.createCriteria(Barrio.class)
					.add(Restrictions.eq("municipioId", municipioId))
					.list();		
			return barrios;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de todos los barrios", e);
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Barrio> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Barrio> barrios = sesion.createCriteria(Barrio.class)
					.list();		
			return barrios;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista los barrios", e);
		}
	}

	@Override
	public void actualizar(Barrio barrio) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(barrio);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el barrio", e);
		}	
	}
	
	@Override
	public void guardar(Barrio barrio) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(barrio);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el barrio", e);
		}	
	}

	@Override
	public void borrar(Barrio barrio) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(barrio);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el barrio", e);
		}	
		
	}
}
