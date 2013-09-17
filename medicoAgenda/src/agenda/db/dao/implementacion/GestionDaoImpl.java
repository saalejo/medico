package agenda.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import agenda.db.dao.interfaz.GestionDao;
import agenda.db.dto.modelo.Gestion;



public class GestionDaoImpl extends HibernateDaoSupport implements GestionDao{

	@Override
	public void guardar(Gestion gestion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(gestion);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error la gestion de agenda", e);
		}
		
	}

	@Override
	public List<Gestion> obtener() {
		
		Session sesion = null;
		sesion = getSession();		
		List<Gestion> gestiones = sesion.createCriteria(Gestion.class)
				.list();		
		return gestiones;
	}

	@Override
	public Gestion obtener(int id) {
		
		Session sesion = null;
		sesion = getSession();		
		Gestion gestion = (Gestion)sesion.createCriteria(Gestion.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return gestion;
		
	}

	@Override
	public void borrar(Gestion gestion) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(gestion);
			tx.commit();	
		}catch(HibernateException e){
			
		}
		
	}

	@Override
	public void actualizar(Gestion gestion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(gestion);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la gestion", e);
		}
		
	}
	
	
	

}
