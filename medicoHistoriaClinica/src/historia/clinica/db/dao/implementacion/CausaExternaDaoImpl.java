package historia.clinica.db.dao.implementacion;

import historia.clinica.db.dao.interfaz.CausaExternaDao;
import historia.clinica.db.dto.modelo.CausaExterna;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CausaExternaDaoImpl  extends HibernateDaoSupport  implements  CausaExternaDao{
	@Override
	public List<CausaExterna> obtener() throws Exception {
		Session sesion = null;
		
		try{
			List<CausaExterna> causaExternas = new ArrayList<CausaExterna>();
			sesion = getSession();
			causaExternas = sesion.createCriteria(CausaExterna.class)
					.list();			
			return causaExternas;
		}catch(HibernateException e){
			throw new Exception(e);
		}
		
	}

	@Override
	public CausaExterna obtener(int id)throws Exception {
		Session sesion = null;
		sesion = getSession();		
		CausaExterna causaExterna = (CausaExterna)sesion.createCriteria(CausaExterna.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return causaExterna;
	}	
}
