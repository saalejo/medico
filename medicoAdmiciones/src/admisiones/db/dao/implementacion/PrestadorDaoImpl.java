package admisiones.db.dao.implementacion;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import admisiones.db.dao.interfaz.PrestadorDao;
import admisiones.db.dto.modelo.Actividad;
import admisiones.db.dto.modelo.Prestador;


public class PrestadorDaoImpl extends HibernateDaoSupport  implements PrestadorDao{

	
	@Override
	public void guardar(Prestador prestador) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(prestador);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Prestador prestador) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(prestador);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
	

	@Override
	public List<Prestador> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Prestador> prestadores = sesion.createCriteria(Prestador.class)
				.list();		
		return prestadores;
	}
}
