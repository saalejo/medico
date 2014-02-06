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
	public List<Sede> obtener(int companiaId) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Sede> sedes = sesion.createCriteria(Sede.class)
					.add(Restrictions.eq("companiaId", companiaId))
					.list();		
			return sedes;
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sede> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Sede> sedes = sesion.createCriteria(Sede.class)
					.list();		
			return sedes;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de sede", e);
		}
	}
	
	@Override
	public void actualizar(Sede sede) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();			
			sesion.update(sede);			
			tx.commit();			
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la sede", e);
		}	
	}

	@Override
	public void guardar(Sede sede) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();			
			sesion.save(sede);			
			tx.commit();			
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardar la sede", e);
		}	
	}

	@Override
	public void borrar(Sede sede) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();			
			sesion.delete(sede);			
			tx.commit();			
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando la sede", e);
		}			
	}
}
