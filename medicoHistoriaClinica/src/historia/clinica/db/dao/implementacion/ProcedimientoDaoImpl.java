package historia.clinica.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.ActividadDao;
import admisiones.db.dto.modelo.Actividad;

public class ProcedimientoDaoImpl extends HibernateDaoSupport  implements ActividadDao{

	@Override
	public Actividad obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		Actividad actividad = (Actividad)sesion.createCriteria(Actividad.class)
				.add(Restrictions.eq("identificacion", id))
				.uniqueResult();		
		return actividad;
	}
	
	@Override
	public List<Actividad> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Actividad> actividades = sesion.createCriteria(Actividad.class)
				.list();		
		return actividades;
	}

	@Override
	public void guardar(Actividad actividad) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(actividad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	@Override
	public void actualizar(Actividad actividad) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.update(actividad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Actividad actividad) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(actividad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}