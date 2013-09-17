package historia.clinica.db.dao.implementacion;

import historia.clinica.db.dao.interfaz.FinalidadDao;
import historia.clinica.db.dto.modelo.Finalidad;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FinalidadDaoImpl extends HibernateDaoSupport  implements FinalidadDao {
	@Override
	public List<Finalidad> obtener() throws Exception {
		Session sesion = null;
		
		try{
			List<Finalidad> finalidads = new ArrayList<Finalidad>();
			sesion = getSession();
			finalidads = sesion.createCriteria(Finalidad.class)
					.list();			
			return finalidads;
		}catch(HibernateException e){
			throw new Exception(e);
		}
		
	}

	@Override
	public Finalidad obtener(int id) {
		Session sesion = null;
		sesion = getSession();		
		Finalidad finalidad = (Finalidad)sesion.createCriteria(Finalidad.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return finalidad;
	}	
}
