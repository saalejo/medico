package historia.clinica.db.dao.implementacion;


import historia.clinica.db.dao.interfaz.IngresoDao;
import historia.clinica.db.dto.modelo.Ingreso;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class IngresoDaoImpl extends HibernateDaoSupport  implements IngresoDao{

	@Override
	public Ingreso obtener(int pacienteId) {
		Session sesion = null;
		sesion = getSession();		
		Ingreso ingreso = (Ingreso)sesion.createCriteria(Ingreso.class)
				.add(Restrictions.eq("pacienteId",pacienteId))	
				.addOrder(Order.desc("id"))
				.setMaxResults(1)			
				.uniqueResult();		
		return ingreso;
	}
	
	@Override
	public List<Ingreso> obtener() {
		Session sesion = null;
		sesion = getSession();		
		List<Ingreso> ingresoes = sesion.createCriteria(Ingreso.class)
				.list();		
		return ingresoes;
	}

	@Override
	public void guardar(Ingreso ingreso) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.save(ingreso);
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}
	@Override
	public void actualizar(Ingreso ingreso) throws Exception {		
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.update(ingreso);
			tx.commit();
			
			
		}catch(HibernateException e){
			throw new Exception(e);
		}	
	}

	@Override
	public void borrar(Ingreso ingreso) {
		Session sesion = null;
		try{
			sesion = getSession();
			Transaction tx = sesion.beginTransaction();
			
			sesion.delete(ingreso);
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
		}	
		
	}
}