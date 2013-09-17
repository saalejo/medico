package agenda.db.dao.implementacion;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import agenda.db.dao.interfaz.FestivoDao;
import agenda.db.dto.modelo.Festivo;



public class FestivoDaoImpl extends HibernateDaoSupport implements FestivoDao{

	@Override
	public void guardar(Festivo festivo) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.save(festivo);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error guardando el consultorio", e);
		}
		
	}

	@Override
	public List<Festivo> obtener() {
		
		Session sesion = null;
		sesion = getSession();		
		List<Festivo> festivos = sesion.createCriteria(Festivo.class)
				.list();		
		return festivos;
	}

	@Override
	public Festivo obtener(int id) {
		
		Session sesion = null;
		sesion = getSession();		
		Festivo festivo = (Festivo)sesion.createCriteria(Festivo.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();		
		return festivo;
		
	}

	@Override
	public void borrar(Festivo festivo) {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.delete(festivo);
			tx.commit();	
		}catch(HibernateException e){
			
		}
		
	}

	@Override
	public void actualizar(Festivo festivo) throws Exception {
		Session sesion = null;
		Transaction tx = null;
		try{
			
			
			sesion = getSession();
			tx = sesion.beginTransaction();
			sesion.update(festivo);
			tx.commit();	
		}catch(HibernateException e){
			throw new Exception("Ha ocurrido un error actualizando el consultorio", e);
		}
		
	}
	
	
	

}
