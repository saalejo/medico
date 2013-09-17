package admisiones.db.dao.implementacion;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.ProfesionalDao;
import admisiones.db.dto.modelo.Actividad;
import admisiones.db.dto.modelo.Profesional;


public class ProfesionalDaoImpl extends HibernateDaoSupport  implements ProfesionalDao{

	
	@Override
	public List<Profesional> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Profesional> profesionales = sesion.createCriteria(Profesional.class)
				.list();		
		return profesionales;
	}
	
	@Override
	public Profesional obtener(String usuario) {
		Session sesion = null;
		sesion = getSession();		
		Profesional profesional = (Profesional)sesion.createCriteria(Profesional.class)
				.add(Restrictions.eq("usuario", usuario))
				.uniqueResult();		
		return profesional;
	}

	@Override
	public void guardar(Profesional profesional) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(profesional);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Profesional profesional) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(profesional);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
