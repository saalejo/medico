package contratos.db.dao.implementacion;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import contratos.db.dao.interfaz.ServicioDao;
import contratos.db.dto.modelo.Servicio;



public class ServicioDaoImpl extends HibernateDaoSupport  implements ServicioDao{

	
	@Override
	public List<Servicio> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Servicio> servicioes = sesion.createCriteria(Servicio.class)
				.list();		
		return servicioes;
	}
	
	@Override
	public Servicio obtener(String usuario) {
		Session sesion = null;
		sesion = getSession();		
		Servicio servicio = (Servicio)sesion.createCriteria(Servicio.class)
				.add(Restrictions.eq("usuario", usuario))
				.uniqueResult();		
		return servicio;
	}

	@Override
	public void guardar(Servicio servicio) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(servicio);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Servicio servicio) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(servicio);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
