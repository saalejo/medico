package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.ProfesionalDao;
import logistico.db.dto.modelo.Profesional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Descripción: Clase que implementa al contrato proporcionado por la interfaz ProfesionalDao.
 * @author Yedinzon Toro Gil
 * 
 */

public class ProfesionalDaoImpl extends HibernateDaoSupport  implements ProfesionalDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Profesional> obtener() throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			List<Profesional> profesionales = sesion.createCriteria(Profesional.class)
					.list();		
			return profesionales;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la lista de Profesionales", e);
		}
	}
	
	@Override
	public Profesional obtener(String usuario) throws Exception {
		Session sesion = null;
		try{
			sesion = getSession();		
			Profesional profesional = (Profesional)sesion.createCriteria(Profesional.class)
					.add(Restrictions.eq("usuario", usuario))
					.uniqueResult();		
			return profesional;
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo el profesional", e);
		}
	}

	@Override
	public void actualizar(Profesional profesional) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(profesional);
			tx.commit();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el Profesional", e);
		}	
	}
	
	@Override
	public void guardar(Profesional profesional) throws Exception {		
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(profesional);
			tx.commit();
			sesion.close();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el Profesional", e);
		}	
	}

	@Override
	public void borrar(Profesional profesional) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(profesional);
			tx.commit();
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando el Profesional", e);
		}	
		
	}
}
