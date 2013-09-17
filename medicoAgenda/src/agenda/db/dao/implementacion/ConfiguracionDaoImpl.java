package agenda.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import agenda.db.dao.interfaz.ConfiguracionDao;
import agenda.db.dto.modelo.Configuracion;








public class ConfiguracionDaoImpl extends HibernateDaoSupport implements ConfiguracionDao{

	@Override
	public List<Configuracion> obtener() {
		
		Session sesion = null;
		sesion = getSession();		
		List<Configuracion> configuraciones = sesion.createCriteria(Configuracion.class)
				.list();		
		return configuraciones;
	}

	@Override
	public Configuracion obtener(int id) {
		
		Session sesion = null;
		sesion = getSession();		
		Configuracion configuracion = (Configuracion)sesion.createCriteria(Configuracion.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return configuracion;
		
	}


	@Override
	public void actualizar(Configuracion configuracion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(configuracion);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la configuracion", e);
		}
		
	}
	
	
	

}
