package contratos.db.dao.implementacion;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import contratos.db.dao.interfaz.AreaServiciosDao;
import contratos.db.dto.modelo.AreaServicios;



public class AreaServiciosDaoImpl extends HibernateDaoSupport  implements AreaServiciosDao{

	
	@Override
	public List<AreaServicios> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<AreaServicios> areaServicioses = sesion.createCriteria(AreaServicios.class)
				.list();		
		return areaServicioses;
	}
	
	@Override
	public AreaServicios obtener(String usuario) {
		Session sesion = null;
		sesion = getSession();		
		AreaServicios areaServicios = (AreaServicios)sesion.createCriteria(AreaServicios.class)
				.add(Restrictions.eq("usuario", usuario))
				.uniqueResult();		
		return areaServicios;
	}

	@Override
	public void guardar(AreaServicios areaServicios) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(areaServicios);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(AreaServicios areaServicios) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(areaServicios);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}
