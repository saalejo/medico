package agenda.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import agenda.db.dao.interfaz.CausaCancelacionDao;
import agenda.db.dto.modelo.CausaCancelacion;



public class CausaCancelacionDaoImpl extends HibernateDaoSupport implements CausaCancelacionDao{

	@Override
	public void guardar(CausaCancelacion causaCancelacion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(causaCancelacion);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando a causa de Cancelacion", e);
		}
		
	}

	@Override
	public List<CausaCancelacion> obtener() {
		
		Session sesion = null;
		sesion = getSession();		
		List<CausaCancelacion> causasCancelacion = sesion.createCriteria(CausaCancelacion.class)
				.list();		
		return causasCancelacion;
	}

	@Override
	public CausaCancelacion obtener(int id) {
		
		Session sesion = null;
		sesion = getSession();		
		CausaCancelacion causaCancelacion = (CausaCancelacion)sesion.createCriteria(CausaCancelacion.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return causaCancelacion;
		
	}

	@Override
	public void borrar(CausaCancelacion causaCancelacion) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(causaCancelacion);
			tx.commit();	
		}catch(HibernateException e){
			
		}
		
	}

	@Override
	public void actualizar(CausaCancelacion causaCancelacion) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(causaCancelacion);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando la causa de Cancelacion", e);
		}
		
	}
	
	
	

}
