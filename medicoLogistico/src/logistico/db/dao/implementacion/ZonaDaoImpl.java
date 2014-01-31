package logistico.db.dao.implementacion;

import java.util.List;

import logistico.db.dao.interfaz.ZonaDao;
import logistico.db.dto.modelo.Zona;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class ZonaDaoImpl extends HibernateDaoSupport  implements ZonaDao{

	
	@Override
	public List<Zona> obtener(int municipioId) {
		Session sesion = null;
		sesion = getSession();		
		List<Zona> zonas = sesion.createCriteria(Zona.class)
				.add(Restrictions.eq("lo_municipio_id", municipioId))
				.list();		
		return zonas;
	}

	@Override
	public void guardar(Zona zona) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(zona);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Zona zona) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(zona);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
