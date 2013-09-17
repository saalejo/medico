package agenda.db.dao.implementacion;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import agenda.db.dao.interfaz.CitaDao;
import agenda.db.dto.modelo.Cita;


public class CitaDaoImpl extends HibernateDaoSupport implements CitaDao{
	
	
	@Override
	public void guardar(Cita cita) throws Exception {
		Session sesion = null;
//		Transaction tx = null;
		try{
			
			sesion = getSession();
//			tx = sesion.beginTransaction();
			sesion.save(cita);
//			sesion.flush();
//			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando la cita", e);
		}		
	}

}
