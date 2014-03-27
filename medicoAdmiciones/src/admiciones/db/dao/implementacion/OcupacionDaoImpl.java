package admiciones.db.dao.implementacion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admiciones.db.dao.interfaz.OcupacionDao;
import admiciones.db.dto.modelo.Ocupacion;


public class OcupacionDaoImpl extends HibernateDaoSupport implements OcupacionDao{
	
	
	@Override
	public void guardar(Ocupacion ocupacion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(ocupacion);
			sesion.flush();
			tx.commit();
			sesion.close();			
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando la ocupacion", e);
		}		
	}
	
	@Override
	public void actualizar(Ocupacion ocupacion) throws Exception {
		Session sesion = null;
		try{			
			sesion = getSession();
			sesion.update(ocupacion);
			sesion.close();
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la ocupacion", e);
		}		
	}

	@Override
	public Ocupacion obtener(int pacienteId) throws Exception {
		Session sesion = null;
		try{	
			sesion = getSession();
			Ocupacion ocupacion = (Ocupacion)sesion.createCriteria(Ocupacion.class)
					.add(Restrictions.eq("pacienteId", pacienteId))
					.uniqueResult();		
			return ocupacion;			
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error obteniendo la ocupacion",e);
		}
	}
	
	@Override
	public void borrar(Ocupacion ocupacion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(ocupacion);
			sesion.flush();
			tx.commit();
			sesion.close();			
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error borrando la ocupacion", e);
		}		
	}

}
