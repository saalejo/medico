package admisiones.db.dao.implementacion;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.EntidadDao;
import admisiones.db.dto.modelo.Entidad;
import admisiones.db.dto.modelo.Entidad;

public class EntidadDaoImpl extends HibernateDaoSupport implements EntidadDao {

	
	
	@Override
	public List<Entidad> obtener() throws Exception {
		Session sesion = null;
		
		try{
			List<Entidad> entidads = new ArrayList<Entidad>();
			sesion = getSession();
			entidads = sesion.createCriteria(Entidad.class)
					.list();			
			return entidads;
		}catch(HibernateException e){
			throw new Exception(e);
		}
		
	}

	@Override
	public Entidad obtener(int codigo) {
		Session sesion = null;
		sesion = getSession();		
		Entidad entidad = (Entidad)sesion.createCriteria(Entidad.class)
				.add(Restrictions.eq("codigo", codigo))
				.uniqueResult();		
		return entidad;
	}

	@Override
	public void guardar(Entidad entidad) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(entidad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Entidad entidad) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(entidad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}