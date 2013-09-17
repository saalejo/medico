package admisiones.db.dao.implementacion;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.EspecialidadDao;
import admisiones.db.dto.modelo.Especialidad;
import admisiones.db.dto.modelo.Especialidad;

public class EspecialidadDaoImpl extends HibernateDaoSupport implements EspecialidadDao {

	
	
	@Override
	public List<Especialidad> obtener() throws Exception {
		Session sesion = null;
		
		try{
			List<Especialidad> especialidads = new ArrayList<Especialidad>();
			sesion = getSession();
			especialidads = sesion.createCriteria(Especialidad.class)
					.list();			
			return especialidads;
		}catch(HibernateException e){
			throw new Exception(e);
		}
		
	}

	@Override
	public Especialidad obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		Especialidad especialidad = (Especialidad)sesion.createCriteria(Especialidad.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return especialidad;
	}

	@Override
	public void guardar(Especialidad especialidad) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(especialidad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Especialidad especialidad) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(especialidad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}