package historia.clinica.db.dao.implementacion;


import historia.clinica.db.dao.interfaz.RemisionDao;
import historia.clinica.db.dto.modelo.Remision;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class RemisionDaoImpl extends HibernateDaoSupport  implements RemisionDao{

	
	@Override
	public List<Remision> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Remision> remisiones = sesion.createCriteria(Remision.class)
				.list();		
		return remisiones;
	}

	@Override
	public void guardar(Remision remision) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(remision);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	@Override
	public void actualizar(Remision remision) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.update(remision);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Remision remision) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(remision);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}