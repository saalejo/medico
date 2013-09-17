package historia.clinica.db.dao.implementacion;


import java.util.List;

import historia.clinica.db.dao.interfaz.IncapacidadDao;
import historia.clinica.db.dto.modelo.Incapacidad;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class IncapacidadDaoImpl extends HibernateDaoSupport  implements IncapacidadDao{

	
	@Override
	public void guardar(Incapacidad incapacidad) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(incapacidad);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	
}