package agenda.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import agenda.db.dao.interfaz.ConsultorioDao;
import agenda.db.dto.modelo.Consultorio;






public class ConsultorioDaoImpl extends HibernateDaoSupport implements ConsultorioDao{

	@Override
	public void guardar(Consultorio consultorio) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(consultorio);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el consultorio", e);
		}
		
	}

	@Override
	public List<Consultorio> obtener() {
		
		Session sesion = null;
		sesion = getSession();		
		List<Consultorio> consultorios = sesion.createCriteria(Consultorio.class)
				.list();		
		return consultorios;
	}

	@Override
	public Consultorio obtener(int id) {
		
		Session sesion = null;
		sesion = getSession();		
		Consultorio consultorio = (Consultorio)sesion.createCriteria(Consultorio.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return consultorio;
		
	}

	@Override
	public void borrar(Consultorio consultorio) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(consultorio);
			tx.commit();	
		}catch(HibernateException e){
			
		}
		
	}

	@Override
	public void actualizar(Consultorio consultorio) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(consultorio);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el consultorio", e);
		}
		
	}
	
	
	

}
